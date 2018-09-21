package com.internetsaying.site.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.internetsaying.user.entity.User;

public class MessageBoard implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2048622016308812160L;
	private String messageId;
	private String messageContent;
	private Date messageTime;
	private User user;
	private int replyNum;
	private String isDelete;
	private List<MessageBoardReply> replies = new ArrayList<>();
	public MessageBoard() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public MessageBoard(String messageId) {
		super();
		this.messageId = messageId;
	}

	public MessageBoard(String messageId, String messageContent, Date messageTime, User user) {
		super();
		this.messageId = messageId;
		this.messageContent = messageContent;
		this.messageTime = messageTime;
		this.user = user;
	}

	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	public String getMessageContent() {
		return messageContent;
	}
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	public Date getMessageTime() {
		return messageTime;
	}
	public void setMessageTime(Date messageTime) {
		this.messageTime = messageTime;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getReplyNum() {
		return replyNum;
	}
	public void setReplyNum(int replyNum) {
		this.replyNum = replyNum;
	}
	public String getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}
	public List<MessageBoardReply> getReplies() {
		return replies;
	}
	public void setReplies(List<MessageBoardReply> replies) {
		this.replies = replies;
	}
	@Override
	public String toString() {
		return "MessageBoard [messageId=" + messageId + ", messageContent=" + messageContent + ", messageTime="
				+ messageTime + ", user=" + user + ", replyNum=" + replyNum + ", isDelete=" + isDelete + ", replies="
				+ replies + "]";
	}
	
	
}
