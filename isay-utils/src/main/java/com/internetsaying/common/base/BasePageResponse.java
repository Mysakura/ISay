package com.internetsaying.common.base;

import java.io.Serializable;
import java.util.List;

import com.internetsaying.utils.PageNumber;
import com.internetsaying.utils.PageSplit;
import com.internetsaying.utils.PageUtils;

public class BasePageResponse<T> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4626688783323933656L;

	private int pageNo;
	
	private int pageSize;
	
	private int count;	// 总记录
	
	private T data;		// 展示给前端的数据
	
	private int allPage;	// 总页数
	
	private String classifyName;	// 侧边栏超链接需要
	private String classifyShowName;// 帖子列表展示需要
	
	private int areaType;				// 底部页码超链接需要

	private List<PageNumber> showPage;	// 展示给前端的页码
	
	public BasePageResponse(int pageNo, int count) {
		super();
		this.pageNo = pageNo;
		this.count = count;
		deal();
	}
	
	private void deal() {
		PageUtils pu = new PageUtils(pageNo, count);
		this.pageNo = pu.getCurPage();
		this.pageSize = PageUtils.getPageSize();
		this.allPage = pu.getAllPage();
		PageSplit ps = new PageSplit(pageNo, pu.getAllPage(), 2);
		showPage = ps.getShowPage();
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public List<PageNumber> getShowPage() {
		return showPage;
	}

	public void setShowPage(List<PageNumber> showPage) {
		this.showPage = showPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getAllPage() {
		return allPage;
	}

	public String getClassifyName() {
		return classifyName;
	}

	public void setClassifyName(String classifyName) {
		this.classifyName = classifyName;
	}

	public int getAreaType() {
		return areaType;
	}

	public void setAreaType(int areaType) {
		this.areaType = areaType;
	}

	public String getClassifyShowName() {
		return classifyShowName;
	}

	public void setClassifyShowName(String classifyShowName) {
		this.classifyShowName = classifyShowName;
	}
	

}
