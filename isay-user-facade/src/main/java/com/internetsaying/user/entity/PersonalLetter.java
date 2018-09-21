package com.internetsaying.user.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 一个私信对应多条消息
 * 模块名称：私信关系
 *
 * @author 董昕杰
 * @since 2018年1月5日
 */
public class PersonalLetter implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2239107518999205987L;
	private String letterId;
	private User personA;
	private User personB;
	private Date lastTime;
	public PersonalLetter() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PersonalLetter(String letterId) {
		super();
		this.letterId = letterId;
	}

	// 添加
	public PersonalLetter(String id, User personA, User personB, Date lastTime) {
		super();
		this.letterId = id;
		this.personA = personA;
		this.personB = personB;
		this.lastTime = lastTime;
	}
	
	public String getLetterId() {
		return letterId;
	}
	public void setLetterId(String letterId) {
		this.letterId = letterId;
	}
	public User getPersonA() {
		return personA;
	}
	public void setPersonA(User personA) {
		this.personA = personA;
	}
	public User getPersonB() {
		return personB;
	}
	public void setPersonB(User personB) {
		this.personB = personB;
	}
	public Date getLastTime() {
		return lastTime;
	}
	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}
	@Override
	public String toString() {
		return "PersonalLetter [letterId=" + letterId + ", personA=" + personA + ", personB=" + personB + ", lastTime=" + lastTime
				+ "]";
	}
	
}
