package com.internetsaying.post.entity;

import java.io.Serializable;
import java.util.Date;

import com.internetsaying.user.entity.User;

/**
 * 
 * 模块名称：闲聊回复
 *
 * @author 董昕杰
 * @since 2017年12月9日
 */
public class ChatReply implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1176955335535305561L;
	private String replyId;
	private String replyContent;
	private Date replyTime;
	
	private User replyUser;
	private User targetUser;
	private Chat chat;
	private String isDelete;
	public ChatReply() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ChatReply(String replyId, User replyUser) {
		super();
		this.replyId = replyId;
		this.replyUser = replyUser;
	}

	public ChatReply(String replyId, String replyContent, Date replyTime, User replyUser, User targetUser, Chat chat) {
		super();
		this.replyId = replyId;
		this.replyContent = replyContent;
		this.replyTime = replyTime;
		this.replyUser = replyUser;
		this.targetUser = targetUser;
		this.chat = chat;
	}

	public ChatReply(String replyId) {
		super();
		this.replyId = replyId;
	}

	public String getReplyId() {
		return replyId;
	}
	public void setReplyId(String replyId) {
		this.replyId = replyId;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public Date getReplyTime() {
		return replyTime;
	}
	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}
	public User getReplyUser() {
		return replyUser;
	}
	public void setReplyUser(User replyUser) {
		this.replyUser = replyUser;
	}
	public User getTargetUser() {
		return targetUser;
	}
	public void setTargetUser(User targetUser) {
		this.targetUser = targetUser;
	}
	public Chat getChat() {
		return chat;
	}
	public void setChat(Chat chat) {
		this.chat = chat;
	}
	public String getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}

	@Override
	public String toString() {
		return "ChatReply [replyId=" + replyId + ", replyContent=" + replyContent + ", replyTime=" + replyTime
				+ ", replyUser=" + replyUser + ", targetUser=" + targetUser + ", chat=" + chat + ", isDelete="
				+ isDelete + "]";
	}
	
	
}
