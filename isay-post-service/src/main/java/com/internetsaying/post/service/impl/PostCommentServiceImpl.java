package com.internetsaying.post.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.jms.Destination;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.internetsaying.exception.CommonException;
import com.internetsaying.exception.enums.ExceptionEnum;
import com.internetsaying.post.dao.PostCommentDAO;
import com.internetsaying.post.entity.Post;
import com.internetsaying.post.entity.PostComment;
import com.internetsaying.post.entity.PostReply;
import com.internetsaying.post.service.PostCommentService;
import com.internetsaying.user.entity.User;
import com.internetsaying.user.service.UserService;

@Transactional(rollbackFor=Exception.class)
@Service
public class PostCommentServiceImpl implements PostCommentService {

	
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Autowired
	@Qualifier("postCommentDestination")
	private Destination postCommentDestination;
	
	@Autowired
	@Qualifier("postReplyDestination")
	private Destination postReplyDestination;
	
	private static final String POST_COMMENT_KEY = "postComments:";	// HASH类型
	private static final String POST_COMMENT_ZSET = "pc:";			// ZSET类型[pc:postid]
	private static final String POST_REPLY_KEY = "postReplies:";		// HASH类型
	private static final String POST_REPLY_ZSET = "pr:";			// ZSET类型[pr:commentid]
	
	@Autowired
	private PostCommentDAO postCommentDAO;
	
	@Autowired
	private UserService userService;
	
	private static Logger log = LoggerFactory.getLogger(PostCommentServiceImpl.class);
	
	@Override
	public int addPostComment(PostComment comment) {
		
		// 进数据库
		int n = postCommentDAO.addPostComment(comment);
		if(n != 1) {
			throw new CommonException(ExceptionEnum.ADD_COMMENT_FAILED.code, ExceptionEnum.ADD_COMMENT_FAILED.msg);
		}
		// 进缓存
		redisTemplate.boundHashOps(POST_COMMENT_KEY + comment.getPost().getPostId()).put(comment.getCommentId(), comment);
		redisTemplate.boundZSetOps(POST_COMMENT_ZSET + comment.getPost().getPostId()).add(comment.getCommentId(), comment.getCommentTime().getTime());
		// 进消息队列-有人评论帖子
		jmsTemplate.convertAndSend(postCommentDestination, JSONObject.toJSONString(comment));
		
		return n;
	}

	@Override
	public int deletePostComment(PostComment comment) {
		User user = comment.getUser();	// 执行删除的用户
		int i = postCommentDAO.checkCommentOwner(user.getUserId(), comment.getCommentId());
		if(i == 0) {
			// 如果没有权限，就会抛异常，也就是说如果有权限，在前面就已经return了，不会执行到这一行
			throw new CommonException(ExceptionEnum.NO_PERMISSION.code, ExceptionEnum.NO_PERMISSION.msg);
		}
		// 更新数据库
		int n = postCommentDAO.updatePostComment(comment);
		if(n == 0) {
			throw new CommonException(ExceptionEnum.DEL_COMMENT_FAILED.code, ExceptionEnum.DEL_COMMENT_FAILED.msg);
		}
		// 更新缓存，先删除ZSet里面的，再删除Hash里面的
		//redisTemplate.boundHashOps(POST_COMMENT_KEY + comment.getPost().getPostId()).delete(comment.getCommentId());
		//redisTemplate.boundZSetOps(POST_COMMENT_ZSET + comment.getPost().getPostId()).remove(comment.getCommentId());
		PostComment pc = (PostComment) redisTemplate.boundHashOps(POST_COMMENT_KEY + comment.getPost().getPostId()).get(comment.getCommentId());
		pc.setIsDelete(comment.getIsDelete());
		redisTemplate.boundHashOps(POST_COMMENT_KEY + comment.getPost().getPostId()).put(pc.getCommentId(), pc);
		return n;
	}

	@Override
	public List<PostComment> getPostCommentList(String postId, int pageNo, int pageSize) {
		Set<Object> set = redisTemplate.boundZSetOps(POST_COMMENT_ZSET + postId).reverseRange(pageSize*(pageNo-1), pageSize*pageNo-1);
		log.info("查询评论列表-是否为空：{}，数量：{}",set.isEmpty(),set.size());
		if(set == null || set.size() == 0) {
			List<PostComment> fromDB = postCommentDAO.getPostCommentList(postId, (pageNo-1)*pageSize, pageSize);
			log.info("从数据库查询评论列表-是否为空：{}",fromDB.isEmpty());
			// 如果无数据，那么也就没必要去查用户了
			if(fromDB == null || fromDB.isEmpty()) {
				return fromDB;
			}
			// 查询用户信息
			Set<String> ids = new HashSet<>();
			fromDB.forEach(e -> {
				ids.add(e.getUser().getUserId());
			});
			// 调用服务返回
			Map<String, User> users = userService.getSpecificUsers(ids);
			// 更新数据
			fromDB.forEach(e -> {
				e.setUser(users.get(e.getUser().getUserId()));
				// 更新缓存
				redisTemplate.boundHashOps(POST_COMMENT_KEY + e.getPost().getPostId()).put(e.getCommentId(), e);
				redisTemplate.boundZSetOps(POST_COMMENT_ZSET + e.getPost().getPostId()).add(e.getCommentId(), e.getCommentTime().getTime());
			});
			return fromDB;
		}
		List<Object> list = redisTemplate.boundHashOps(POST_COMMENT_KEY + postId).multiGet(set);
		log.info("查询评论列表-是否为空：{}，数量(来自HASH)：{}",list.isEmpty(),list.size());
		List<PostComment> comments = new ArrayList<>();
		list.forEach(e -> {
			PostComment pc = (PostComment) e;
			long size = redisTemplate.boundZSetOps(POST_REPLY_ZSET + pc.getCommentId()).size();
			pc.setReplyNum((int) size);
			comments.add(pc);
		});
		return comments;
	}

	@Override
	public int addPostReply(PostReply reply) {
		// 回复目标，没有名字，然而这里要进缓存，所以需要先查出来
		Map<String, User> users = userService.getSpecificUsers(new HashSet<String>(Arrays.asList(reply.getTargetUser().getUserId())));
		reply.setTargetUser(users.get(reply.getTargetUser().getUserId()));
		// 进数据库
		int n = postCommentDAO.addPostReply(reply);
		if(n == 0) {
			throw new CommonException(ExceptionEnum.ADD_REPLY_FAILED.code, ExceptionEnum.ADD_REPLY_FAILED.msg);
		}
		// 缓存
		redisTemplate.boundHashOps(POST_REPLY_KEY + reply.getPostComment().getCommentId()).put(reply.getReplyId(), reply);
		redisTemplate.boundZSetOps(POST_REPLY_ZSET + reply.getPostComment().getCommentId()).add(reply.getReplyId(), reply.getReplyTime().getTime());
		// 消息队列-有人回复你
		jmsTemplate.convertAndSend(postReplyDestination, JSONObject.toJSONString(reply));
		return n;
	}

	@Override
	public int deletePostReply(PostReply reply) {
		User user = reply.getReplyUser();
		int i = postCommentDAO.checkReplyOwner(user.getUserId(), reply.getReplyId());
		if(i == 0) {
			// 如果没有权限，就会抛异常，也就是说如果有权限，在前面就已经return了，不会执行到这一行
			throw new CommonException(ExceptionEnum.NO_PERMISSION.code, ExceptionEnum.NO_PERMISSION.msg);
		}
		// 更新数据库
		int n = postCommentDAO.updatePostReply(reply);
		if(n == 0) {
			throw new CommonException(ExceptionEnum.DEL_REPLY_FAILED.code, ExceptionEnum.DEL_REPLY_FAILED.msg);
		}
		// 更新缓存
		PostReply pr = (PostReply) redisTemplate.boundHashOps(POST_REPLY_KEY + reply.getPostComment().getCommentId()).get(reply.getReplyId());
		pr.setIsDelete(reply.getIsDelete());
		redisTemplate.boundHashOps(POST_REPLY_KEY + reply.getPostComment().getCommentId()).put(pr.getReplyId(), pr);
		
		return n;
	}

	@Override
	public List<PostReply> getCommentReplyList(String commentId, int pageNo, int pageSize) {
		Set<Object> set = redisTemplate.boundZSetOps(POST_REPLY_ZSET + commentId).range(pageSize*(pageNo-1), pageSize*pageNo-1);
		if(set == null || set.isEmpty()) {
			List<PostReply> fromDB = postCommentDAO.getCommentReplyList(commentId, (pageNo-1)*pageSize, pageSize);
			log.info("从数据库查询评论回复列表-是否为空：{}",fromDB.isEmpty());
			// 如果无数据，那么也就没必要去查用户了
			if(fromDB == null || fromDB.isEmpty()) {
				return fromDB;
			}
			// 查询用户信息
			Set<String> ids = new HashSet<>();
			fromDB.forEach(e -> {
				ids.add(e.getReplyUser().getUserId());
				ids.add(e.getTargetUser().getUserId());
			});
			// 调用服务返回
			Map<String, User> users = userService.getSpecificUsers(ids);
			// 更新数据
			fromDB.forEach(e -> {
				e.setReplyUser(users.get(e.getReplyUser().getUserId()));
				e.setTargetUser(users.get(e.getTargetUser().getUserId()));
				// 更新缓存
				redisTemplate.boundHashOps(POST_REPLY_KEY + e.getPostComment().getCommentId()).put(e.getReplyId(), e);
				redisTemplate.boundZSetOps(POST_REPLY_ZSET + e.getPostComment().getCommentId()).add(e.getReplyId(), e.getReplyTime().getTime());
			});
			return fromDB;
		}
		List<Object> list = redisTemplate.boundHashOps(POST_REPLY_KEY + commentId).multiGet(set);
		List<PostReply> replies = new ArrayList<>();
		list.forEach(e -> {
			replies.add((PostReply) e);
		});
		
		return replies;
	}

	@Override
	public int getAllCommentCount() {
		return postCommentDAO.getAllCommentCount();
	}
	
	@Override
	public int getCommentCount(String postId) {
		return postCommentDAO.getCommentCount(postId);
	}

	@Override
	public int getReplyCount(String commentId) {
		return postCommentDAO.getReplyCount(commentId);
	}

	@Override
	public PostComment getCommentById(String commentId) {
		PostComment p = new PostComment();
		p.setPost(new Post(postCommentDAO.getPostIdById(commentId)));
		return p;
	}

}
