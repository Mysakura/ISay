package com.internetsaying.site.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.internetsaying.exception.CommonException;
import com.internetsaying.exception.enums.ExceptionEnum;
import com.internetsaying.site.dao.MessageBoardDAO;
import com.internetsaying.site.entity.MessageBoard;
import com.internetsaying.site.entity.MessageBoardReply;
import com.internetsaying.site.service.MessageBoardService;
import com.internetsaying.user.entity.Role;
import com.internetsaying.user.entity.User;
import com.internetsaying.user.service.UserService;

@Transactional(rollbackFor=Exception.class)
@Service
public class MessageBoardServiceImpl implements MessageBoardService {

	@Autowired
	private MessageBoardDAO messageBoardDAO;
	
	@Autowired
	private UserService userService;
	
	@Override
	public int addMessage(MessageBoard messageBoard) {
		return messageBoardDAO.addMessage(messageBoard);
	}

	@Override
	public int deleteMessage(MessageBoard messageBoard) {
		User user = messageBoard.getUser();
		// 先检查该用户是否为该条留言的所有者
		int i = messageBoardDAO.checkMessageBelong(messageBoard);
		if(i == 1) {
			return messageBoardDAO.updateMessage(messageBoard);
		}else {
			// 如果不是，则判断是否是删除权限的管理员
			List<Role> roles = user.getRoles();
			for (Role role : roles) {
				if("AdminUpdate".equals(role.getRoleName()) || "AdminAll".equals(role.getRoleName())) {
					return messageBoardDAO.updateMessage(messageBoard);
				}
			}
			// 如果没有权限，就会抛异常，也就是说如果有权限，在前面就已经return了，不会执行到这一行
			throw new CommonException(ExceptionEnum.NO_PERMISSION.code, ExceptionEnum.NO_PERMISSION.msg);
		}
	}

	@Override
	public List<MessageBoard> getMessageList(int pageNo, int pageSize) {
		List<MessageBoard> messageList = messageBoardDAO.getMessageList(pageSize*(pageNo-1), pageSize);
		// 如果无数据，直接返回即可
		if(messageList.isEmpty()) {
			return messageList;
		}
		// 遍历，获取每条留言对应的留言ID和用户ID，放入一个set
		Set<String> mIds = new HashSet<>();
		Set<String> uIds = new HashSet<>();
		for (MessageBoard m : messageList) {
			mIds.add(m.getMessageId());
			uIds.add(m.getUser().getUserId());
		}
		// 利用mIds，查出所有回复涉及的用户
		Set<String> rIds = messageBoardDAO.getUserIdsOfMessageList(mIds);
		
		// 回复列表里面的用户合并到用户集合
		uIds.addAll(rIds);
		
		// 调用用户服务，传递uIds获得用户详细信息
		Map<String, User> specificUsers = userService.getSpecificUsers(uIds);
		// 遍历，给每条数据放置对应的用户详细信息
		for (MessageBoard m : messageList) {
			// 留言者
			String muId = m.getUser().getUserId();
			m.setUser(specificUsers.get(muId));
			for (MessageBoardReply r : m.getReplies()) {
				// 回复者
				String ruId = r.getFromUser().getUserId();
				r.setFromUser(specificUsers.get(ruId));
				// 被回复者
				ruId = r.getToUser().getUserId();
				r.setToUser(specificUsers.get(ruId));
			}
		}
		return messageList;
	}

	@Override
	public int getMessageCount() {
		return messageBoardDAO.getMessageCount();
	}
	
	@Override
	public int addReply(MessageBoardReply reply) {
		return messageBoardDAO.addReply(reply);
	}

	@Override
	public int deleteReply(MessageBoardReply reply) {
		User user = reply.getFromUser();
		// 先检查该用户是否为该条留言的所有者
		int i = messageBoardDAO.checkReplyBelong(reply);
		if(i == 1) {
			return messageBoardDAO.updateReply(reply);
		}else {
			// 如果不是，则判断是否是删除权限的管理员
			List<Role> roles = user.getRoles();
			for (Role role : roles) {
				if("AdminUpdate".equals(role.getRoleName()) || "AdminAll".equals(role.getRoleName())) {
					return messageBoardDAO.updateReply(reply);
				}
			}
			// 如果没有权限，就会抛异常，也就是说如果有权限，在前面就已经return了，不会执行到这一行
			throw new CommonException(ExceptionEnum.NO_PERMISSION.code, ExceptionEnum.NO_PERMISSION.msg);
		}
	}

	@Override
	public List<MessageBoardReply> getReplyList(String messageId, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MessageBoardReply> getReplyList(String messageId) {
		return messageBoardDAO.getReplyList(messageId);
	}

}
