package com.internetsaying.post.dto;

import java.io.Serializable;

public class StatisticsTopPost implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 386438863987293292L;

	private String postId;
	private String postTitle;
	private Integer num;
	public StatisticsTopPost() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public StatisticsTopPost(String postId, String postTitle, Integer num) {
		super();
		this.postId = postId;
		this.postTitle = postTitle;
		this.num = num;
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	
	
}
