package com.internetsaying.post.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.internetsaying.post.entity.SolrPost;

@Repository
public interface SolrPostDAO {

	/**
	 * 添加
	 * @param post
	 * @return
	 */
	int addSolrPost(SolrPost post);
	
	/**
	 * 更新
	 * @param post
	 * @return
	 */
	int updateSolrPost(SolrPost post);
	
	/**
	 * 删除，不是逻辑删
	 * @param id
	 * @return
	 */
	int deleteSolrPost(@Param("postId") String postId);
}
