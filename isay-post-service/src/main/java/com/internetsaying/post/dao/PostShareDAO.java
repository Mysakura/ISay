package com.internetsaying.post.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.internetsaying.post.entity.PostShare;

@Repository
public interface PostShareDAO {

	int addSharePost(PostShare postShare);
	
	int updateSharePost(PostShare postShare);
	
	/**
	 * 获取展示在前台的内容
	 * @param shareId
	 * @return
	 */
	String getContent(@Param("shareId") int shareId);
	
	/**
	 * 获得共享帖子的修改历史
	 * @param postId
	 * @return
	 */
	List<PostShare> getPostModifyList(@Param("postId") String postId);
	
	/**
	 * 大家都可以修改原版，但是自己创建的修改只能自己去修改
	 * @param shareId
	 * @return
	 */
	String getOwnShareToEdit(@Param("shareId") int shareId);
	
	/**
	 * 检查是不是自己的
	 * @param shareId
	 * @param userId
	 * @return
	 */
	int checkPostShare(@Param("shareId") int shareId,@Param("authorId") String userId);
}
