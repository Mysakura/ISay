package com.internetsaying.post.dao;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.internetsaying.post.entity.Chat;
import com.internetsaying.post.entity.ChatReply;

@Repository
public interface ChatDAO {

	/**
	 * 添加闲聊
	 * @param chat
	 * @return
	 */
	int addChat(Chat chat);
	
	/**
	 * 删除闲聊，仅仅本人或者有删除权限的管理员可以操作，实际上是更新is_delete字段
	 * @param chatId
	 * @return
	 */
	int deleteChat(@Param("chatId") String chatId);
	
	/**
	 * 获取闲聊列表【策略：每个闲聊下面只显示固定数量的回复，想看更多回复，要到这条闲聊的详细页面】
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<Chat> getChats(@Param("pageNo") int pageNo, @Param("pageSize") int pageSize);
	
	/**
	 * 获得个人的闲聊记录
	 * @param userId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<Chat> getChatsPersonally(@Param("userId") String userId, @Param("pageNo") int pageNo, @Param("pageSize") int pageSize);
	
	/**
	 * 添加回复
	 * @param reply
	 * @return
	 */
	int addChatReply(ChatReply reply);
	
	/**
	 * 删除回复：仅仅本人或者有删除权限的管理员可以操作，实际上是更新is_delete字段
	 * @param replyId
	 * @return
	 */
	int deleteChatReply(@Param("replyId") String replyId);
	
	/**
	 * 获取闲聊下面的所有回复
	 * @param chatId
	 * @return
	 */
	List<ChatReply> getReplies(@Param("chatId") String chatId);
	
	/**
	 * 获得闲聊数量
	 * @return
	 */
	int getChatCount();
	
	/**
	 * 获得闲聊数量:用户
	 * @return
	 */
	int getChatCountPersonally(@Param("userId") String userId);
	
	/**
	 * 验证用户与闲聊
	 * @param userId
	 * @param chatId
	 * @return
	 */
	int checkUserChat(@Param("userId") String userId, @Param("chatId") String chatId);
	
	/**
	 * 验证用户与闲聊回复
	 * @param userId
	 * @param replyId
	 * @return
	 */
	int checkUserChatReply(@Param("userId") String userId, @Param("replyId") String replyId);
	
	/**
	 * 获得闲聊回复涉及的所有用户Id
	 * @param mIds
	 * @return
	 */
	Set<String> getUserIdsOfChatReply(@Param("cIds") Set<String> cIds);
	
}
