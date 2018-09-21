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
import com.internetsaying.site.entity.Announcement;
import com.internetsaying.site.service.AnnouncementService;
import com.internetsaying.user.entity.User;
import com.internetsaying.utils.IDUtils;

@Controller
@RequestMapping("/announce")
public class AnnounceController {

	@Autowired
	private AnnouncementService announcementService;
	
	@RequestMapping("/list")
	public String annList(Map<String, Object> map) {
		return annList(map, 1);
	}
	
	@RequestMapping("/list/{page}")
	public String annList(Map<String, Object> map, @PathVariable("page") int page) {
		int count = announcementService.getAnnouncementCount();
		BasePageResponse<List<Announcement>> response = new BasePageResponse<>(page, count);
		response.setData(announcementService.getAnnouncementList(response.getPageNo(), response.getPageSize()));
		map.put("response", response);
		return "admin_announce_manage";
	}
	
	@RequestMapping("/write")
	public String writeAnn() {
		return "write_announce";
	}
	
	@RequestMapping("/addAnnounce")
	public String addAnnounce(HttpSession session, Announcement announcement) {
		User user = (User) session.getAttribute("user");
		announcement.setAnnId(IDUtils.createID20(announcement.getAnnTime()));
		announcement.setAnnEditor(new User(user.getUserId()));
		announcementService.addAnnouncement(announcement);
		session.setAttribute("success", "添加成功");
		return "redirect:/success";
	}
	
	@RequestMapping("/look/{id}")
	public String lookAnn(Map<String, Object> map, @PathVariable("id") String id) {
		Announcement announcement = announcementService.getAnnouncement(id);
		map.put("data", announcement);
		return "announce_details";
	}
	
	@RequestMapping("/delAnnounce")
	public @ResponseBody BaseResponse<Integer> delAnnounce(@RequestParam("annId") String annId) {
		int deleteAnnouncement = announcementService.deleteAnnouncement(annId);
		return new BaseResponse<Integer>(deleteAnnouncement);
	}
}
