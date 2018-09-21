package com.internetsaying.user.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 当用户评论，私信--放入消息队列发邮件+持久化
 * 模块名称：系统消息
 *
 * @author 董昕杰
 * @since 2018年1月5日
 */
public class SystemMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 473459125019625497L;
	private String id;
	private User user;
	private String msgContent;
	private Date time;
	public SystemMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	// 删除
	public SystemMessage(String id) {
		super();
		this.id = id;
	}
	// 添加
	public SystemMessage(String id, User user, String msgContent, Date time) {
		super();
		this.id = id;
		this.user = user;
		this.msgContent = msgContent;
		this.time = time;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getMsgContent() {
		return msgContent;
	}
	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "SystemMessage [id=" + id + ", user=" + user + ", msgContent=" + msgContent + ", time=" + time + "]";
	}
	
}
