package com.internetsaying.user.entity;

import java.io.Serializable;
import java.util.Date;

public class Fans implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3601990973327391663L;
	
	private Integer fansId;
	private String masterId;
	private String followerId;
	private Date time;
	
	public Fans() {
		super();
	}

	public Fans(String masterId, String followerId, Date time) {
		super();
		this.masterId = masterId;
		this.followerId = followerId;
		this.time = time;
	}

	public Integer getFansId() {
		return fansId;
	}

	public void setFansId(Integer fansId) {
		this.fansId = fansId;
	}

	public String getMasterId() {
		return masterId;
	}

	public void setMasterId(String masterId) {
		this.masterId = masterId;
	}

	public String getFollowerId() {
		return followerId;
	}

	public void setFollowerId(String followerId) {
		this.followerId = followerId;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Fans [fansId=" + fansId + ", masterId=" + masterId + ", followerId=" + followerId + ", time=" + time
				+ "]";
	}


}
