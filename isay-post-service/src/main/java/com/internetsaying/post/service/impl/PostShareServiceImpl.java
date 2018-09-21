package com.internetsaying.post.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.internetsaying.post.dao.PostShareDAO;
import com.internetsaying.post.entity.PostShare;
import com.internetsaying.post.service.PostShareService;
import com.internetsaying.user.entity.User;
import com.internetsaying.user.service.UserService;

@Transactional(rollbackFor=Exception.class)
@Service
public class PostShareServiceImpl implements PostShareService {

	@Autowired
	private PostShareDAO postShareDAO;
	
	@Autowired
	private UserService userSerivce;
	
	@Override
	public int addSharePost(PostShare postShare) {
		return postShareDAO.addSharePost(postShare);
	}

	@Override
	public int updateSharePost(PostShare postShare) {
		return postShareDAO.updateSharePost(postShare);
	}

	@Override
	public String getContent(int shareId) {
		return postShareDAO.getContent(shareId);
	}

	@Override
	public List<PostShare> getPostModifyList(String postId) {
		List<PostShare> list = postShareDAO.getPostModifyList(postId);
		if(list.isEmpty())
			return list;
		Set<String> ids = new HashSet<>();
		for(PostShare p : list) {
			ids.add(p.getUser().getUserId());
		}
		Map<String, User> users = userSerivce.getSpecificUsers(ids);
		for(PostShare p : list) {
			p.setUser(users.get(p.getUser().getUserId()));
		}
		return list;
	}

	@Override
	public String getOwnShareToEdit(int shareId) {
		return postShareDAO.getOwnShareToEdit(shareId);
	}

	@Override
	public int checkPostShare(int shareId, String userId) {
		return postShareDAO.checkPostShare(shareId, userId);
	}

}
