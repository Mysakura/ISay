package com.internetsaying.common.base;

import java.io.Serializable;

import com.internetsaying.exception.enums.ExceptionEnum;
import com.internetsaying.utils.PageUtils;

public class BaseJSONPageResponse<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7793695440750380151L;
	
	private int pageNo;
	
	private int pageSize;
	
	private int nextPage;
	
	private int isLast;	// 是否最后一页	0	1
	
	private int count;	// 总记录
	
	private T data;
	
	private int code;	// 状态码
	
	private String msg;
	
	public BaseJSONPageResponse(int pageNo, int count) {
		super();
		this.pageNo = pageNo;
		this.count = count;
		deal();
	}
	
	private void deal() {
		PageUtils pu = new PageUtils(pageNo, count);
		this.pageNo = pu.getCurPage();
		this.pageSize = PageUtils.getPageSize();
		this.nextPage = pu.nextPage();
		this.isLast = pu.getIsLast();
	}

	public int getPageNo() {
		return pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getNextPage() {
		return nextPage;
	}

	public int getIsLast() {
		return isLast;
	}

	public int getCount() {
		return count;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
		this.code = ExceptionEnum.REQUEST_SUCCESS.code;
		this.msg = ExceptionEnum.REQUEST_SUCCESS.msg;
	}

	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

}
