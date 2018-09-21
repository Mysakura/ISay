package com.internetsaying.admin.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.internetsaying.common.base.BasePageResponse;
import com.internetsaying.common.base.BaseResponse;
import com.internetsaying.common.enums.DeleteStatus;
import com.internetsaying.user.entity.User;
import com.internetsaying.user.service.UserRoleService;
import com.internetsaying.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRoleService userRoleService;
	
	@RequestMapping("/list")
	public String userList(Map<String, Object> map) {
		return userList(map, 1);
	}
	
	@RequestMapping("/list/{page}")
	public String userList(Map<String, Object> map, @PathVariable("page") int page) {
		int count = userService.getUserCount();
		BasePageResponse<List<User>> response = new BasePageResponse<>(page, count);
		response.setData(userService.getUserList(response.getPageNo(), response.getPageSize()));
		map.put("response", response);
		return "admin_user_manage";
	}
	
	/**
	 * 屏蔽
	 * @param session
	 * @param userId
	 * @return
	 */
	@RequestMapping("/shield")
	public @ResponseBody BaseResponse<Integer> shield(HttpSession session, @RequestParam("userId") String userId) {
		int deleteUser = userService.deleteUser(new User(userId, DeleteStatus.ALR_DEL.code));
		return new BaseResponse<Integer>(deleteUser);
	}
	
	/**
	 * 解除屏蔽
	 * @param session
	 * @param userId
	 * @return
	 */
	@RequestMapping("/show")
	public @ResponseBody BaseResponse<Integer> show(HttpSession session, @RequestParam("userId") String userId) {
		int deleteUser = userService.deleteUser(new User(userId, DeleteStatus.NOT_DEL.code));
		return new BaseResponse<Integer>(deleteUser);
	}
	
	/**
	 * 设为管理
	 * @param session
	 * @param userId
	 * @return
	 */
	@RequestMapping("/toAdmin")
	public @ResponseBody BaseResponse<Integer> toAdmin(HttpSession session, @RequestParam("userId") String userId) {
		String roleId = userRoleService.getRoleIdByName("admin");
		int insertUserRole = userRoleService.insertUserRole(roleId, userId);
		return new BaseResponse<Integer>(insertUserRole);
	}
	
	/**
	 * 移除管理
	 * @param session
	 * @param roleId
	 * @return
	 */
	@RequestMapping("/removeAdmin")
	public @ResponseBody BaseResponse<Integer> removeAdmin(HttpSession session, @RequestParam("roleId") String roleId, @RequestParam("userId") String userId) {
		int deleteUserRole = userRoleService.deleteUserRole(roleId, userId);
		return new BaseResponse<Integer>(deleteUserRole);
	}
}
