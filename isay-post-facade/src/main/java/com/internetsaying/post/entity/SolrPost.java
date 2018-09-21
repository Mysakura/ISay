package com.internetsaying.post.entity;

import java.io.Serializable;
import java.util.Date;

public class SolrPost implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3918419115316711972L;
	private Integer id;
	private String spId;
	private String spTitle;
	private String spContent;
	private String spCover;
	private Date spTime;
	public SolrPost() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SolrPost(String spId, String spTitle, String spContent, String spCover, Date spTime) {
		super();
		this.spId = spId;
		this.spTitle = spTitle;
		this.spContent = spContent;
		this.spCover = spCover;
		this.spTime = spTime;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSpId() {
		return spId;
	}
	public void setSpId(String spId) {
		this.spId = spId;
	}
	public String getSpTitle() {
		return spTitle;
	}
	public void setSpTitle(String spTitle) {
		this.spTitle = spTitle;
	}
	public String getSpContent() {
		return spContent;
	}
	public void setSpContent(String spContent) {
		this.spContent = spContent;
	}
	public String getSpCover() {
		return spCover;
	}
	public void setSpCover(String spCover) {
		this.spCover = spCover;
	}
	public Date getSpTime() {
		return spTime;
	}
	public void setSpTime(Date spTime) {
		this.spTime = spTime;
	}
	@Override
	public String toString() {
		return "SolrPost [id=" + id + ", spId=" + spId + ", spTitle=" + spTitle + ", spContent=" + spContent
				+ ", spCover=" + spCover + ", spTime=" + spTime + "]";
	}
	
}
