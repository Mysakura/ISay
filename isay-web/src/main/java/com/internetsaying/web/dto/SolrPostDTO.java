package com.internetsaying.web.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * solr查询返回的数据
 * @author dong
 *
 */
public class SolrPostDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -316042902119107661L;
	
	private String postId;
	
	private String postTitle;
	
	private String postContent;
	
	private String postCover;
	
	private Date postTime;
	
	private String postQuery;
	
	public SolrPostDTO() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public String getPostCover() {
		return postCover;
	}

	public void setPostCover(String postCover) {
		this.postCover = postCover;
	}

	public Date getPostTime() {
		return postTime;
	}

	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}

	public String getPostQuery() {
		return postQuery;
	}

	public void setPostQuery(String postQuery) {
		this.postQuery = postQuery;
	}

	@Override
	public String toString() {
		return "SolrPost [postId=" + postId + ", postTitle=" + postTitle + ", postContent=" + postContent
				+ ", postCover=" + postCover + ", postTime=" + postTime + ", postQuery=" + postQuery + "]";
	}

	
}
