package com.internetsaying.post.dto;

import java.io.Serializable;

public class StatisticsTopTenPost implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2274120745830255619L;

	private String postId;
	private String postTitle;
	private Integer visitNum;
	private Integer commentNum;
	public StatisticsTopTenPost() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public StatisticsTopTenPost(String postId, String postTitle, Integer visitNum, Integer commentNum) {
		super();
		this.postId = postId;
		this.postTitle = postTitle;
		this.visitNum = visitNum;
		this.commentNum = commentNum;
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

	public Integer getVisitNum() {
		return visitNum;
	}
	public void setVisitNum(Integer visitNum) {
		this.visitNum = visitNum;
	}
	public Integer getCommentNum() {
		return commentNum;
	}
	public void setCommentNum(Integer commentNum) {
		this.commentNum = commentNum;
	}
	
}
