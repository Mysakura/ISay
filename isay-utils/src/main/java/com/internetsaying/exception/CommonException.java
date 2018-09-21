package com.internetsaying.exception;

public class CommonException extends IsayException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7361036142283363659L;
	
	private Integer code;

	public CommonException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommonException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	

	public CommonException(Integer code, String message) {
		super(message);
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	
}
