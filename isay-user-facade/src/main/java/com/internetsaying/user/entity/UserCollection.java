package com.internetsaying.user.entity;

import java.io.Serializable;

public class UserCollection implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7326362507293716740L;
	
	private Integer collectionId;
	private String userId;
	private String postId;
	
	public UserCollection() {
		super();
	}

	public UserCollection(String userId, String postId) {
		super();
		this.userId = userId;
		this.postId = postId;
	}

	public Integer getCollectionId() {
		return collectionId;
	}

	public void setCollectionId(Integer collectionId) {
		this.collectionId = collectionId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	@Override
	public String toString() {
		return "Collection [collectionId=" + collectionId + ", userId=" + userId + ", postId=" + postId + "]";
	}

}
