package com.internetsaying.post.service;

import java.util.List;

import com.internetsaying.exception.CommonException;
import com.internetsaying.post.entity.Chat;
import com.internetsaying.post.entity.ChatReply;
import com.internetsaying.user.entity.User;

/**
 * 闲聊业务
 * @author dong
 *
 */
public interface ChatService {

	/**
	 * 添加闲聊
	 * @param chat
	 * @return
	 */
	int addChat(Chat chat) throws CommonException;
	
	/**
	 * 删除闲聊，仅仅本人或者有删除权限的管理员可以操作，实际上是更新is_delete字段
	 * 0-失败；1-成功；-1-无权限
	 * @param chat
	 * @param deleter	执行此操作的人
	 * @return
	 */
	int deleteChat(Chat chat, User deleter) throws CommonException;
	
	/**
	 * 获取闲聊列表【策略：每个闲聊下面只显示固定数量的回复，想看更多回复，要到这条闲聊的详细页面】
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<Chat> getChats(int pageNo, int pageSize) throws CommonException;
	
	/**
	 * 获得个人的闲聊记录
	 * @param userId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<Chat> getChatsPersonally(String userId, int pageNo, int pageSize) throws CommonException;
	
	/**
	 * 添加回复
	 * @param reply
	 * @return
	 */
	int addChatReply(ChatReply reply) throws CommonException;
	
	/**
	 * 删除回复：仅仅本人或者有删除权限的管理员可以操作，实际上是更新is_delete字段
	 * @param reply
	 * @param deleter	执行此操作的人
	 * @return
	 */
	int deleteChatReply(ChatReply reply, User deleter) throws CommonException;

	/**
	 * 获取闲聊下面的所有回复
	 * @param chatId
	 * @return
	 */
	List<ChatReply> getReplies(String chatId) throws CommonException;
	
	/**
	 * 获得闲聊数量
	 * @return
	 */
	int getChatCount() throws CommonException;
	
	/**
	 * 获得用户的闲聊数量
	 * @param userId
	 * @return
	 * @throws CommonException
	 */
	int getChatCountPersonally(String userId) throws CommonException;
	
	/**
	 * 获取闲聊下面的回复，分页
	 * @param chatId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@Deprecated
	List<ChatReply> getReplies(String chatId, int pageNo, int pageSize) throws CommonException;
	
	
	/**
	 * 获得回复数量
	 * @return
	 */
	@Deprecated
	int getChatReplyCount() throws CommonException;
}
