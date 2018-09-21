package com.internetsaying.post.dto;

import java.io.Serializable;

/**
 * 汇总信息，专门给用户个人中心展示
 * @author dong
 *
 */
public class PostInfusion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5898688475404687209L;
	private int upNum;
	private int downNum;
	private int postNum;
	public PostInfusion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getUpNum() {
		return upNum;
	}
	public void setUpNum(int upNum) {
		this.upNum = upNum;
	}
	public int getDownNum() {
		return downNum;
	}
	public void setDownNum(int downNum) {
		this.downNum = downNum;
	}
	public int getPostNum() {
		return postNum;
	}
	public void setPostNum(int postNum) {
		this.postNum = postNum;
	}
	@Override
	public String toString() {
		return "PostInfusion [upNum=" + upNum + ", downNum=" + downNum + ", postNum=" + postNum + "]";
	}
	
}
