package com.internetsaying.user.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.internetsaying.exception.CommonException;
import com.internetsaying.user.entity.SystemMessage;

public interface SystemMsgService {

	/**
	 * 给用户发消息
	 * @param msg
	 * @return
	 */
	int addSystemMsg(SystemMessage msg) throws CommonException;
	
	/**
	 * 删除消息（仅仅管理员可操作）
	 * @param msg
	 * @return
	 */
	int deleteSystemMsg(SystemMessage msg) throws CommonException;
	
	/**
	 * 获取用户的消息
	 * @param userId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<SystemMessage> getSystemMsgList(String userId, int pageNo, int pageSize) throws CommonException;
	
	/**
	 * 获取全部消息
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<SystemMessage> getSystemMsgList(int pageNo, int pageSize) throws CommonException;
	
	/**
	 * 获得用户的消息数量
	 * @param userId
	 * @return
	 */
	int getSysCountForUser(@Param("userId") String userId) throws CommonException;
	
	/**
	 * 获得全部系统消息数量
	 * @return
	 */
	int getSysCountForAll() throws CommonException;
}
