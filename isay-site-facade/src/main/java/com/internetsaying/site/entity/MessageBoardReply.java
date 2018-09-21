package com.internetsaying.site.entity;

import java.io.Serializable;
import java.util.Date;

import com.internetsaying.user.entity.User;

public class MessageBoardReply implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -762206971329264067L;
	private String mrId;
	private String mrContent;
	private Date mrTime;
	private MessageBoard mrMessage;
	private User fromUser;
	private User toUser;
	private String isDelete;
	public MessageBoardReply() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MessageBoardReply(String mrId, String mrContent, Date mrTime, MessageBoard mrMessage, User fromUser,
			User toUser) {
		super();
		this.mrId = mrId;
		this.mrContent = mrContent;
		this.mrTime = mrTime;
		this.mrMessage = mrMessage;
		this.fromUser = fromUser;
		this.toUser = toUser;
	}
	public String getMrId() {
		return mrId;
	}
	public void setMrId(String mrId) {
		this.mrId = mrId;
	}
	public String getMrContent() {
		return mrContent;
	}
	public void setMrContent(String mrContent) {
		this.mrContent = mrContent;
	}
	public Date getMrTime() {
		return mrTime;
	}
	public void setMrTime(Date mrTime) {
		this.mrTime = mrTime;
	}
	public MessageBoard getMrMessage() {
		return mrMessage;
	}
	public void setMrMessage(MessageBoard mrMessage) {
		this.mrMessage = mrMessage;
	}
	public User getFromUser() {
		return fromUser;
	}
	public void setFromUser(User fromUser) {
		this.fromUser = fromUser;
	}
	public User getToUser() {
		return toUser;
	}
	public void setToUser(User toUser) {
		this.toUser = toUser;
	}
	public String getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}
	@Override
	public String toString() {
		return "MessageBoardReply [mrId=" + mrId + ", mrContent=" + mrContent + ", mrTime=" + mrTime + ", mrMessage="
				+ mrMessage + ", fromUser=" + fromUser + ", toUser=" + toUser + ", isDelete=" + isDelete + "]";
	}
	
}
