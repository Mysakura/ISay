package com.internetsaying.post.service;

import java.util.List;

import com.internetsaying.exception.CommonException;
import com.internetsaying.post.dto.ReceivePotDetail;
import com.internetsaying.post.entity.ThrowPot;
import com.internetsaying.post.entity.ThrowPotDetail;

/**
 * 甩锅业务
 * @author dong
 *
 */
public interface ThrowPotService {

	/**
	 * 获取某个领域对应的“送出”情况
	 * @param areaId
	 * @return
	 */
	ThrowPot getThrowPotByArea(int areaId) throws CommonException;
	
	/**
	 * 获得某个领域收到礼物的情况
	 * 这里比较难办，这里查询的不是数据库的实体，查询的结果需要重新封装在一个供前台显示的类里
	 * @param areaId
	 * @return
	 */
	List<ReceivePotDetail> getReceiveInfo(int areaId) throws CommonException;
	
	/**
	 * 添加甩锅详情
	 * @param detail
	 * @return
	 */
	int addThrowPotDetail(ThrowPotDetail detail) throws CommonException;
	
	/**
	 * 获取某个领域的甩锅动态
	 * @param areaId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<ThrowPotDetail> getDetailListByArea(int areaId, int pageNo, int pageSize) throws CommonException;
	
}
