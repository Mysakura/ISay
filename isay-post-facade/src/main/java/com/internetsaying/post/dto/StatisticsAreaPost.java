package com.internetsaying.post.dto;

import java.io.Serializable;

import com.internetsaying.post.entity.WorkArea;

/**
 * 不同area里面的帖子数（甜甜圈图）
 * @author dong
 *
 */
public class StatisticsAreaPost implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4256572405854911887L;
	private WorkArea area;
	private Integer postNum;
	
	public StatisticsAreaPost() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StatisticsAreaPost(WorkArea area, Integer postNum) {
		super();
		this.area = area;
		this.postNum = postNum;
	}

	public WorkArea getArea() {
		return area;
	}

	public void setArea(WorkArea area) {
		this.area = area;
	}

	public Integer getPostNum() {
		return postNum;
	}

	public void setPostNum(Integer postNum) {
		this.postNum = postNum;
	}
	
}
