package com.internetsaying.post.service;

import java.util.List;

import com.internetsaying.exception.CommonException;
import com.internetsaying.post.entity.PostShare;

public interface PostShareService {

	int addSharePost(PostShare postShare) throws CommonException;
	
	int updateSharePost(PostShare postShare) throws CommonException;
	
	/**
	 * 获取展示在前台的内容
	 * @param shareId
	 * @return
	 */
	String getContent(int shareId) throws CommonException;
	
	/**
	 * 获得共享帖子的修改历史
	 * @param postId
	 * @return
	 */
	List<PostShare> getPostModifyList(String postId) throws CommonException;
	
	/**
	 * 大家都可以修改原版，但是自己创建的修改只能自己去修改
	 * @param shareId
	 * @return
	 */
	String getOwnShareToEdit(int shareId) throws CommonException;
	
	/**
	 * 检查是不是自己的
	 * @param shareId
	 * @param userId
	 * @return
	 */
	int checkPostShare(int shareId, String userId) throws CommonException;
}
