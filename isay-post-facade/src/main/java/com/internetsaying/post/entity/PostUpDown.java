package com.internetsaying.post.entity;

import java.io.Serializable;

public class PostUpDown implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3229422116403372552L;
	private Integer id;
	private String postId;
	private String userId;
	private String type;
	
	public PostUpDown() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PostUpDown(Integer id) {
		super();
		this.id = id;
	}

	public PostUpDown(Integer id, String type) {
		super();
		this.id = id;
		this.type = type;
	}

	public PostUpDown(String postId, String userId, String type) {
		super();
		this.postId = postId;
		this.userId = userId;
		this.type = type;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "PostUpDown [id=" + id + ", postId=" + postId + ", userId=" + userId + ", type=" + type + "]";
	}
	
}
