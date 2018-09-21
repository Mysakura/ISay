package com.internetsaying.site.dto;

import java.io.Serializable;

import com.internetsaying.post.entity.Post;

/**
 * 根据赞成数选出前十名文章，并获取浏览量与评论数（散点图）
 * @author dong
 *
 */
public class PostTenStatistics implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2775499865854407656L;
	private Post post;
	private Integer visitNum;
	private Integer commentNum;
	public PostTenStatistics() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PostTenStatistics(Post post, Integer visitNum, Integer commentNum) {
		super();
		this.post = post;
		this.visitNum = visitNum;
		this.commentNum = commentNum;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
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
