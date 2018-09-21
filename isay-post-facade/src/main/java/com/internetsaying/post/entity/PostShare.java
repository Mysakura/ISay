package com.internetsaying.post.entity;

import java.io.Serializable;
import java.util.Date;

import com.internetsaying.user.entity.User;

/**
 * 
 * 模块名称：共享帖子
 *
 * @author 董昕杰
 * @since 2018-05-19
 */
public class PostShare implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1527705171754370423L;
	private Integer shareId;
	private String postId;
	private String postContent;
	private String postMarkdown;
	private Date postTime;
	private User user;
	private Date modifyTime;
	private String isDelete;
	
	public PostShare() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PostShare(Integer shareId, String postContent, String postMarkdown, Date modifyTime) {
		super();
		this.shareId = shareId;
		this.postContent = postContent;
		this.postMarkdown = postMarkdown;
		this.modifyTime = modifyTime;
	}

	public PostShare(String postId, String postContent, String postMarkdown, Date postTime, User user,
			Date modifyTime) {
		super();
		this.postId = postId;
		this.postContent = postContent;
		this.postMarkdown = postMarkdown;
		this.postTime = postTime;
		this.user = user;
		this.modifyTime = modifyTime;
	}

	public Integer getShareId() {
		return shareId;
	}

	public void setShareId(Integer shareId) {
		this.shareId = shareId;
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public String getPostMarkdown() {
		return postMarkdown;
	}

	public void setPostMarkdown(String postMarkdown) {
		this.postMarkdown = postMarkdown;
	}

	public Date getPostTime() {
		return postTime;
	}

	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}

	@Override
	public String toString() {
		return "PostShare [shareId=" + shareId + ", postId=" + postId + ", postContent=" + postContent
				+ ", postMarkdown=" + postMarkdown + ", postTime=" + postTime + ", user=" + user + ", modifyTime="
				+ modifyTime + ", isDelete=" + isDelete + "]";
	}

	
	
}
