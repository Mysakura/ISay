package com.internetsaying.post.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.internetsaying.user.entity.User;

/**
 * 
 * 模块名称：帖子评论
 * 一个评论对应一个帖子
 * 一个评论对应多个回复
 * 一个评论对应一个评论者】
 *
 * @author 董昕杰
 * @since 2017年12月9日
 */
public class PostComment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3523417631110631998L;
	
	private String commentId;
	private String commentContent;
	private Date commentTime;
	// 评论者
	private User user;
	// 对应的帖子
	private Post post;
	private int replyNum;
	private String isDelete;
	// 对应的回复
	private List<PostReply> postReplies = new ArrayList<>();
	public PostComment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PostComment(String commentId) {
		super();
		this.commentId = commentId;
	}

	public PostComment(String commentId, String isDelete, Post post) {
		super();
		this.commentId = commentId;
		this.isDelete = isDelete;
		this.post = post;
	}

	public PostComment(String commentId, String commentContent, Date commentTime, User user, Post post) {
		super();
		this.commentId = commentId;
		this.commentContent = commentContent;
		this.commentTime = commentTime;
		this.user = user;
		this.post = post;
	}
	public String getCommentId() {
		return commentId;
	}
	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public Date getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	public List<PostReply> getPostReplies() {
		return postReplies;
	}
	public void setPostReplies(List<PostReply> postReplies) {
		this.postReplies = postReplies;
	}
	public String getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}
	public int getReplyNum() {
		return replyNum;
	}
	public void setReplyNum(int replyNum) {
		this.replyNum = replyNum;
	}
	@Override
	public String toString() {
		return "PostComment [commentId=" + commentId + ", commentContent=" + commentContent + ", commentTime="
				+ commentTime + ", user=" + user.getUserId() + ", post=" + post + ", replyNum=" + replyNum + ", isDelete="
				+ isDelete + ", postReplies=" + postReplies + "]";
	}
	
}
