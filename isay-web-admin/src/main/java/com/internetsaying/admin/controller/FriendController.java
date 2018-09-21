package com.internetsaying.admin.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.internetsaying.common.base.BaseResponse;
import com.internetsaying.site.entity.FriendLink;
import com.internetsaying.site.service.FriendService;
import com.internetsaying.user.entity.User;

@Controller
@RequestMapping("/friend")
public class FriendController {

	@Autowired
	private FriendService friendService;
	
	private static final int pageSize = 100;	// 省事了，不整分页了
	
	@RequestMapping("/all")
	public String all(Map<String, Object> map) {
		List<FriendLink> list = friendService.getFriendLinkList(1, pageSize);
		map.put("data", list);
		return "admin_friend_manage";
	}
	
	@RequestMapping("/uncheck")
	public String uncheck(Map<String, Object> map) {
		List<FriendLink> list = friendService.getFriendLinkListOfNotDeal(1, pageSize);
		map.put("data", list);
		return "admin_friend_manage";
	}
	
	@RequestMapping("/accept")
	public String accept(Map<String, Object> map) {
		List<FriendLink> list = friendService.getFriendLinkListOfAccept(1, pageSize);
		map.put("data", list);
		return "admin_friend_manage";
	}
	
	@RequestMapping("/deny")
	public String deny(Map<String, Object> map) {
		List<FriendLink> list = friendService.getFriendLinkListOfDeny(1, pageSize);
		map.put("data", list);
		return "admin_friend_manage";
	}
	
	@RequestMapping("/deal_accept")
	public @ResponseBody BaseResponse<Integer> accept(HttpSession session, @RequestParam("flId") String flId) {
		User user = (User) session.getAttribute("user");
		int acceptFriend = friendService.acceptFriend(flId, user.getUserId());
		return new BaseResponse<Integer>(acceptFriend);
	}
	
	@RequestMapping("/deal_deny")
	public @ResponseBody BaseResponse<Integer> deny(HttpSession session, @RequestParam("flId") String flId) {
		User user = (User) session.getAttribute("user");
		int denyFriend = friendService.denyFriend(flId, user.getUserId());
		return new BaseResponse<Integer>(denyFriend);
	}
	
}
