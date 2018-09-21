package com.internetsaying.site.dto;

import java.io.Serializable;

import com.internetsaying.user.entity.User;

/**
 * 获赞最多的，反对最多的，发帖最多的(用户)--柱形图
 * @author dong
 *
 */
public class UserStatistics implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5348179019193814823L;

	private Integer postNum;
	private User postUser;
	private Integer upNum;
	private User upUser;
	private Integer downNum;
	private User downUser;
	public UserStatistics() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserStatistics(Integer postNum, User postUser, Integer upNum, User upUser, Integer downNum, User downUser) {
		super();
		this.postNum = postNum;
		this.postUser = postUser;
		this.upNum = upNum;
		this.upUser = upUser;
		this.downNum = downNum;
		this.downUser = downUser;
	}
	public Integer getPostNum() {
		return postNum;
	}
	public void setPostNum(Integer postNum) {
		this.postNum = postNum;
	}
	public User getPostUser() {
		return postUser;
	}
	public void setPostUser(User postUser) {
		this.postUser = postUser;
	}
	public Integer getUpNum() {
		return upNum;
	}
	public void setUpNum(Integer upNum) {
		this.upNum = upNum;
	}
	public User getUpUser() {
		return upUser;
	}
	public void setUpUser(User upUser) {
		this.upUser = upUser;
	}
	public Integer getDownNum() {
		return downNum;
	}
	public void setDownNum(Integer downNum) {
		this.downNum = downNum;
	}
	public User getDownUser() {
		return downUser;
	}
	public void setDownUser(User downUser) {
		this.downUser = downUser;
	}
	
}
