package com.internetsaying.site.service;

import java.util.List;

import com.internetsaying.exception.CommonException;
import com.internetsaying.site.entity.TimeLine;

public interface TimeLineService {

	/**
	 * 添加事件
	 * @param line
	 * @return
	 */
	int addTimeLine(TimeLine line) throws CommonException;
	
	/**
	 * 更新事件
	 * @param line
	 * @return
	 */
	int updateTimeLine(TimeLine line) throws CommonException;
	
	/**
	 * 删除事件
	 * @param tlId
	 * @return
	 */
	int deleteTimeLine(String tlId) throws CommonException;
	
	/**
	 * 不分页是因为本模块仅仅记录重大事件，数据量小
	 * @return
	 */
	List<TimeLine> getTimeLineList() throws CommonException;
}
