package com.internetsaying.site.entity;

import java.io.Serializable;
import java.util.Date;

import com.internetsaying.user.entity.User;

public class TimeLine implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2530209758576682184L;
	private String tlId;
	private String tlContent;
	private Date tlTime;
	private User editor;
	public TimeLine() {
		super();
		// TODO Auto-generated constructor stub
	}
	// 添加
	public TimeLine(String tlId, String tlContent, Date tlTime, User editor) {
		super();
		this.tlId = tlId;
		this.tlContent = tlContent;
		this.tlTime = tlTime;
		this.editor = editor;
	}
	// 修改
	public TimeLine(String tlId, String tlContent, User editor) {
		super();
		this.tlId = tlId;
		this.tlContent = tlContent;
		this.editor = editor;
	}
	public String getTlId() {
		return tlId;
	}
	public void setTlId(String tlId) {
		this.tlId = tlId;
	}
	public String getTlContent() {
		return tlContent;
	}
	public void setTlContent(String tlContent) {
		this.tlContent = tlContent;
	}
	public Date getTlTime() {
		return tlTime;
	}
	public void setTlTime(Date tlTime) {
		this.tlTime = tlTime;
	}
	public User getEditor() {
		return editor;
	}
	public void setEditor(User editor) {
		this.editor = editor;
	}
	@Override
	public String toString() {
		return "TimeLine [tlId=" + tlId + ", tlContent=" + tlContent + ", tlTime=" + tlTime + ", editor=" + editor
				+ "]";
	}
	
}
