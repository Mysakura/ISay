package com.internetsaying.admin.controller;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.internetsaying.user.entity.User;

@Controller
public class CommonController {

	
	
	@RequestMapping(value= {"/","/index"})
	public String index() {
		return "index";
	}
	
	/**
	 * 登录，RequestMethod=post
	 * @param request
	 * @param attr
	 * @return
	 */
	@RequestMapping(value="/login")
	public String login(HttpSession session, @RequestParam("email") String email, @RequestParam("password") String password){
		
		Subject subject = SecurityUtils.getSubject();
		
		UsernamePasswordToken token = new UsernamePasswordToken(email, password);
		
		subject.login(token);
		
		User principal = (User) subject.getPrincipal();
		session.setAttribute("user", principal);
		
		return "redirect:/home";
	}
	
	@RequestMapping("/home")
	public String home(){
		return "home";
	}
	
	/**
	 * 错误页面
	 * @param request
	 * @param attr
	 * @return
	 */
	@RequestMapping("/error")
	public String error(){
		return "tip/error";
	}
	
	/**
	 * 成功界面
	 * @param request
	 * @param attr
	 * @return
	 */
	@RequestMapping("/success")
	public String success(){
		return "tip/success";
	}
	
	/**
	 * 404页面
	 * @return
	 */
	@RequestMapping("/404")
	public String notFound(){
		return "tip/404";
	}
}
