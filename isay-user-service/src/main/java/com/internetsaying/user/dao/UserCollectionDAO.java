package com.internetsaying.user.dao;

import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.internetsaying.user.entity.UserCollection;

public interface UserCollectionDAO {

	/**
	 * 添加用户收藏
	 * @param collection
	 * @return
	 */
	int addCollection(UserCollection collection);
	
	/**
	 * 获得用户收藏的帖子
	 * @param userId
	 * @return
	 */
	Set<String> getUserCollectPostIds(@Param("userId") String userId, @Param("limitStart") int limitStart, @Param("pageSize") int pageSize);
	
	/**
	 * 用户收藏的帖子数量
	 * @param userId
	 * @return
	 */
	int getUserCollectPostCount(@Param("userId") String userId);
	
	/**
	 * 检测是否已经收藏
	 * @param userId
	 * @param postId
	 * @return
	 */
	int checkCollect(@Param("userId") String userId, @Param("postId") String postId);
	
	/**
	 * 取消收藏
	 * @param userId
	 * @param postId
	 * @return
	 */
	int cancelCollect(@Param("userId") String userId, @Param("postId") String postId);
}
