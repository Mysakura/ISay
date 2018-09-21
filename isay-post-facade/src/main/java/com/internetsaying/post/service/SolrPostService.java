package com.internetsaying.post.service;

import com.internetsaying.post.entity.SolrPost;

public interface SolrPostService {

	/**
	 * 添加
	 * @param post
	 * @return
	 */
	int addSolrPost(SolrPost post);
	
	/**
	 * 更新,根据帖子id
	 * @param post
	 * @return
	 */
	int updateSolrPost(SolrPost post);
	
	/**
	 * 删除，不是逻辑删,根据帖子id
	 * @param id
	 * @return
	 */
	int deleteSolrPost(String id);
}
