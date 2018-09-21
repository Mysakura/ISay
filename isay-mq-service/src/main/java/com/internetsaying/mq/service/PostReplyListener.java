package com.internetsaying.mq.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.internetsaying.exception.CommonException;
import com.internetsaying.exception.enums.ExceptionEnum;
import com.internetsaying.mq.common.SystemMsgVar;
import com.internetsaying.post.entity.Post;
import com.internetsaying.post.entity.PostComment;
import com.internetsaying.post.entity.PostReply;
import com.internetsaying.post.service.PostCommentService;
import com.internetsaying.post.service.PostService;
import com.internetsaying.user.entity.SystemMessage;
import com.internetsaying.user.entity.User;
import com.internetsaying.user.service.SystemMsgService;
import com.internetsaying.utils.IDUtils;

public class PostReplyListener implements MessageListener {

	@Autowired
	private SystemMsgService systemMsgService;
	
	@Autowired
	private PostCommentService postCommentService;
	
	@Autowired
	private PostService postService;
	
	@Override
	public void onMessage(Message message) {
		TextMessage text = (TextMessage) message;
		try {
			PostReply reply = JSONObject.parseObject(text.getText(), PostReply.class);
			if(reply == null) {
				throw new CommonException(ExceptionEnum.MQ_RECEIVE_NULL.code, ExceptionEnum.MQ_RECEIVE_NULL.msg);
			}
			Date time = reply.getReplyTime();
			String userId = reply.getReplyUser().getUserId();	// 回复者id
			String userName = reply.getReplyUser().getNickname();
			String targetId = reply.getTargetUser().getUserId();	// 目标id
			String commentId = reply.getPostComment().getCommentId();	// 评论id
			PostComment comment = postCommentService.getCommentById(commentId);
			String postId = comment.getPost().getPostId();	// 帖子id
			Post post = postService.getPostById(postId);
			String timeStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(time);
			String content = "<a class='sys-user' href='"+ SystemMsgVar.PRE_FIX +"/user/"+ userId +"'>"+ userName +"</a>在帖子<a class='sys-post' href='"+ SystemMsgVar.PRE_FIX +"/card/post_details/"+ postId +"'>《"+ post.getPostTitle() +"》</a>中回复了你<span class='sys-time'>"+ timeStr +"</span>";
			systemMsgService.addSystemMsg(new SystemMessage(IDUtils.createID20(time), new User(targetId), content, time));
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
