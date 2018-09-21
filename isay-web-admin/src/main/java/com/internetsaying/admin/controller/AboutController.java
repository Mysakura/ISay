package com.internetsaying.admin.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.internetsaying.common.base.BaseResponse;
import com.internetsaying.site.entity.About;
import com.internetsaying.site.service.AboutService;
import com.internetsaying.user.entity.User;
import com.internetsaying.utils.IDUtils;

@Controller
@RequestMapping("/about")
public class AboutController {

	@Autowired
	private AboutService aboutService;
	
	@RequestMapping("/list")
	public String adboutA(Map<String, Object> map) {
		map.put("data", aboutService.getAboutList());
		return "admin_about_manage";
	}
	
	@RequestMapping("/write")
	public String writeAdbout() {
		return "write_about";
	}
	
	@RequestMapping("/add")
	public String addAbout(HttpSession session, About about){
		User user = (User) session.getAttribute("user");
		about.setAboutId(IDUtils.createID20(about.getAboutTime()));
		about.setAboutEditor(new User(user.getUserId()));
		aboutService.addAbout(about);
		session.setAttribute("success", "添加成功");
		return "redirect:/success";
	}
	
	@RequestMapping("/look/{id}")
	public String lookAbout(Map<String, Object> map, @PathVariable("id") String id) {
		About about = aboutService.getAboutById(id);
		map.put("data", about);
		return "about_details";
	}
	
	@RequestMapping("/del")
	public @ResponseBody BaseResponse<Integer> delAbout(@RequestParam("aboutId") String aboutId){
		int deleteAbout = aboutService.deleteAbout(aboutId);
		return new BaseResponse<Integer>(deleteAbout);
	}
}
