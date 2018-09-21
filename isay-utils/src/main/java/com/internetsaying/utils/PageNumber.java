package com.internetsaying.utils;

/**
 * 
 * 上一页：1
 * 普通页：2
 * 省略号：3
 * 当前页：4
 * 下一页：5
 * 总页码：6
 *	
 */
public class PageNumber {

	private Integer pageNo;
	private String info;
	
	public PageNumber(Integer pageNo, String info) {
		super();
		this.pageNo = pageNo;
		this.info = info;
	}
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	@Override
	public String toString() {
		return "PageNumber [pageNo=" + pageNo + ", info=" + info + "]";
	}
}
