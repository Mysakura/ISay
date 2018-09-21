package com.internetsaying.post.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.internetsaying.exception.CommonException;
import com.internetsaying.exception.enums.ExceptionEnum;
import com.internetsaying.post.dao.ChatDAO;
import com.internetsaying.post.entity.Chat;
import com.internetsaying.post.entity.ChatReply;
import com.internetsaying.post.service.ChatService;
import com.internetsaying.user.entity.User;
import com.internetsaying.user.service.UserService;

@Transactional(rollbackFor=Exception.class)
@Service
public class ChatServiceImpl implements ChatService {

	@Autowired
	private ChatDAO chatDAO;
	
	@Autowired
	private UserService userService;
	
	private static Logger log = LoggerFactory.getLogger(ChatServiceImpl.class);
	
	@Override
	public int addChat(Chat chat) {
		return chatDAO.addChat(chat);
	}

	@Override
	public int deleteChat(Chat chat, User deleter) {
		// 检查用户身份
		// 本条数据所有者
		int checkUserChat = chatDAO.checkUserChat(deleter.getUserId(), chat.getChatId());
		if(checkUserChat == 1) {
			log.info("闲聊：本人删除：{}，闲聊ID：{}", deleter.getNickname(), chat.getChatId());
			return chatDAO.deleteChat(chat.getChatId());
		}else {
			// 拥有删除权限的管理员
			boolean permit = false;
			for(int i = 0; i < deleter.getRoles().size(); i++) {
				if("admin".equals(deleter.getRoles().get(i).getRoleName())) {
					log.info("闲聊回复：管理员删除：{}，闲聊回复ID：{}", deleter.getNickname(), chat.getChatId());
					permit = true;
				}
			}
			if(permit) {
				return chatDAO.deleteChat(chat.getChatId());
			}else {
				// 其它
				throw new CommonException(ExceptionEnum.CHAT_DEL_NO_PERMIT.code, ExceptionEnum.CHAT_DEL_NO_PERMIT.msg);
			}
		}
	}

	@Override
	public List<Chat> getChats(int pageNo, int pageSize) {
		List<Chat> chats = chatDAO.getChats((pageNo-1)*pageSize, pageSize);
		if(chats.isEmpty())
			return chats;
		// 用户服务
		Set<String> ids = new HashSet<>();
		Set<String> cIds = new HashSet<>();
		for(Chat c : chats) {
			cIds.add(c.getChatId());
			ids.add(c.getUser().getUserId());
		}
		Set<String> idsOfChatReply = chatDAO.getUserIdsOfChatReply(cIds);
		ids.addAll(idsOfChatReply);
		Map<String, User> specificUsers = userService.getSpecificUsers(ids);
		for(Chat c : chats) {
			c.setUser(specificUsers.get(c.getUser().getUserId()));
			for(ChatReply r : c.getReplies()) {
				r.setReplyUser(specificUsers.get(r.getReplyUser().getUserId()));
				r.setTargetUser(specificUsers.get(r.getTargetUser().getUserId()));
			}
		}
		
		return chats;
	}

	@Override
	public List<Chat> getChatsPersonally(String userId, int pageNo, int pageSize) {
		List<Chat> chats = chatDAO.getChatsPersonally(userId, (pageNo-1)*pageSize, pageSize);
		if(chats.isEmpty())
			return chats;
		// 用户服务
		Set<String> ids = new HashSet<>();
		Set<String> cIds = new HashSet<>();
		for(Chat c : chats) {
			cIds.add(c.getChatId());
			ids.add(c.getUser().getUserId());
		}
		Set<String> idsOfChatReply = chatDAO.getUserIdsOfChatReply(cIds);
		ids.addAll(idsOfChatReply);
		Map<String, User> specificUsers = userService.getSpecificUsers(ids);
		for(Chat c : chats) {
			c.setUser(specificUsers.get(c.getUser().getUserId()));
			for(ChatReply r : c.getReplies()) {
				r.setReplyUser(specificUsers.get(r.getReplyUser().getUserId()));
				r.setTargetUser(specificUsers.get(r.getTargetUser().getUserId()));
			}
		}
		return chats;
	}

	@Override
	public int addChatReply(ChatReply reply) {
		return chatDAO.addChatReply(reply);
	}

	@Override
	public int deleteChatReply(ChatReply reply, User deleter) {
		// 检查用户身份
		// 本条数据所有者
		int checkUserChatReply = chatDAO.checkUserChatReply(deleter.getUserId(), reply.getReplyId());
		if(checkUserChatReply == 1) {
			log.info("闲聊回复：本人删除：{}，闲聊回复ID：{}", deleter.getNickname(), reply.getReplyId());
			return chatDAO.deleteChatReply(reply.getReplyId());
		}else {
			// 拥有删除权限的管理员
			boolean permit = false;
			for(int i = 0; i < deleter.getRoles().size(); i++) {
				if("admin".equals(deleter.getRoles().get(i).getRoleName())) {
					log.info("闲聊回复：管理员删除：{}，闲聊回复ID：{}", deleter.getNickname(), reply.getReplyId());
					permit = true;
				}
			}
			if(permit) {
				return chatDAO.deleteChatReply(reply.getReplyId());
			}else {
				// 其它
				throw new CommonException(ExceptionEnum.CHAT_REPLY_DEL_NO_PERMIT.code, ExceptionEnum.CHAT_REPLY_DEL_NO_PERMIT.msg);
			}
		}
	}

	@Override 
	public List<ChatReply> getReplies(String chatId, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ChatReply> getReplies(String chatId) {
		return chatDAO.getReplies(chatId);
	}

	@Override
	public int getChatCount() {
		return chatDAO.getChatCount();
	}

	@Override
	public int getChatCountPersonally(String userId) throws CommonException {
		return chatDAO.getChatCountPersonally(userId);
	}
	
	@Override
	public int getChatReplyCount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
