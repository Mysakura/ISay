package com.internetsaying.post.entity;

import java.io.Serializable;

/**
 * 
 * 模块名称：甩锅
 *
 * @author 董昕杰
 * @since 2017年12月9日
 */
public class ThrowPot implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 86866055692744058L;
	private int flowerNum;
	private int hammerNum;
	private int potNum;
	private int agentNum;
	private int hatNum;
	private WorkArea workArea;	// 主键
	public ThrowPot() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ThrowPot(int flowerNum, int hammerNum, int potNum, int agentNum, int hatNum) {
		super();
		this.flowerNum = flowerNum;
		this.hammerNum = hammerNum;
		this.potNum = potNum;
		this.agentNum = agentNum;
		this.hatNum = hatNum;
	}
	public int getFlowerNum() {
		return flowerNum;
	}
	public void setFlowerNum(int flowerNum) {
		this.flowerNum = flowerNum;
	}
	public int getHammerNum() {
		return hammerNum;
	}
	public void setHammerNum(int hammerNum) {
		this.hammerNum = hammerNum;
	}
	public int getPotNum() {
		return potNum;
	}
	public void setPotNum(int potNum) {
		this.potNum = potNum;
	}
	public int getAgentNum() {
		return agentNum;
	}
	public void setAgentNum(int agentNum) {
		this.agentNum = agentNum;
	}
	public int getHatNum() {
		return hatNum;
	}
	public void setHatNum(int hatNum) {
		this.hatNum = hatNum;
	}
	public WorkArea getWorkArea() {
		return workArea;
	}
	public void setWorkArea(WorkArea workArea) {
		this.workArea = workArea;
	}
	@Override
	public String toString() {
		return "ThrowPot [flowerNum=" + flowerNum + ", hammerNum=" + hammerNum + ", potNum=" + potNum + ", agentNum="
				+ agentNum + ", hatNum=" + hatNum + ", workArea=" + workArea + "]";
	}
	
	
}
