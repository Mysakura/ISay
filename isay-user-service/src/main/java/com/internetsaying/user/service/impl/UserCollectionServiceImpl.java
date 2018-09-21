package com.internetsaying.user.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.internetsaying.user.dao.UserCollectionDAO;
import com.internetsaying.user.entity.UserCollection;
import com.internetsaying.user.service.UserCollectionService;

@Transactional(rollbackFor=Exception.class)
@Service
public class UserCollectionServiceImpl implements UserCollectionService {

	@Autowired
	private UserCollectionDAO userCollectionDAO;
	
	@Autowired
	@Qualifier("serviceRedisTemplate")
	private RedisTemplate<String, Object> redisTemplate;
	
	//private static final String SET_USER_COLLECTION = "set:collection:";	// 用户收藏的帖子，帖子id为member。key为用户id
	
	@Override
	public int addCollection(UserCollection collection) {
		return userCollectionDAO.addCollection(collection);
	}
	
	@Override
	public int delCollection(UserCollection collection) {
		return userCollectionDAO.cancelCollect(collection.getUserId(), collection.getPostId());
	}
	
	@Override
	public Set<String> getUserCollectPostIds(String userId, int pageNo, int pageSize) {
		return userCollectionDAO.getUserCollectPostIds(userId, pageSize*(pageNo-1), pageSize);
	}

	@Override
	public int getUserCollectPostCount(String userId) {
		return userCollectionDAO.getUserCollectPostCount(userId);
	}

	@Override
	public int checkCollect(String userId, String postId) {
		return userCollectionDAO.checkCollect(userId, postId);
	}

}
