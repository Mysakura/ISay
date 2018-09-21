package com.internetsaying.post.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 模块名称：帖子领域
 * 一个领域对应多个标签
 *
 * @author 董昕杰
 * @since 2017年12月9日
 */
public class WorkArea implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7885803689385356092L;
	private int areaId;
	private String areaName;
	private List<AreaLabel> labels = new ArrayList<>();
	public WorkArea() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public WorkArea(int areaId) {
		super();
		this.areaId = areaId;
	}

	public WorkArea(String areaName) {
		super();
		this.areaName = areaName;
	}
	
	public WorkArea(int areaId, String areaName) {
		super();
		this.areaId = areaId;
		this.areaName = areaName;
	}
	public int getAreaId() {
		return areaId;
	}
	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public List<AreaLabel> getLabels() {
		return labels;
	}
	public void setLabels(List<AreaLabel> labels) {
		this.labels = labels;
	}
	@Override
	public String toString() {
		return "WorkArea [areaId=" + areaId + ", areaName=" + areaName + ", labels=" + labels + "]";
	}
	
}
