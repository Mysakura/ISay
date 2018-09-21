package com.internetsaying.user.dto;

import java.io.Serializable;

/**
 * 用来存储：时间-记录数 的数据
 * @author dong
 *
 */
public class TimeCountDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8371211034009477870L;
	private String time;
	private int count;
	public TimeCountDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TimeCountDTO(String time, int count) {
		super();
		this.time = time;
		this.count = count;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "TimeCountDTO [time=" + time + ", count=" + count + "]";
	}
	
}
