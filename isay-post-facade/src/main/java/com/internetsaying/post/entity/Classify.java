package com.internetsaying.post.entity;

import java.io.Serializable;

/**
 * 
 * 模块名称：帖子分类
 *
 * @author 董昕杰
 * @since 2017年12月9日
 */
public class Classify implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8488701431911923189L;
	private int classifyId;
	private String classifyName;
	public Classify() {
		// TODO Auto-generated constructor stub
	}
	public Classify(int classifyId) {
		this.classifyId = classifyId;
	}
	public Classify(String classifyName) {
		this.classifyName = classifyName;
	}
	public int getClassifyId() {
		return classifyId;
	}
	public void setClassifyId(int classifyId) {
		this.classifyId = classifyId;
	}
	public String getClassifyName() {
		return classifyName;
	}
	public void setClassifyName(String classifyName) {
		this.classifyName = classifyName;
	}
	@Override
	public String toString() {
		return "Classify [classifyId=" + classifyId + ", classifyName=" + classifyName + "]";
	}
	
}
