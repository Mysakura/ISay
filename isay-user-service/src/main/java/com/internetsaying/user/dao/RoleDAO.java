package com.internetsaying.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.internetsaying.user.entity.Role;

@Repository
public interface RoleDAO {
	
	/**
	 * 插入角色
	 * @param role
	 * @return
	 */
	int insertRole(Role role);
	
	/**
	 * 删除角色
	 * @param roleId
	 * @return
	 */
	int deleteRole(@Param("roleId") String roleId);
	
	/**
	 * 获得角色列表
	 * @return
	 */
	List<Role> getRoleList();
	
	/**
	 * 根据角色名查询角色id
	 * @param roleName
	 * @return
	 */
	String getRoleIdByName(@Param("roleName") String roleName);
	
	/**
	 * 插入用户-角色
	 * @param roleId
	 * @param userId
	 * @return
	 */
	int insertUserRole(@Param("roleId") String roleId, @Param("userId") String userId);

	/**
	 * 删除用户-角色
	 * @param id
	 * @return
	 */
	int deleteUserRole(@Param("roleId") String roleId, @Param("userId") String userId);
}
