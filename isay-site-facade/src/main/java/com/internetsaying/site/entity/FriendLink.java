package com.internetsaying.site.entity;

import java.io.Serializable;
import java.util.Date;

import com.internetsaying.user.entity.User;

public class FriendLink implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 303686082635215790L;
	private String flId;
	private String flName;
	private String flUrl;
	private String flOk;
	private User flUser;
	private User flAdmin;
	private Date flTime;
	public FriendLink() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public FriendLink(String flId, String flName, String flUrl, User flUser, Date flTime) {
		super();
		this.flId = flId;
		this.flName = flName;
		this.flUrl = flUrl;
		this.flUser = flUser;
		this.flTime = flTime;
	}

	public FriendLink(String flId, String flOk, User flAdmin) {
		super();
		this.flId = flId;
		this.flOk = flOk;
		this.flAdmin = flAdmin;
	}

	public String getFlId() {
		return flId;
	}
	public void setFlId(String flId) {
		this.flId = flId;
	}
	public String getFlName() {
		return flName;
	}
	public void setFlName(String flName) {
		this.flName = flName;
	}
	public String getFlUrl() {
		return flUrl;
	}
	public void setFlUrl(String flUrl) {
		this.flUrl = flUrl;
	}
	public String getFlOk() {
		return flOk;
	}
	public void setFlOk(String flOk) {
		this.flOk = flOk;
	}
	public User getFlUser() {
		return flUser;
	}
	public void setFlUser(User flUser) {
		this.flUser = flUser;
	}
	public User getFlAdmin() {
		return flAdmin;
	}
	public void setFlAdmin(User flAdmin) {
		this.flAdmin = flAdmin;
	}
	public Date getFlTime() {
		return flTime;
	}
	public void setFlTime(Date flTime) {
		this.flTime = flTime;
	}

	@Override
	public String toString() {
		return "FriendLink [flId=" + flId + ", flName=" + flName + ", flUrl=" + flUrl + ", flOk=" + flOk + ", flUser="
				+ flUser + ", flAdmin=" + flAdmin + ", flTime=" + flTime + "]";
	}
	
}
