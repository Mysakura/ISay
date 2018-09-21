package com.internetsaying.post.dto;

/**
 * 来自每个领域的礼物数量
 * @author dong
 *
 */
public class AreaReceiveNum {

	private String areaName;
	private int giftNum;
	public AreaReceiveNum() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public int getGiftNum() {
		return giftNum;
	}
	public void setGiftNum(int giftNum) {
		this.giftNum = giftNum;
	}
	@Override
	public String toString() {
		return "AreaReceiveNum [areaName=" + areaName + ", giftNum=" + giftNum + "]";
	}
	
}
