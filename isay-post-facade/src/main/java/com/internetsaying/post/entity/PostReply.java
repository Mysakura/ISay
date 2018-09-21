package com.internetsaying.post.entity;

import java.io.Serializable;
import java.util.Date;

import com.internetsaying.user.entity.User;

/**
 * 
 * 模块名称：帖子回复
 *
 * @author 董昕杰
 * @since 2017年12月9日
 */
public class PostReply implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4173752736682632829L;
	private String replyId;
	private String replyContent;
	private Date replyTime;
	
	// 回复者
	private User replyUser;
	// 回复目标
	private User targetUser;
	private String isDelete;
	// 对应的评论
	private PostComment postComment;
	public PostReply() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PostReply(String replyId, String isDelete, PostComment postComment) {
		super();
		this.replyId = replyId;
		this.isDelete = isDelete;
		this.postComment = postComment;
	}

	public PostReply(String replyId, String replyContent, Date replyTime, User replyUser, User targetUser,
			PostComment postComment) {
		super();
		this.replyId = replyId;
		this.replyContent = replyContent;
		this.replyTime = replyTime;
		this.replyUser = replyUser;
		this.targetUser = targetUser;
		this.postComment = postComment;
	}

	public String getReplyId() {
		return replyId;
	}
	public void setReplyId(String replyId) {
		this.replyId = replyId;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public Date getReplyTime() {
		return replyTime;
	}
	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}
	public User getReplyUser() {
		return replyUser;
	}
	public void setReplyUser(User replyUser) {
		this.replyUser = replyUser;
	}
	public User getTargetUser() {
		return targetUser;
	}
	public void setTargetUser(User targetUser) {
		this.targetUser = targetUser;
	}
	public PostComment getPostComment() {
		return postComment;
	}
	public void setPostComment(PostComment postComment) {
		this.postComment = postComment;
	}
	public String getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}

	@Override
	public String toString() {
		return "PostReply [replyId=" + replyId + ", replyContent=" + replyContent + ", replyTime=" + replyTime
				+ ", replyUser=" + replyUser + ", targetUser=" + targetUser + ", isDelete=" + isDelete
				+ ", postComment=" + postComment.getCommentId() + "]";
	}
	
}
