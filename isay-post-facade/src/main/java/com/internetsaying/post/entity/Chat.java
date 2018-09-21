package com.internetsaying.post.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.internetsaying.user.entity.User;

/**
 * 
 * 模块名称：闲聊
 *
 * @author 董昕杰
 * @since 2017年12月9日
 */
public class Chat implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1031779161288981729L;
	private String chatId;
	private String chatContent;
	private Date chatTime;
	private User user;
	private String isDelete;
	private List<ChatReply> replies = new ArrayList<>();
	public Chat() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Chat(String chatId, User user) {
		super();
		this.chatId = chatId;
		this.user = user;
	}

	public Chat(String chatId, String chatContent, Date chatTime, User user) {
		super();
		this.chatId = chatId;
		this.chatContent = chatContent;
		this.chatTime = chatTime;
		this.user = user;
	}

	public Chat(String chatId) {
		super();
		this.chatId = chatId;
	}

	public String getChatId() {
		return chatId;
	}
	public void setChatId(String chatId) {
		this.chatId = chatId;
	}
	public String getChatContent() {
		return chatContent;
	}
	public void setChatContent(String chatContent) {
		this.chatContent = chatContent;
	}
	public Date getChatTime() {
		return chatTime;
	}
	public void setChatTime(Date chatTime) {
		this.chatTime = chatTime;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}
	public List<ChatReply> getReplies() {
		return replies;
	}
	public void setReplies(List<ChatReply> replies) {
		this.replies = replies;
	}

	@Override
	public String toString() {
		return "Chat [chatId=" + chatId + ", chatContent=" + chatContent + ", chatTime=" + chatTime + ", user=" + user
				+ ", isDelete=" + isDelete + ", replies=" + replies + "]";
	}
	
	
}
