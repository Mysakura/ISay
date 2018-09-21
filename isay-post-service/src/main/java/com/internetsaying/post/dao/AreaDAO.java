package com.internetsaying.post.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.internetsaying.post.entity.AreaLabel;
import com.internetsaying.post.entity.WorkArea;

@Repository
public interface AreaDAO {

	/**
	 * 添加Area,批量
	 * @param area
	 * @return
	 */
	int addArea(@Param("areaList") List<WorkArea> areas);
	
	/**
	 * 更新Area名字
	 * @param area
	 * @return
	 */
	int updateArea(WorkArea area);
	
	/**
	 * 删除Area
	 * @param areaId
	 * @return
	 */
	int deleteArea(@Param("areaId") int areaId);
	
	/**
	 * 获取所有领域
	 * @return
	 */
	List<WorkArea> getAreas();
	
	/**
	 * 添加领域标签,批量
	 * @param label
	 * @return
	 */
	int addAreaLabel(@Param("labelList") List<AreaLabel> labels);
	
	/**
	 * 更新领域标签名字
	 * @param label
	 * @return
	 */
	int updateAreaLabel(AreaLabel label);
	
	/**
	 * 删除领域标签
	 * @param labelId
	 * @return
	 */
	int deleteAreaLabel(@Param("labelId") int labelId);
	
	/**
	 * 获得领域对应的标签
	 * @param areaId
	 * @return
	 */
	List<AreaLabel> getAreaLabel(@Param("areaId") int areaId);

	/**
	 * 根据id获取领域
	 * @param areaId
	 * @return
	 */
	WorkArea getAreaById(@Param("areaId") int areaId);
	
	/**
	 * 根据领域名获得id
	 * @param areaName
	 * @return
	 */
	int getAreaIdByName(@Param("areaName") String areaName);
}
