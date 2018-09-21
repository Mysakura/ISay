package com.internetsaying.post.service;

import java.util.List;

import com.internetsaying.exception.CommonException;
import com.internetsaying.post.entity.AreaLabel;
import com.internetsaying.post.entity.WorkArea;

/**
 * 工作领域业务
 * @author dong
 *
 */
public interface AreaService {

	/**
	 * 添加Area
	 * @param area
	 * @return
	 */
	int addArea(List<WorkArea> area) throws CommonException;
	
	/**
	 * 更新Area名字
	 * @param area
	 * @return
	 */
	int updateArea(WorkArea area) throws CommonException;
	
	/**
	 * 删除Area
	 * @param areaId
	 * @return
	 */
	int deleteArea(int areaId) throws CommonException;
	
	/**
	 * 获取所有领域
	 * @return
	 */
	List<WorkArea> getAreas() throws CommonException;
	
	/**
	 * 添加领域标签
	 * @param label
	 * @return
	 */
	int addAreaLabel(List<AreaLabel> label) throws CommonException;
	
	/**
	 * 更新领域标签名字
	 * @param label
	 * @return
	 */
	int updateAreaLabel(AreaLabel label) throws CommonException;
	
	/**
	 * 删除领域标签
	 * @param labelId
	 * @return
	 */
	int deleteAreaLabel(int labelId) throws CommonException;
	
	/**
	 * 获得领域对应的标签
	 * @param areaId
	 * @return
	 */
	List<AreaLabel> getAreaLabel(int areaId) throws CommonException;
	
	/**
	 * 根据领域名字获得ID
	 * @param areaName
	 * @return
	 */
	int getAreaIdByName(String areaName);
	
}
