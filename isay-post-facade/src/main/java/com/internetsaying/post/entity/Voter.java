package com.internetsaying.post.entity;

import java.io.Serializable;

/**
 * 
 * 模块名称：投票者
 * 一个用户对应多个投票项
 * 一个投票项对应多个用户
 *
 * @author 董昕杰
 * @since 2017年12月9日
 */
public class Voter implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4705461400425141940L;
	private int voterId;
	private String userId;
	private int  itemId;
	private String voteId;	// 所属于的投票
	public Voter() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Voter(String userId, int itemId, String voteId) {
		super();
		this.userId = userId;
		this.itemId = itemId;
		this.voteId = voteId;
	}
	public int getVoterId() {
		return voterId;
	}
	public void setVoterId(int voterId) {
		this.voterId = voterId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getVoteId() {
		return voteId;
	}
	public void setVoteId(String voteId) {
		this.voteId = voteId;
	}
	
	
}
