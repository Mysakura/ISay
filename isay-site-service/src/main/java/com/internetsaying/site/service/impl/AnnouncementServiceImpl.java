package com.internetsaying.site.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.internetsaying.site.dao.AnnounceDAO;
import com.internetsaying.site.entity.Announcement;
import com.internetsaying.site.service.AnnouncementService;
import com.internetsaying.user.entity.User;
import com.internetsaying.user.service.UserService;

@Transactional(rollbackFor=Exception.class)
@Service
public class AnnouncementServiceImpl implements AnnouncementService {

	@Autowired
	private AnnounceDAO announceDAO;
	
	@Autowired
	private UserService userService;
	
	@Override
	public int addAnnouncement(Announcement announcement) {
		return announceDAO.addAnnouncement(announcement);
	}

	@Override
	public int updateAnnouncement(Announcement announcement) {
		return announceDAO.updateAnnouncement(announcement);
	}

	@Override
	public int deleteAnnouncement(String annId) {
		return announceDAO.deleteAnnouncement(annId);
	}

	@Override
	public Announcement getAnnouncement(String annId) {
		return announceDAO.getAnnouncement(annId);
	}

	@Override
	public List<Announcement> getAnnouncementList(int pageNo, int pageSize) {
		List<Announcement> list = announceDAO.getAnnouncementList(pageSize*(pageNo-1), pageSize);
		if(list.isEmpty()) {
			return list;
		}
		Set<String> ids = new HashSet<>();
		for (Announcement a : list) {
			ids.add(a.getAnnEditor().getUserId());
		}
		Map<String, User> map = userService.getSpecificUsers(ids);
		for (Announcement a : list) {
			a.setAnnEditor(map.get(a.getAnnEditor().getUserId()));
		}
		return list;
	}

	@Override
	public int getAnnouncementCount() {
		// TODO Auto-generated method stub
		return announceDAO.getAnnouncementCount();
	}

}
