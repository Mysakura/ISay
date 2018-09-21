package com.internetsaying.site.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.internetsaying.exception.CommonException;
import com.internetsaying.site.dao.AboutDAO;
import com.internetsaying.site.entity.About;
import com.internetsaying.site.service.AboutService;
import com.internetsaying.user.entity.User;
import com.internetsaying.user.service.UserService;

@Transactional(rollbackFor=Exception.class)
@Service
public class AboutServiceImpl implements AboutService {

	@Autowired
	private AboutDAO aboutDAO;
	
	@Autowired
	private UserService userService;
	
	@Override
	public int addAbout(About about) {
		return aboutDAO.addAbout(about);
	}

	@Override
	public int updateAbout(About about) {
		return aboutDAO.updateAbout(about);
	}

	@Override
	public int deleteAbout(String aboutId) {
		return aboutDAO.deleteAbout(aboutId);
	}

	@Override
	public About getAboutSiteOfNew() {
		return aboutDAO.getAboutByType("1");
	}

	@Override
	public About getAboutAuthorOfNew() {
		return aboutDAO.getAboutByType("2");
	}

	@Override
	public About getAboutContactOfNew() {
		return aboutDAO.getAboutByType("3");
	}

	@Override
	public List<About> getAboutList() {
		List<About> list = aboutDAO.getAboutList();
		if(list.isEmpty()) {
			return list;
		}
		Set<String> ids =new HashSet<>();
		for (About a : list) {
			ids.add(a.getAboutEditor().getUserId());
		}
		Map<String, User> map = userService.getSpecificUsers(ids);
		for (About a : list) {
			a.setAboutEditor(map.get(a.getAboutEditor().getUserId()));
		}
		// 获得用户信息（配置dubbo，部署服务才可以）
		return list;
	}

	@Override
	public About getAboutById(String aboutId) throws CommonException {
		return aboutDAO.getAboutById(aboutId);
	}

}
