package com.internetsaying.site.service;

import java.util.List;

import com.internetsaying.exception.CommonException;
import com.internetsaying.site.entity.MessageBoard;
import com.internetsaying.site.entity.MessageBoardReply;

/**
 * 用户添加，除了进数据库，还要进缓存。更新也一样。
 * @author dong
 *
 */
public interface MessageBoardService {

	/**
	 * 添加留言
	 * @param messageBoard
	 * @return
	 */
	int addMessage(MessageBoard messageBoard) throws CommonException;
	
	/**
	 * 删除留言，实际是更新，管理员可以删除，留言的所有者也可以删除。
	 * 先验明身份，如果是带有删除权限的管理员，直接更新。
	 * 如果是无删除权限的管理员，拒绝。
	 * 如果是普通用户，还是留言的所有者，则可以更新。
	 * 其他不可以
	 * @param messageBoard
	 * @return 0-失败；1-成功；-1-无权限
	 */
	int deleteMessage(MessageBoard messageBoard) throws CommonException;
	
	/**
	 * 留言列表,利用缓存(还需要调用用户服务，获得留言对应的用户信息)
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<MessageBoard> getMessageList(int pageNo, int pageSize) throws CommonException;
	
	/**
	 * 获得留言数量
	 * @return
	 */
	int getMessageCount() throws CommonException;
	
	/**
	 * 添加回复,流程类似于删除留言
	 * @param reply
	 * @return
	 */
	int addReply(MessageBoardReply reply) throws CommonException;
	
	/**
	 * 删除回复，实际是更新
	 * @param reply
	 * @return
	 */
	int deleteReply(MessageBoardReply reply) throws CommonException;
	
	/**
	 * 获取回复列表（数据量大的时候，回复也需要分页，但目前这个方法不用）
	 * @param messageId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@Deprecated
	List<MessageBoardReply> getReplyList(String messageId, int pageNo, int pageSize) throws CommonException;
	
	/**
	 * 获得回复列表（全部）
	 * @param messageId
	 * @return
	 */
	List<MessageBoardReply> getReplyList(String messageId) throws CommonException;
}
