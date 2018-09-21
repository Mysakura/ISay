package com.internetsaying.user.service;

import java.util.Set;

import com.internetsaying.user.entity.UserCollection;

public interface UserCollectionService {

	/**
	 * 添加用户收藏
	 * @param collection
	 * @return
	 */
	int addCollection(UserCollection collection);
	
	/**
	 * 删除用户收藏
	 * @param collection
	 * @return
	 */
	int delCollection(UserCollection collection);
	
	/**
	 * 获得用户收藏的帖子
	 * @param userId
	 * @return
	 */
	Set<String> getUserCollectPostIds(String userId, int pageNo, int pageSize);
	
	/**
	 * 用户收藏的帖子数量
	 * @param userId
	 * @return
	 */
	int getUserCollectPostCount(String userId);
	
	/**
	 * 检测是否已经收藏
	 * @param userId
	 * @param postId
	 * @return
	 */
	int checkCollect(String userId, String postId);
}
