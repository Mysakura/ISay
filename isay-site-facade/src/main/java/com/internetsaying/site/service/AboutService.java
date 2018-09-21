package com.internetsaying.site.service;

import java.util.List;

import com.internetsaying.exception.CommonException;
import com.internetsaying.site.entity.About;

public interface AboutService {

	/**
	 * 添加
	 * @param about
	 * @return
	 */
	int addAbout(About about) throws CommonException;
	
	/**
	 * 更新
	 * @param about
	 * @return
	 */
	int updateAbout(About about) throws CommonException;
	
	/**
	 * 删除
	 * @param aboutId
	 * @return
	 */
	int deleteAbout(String aboutId) throws CommonException;
	
	/**
	 * 关于站点
	 * @return
	 */
	About getAboutSiteOfNew() throws CommonException;
	
	/**
	 * 关于作者
	 * @return
	 */
	About getAboutAuthorOfNew() throws CommonException;
	
	/**
	 * 联系方式
	 * @return
	 */
	About getAboutContactOfNew() throws CommonException;
	
	/**
	 * 获得About列表，按照类型分组。调用user服务，获得与about相关的管理员信息
	 * @return
	 */
	List<About> getAboutList() throws CommonException;
	
	/**
	 * 根据id获取About
	 * @param aboutId
	 * @return
	 * @throws CommonException
	 */
	About getAboutById(String aboutId) throws CommonException;
}
