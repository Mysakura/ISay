package com.internetsaying.site.service;

import java.util.List;

import com.internetsaying.exception.CommonException;
import com.internetsaying.site.entity.Announcement;

public interface AnnouncementService {

	/**
	 * 添加公告
	 * @param announcement
	 * @return
	 */
	int addAnnouncement(Announcement announcement) throws CommonException;
	
	/**
	 * 更新公告
	 * @param announcement
	 * @return
	 */
	int updateAnnouncement(Announcement announcement) throws CommonException;
	
	/**
	 * 删除公告
	 * @param annId
	 * @return
	 */
	int deleteAnnouncement(String annId) throws CommonException;
	
	/**
	 * 获取公告
	 * @param annId
	 * @return
	 */
	Announcement getAnnouncement(String annId) throws CommonException;
	
	/**
	 * 获取公告列表，分页
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<Announcement> getAnnouncementList(int pageNo, int pageSize) throws CommonException;
	
	/**
	 * 获得公告数量
	 * @return
	 */
	int getAnnouncementCount() throws CommonException;
	
}
