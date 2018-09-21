package com.internetsaying.user.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 粉丝展示DTO
 * @author 001977
 *
 */
public class FansDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3208908515796092604L;
	private String userId;
	private String nickname;
	private String userPhoto;
	private String job;
	private Date time;
	public FansDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getUserPhoto() {
		return userPhoto;
	}
	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
}
