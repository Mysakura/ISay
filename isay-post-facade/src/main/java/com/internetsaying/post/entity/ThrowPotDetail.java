package com.internetsaying.post.entity;

import java.io.Serializable;
import java.util.Date;

import com.internetsaying.user.entity.User;

/**
 * 
 * 模块名称：甩锅详情
 *
 * @author 董昕杰
 * @since 2017年12月9日
 */
public class ThrowPotDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4465825151626735534L;
	private int detailId;
	// 甩锅者
	private User user;
	// 所属领域
	private WorkArea workArea;
	// 目标领域
	private WorkArea targetArea;
	// 礼物
	private String gift;
	// 时间
	private Date time;
	public ThrowPotDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ThrowPotDetail(User user, WorkArea workArea, WorkArea targetArea, String gift, Date time) {
		super();
		this.user = user;
		this.workArea = workArea;
		this.targetArea = targetArea;
		this.gift = gift;
		this.time = time;
	}

	public ThrowPotDetail(String gift, Date time) {
		super();
		this.gift = gift;
		this.time = time;
	}
	public int getDetailId() {
		return detailId;
	}
	public void setDetailId(int detailId) {
		this.detailId = detailId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public WorkArea getWorkArea() {
		return workArea;
	}
	public void setWorkArea(WorkArea workArea) {
		this.workArea = workArea;
	}
	public WorkArea getTargetArea() {
		return targetArea;
	}
	public void setTargetArea(WorkArea targetArea) {
		this.targetArea = targetArea;
	}
	public String getGift() {
		return gift;
	}
	public void setGift(String gift) {
		this.gift = gift;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "ThrowPotDetail [detailId=" + detailId + ", user=" + user + ", workArea=" + workArea + ", targetArea="
				+ targetArea + ", gift=" + gift + ", time=" + time + "]";
	}
	
}
