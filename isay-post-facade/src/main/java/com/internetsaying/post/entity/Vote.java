package com.internetsaying.post.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.internetsaying.user.entity.User;

/**
 * 
 * 模块名称：投票
 *
 * @author 董昕杰
 * @since 2017年12月9日
 */
public class Vote implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7094017609524264261L;
	private String voteId;
	private String voteContent;
	private Date voteTime;
	private User user;
	private List<VoteItem> items = new ArrayList<>();
	private String isDelete;
	private Integer areaId;
	public Vote() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Vote(String voteId) {
		super();
		this.voteId = voteId;
	}

	public Vote(String voteId, String isDelete) {
		super();
		this.voteId = voteId;
		this.isDelete = isDelete;
	}

	public Vote(String voteContent, Date voteTime, User user, Integer areaId) {
		super();
		this.voteContent = voteContent;
		this.voteTime = voteTime;
		this.user = user;
		this.areaId = areaId;
	}

	public String getVoteId() {
		return voteId;
	}
	public void setVoteId(String voteId) {
		this.voteId = voteId;
	}
	public String getVoteContent() {
		return voteContent;
	}
	public void setVoteContent(String voteContent) {
		this.voteContent = voteContent;
	}
	public Date getVoteTime() {
		return voteTime;
	}
	public void setVoteTime(Date voteTime) {
		this.voteTime = voteTime;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<VoteItem> getItems() {
		return items;
	}
	public void setItems(List<VoteItem> items) {
		this.items = items;
	}
	public String getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
	
}
