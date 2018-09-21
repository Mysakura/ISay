package com.internetsaying.post.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.internetsaying.post.entity.PostUpDown;

/**
 * 赞成、反对数据表里面的
 * @author dong
 *
 */
@Repository
public interface UpDownDAO {

	/**
	 * 检查
	 * @param userId
	 * @param postId
	 * @return
	 */
	PostUpDown checkPostUpDown(@Param("userId") String userId, @Param("postId") String postId);
	
	/**
	 * 添加
	 * @param postUpDown
	 * @return
	 */
	int addPostUpDown(PostUpDown postUpDown);
	
	/**
	 * 更新
	 * @param id
	 * @param type
	 * @return
	 */
	int updatePostUpDown(@Param("id") Integer id, @Param("type") String type);
	
}
