package com.internetsaying.site.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.internetsaying.site.entity.Announcement;

@Repository
public interface AnnounceDAO {

	/**
	 * 添加公告
	 * @param announcement
	 * @return
	 */
	int addAnnouncement(Announcement announcement);
	
	/**
	 * 更新公告
	 * @param announcement
	 * @return
	 */
	int updateAnnouncement(Announcement announcement);
	
	/**
	 * 删除公告
	 * @param annId
	 * @return
	 */
	int deleteAnnouncement(@Param("annId") String annId);
	
	/**
	 * 获取公告
	 * @param annId
	 * @return
	 */
	Announcement getAnnouncement(@Param("annId") String annId);
	
	/**
	 * 获取公告列表，分页
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<Announcement> getAnnouncementList(@Param("pageNo") int pageNo, @Param("pageSize") int pageSize);
	
	/**
	 * 获得公告数量
	 * @return
	 */
	int getAnnouncementCount();
}
