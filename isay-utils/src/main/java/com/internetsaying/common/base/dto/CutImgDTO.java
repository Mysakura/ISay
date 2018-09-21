package com.internetsaying.common.base.dto;

import java.io.Serializable;

public class CutImgDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7046137429914742002L;
	private String x; 
	private String y; 
	private String w; 
	private String h; 
	private String dw; 
	private String dh;
	
	public CutImgDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getX() {
		return x;
	}

	public void setX(String x) {
		this.x = x;
	}

	public String getY() {
		return y;
	}

	public void setY(String y) {
		this.y = y;
	}

	public String getW() {
		return w;
	}

	public void setW(String w) {
		this.w = w;
	}

	public String getH() {
		return h;
	}

	public void setH(String h) {
		this.h = h;
	}

	public String getDw() {
		return dw;
	}

	public void setDw(String dw) {
		this.dw = dw;
	}

	public String getDh() {
		return dh;
	}

	public void setDh(String dh) {
		this.dh = dh;
	}
	
}
