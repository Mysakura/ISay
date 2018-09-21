package com.internetsaying.user.entity;

import java.io.Serializable;

/**
 * 
 * 模块名称：用户角色
 *
 * @author 董昕杰
 * @since 2018年1月5日
 */
public class Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 233089549271902441L;
	private String roleId;
	private String roleName;
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Role(String roleId, String roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + "]";
	}
	
}
