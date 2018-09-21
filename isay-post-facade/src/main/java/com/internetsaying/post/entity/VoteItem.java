package com.internetsaying.post.entity;

import java.io.Serializable;

/**
 * 
 * 模块名称：投票选项
 *
 * @author 董昕杰
 * @since 2017年12月9日
 */
public class VoteItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3985078618396431334L;
	private int itemId;
	private String itemContent;
	// 此投票选项得到的票数
	private int voteNum;
	private Vote vote;
	public VoteItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public VoteItem(String itemContent, int voteNum, Vote vote) {
		super();
		this.itemContent = itemContent;
		this.voteNum = voteNum;
		this.vote = vote;
	}

	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemContent() {
		return itemContent;
	}
	public void setItemContent(String itemContent) {
		this.itemContent = itemContent;
	}
	public int getVoteNum() {
		return voteNum;
	}
	public void setVoteNum(int voteNum) {
		this.voteNum = voteNum;
	}
	public Vote getVote() {
		return vote;
	}
	public void setVote(Vote vote) {
		this.vote = vote;
	}
	
}
