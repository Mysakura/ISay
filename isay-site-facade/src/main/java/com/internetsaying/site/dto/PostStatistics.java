package com.internetsaying.site.dto;

import java.io.Serializable;

import com.internetsaying.post.entity.Post;

/**
 * 浏览最多的，评论最多的，收藏最多的，获赞最多的，反对最多的(帖子)--柱形图
 * @author dong
 *
 */
public class PostStatistics implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 421881832861492505L;

	private Integer visitNum;
	private Post visitPost;
	private Integer commentNum;
	private Post commentPost;
	private Integer collectNum;
	private Post collectPost;
	private Integer upNum;
	private Post upPost;
	private Integer downNum;
	private Post downPost;
	public PostStatistics() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PostStatistics(Integer visitNum, Post visitPost, Integer commentNum, Post commentPost, Integer collectNum,
			Post collectPost, Integer upNum, Post upPost, Integer downNum, Post downPost) {
		super();
		this.visitNum = visitNum;
		this.visitPost = visitPost;
		this.commentNum = commentNum;
		this.commentPost = commentPost;
		this.collectNum = collectNum;
		this.collectPost = collectPost;
		this.upNum = upNum;
		this.upPost = upPost;
		this.downNum = downNum;
		this.downPost = downPost;
	}

	public Integer getVisitNum() {
		return visitNum;
	}
	public void setVisitNum(Integer visitNum) {
		this.visitNum = visitNum;
	}
	public Post getVisitPost() {
		return visitPost;
	}
	public void setVisitPost(Post visitPost) {
		this.visitPost = visitPost;
	}
	
	public Integer getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(Integer commentNum) {
		this.commentNum = commentNum;
	}

	public Post getCommentPost() {
		return commentPost;
	}

	public void setCommentPost(Post commentPost) {
		this.commentPost = commentPost;
	}

	public Integer getCollectNum() {
		return collectNum;
	}
	public void setCollectNum(Integer collectNum) {
		this.collectNum = collectNum;
	}
	public Post getCollectPost() {
		return collectPost;
	}
	public void setCollectPost(Post collectPost) {
		this.collectPost = collectPost;
	}
	public Integer getUpNum() {
		return upNum;
	}
	public void setUpNum(Integer upNum) {
		this.upNum = upNum;
	}
	public Post getUpPost() {
		return upPost;
	}
	public void setUpPost(Post upPost) {
		this.upPost = upPost;
	}
	public Integer getDownNum() {
		return downNum;
	}
	public void setDownNum(Integer downNum) {
		this.downNum = downNum;
	}
	public Post getDownPost() {
		return downPost;
	}
	public void setDownPost(Post downPost) {
		this.downPost = downPost;
	}
	
}
