package com.internetsaying.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.internetsaying.exception.CommonException;
import com.internetsaying.user.dao.RoleDAO;
import com.internetsaying.user.entity.Role;
import com.internetsaying.user.service.UserRoleService;

@Transactional(rollbackFor=Exception.class)
@Service
public class UserRoleServiceImpl implements UserRoleService {

	@Autowired
	private RoleDAO roleDAO;
	
	@Override
	public int insertRole(Role role) {
		return roleDAO.insertRole(role);
	}

	@Override
	public int deleteRole(String roleId) {
		return roleDAO.deleteRole(roleId);
	}

	@Override
	public List<Role> getRoleList() {
		return roleDAO.getRoleList();
	}

	@Override
	public int insertUserRole(String roleId, String userId) throws CommonException {
		return roleDAO.insertUserRole(roleId, userId);
	}

	@Override
	public int deleteUserRole(String roleId, String userId) throws CommonException {
		return roleDAO.deleteUserRole(roleId, userId);
	}

	@Override
	public String getRoleIdByName(String roleName) throws CommonException {
		return roleDAO.getRoleIdByName(roleName);
	}

}
