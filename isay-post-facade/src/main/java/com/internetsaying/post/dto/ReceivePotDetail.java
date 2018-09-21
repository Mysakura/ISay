package com.internetsaying.post.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * 某个领域收到来自其它领域的礼物数量详情
 * @author dong
 *
 */
public class ReceivePotDetail {

	private int gift;
	private List<AreaReceiveNum> receiveNums = new ArrayList<>();
	public ReceivePotDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ReceivePotDetail(int gift, List<AreaReceiveNum> receiveNums) {
		super();
		this.gift = gift;
		this.receiveNums = receiveNums;
	}

	public int getGift() {
		return gift;
	}
	public void setGift(int gift) {
		this.gift = gift;
	}
	public List<AreaReceiveNum> getReceiveNums() {
		return receiveNums;
	}
	public void setReceiveNums(List<AreaReceiveNum> receiveNums) {
		this.receiveNums = receiveNums;
	}

	@Override
	public String toString() {
		return "ReceivePotDetail [gift=" + gift + ", receiveNums=" + receiveNums + "]";
	}
	
	
}
