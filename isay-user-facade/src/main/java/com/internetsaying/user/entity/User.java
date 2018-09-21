package com.internetsaying.user.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 模块名称：用户
 * 一个用户收藏多个帖子】--会出现循环依赖问题，那么想要得到收藏的帖子，直接从帖子服务调用
 * 一个用户被多个用户关注
 * 一个用户关注多个用户
 * 一个用户对应多个角色
 *
 * @author 董昕杰
 * @since 2017年12月9日
 */
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1111392944526991797L;
	private String userId;
	private String userEmail;
	private String password;
	private String nickname;
	private String sex;
	private String userPhoto;
	private String userBg;
	private String userGraduate;
	private String userAlipay;
	private String userVxin;
	private String job;
	private String company;
	private String workplace;
	private String shield;
	private List<Role> roles;
	private List<User> follows = new ArrayList<>();	// 关注的人
	private List<User> fans = new ArrayList<>();	// 我的粉丝
	public User() {
	}
	
	// 作为存储标志
	public User(String userId) {
		this.userId = userId;
	}

	// 注册
	public User(String userId, String userEmail, String password, String nickname) {
		super();
		this.userId = userId;
		this.userEmail = userEmail;
		this.password = password;
		this.nickname = nickname;
	}
	
	// 修改基本信息
	public User(String userId, String nickname, String sex, String userGraduate, String job, String company,
			String workplace) {
		super();
		this.userId = userId;
		this.nickname = nickname;
		this.sex = sex;
		this.userGraduate = userGraduate;
		this.job = job;
		this.company = company;
		this.workplace = workplace;
	}
	
	// 修改密码，头像，背景，支付宝，微信
	public User(String userId, String password, String userPhoto, String userBg, String userAlipay, String userVxin) {
		super();
		this.userId = userId;
		this.password = password;
		this.userPhoto = userPhoto;
		this.userBg = userBg;
		this.userAlipay = userAlipay;
		this.userVxin = userVxin;
	}
	
	// 删除
	public User(String userId, String shield) {
		super();
		this.userId = userId;
		this.shield = shield;
	}
	
	// 提供给其他模块的展示数据
	public User(String userId, String nickname, String userPhoto) {
		super();
		this.userId = userId;
		this.nickname = nickname;
		this.userPhoto = userPhoto;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getUserPhoto() {
		return userPhoto;
	}
	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}
	
	public String getUserBg() {
		return userBg;
	}
	public void setUserBg(String userBg) {
		this.userBg = userBg;
	}
	public String getUserGraduate() {
		return userGraduate;
	}
	public void setUserGraduate(String userGraduate) {
		this.userGraduate = userGraduate;
	}
	public String getUserAlipay() {
		return userAlipay;
	}
	public void setUserAlipay(String userAlipay) {
		this.userAlipay = userAlipay;
	}
	public String getUserVxin() {
		return userVxin;
	}
	public void setUserVxin(String userVxin) {
		this.userVxin = userVxin;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getWorkplace() {
		return workplace;
	}
	public void setWorkplace(String workplace) {
		this.workplace = workplace;
	}
	public String getShield() {
		return shield;
	}
	public void setShield(String shield) {
		this.shield = shield;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public List<User> getFollows() {
		return follows;
	}
	public void setFollows(List<User> follows) {
		this.follows = follows;
	}
	public List<User> getFans() {
		return fans;
	}
	public void setFans(List<User> fans) {
		this.fans = fans;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userEmail=" + userEmail + ", password=" + password + ", nickname="
				+ nickname + ", sex=" + sex + ", userPhoto=" + userPhoto + ", userBg=" + userBg + ", userGraduate="
				+ userGraduate + ", userAlipay=" + userAlipay + ", userVxin=" + userVxin + ", job=" + job + ", company="
				+ company + ", workplace=" + workplace + ", shield=" + shield + ", roles=" + roles + "]";
	}
	

	
}
