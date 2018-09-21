package com.internetsaying.post.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.internetsaying.post.dao.SolrPostDAO;
import com.internetsaying.post.entity.SolrPost;
import com.internetsaying.post.service.SolrPostService;

@Transactional(rollbackFor=Exception.class)
@Service
public class SolrPostServiceImpl implements SolrPostService {

	@Autowired
	private SolrPostDAO solrPostDAO;
	
	@Override
	public int addSolrPost(SolrPost post) {
		return solrPostDAO.addSolrPost(post);
	}

	@Override
	public int updateSolrPost(SolrPost post) {
		return solrPostDAO.updateSolrPost(post);
	}

	@Override
	public int deleteSolrPost(String id) {
		return solrPostDAO.deleteSolrPost(id);
	}

}
