package com.internetsaying.post.dto;

import java.io.Serializable;

public class StatisticsTopTenUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2083598454190324136L;

	private String userId;
	private Integer upNum;
	private Integer downNum;
	private Integer visitNum;
	public StatisticsTopTenUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StatisticsTopTenUser(String userId, Integer upNum, Integer downNum, Integer visitNum) {
		super();
		this.userId = userId;
		this.upNum = upNum;
		this.downNum = downNum;
		this.visitNum = visitNum;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Integer getUpNum() {
		return upNum;
	}
	public void setUpNum(Integer upNum) {
		this.upNum = upNum;
	}
	public Integer getDownNum() {
		return downNum;
	}
	public void setDownNum(Integer downNum) {
		this.downNum = downNum;
	}
	public Integer getVisitNum() {
		return visitNum;
	}
	public void setVisitNum(Integer visitNum) {
		this.visitNum = visitNum;
	}
	
}
