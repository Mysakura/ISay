package com.internetsaying.post.entity;

import java.io.Serializable;

/**
 * 
 * 模块名称：领域对应的标签
 * 多个标签对应一个领域
 *
 * @author 董昕杰
 * @since 2017年12月9日
 */
public class AreaLabel implements Comparable<AreaLabel>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1665889503247875787L;
	private int labelId;
	private String labelName;
	private WorkArea workArea;
	public AreaLabel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public AreaLabel(int labelId) {
		super();
		this.labelId = labelId;
	}

	public AreaLabel(int labelId, String labelName) {
		super();
		this.labelId = labelId;
		this.labelName = labelName;
	}
	
	// 添加
	public AreaLabel(String labelName, WorkArea workArea) {
		super();
		this.labelName = labelName;
		this.workArea = workArea;
	}
	public int getLabelId() {
		return labelId;
	}
	public void setLabelId(int labelId) {
		this.labelId = labelId;
	}
	public String getLabelName() {
		return labelName;
	}
	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}
	public WorkArea getWorkArea() {
		return workArea;
	}
	public void setWorkArea(WorkArea workArea) {
		this.workArea = workArea;
	}

	@Override
	public String toString() {
		return "AreaLabel [labelId=" + labelId + ", labelName=" + labelName + ", workArea=" + workArea + "]";
	}

	@Override
	public int compareTo(AreaLabel o) {
		return Integer.compare(labelId, o.getLabelId());
	}
	
}
