package com.internetsaying.site.dto;

import java.io.Serializable;

/**
 * 总用户数,总帖子数,评论数,留言数,闲聊数--雷达图
 * @author dong
 *
 */
public class CommonStatistics implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5082211302472891335L;
	private Integer userNum;
	private Integer postNum;
	private Integer commentNum;
	private Integer massageNum;
	private Integer chatNum;
	public CommonStatistics() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CommonStatistics(Integer userNum, Integer postNum, Integer commentNum, Integer massageNum, Integer chatNum) {
		super();
		this.userNum = userNum;
		this.postNum = postNum;
		this.commentNum = commentNum;
		this.massageNum = massageNum;
		this.chatNum = chatNum;
	}
	public Integer getUserNum() {
		return userNum;
	}
	public void setUserNum(Integer userNum) {
		this.userNum = userNum;
	}
	public Integer getPostNum() {
		return postNum;
	}
	public void setPostNum(Integer postNum) {
		this.postNum = postNum;
	}
	public Integer getCommentNum() {
		return commentNum;
	}
	public void setCommentNum(Integer commentNum) {
		this.commentNum = commentNum;
	}
	public Integer getMassageNum() {
		return massageNum;
	}
	public void setMassageNum(Integer massageNum) {
		this.massageNum = massageNum;
	}
	public Integer getChatNum() {
		return chatNum;
	}
	public void setChatNum(Integer chatNum) {
		this.chatNum = chatNum;
	}
	
	
}
