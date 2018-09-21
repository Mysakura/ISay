package com.internetsaying.post.dto;

import java.io.Serializable;

/**
 * 每月的帖子数(折线图)
 * @author dong
 *
 */
public class StatisticsMonthPostNum implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8374604461424950732L;
	private Integer num;
	private String month;
	public StatisticsMonthPostNum() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StatisticsMonthPostNum(Integer num, String month) {
		super();
		this.num = num;
		this.month = month;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	
}
