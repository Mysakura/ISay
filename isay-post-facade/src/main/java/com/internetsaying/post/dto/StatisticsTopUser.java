package com.internetsaying.post.dto;

import java.io.Serializable;

public class StatisticsTopUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 386438863987293292L;

	private String userId;
	private Integer num;
	public StatisticsTopUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StatisticsTopUser(String userId, Integer num) {
		super();
		this.userId = userId;
		this.num = num;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	
	
}
