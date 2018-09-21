package com.internetsaying.post.dto;

import java.io.Serializable;

import com.internetsaying.post.entity.WorkArea;

/**
 * 每个领域的标签数（饼图）
 * @author dong
 *
 */
public class StatisticsAreaLabel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3673506209804891159L;
	private WorkArea area;
	private Integer labelNum;
	
	public StatisticsAreaLabel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StatisticsAreaLabel(WorkArea area, Integer labelNum) {
		super();
		this.area = area;
		this.labelNum = labelNum;
	}

	public WorkArea getArea() {
		return area;
	}

	public void setArea(WorkArea area) {
		this.area = area;
	}

	public Integer getLabelNum() {
		return labelNum;
	}

	public void setLabelNum(Integer labelNum) {
		this.labelNum = labelNum;
	}
	
	
}
