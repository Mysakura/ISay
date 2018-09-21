package com.internetsaying.site.entity;

import java.io.Serializable;
import java.util.Date;

import com.internetsaying.user.entity.User;

public class Announcement implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4768070880230574304L;
	private String annId;
	private String annTitle;
	private String annContent;
	private String annMarkdown;
	private User annEditor;
	private Date annTime;
	public Announcement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Announcement(String annId, String annTitle, String annContent, String annMarkdown, User annEditor,
			Date annTime) {
		super();
		this.annId = annId;
		this.annTitle = annTitle;
		this.annContent = annContent;
		this.annMarkdown = annMarkdown;
		this.annEditor = annEditor;
		this.annTime = annTime;
	}
	public String getAnnId() {
		return annId;
	}
	public void setAnnId(String annId) {
		this.annId = annId;
	}
	public String getAnnTitle() {
		return annTitle;
	}
	public void setAnnTitle(String annTitle) {
		this.annTitle = annTitle;
	}
	public String getAnnContent() {
		return annContent;
	}
	public void setAnnContent(String annContent) {
		this.annContent = annContent;
	}
	public String getAnnMarkdown() {
		return annMarkdown;
	}
	public void setAnnMarkdown(String annMarkdown) {
		this.annMarkdown = annMarkdown;
	}
	public User getAnnEditor() {
		return annEditor;
	}
	public void setAnnEditor(User annEditor) {
		this.annEditor = annEditor;
	}
	public Date getAnnTime() {
		return annTime;
	}
	public void setAnnTime(Date annTime) {
		this.annTime = annTime;
	}
	@Override
	public String toString() {
		return "Announcement [annId=" + annId + ", annTitle=" + annTitle + ", annContent=" + annContent
				+ ", annMarkdown=" + annMarkdown + ", annEditor=" + annEditor + ", annTime=" + annTime + "]";
	}
	
}
