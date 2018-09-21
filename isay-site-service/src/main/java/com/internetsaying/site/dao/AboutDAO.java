package com.internetsaying.site.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.internetsaying.site.entity.About;

@Repository
public interface AboutDAO {

	/**
	 * 添加
	 * @param about
	 * @return
	 */
	int addAbout(About about);
	
	/**
	 * 更新
	 * @param about
	 * @return
	 */
	int updateAbout(About about);
	
	/**
	 * 删除
	 * @param aboutId
	 * @return
	 */
	int deleteAbout(@Param("aboutId") String aboutId);
	
	/**
	 * 根据id获取About
	 * @param aboutId
	 * @return
	 */
	About getAboutById(@Param("aboutId") String aboutId);
	
	/**
	 * 根据类型获取About，取最新的那一个
	 * @param type
	 * @return
	 */
	About getAboutByType(@Param("type") String type);
	
	/**
	 * 获得About列表，按照类型分组
	 * @return
	 */
	List<About> getAboutList();
}
