package com.internetsaying.exception.enums;

public enum ExceptionEnum {
	
	REQUEST_SUCCESS(0, "请求成功"),
	REQUEST_FAILED(1, "请求失败"),
	LOGIN_FAILED(1001, "用户名密码错误"),
	RE_LOGIN(1002, "需要先登录"),
	LOGIN_INFO_OVERDUE(1003, "您还没有登录或登录身份已过期"),
	USER_NOT_EXIST(1004, "用户不存在！"),
	NO_PERMISSION(1005, "无权限！"),
	LOGIN_CANCEL(1006, "您已被禁止登录本网站！"),
	
	REGISTER_SUCCESS(2000, "注册成功"),
	REGISTER_FAILED(2001, "注册失败"),
	
	ADD_VOTE_FAILED(3001, "添加投票失败"),
	ADD_VOTER_FAILED(3002, "参与投票失败！您已经投过票了"),
	
	ADD_FRIEND_SUCCESS(4000, "添加友情链接成功，等待审核"),
	FRIEND_EXIST(4001, "添加友情链接失败，友情链接已存在"),
	ADD_FRIEND_FAILED(4002, "添加友情链接失败"),
	
	POST_NOT_EXIST(5001, "帖子不存在！"),
	COLLECT_POST_FAILD(5002, "您已经收藏了这个帖子！"),
	COLLECT_ALREADY_CANCEL(5003, "您已经取消收藏！"),
	NOT_POST_OWNER(5004, "您不是这个帖子的所有者！"),
	ALREADY_UP(5005, "您已经赞成过该帖子！"),
	ALREADY_DOWN(5006, "您已经反对过该帖子！"),
	POSTSHARE_MODIFY_NO_PERMIT(5007, "您只能修改原帖子，不能修改他人的修改历史！"),
	
	ADD_COMMENT_FAILED(6001, "添加评论失败！"),
	DEL_COMMENT_FAILED(6002, "删除评论失败！"),
	ADD_REPLY_FAILED(6003, "添加评论回复失败！"),
	DEL_REPLY_FAILED(6004, "删除评论回复失败！"),
	
	CREATE_RELATIONSHIP_FAILED(7001, "建立私信关系失败！"),
	
	COMPANY_ALREADY_EXIST(8001, "公司已存在！"),
	
	CHAT_DEL_NO_PERMIT(9001, "您无权限删除此条闲聊！"),
	CHAT_REPLY_DEL_NO_PERMIT(9002, "您无权限删除此条闲聊回复！"),
	
	MQ_RECEIVE_NULL(10001, "消息队列接收到的实体为空！"),
	
	;
	
	public Integer code;
	
	public String msg;

	private ExceptionEnum(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	

}
