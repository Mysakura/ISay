package com.internetsaying.post.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.internetsaying.user.entity.User;

/**
 * 
 * 模块名称：公司
 *
 * @author 董昕杰
 * @since 2017年12月9日
 */
public class Company implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1246335235762094780L;
	private Integer companyId;
	private String companyName;
	private Integer goodNum;
	private Integer badNum;
	private User user;
	private String isDelete;
	private List<CompanyLabel> labels = new ArrayList<>();
	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Company(Integer companyId) {
		super();
		this.companyId = companyId;
	}

	public Company(Integer companyId, Integer goodNum, Integer badNum) {
		super();
		this.companyId = companyId;
		this.goodNum = goodNum;
		this.badNum = badNum;
	}

	public Company(Integer companyId, String isDelete) {
		super();
		this.companyId = companyId;
		this.isDelete = isDelete;
	}

	public Company(String companyName, User user) {
		super();
		this.companyName = companyName;
		this.user = user;
	}

	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Integer getGoodNum() {
		return goodNum;
	}
	public void setGoodNum(Integer goodNum) {
		this.goodNum = goodNum;
	}
	public Integer getBadNum() {
		return badNum;
	}
	public void setBadNum(Integer badNum) {
		this.badNum = badNum;
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

	public List<CompanyLabel> getLabels() {
		return labels;
	}

	public void setLabels(List<CompanyLabel> labels) {
		this.labels = labels;
	}

	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", companyName=" + companyName + ", goodNum=" + goodNum + ", badNum="
				+ badNum + ", user=" + user + ", isDelete=" + isDelete + ", labels=" + labels + "]";
	}
	
	
}
