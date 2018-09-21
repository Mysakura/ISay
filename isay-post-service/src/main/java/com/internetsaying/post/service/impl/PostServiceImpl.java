package com.internetsaying.post.service.impl;

import java.util.ArrayList;
import java.util.Collections;
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
import com.internetsaying.post.dao.PostDAO;
import com.internetsaying.post.dao.UpDownDAO;
import com.internetsaying.post.dto.PostInfusion;
import com.internetsaying.post.entity.AreaLabel;
import com.internetsaying.post.entity.Post;
import com.internetsaying.post.entity.PostUpDown;
import com.internetsaying.post.service.PostService;
import com.internetsaying.user.entity.User;
import com.internetsaying.user.service.UserService;

@Transactional(rollbackFor=Exception.class)
@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Autowired
	@Qualifier("postUpdateDestination")
	private Destination postUpdateDestination;
	
	@Autowired
	@Qualifier("postSaveDestination")
	private Destination postSaveDestination;

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	private static final String POST_KEY = "posts";
	private static final String POST_ZSET = "zset:post";	// 全部帖子，以时间为分数，帖子id为member
	
	private static final String POST_ZSET_USER = "zset:post:";	// 用户的帖子，以时间为分数，帖子id为member。key为用户id
	private static final String POST_ZSET_CLASSIFY_N = "zset:c:post:";	// 分类的帖子，以时间为分数，帖子id为member。key为分类id
	private static final String POST_ZSET_CLASSIFY_H = "zset:h:post:";	// 分类的帖子，以浏览量为分数。浏览量更新，这里分数也要更新。key为分类id
	private static final String POST_ZSET_C_A = "zset:post:";	// 分类下，领域对应的帖子，以时间为分数，帖子id为member。key为分类id+领域id
	
	@Autowired
	private PostDAO postDAO;
	
	@Autowired
	private UpDownDAO upDownDAO;
	
	@Autowired
	private UserService userService;
	
	private static Logger log = LoggerFactory.getLogger(PostServiceImpl.class);
	
	@Override
	public int addPost(Post post) {
		// 进数据库
		int a = postDAO.addPost(post);
		int b = postDAO.addPostLabel(post.getPostId(), post.getLabels());
		// 进缓存
		if(a == 1 && b == post.getLabels().size()) {
			// 不进Hash，因为此时的数据不全，比如说只有分类id、领域id、标签id，而没有对应的name
			//redisTemplate.boundHashOps(POST_KEY).put(post.getPostId(), post);
			// 进ZSet
			redisTemplate.boundZSetOps(POST_ZSET).add(post.getPostId(), post.getPostTime().getTime());
			// 进用户帖子缓存
			redisTemplate.boundZSetOps(POST_ZSET_USER + post.getUser().getUserId()).add(post.getPostId(), post.getPostTime().getTime());
			// 分类帖子-时间为分数
			redisTemplate.boundZSetOps(POST_ZSET_CLASSIFY_N + post.getClassify().getClassifyId()).add(post.getPostId(), post.getPostTime().getTime());
			// 分类帖子-浏览量为分数
			redisTemplate.boundZSetOps(POST_ZSET_CLASSIFY_H + post.getClassify().getClassifyId()).add(post.getPostId(), post.getVisitNum());
			// 领域帖子
			redisTemplate.boundZSetOps(POST_ZSET_C_A + post.getClassify().getClassifyId() + ":" + post.getWorkArea().getAreaId()).add(post.getPostId(), post.getPostTime().getTime());
			
			return 1;
		}
		return 0;
	}

	@Override
	public int updatePost(Post post, Set<AreaLabel> newLabels) {
		String postId = post.getPostId();
		Set<AreaLabel> temp = new HashSet<>();
		Set<AreaLabel> old = post.getLabels();
		// 更新帖子
		int a = postDAO.updatePost(post);
		// 更新标签：删除只属于old的
		temp.addAll(old);
		temp.removeAll(newLabels);
		// 调用DAO，传入temp
		if(!temp.isEmpty())
			postDAO.delPostLabel(postId, temp);
		temp.clear();
		// 更新标签：添加只属于new的
		temp.addAll(newLabels);
		temp.removeAll(old);
		// 调用DAO，传入temp
		if(!temp.isEmpty())
			postDAO.addPostLabel(postId, temp);
		// 更新缓存
		redisTemplate.boundHashOps(POST_KEY).put(post.getPostId(), postDAO.getPostById(postId));
		// 设置缓存过期,1秒后过期
		//redisTemplate.boundHashOps(POST_KEY).expire(1, TimeUnit.SECONDS);
		// 删除对应的field
		redisTemplate.boundHashOps(POST_KEY).delete(post.getPostId());
		
		return a;
	}

	// 目的--更新
	private void jmsForUpdate(Post post) {
		jmsTemplate.send(postUpdateDestination, session -> {
			return session.createTextMessage(JSONObject.toJSONString(post));
		});
	}
	
	// 目的--添加
	private void jmsForSave(List<Post> posts) {
		jmsTemplate.send(postSaveDestination, session -> {
			return session.createTextMessage(JSONObject.toJSONString(posts));
		});
	}
	
	@Override
	public int updateVisitNum(Post post) {
		// 更新数据库
		int i = postDAO.updatePost(post);
		// 更新缓存
		if(i == 1) {
			// 更新HASH和以visit为score的ZSet
			redisTemplate.boundHashOps(POST_KEY).delete(post.getPostId());
			// 成员增量+1
			redisTemplate.boundZSetOps(POST_ZSET_CLASSIFY_H + post.getClassify().getClassifyId()).incrementScore(post.getPostId(), 1);
			return 1;
		}
		return 0;
	}

	@Override
	public int updateUpNum(Post post) {
		log.info("赞成帖子：传参：用户：{}，帖子：{}",post.getUser().getUserId(), post.getPostId());
		// 先检查post_up_down是否存在用户-帖子对应关系，如果不存在则添加，反之进行下一步判断：
		// 然后判断type类型，如果为赞成类型，则直接返回提示，否则直接修改类型
		// 最后修改帖子表里面的赞成反对字段(仅仅涉及添加：赞成数+1；如果涉及修改：赞成数+1，反对数-1)
		PostUpDown upDown = upDownDAO.checkPostUpDown(post.getUser().getUserId(), post.getPostId());
		if(upDown == null) {
			// 不存在则添加
			upDownDAO.addPostUpDown(new PostUpDown(post.getPostId(), post.getUser().getUserId(), "1"));
			// 仅仅涉及添加：赞成数+1
			post.setUpNum(1);
		}else {
			if("1".equals(upDown.getType())) {
				// 如果为赞成类型，则直接返回提示
				throw new CommonException(ExceptionEnum.ALREADY_UP.code, ExceptionEnum.ALREADY_UP.msg);
			}else {
				// 否则直接修改类型
				upDownDAO.updatePostUpDown(upDown.getId(), "1");
				// 如果涉及修改：赞成数+1，反对数-1
				post.setUpNum(1);	// 这里极为重要的约定：正数为+，负数为-，PostDAO.xml 做了特殊处理
				post.setDownNum(-1);
			}
		}
		// 更新数据库
		int i = postDAO.updatePost(post);
		// 删除缓存
		if(i == 1) {
			// 删除对应的field
			redisTemplate.boundHashOps(POST_KEY).delete(post.getPostId());
			return 1;
		}
		return 0;
	}

	@Override
	public int updateDownNum(Post post) {
		log.info("反对帖子：传参：用户：{}，帖子：{}",post.getUser().getUserId(), post.getPostId());
		// 先检查post_up_down是否存在用户-帖子对应关系，如果不存在则添加，反之进行下一步判断：
		// 然后判断type类型，如果为反对类型，则直接返回提示，否则直接修改类型
		// 最后修改帖子表里面的赞成反对字段(仅仅涉及添加：反对数+1；如果涉及修改：反对数+1，赞成数-1)
		PostUpDown upDown = upDownDAO.checkPostUpDown(post.getUser().getUserId(), post.getPostId());
		if(upDown == null) {
			// 不存在则添加
			upDownDAO.addPostUpDown(new PostUpDown(post.getPostId(), post.getUser().getUserId(), "2"));
			// 仅仅涉及添加：反对数+1
			post.setDownNum(1);
		}else {
			if("2".equals(upDown.getType())) {
				// 如果为反对类型，则直接返回提示
				throw new CommonException(ExceptionEnum.ALREADY_DOWN.code, ExceptionEnum.ALREADY_DOWN.msg);
			}else {
				// 否则直接修改类型
				upDownDAO.updatePostUpDown(upDown.getId(), "2");
				// 如果涉及修改：反对数+1，赞成数-1
				post.setUpNum(-1);	// 这里极为重要的约定：正数为+，负数为-，PostDAO.xml 做了特殊处理
				post.setDownNum(1);
			}
		}
		// 更新数据库
		int i = postDAO.updatePost(post);
		// 删除缓存
		if(i == 1) {
			// 删除对应的field
			redisTemplate.boundHashOps(POST_KEY).delete(post.getPostId());
			return 1;
		}
		return 0;
	}

	@Override
	public int updateCollectionNum(Post post) {
		// 更新数据库
		int i = postDAO.updatePost(post);
		// 删除缓存
		if(i == 1) {
			// 删除对应的field
			redisTemplate.boundHashOps(POST_KEY).delete(post.getPostId());
			return 1;
		}
		return 0;
	}

	@Override
	public int deletePost(Post post) {
		// 更新数据库
		int i = postDAO.checkPost(post.getUser().getUserId(), post.getPostId());
		if(i == 0) {
			throw new CommonException(ExceptionEnum.NOT_POST_OWNER.code, ExceptionEnum.NOT_POST_OWNER.msg);
		}
		i = postDAO.updatePost(post);
		// 更新缓存,更新HASH以及所有ZSet
		if(i == 1) {
			redisTemplate.boundHashOps(POST_KEY).delete(post.getPostId());
			jmsForUpdate(post);		// 这里没有对应处理
			return 1;
		}
		return 0;
	}

	@Override
	public Post getPostById(String postId) {
		Post post = (Post) redisTemplate.boundHashOps(POST_KEY).get(postId);
		if(post == null) {
			post = postDAO.getPostById(postId);
			if(post == null)
				throw new CommonException(ExceptionEnum.POST_NOT_EXIST.code, ExceptionEnum.POST_NOT_EXIST.msg);
			// 获得帖子的作者信息
			Set<String> ids = new HashSet<>();
			ids.add(post.getUser().getUserId());
			Map<String, User> users = userService.getSpecificUsers(ids);
			post.setUser(users.get(post.getUser().getUserId())); 	// 设置用户信息
			if(post != null) {
				redisTemplate.boundHashOps(POST_KEY).put(postId, post);
				return post;
			}
		}
		return post;
	}
	
	@Override
	public Post getPostByIdForModify(String postId) {
		return postDAO.getPostByIdForModify(postId);
	}
	
	@Override
	public List<Post> getAllPost(int pageNo, int pageSize) {
		// 从缓存中找
		Set<Object> idSet = redisTemplate.boundZSetOps(POST_ZSET).reverseRange(pageSize*(pageNo-1), pageSize*pageNo-1);
		if(idSet == null || idSet.size() == 0) {
			List<Post> fromDB = postDAO.getAllPost(pageSize*(pageNo-1), pageSize);
			fromDB.forEach(e -> {
				redisTemplate.boundZSetOps(POST_ZSET).add(e.getPostId(), e.getPostTime().getTime());
			});
			return fromDB;
		}
		List<Object> list = redisTemplate.boundHashOps(POST_KEY).multiGet(idSet);
		// 已查到的数据
		Set<Object> ready = new HashSet<>();
		// 需要从数据库中查找的数据
		Set<Object> notExist = new HashSet<>();
		// 返回结果集
		List<Post> posts = new ArrayList<>();
		list.forEach(o ->{
			if(o != null) {
				Post p = (Post) o;
				posts.add(p);
				ready.add(p.getPostId());
			}
		});
		// 需要的Set - 已经有的Set = 缓存中没有的Set
		notExist.addAll(idSet);
		notExist.removeAll(ready);
		if(!notExist.isEmpty()) {
			// 缓存中没有的从数据库中查
			List<Post> list2 = postDAO.getPostOfSpecific(notExist);
			// 添加到结果集
			posts.addAll(list2);
			// 添加到缓存由消息队列来完成
			jmsForSave(list2);
		}
		Collections.reverse(posts);
		return posts;
	}
	
	@Override
	public List<Post> getAllPostOfDel(String isDelete, int pageNo, int pageSize) {
		return postDAO.getAllPostOfDel(isDelete, (pageNo-1)*pageSize, pageSize);
	}
	
	@Override
	public List<Post> getPostListOfUser(String userId, int pageNo, int pageSize) {
		log.info("请求参数-{}-{}-{}", userId, pageNo, pageSize);
		Set<Object> idSet = redisTemplate.boundZSetOps(POST_ZSET_USER + userId).reverseRange(pageSize*(pageNo-1), pageSize*pageNo-1);
		if(idSet == null || idSet.size() == 0) {
			List<Post> fromDB = postDAO.getPostListOfUser(userId, pageSize*(pageNo-1), pageSize);
			fromDB.forEach(e -> {
				redisTemplate.boundZSetOps(POST_ZSET_USER + userId).add(e.getPostId(), e.getPostTime().getTime());
			});
			log.info("初始化-用户帖子-直接返回数据库");
			return fromDB;
		}
		List<Object> list = redisTemplate.boundHashOps(POST_KEY).multiGet(idSet);
		
		// 已查到的数据
		Set<Object> ready = new HashSet<>();
		// 需要从数据库中查找的数据
		Set<Object> notExist = new HashSet<>();
		List<Post> posts = new ArrayList<>();
		list.forEach(o ->{
			if(o != null) {
				Post p = (Post) o;
				posts.add(p);
				ready.add(p.getPostId());
			}
		});
		// 需要的Set - 已经有的Set = 缓存中没有的Set
		notExist.addAll(idSet);
		notExist.removeAll(ready);
		if(!notExist.isEmpty()) {
			// 缓存中没有的从数据库中查
			List<Post> list2 = postDAO.getPostOfSpecific(notExist);
			// 添加到结果集
			posts.addAll(list2);
			// 添加到缓存由消息队列来完成
			jmsForSave(list2);
		}
		Collections.reverse(posts);
		log.info("用户帖子-缓存+数据库-{}", posts.size());
		return posts;
	}

	@Override
	public List<Post> getPostByClassifyOfNew(int classifyId, int pageNo, int pageSize) {
		Set<Object> idSet = redisTemplate.boundZSetOps(POST_ZSET_CLASSIFY_N + classifyId).reverseRange(pageSize*(pageNo-1), pageSize*pageNo-1);
		if(idSet == null || idSet.size() == 0) {
			List<Post> fromDB = postDAO.getPostByClassifyOfNew(classifyId, pageSize*(pageNo-1), pageSize);
			log.info("从数据库查询帖子列表-是否为空：{}",fromDB.isEmpty());
			// 如果无数据，那么也就没必要去查用户了
			if(fromDB == null || fromDB.isEmpty()) {
				return fromDB;
			}
			Set<String> ids = new HashSet<>();
			fromDB.forEach(e -> {
				ids.add(e.getUser().getUserId());
			});
			// 查询详细用户信息
			Map<String, User> users = userService.getSpecificUsers(ids);
			fromDB.forEach(e -> {
				e.setUser(users.get(e.getUser().getUserId()));
				redisTemplate.boundZSetOps(POST_ZSET_CLASSIFY_N + classifyId).add(e.getPostId(), e.getPostTime().getTime());
			});
			return fromDB;
		}
		List<Object> list = redisTemplate.boundHashOps(POST_KEY).multiGet(idSet);
		// 已查到的数据
		Set<Object> ready = new HashSet<>();
		// 需要从数据库中查找的数据
		Set<Object> notExist = new HashSet<>();
		List<Post> posts = new ArrayList<>();
		list.forEach(o ->{
			if(o != null) {
				Post p = (Post) o;
				posts.add(p);
				ready.add(p.getPostId());
			}
		});
		// 需要的Set - 已经有的Set = 缓存中没有的Set
		notExist.addAll(idSet);
		notExist.removeAll(ready);
		if(!notExist.isEmpty()) {
			// 缓存中没有的从数据库中查
			List<Post> list2 = postDAO.getPostOfSpecific(notExist);
			// 帖子对应的用户
			Set<String> ids = new HashSet<>();
			list2.forEach(e -> {
				ids.add(e.getUser().getUserId());
			});
			// 查询详细用户信息
			Map<String, User> users = userService.getSpecificUsers(ids);
			list2.forEach(e -> {
				e.setUser(users.get(e.getUser().getUserId()));
			});
			// 添加到结果集
			posts.addAll(list2);
			// 添加到缓存由消息队列来完成
			jmsForSave(list2);
		}
		Collections.reverse(posts);
		return posts;
	}

	@Override
	public List<Post> getPostByClassifyOfHot(int classifyId, int pageNo, int pageSize) {
		Set<Object> idSet = redisTemplate.boundZSetOps(POST_ZSET_CLASSIFY_H + classifyId).reverseRange(pageSize*(pageNo-1), pageSize*pageNo-1);
		if(idSet == null || idSet.size() == 0) {
			List<Post> fromDB = postDAO.getPostByClassifyOfHot(classifyId, pageSize*(pageNo-1), pageSize);
			log.info("从数据库查询帖子列表-是否为空：{}",fromDB.isEmpty());
			// 如果无数据，那么也就没必要去查用户了
			if(fromDB == null || fromDB.isEmpty()) {
				return fromDB;
			}
			Set<String> ids = new HashSet<>();
			fromDB.forEach(e -> {
				ids.add(e.getUser().getUserId());
			});
			// 查询详细用户信息
			Map<String, User> users = userService.getSpecificUsers(ids);
			fromDB.forEach(e -> {
				e.setUser(users.get(e.getUser().getUserId()));
				redisTemplate.boundZSetOps(POST_ZSET_CLASSIFY_H + classifyId).add(e.getPostId(), e.getVisitNum());
			});
			return fromDB;
		}
		List<Object> list = redisTemplate.boundHashOps(POST_KEY).multiGet(idSet);
		// 已查到的数据
		Set<Object> ready = new HashSet<>();
		// 需要从数据库中查找的数据
		Set<Object> notExist = new HashSet<>();
		List<Post> posts = new ArrayList<>();
		list.forEach(o ->{
			if(o != null) {
				Post p = (Post) o;
				posts.add(p);
				ready.add(p.getPostId());
			}
		});
		// 需要的Set - 已经有的Set = 缓存中没有的Set
		notExist.addAll(idSet);
		notExist.removeAll(ready);
		if(!notExist.isEmpty()) {
			// 缓存中没有的从数据库中查
			List<Post> list2 = postDAO.getPostOfSpecific(notExist);
			// 帖子对应的用户
			Set<String> ids = new HashSet<>();
			list2.forEach(e -> {
				ids.add(e.getUser().getUserId());
			});
			// 查询详细用户信息
			Map<String, User> users = userService.getSpecificUsers(ids);
			list2.forEach(e -> {
				e.setUser(users.get(e.getUser().getUserId()));
			});
			// 添加到结果集
			posts.addAll(list2);
			// 添加到缓存由消息队列来完成
			jmsForSave(list2);
		}
		// 这里的排序，不能按照时间
		//Collections.reverse(posts);
		return posts;
	}

	@Override
	public List<Post> getPostByClassifyOfArea(int classifyId, int areaId, int pageNo, int pageSize) {
		Set<Object> idSet = redisTemplate.boundZSetOps(POST_ZSET_C_A + classifyId + ":" + areaId).reverseRange(pageSize*(pageNo-1), pageSize*pageNo-1);
		if(idSet == null || idSet.size() == 0) {
			List<Post> fromDB = postDAO.getPostByClassifyOfArea(classifyId, areaId, pageSize*(pageNo-1), pageSize);
			log.info("从数据库查询帖子列表-是否为空：{}",fromDB.isEmpty());
			// 如果无数据，那么也就没必要去查用户了
			if(fromDB == null || fromDB.isEmpty()) {
				return fromDB;
			}
			Set<String> ids = new HashSet<>();
			fromDB.forEach(e -> {
				ids.add(e.getUser().getUserId());
			});
			// 查询详细用户信息
			Map<String, User> users = userService.getSpecificUsers(ids);
			fromDB.forEach(e -> {
				e.setUser(users.get(e.getUser().getUserId()));
				redisTemplate.boundZSetOps(POST_ZSET_C_A + classifyId + ":" + areaId).add(e.getPostId(), e.getPostTime().getTime());
			});
			return fromDB;
		}
		List<Object> list = redisTemplate.boundHashOps(POST_KEY).multiGet(idSet);
		// 已查到的数据
		Set<Object> ready = new HashSet<>();
		// 需要从数据库中查找的数据
		Set<Object> notExist = new HashSet<>();
		List<Post> posts = new ArrayList<>();
		list.forEach(o ->{
			if(o != null) {
				Post p = (Post) o;
				posts.add(p);
				ready.add(p.getPostId());
			}
		});
		// 需要的Set - 已经有的Set = 缓存中没有的Set
		notExist.addAll(idSet);
		notExist.removeAll(ready);
		if(!notExist.isEmpty()) {
			// 缓存中没有的从数据库中查
			List<Post> list2 = postDAO.getPostOfSpecific(notExist);
			// 帖子对应的用户
			Set<String> ids = new HashSet<>();
			list2.forEach(e -> {
				ids.add(e.getUser().getUserId());
			});
			// 查询详细用户信息
			Map<String, User> users = userService.getSpecificUsers(ids);
			list2.forEach(e -> {
				e.setUser(users.get(e.getUser().getUserId()));
			});
			// 添加到结果集
			posts.addAll(list2);
			// 添加到缓存由消息队列来完成
			jmsForSave(list2);
		}
		Collections.reverse(posts);
		return posts;
	}

	@Override
	public int getAllPostCount() {
		return postDAO.getAllPostCount();
	}
	
	@Override
	public int getAllPostOfDelCount(String isDelete) {
		return postDAO.getAllPostOfDelCount(isDelete);
	}

	@Override
	public int getPostCountOfUser(String userId) {
		return postDAO.getPostCountOfUser(userId);
	}

	@Override
	public int getPostCountForClassify(int classifyId) {
		return postDAO.getPostCountForClassify(classifyId);
	}

	@Override
	public int getPostCountOfAreaForClassify(int classifyId, int areaId) {
		return postDAO.getPostCountOfAreaForClassify(classifyId, areaId);
	}

	@Override
	public PostInfusion getPostInfusionForUser(String userId) {
		return postDAO.getPostInfusionForUser(userId);
	}

	@Override
	public List<Post> getSpecificPosts(Set<String> postIds) {
		List<Post> posts = postDAO.getSpecificPosts(postIds);
		Set<String> ids = new HashSet<>();
		posts.forEach(e -> {
			ids.add(e.getUser().getUserId());
		});
		Map<String, User> users = userService.getSpecificUsers(ids);
		posts.forEach(e -> {
			e.setUser(users.get(e.getUser().getUserId()));
		});
		return posts;
	}

	@Override
	public int checkPost(String userId, String postId) throws CommonException {
		return postDAO.checkPost(userId, postId);
	}

}
