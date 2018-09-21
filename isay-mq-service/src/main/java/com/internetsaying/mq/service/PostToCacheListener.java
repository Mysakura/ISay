package com.internetsaying.mq.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import com.alibaba.fastjson.JSONObject;
import com.internetsaying.post.entity.Post;

public class PostToCacheListener implements MessageListener {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	private static final String POST_KEY = "posts";
	
	
	@Override
	public void onMessage(Message message) {
		TextMessage text = (TextMessage) message;
		try {
			List<Post> posts = JSONObject.parseArray(text.getText(), Post.class);
			Map<String, Object> map = new HashMap<>();
			for (Post post : posts) {
				map.put(post.getPostId(), post);
			}
			redisTemplate.boundHashOps(POST_KEY).putAll(map);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
