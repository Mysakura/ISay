package com.internetsaying.post.entity;

import java.io.Serializable;

import com.internetsaying.user.entity.User;

/**
 * 
 * 模块名称：公司标签
 *
 * @author 董昕杰
 * @since 2017年12月9日
 */
public class CompanyLabel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5048769710210920539L;
	private int labelId;
	private String labelName;
	private String labelType;
	// 公司
	private Company company;
	// 印象者
	private User user;
	private String isDelete;
	
	public CompanyLabel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CompanyLabel(int labelId, String isDelete) {
		super();
		this.labelId = labelId;
		this.isDelete = isDelete;
	}

	public CompanyLabel(String labelName, String labelType, Company company, User user) {
		super();
		this.labelName = labelName;
		this.labelType = labelType;
		this.company = company;
		this.user = user;
	}

	public int getLabelId() {
		return labelId;
	}
	public void setLabelId(int labelId) {
		this.labelId = labelId;
	}
	public String getLabelName() {
		return labelName;
	}
	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}
	public String getLabelType() {
		return labelType;
	}
	public void setLabelType(String labelType) {
		this.labelType = labelType;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}

	@Override
	public String toString() {
		return "CompanyLabel [labelId=" + labelId + ", labelName=" + labelName + ", labelType=" + labelType
				+ ", company=" + company + ", user=" + user + ", isDelete=" + isDelete + "]";
	}
	
}
