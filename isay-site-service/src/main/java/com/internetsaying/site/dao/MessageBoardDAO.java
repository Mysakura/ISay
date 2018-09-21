package com.internetsaying.site.dao;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.internetsaying.site.entity.MessageBoard;
import com.internetsaying.site.entity.MessageBoardReply;

@Repository
public interface MessageBoardDAO {
	
	/**
	 * 添加留言
	 * @param messageBoard
	 * @return
	 */
	int addMessage(MessageBoard messageBoard);
	
	/**
	 * 更新留言
	 * @param messageBoard
	 * @return
	 */
	int updateMessage(MessageBoard messageBoard);
	
	/**
	 * 检查留言是否属于某个用户
	 * @param messageBoard
	 * @return
	 */
	int checkMessageBelong(MessageBoard messageBoard);
	
	/**
	 * 留言列表
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<MessageBoard> getMessageList(@Param("pageNo") int pageNo, @Param("pageSize") int pageSize);
	
	/**
	 * 获得留言列表里面涉及所有回复的用户ID
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	Set<String> getUserIdsOfMessageList(@Param("mIds") Set<String> mIds);
	
	/**
	 * 获得留言数量
	 * @return
	 */
	int getMessageCount();
	
	/**
	 * 添加回复,流程类似于删除留言
	 * @param reply
	 * @return
	 */
	int addReply(MessageBoardReply reply);
	
	/**
	 * 删除回复，实际是更新
	 * @param reply
	 * @return
	 */
	int updateReply(MessageBoardReply reply);
	
	/**
	 * 检查回复是否属于某个用户
	 * @param messageBoard
	 * @return
	 */
	int checkReplyBelong(MessageBoardReply reply);
	
	/**
	 * 获得回复列表（全部）
	 * @param messageId
	 * @return
	 */
	List<MessageBoardReply> getReplyList(@Param("messageId") String messageId);

	/**
	 * 获得回复数量
	 * @return
	 */
	int getReplyCount();
	
}
