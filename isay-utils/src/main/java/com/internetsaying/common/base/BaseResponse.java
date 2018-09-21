package com.internetsaying.common.base;

import java.io.Serializable;

import com.internetsaying.exception.enums.ExceptionEnum;

public class BaseResponse<T> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7376563482232012110L;

	private int code;
	
	private String msg;
	
	private T data;

	public BaseResponse(int code, String msg, T data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public BaseResponse(int code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = null;
	}

	public BaseResponse(String msg, T data) {
		super();
		this.msg = msg;
		this.data = data;
	}

	public BaseResponse(T data) {
		super();
		this.code = ExceptionEnum.REQUEST_SUCCESS.code;
		this.msg = ExceptionEnum.REQUEST_SUCCESS.msg;
		this.data = data;
	}

	public BaseResponse() {
		super();
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	

}
