package com.internetsaying.user.service;

import java.util.List;

import com.internetsaying.exception.CommonException;
import com.internetsaying.user.entity.Role;

public interface UserRoleService {

	/**
	 * 插入用户-角色
	 * @param roleId
	 * @param userId
	 * @return
	 */
	int insertUserRole(String roleId, String userId) throws CommonException;

	/**
	 * 删除用户-角色
	 * @param roleId
	 * @param userId
	 * @return
	 */
	int deleteUserRole(String roleId, String userId) throws CommonException;
	
	/**
	 * 根据角色名查询角色id
	 * @param roleName
	 * @return
	 */
	String getRoleIdByName(String roleName) throws CommonException;
	
	/**
	 * 插入角色
	 * @param role
	 * @return
	 */
	int insertRole(Role role) throws CommonException;
	
	/**
	 * 删除角色
	 * @param roleId
	 * @return
	 */
	int deleteRole(String roleId) throws CommonException;
	
	/**
	 * 获得角色列表
	 * @return
	 */
	List<Role> getRoleList() throws CommonException;
}
