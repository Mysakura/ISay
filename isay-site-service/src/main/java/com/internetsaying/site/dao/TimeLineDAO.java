package com.internetsaying.site.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.internetsaying.site.entity.TimeLine;

@Repository
public interface TimeLineDAO {

	/**
	 * 添加事件
	 * @param line
	 * @return
	 */
	int addTimeLine(TimeLine line);
	
	/**
	 * 更新事件
	 * @param line
	 * @return
	 */
	int updateTimeLine(TimeLine line);
	
	/**
	 * 删除事件
	 * @param tlId
	 * @return
	 */
	int deleteTimeLine(@Param("tlId") String tlId);
	
	/**
	 * 不分页是因为本模块仅仅记录重大事件，数据量小
	 * @return
	 */
	List<TimeLine> getTimeLineList();
}
