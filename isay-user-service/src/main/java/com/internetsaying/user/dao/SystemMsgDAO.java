package com.internetsaying.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.internetsaying.user.entity.SystemMessage;

@Repository
public interface SystemMsgDAO {

	/**
	 * 给用户发消息
	 * @param msg
	 * @return
	 */
	int addSystemMsg(SystemMessage msg);
	
	/**
	 * 删除消息
	 * @param msg
	 * @return
	 */
	int deleteSystemMsg(SystemMessage msg);
	
	/**
	 * 获取用户的消息
	 * @param userId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<SystemMessage> getSystemMsgListForUser(@Param("userId") String userId, @Param("pageNo") int pageNo, @Param("pageSize") int pageSize);
	
	/**
	 * 获取全部消息
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<SystemMessage> getSystemMsgListForAll(@Param("pageNo") int pageNo, @Param("pageSize") int pageSize);
	
	/**
	 * 获得用户的消息数量
	 * @param userId
	 * @return
	 */
	int getSysCountForUser(@Param("userId") String userId);
	
	/**
	 * 获得全部系统消息数量
	 * @return
	 */
	int getSysCountForAll();
}
