package com.internetsaying.site.dto;

import java.io.Serializable;

import com.internetsaying.user.entity.User;

/**
 * 根据发帖量选出前10名用户，在查出10名用户的赞成数，反对数，以及浏览量（气泡图）
 * @author dong
 *
 */
public class PostUserStatistics implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7753820722403299182L;
	private User user;
	private Integer upNum;
	private Integer downNum;
	private Integer visitNum;
	public PostUserStatistics() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PostUserStatistics(User user, Integer upNum, Integer downNum, Integer visitNum) {
		super();
		this.user = user;
		this.upNum = upNum;
		this.downNum = downNum;
		this.visitNum = visitNum;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
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
