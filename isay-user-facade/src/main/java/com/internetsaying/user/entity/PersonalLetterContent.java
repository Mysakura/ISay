package com.internetsaying.user.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 私信关系包含的对话列表
 * @author dong
 *
 */
public class PersonalLetterContent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4493137771459465085L;
	private int lcId;
	private PersonalLetter letter;
	private User sender;
	private User receiver;
	private String content;
	private Date time;
	public PersonalLetterContent() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PersonalLetterContent(PersonalLetter letter, User sender, User receiver, String content,
			Date time) {
		super();
		this.letter = letter;
		this.sender = sender;
		this.receiver = receiver;
		this.content = content;
		this.time = time;
	}
	
	public int getLcId() {
		return lcId;
	}
	public void setLcId(int lcId) {
		this.lcId = lcId;
	}
	public PersonalLetter getLetter() {
		return letter;
	}
	public void setLetter(PersonalLetter letter) {
		this.letter = letter;
	}
	public User getSender() {
		return sender;
	}
	public void setSender(User sender) {
		this.sender = sender;
	}
	public User getReceiver() {
		return receiver;
	}
	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "PersonalLetterContent [lcId=" + lcId + ", letter=" + letter + ", sender=" + sender + ", receiver="
				+ receiver + ", content=" + content + ", time=" + time + "]";
	}
	
}
