package com.internetsaying.site.entity;

import java.io.Serializable;
import java.util.Date;

import com.internetsaying.user.entity.User;

public class About implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7899133866023321064L;
	private String aboutId;
	private String aboutContent;
	private String aboutMarkdown;
	private String aboutType;
	private User aboutEditor;
	private Date aboutTime;
	public About() {
		super();
		// TODO Auto-generated constructor stub
	}
	public About(String aboutId, String aboutContent, String aboutMarkdown, String aboutType, User aboutEditor,
			Date aboutTime) {
		super();
		this.aboutId = aboutId;
		this.aboutContent = aboutContent;
		this.aboutMarkdown = aboutMarkdown;
		this.aboutType = aboutType;
		this.aboutEditor = aboutEditor;
		this.aboutTime = aboutTime;
	}
	
	public About(String aboutId, String aboutContent, String aboutMarkdown, User aboutEditor, Date aboutTime) {
		super();
		this.aboutId = aboutId;
		this.aboutContent = aboutContent;
		this.aboutMarkdown = aboutMarkdown;
		this.aboutEditor = aboutEditor;
		this.aboutTime = aboutTime;
	}
	public String getAboutId() {
		return aboutId;
	}
	public void setAboutId(String aboutId) {
		this.aboutId = aboutId;
	}
	public String getAboutContent() {
		return aboutContent;
	}
	public void setAboutContent(String aboutContent) {
		this.aboutContent = aboutContent;
	}
	public String getAboutMarkdown() {
		return aboutMarkdown;
	}
	public void setAboutMarkdown(String aboutMarkdown) {
		this.aboutMarkdown = aboutMarkdown;
	}
	public String getAboutType() {
		return aboutType;
	}
	public void setAboutType(String aboutType) {
		this.aboutType = aboutType;
	}
	public User getAboutEditor() {
		return aboutEditor;
	}
	public void setAboutEditor(User aboutEditor) {
		this.aboutEditor = aboutEditor;
	}
	public Date getAboutTime() {
		return aboutTime;
	}
	public void setAboutTime(Date aboutTime) {
		this.aboutTime = aboutTime;
	}
	@Override
	public String toString() {
		return "About [aboutId=" + aboutId + ", aboutContent=" + aboutContent + ", aboutMarkdown=" + aboutMarkdown
				+ ", aboutType=" + aboutType + ", aboutEditor=" + aboutEditor + ", aboutTime=" + aboutTime + "]";
	}
	
}
