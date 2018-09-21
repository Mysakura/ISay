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
import com.internetsaying.exception.CommonException;
import com.internetsaying.exception.enums.ExceptionEnum;
import com.internetsaying.site.entity.TimeLine;
import com.internetsaying.site.service.TimeLineService;
import com.internetsaying.user.entity.User;
import com.internetsaying.utils.IDUtils;

@Controller
@RequestMapping("/timeline")
public class TimeLineController {

	@Autowired
	private TimeLineService timeLineService;
	
	@RequestMapping("/all")
	public String all(Map<String, Object> map) {
		List<TimeLine> list = timeLineService.getTimeLineList();
		map.put("data", list);
		return "admin_timeline_manage";
	}
	
	@RequestMapping("/add")
	public @ResponseBody BaseResponse<Integer> add(HttpSession session, TimeLine line) {
		User user = (User) session.getAttribute("user");
		if(user == null) {
			throw new CommonException(ExceptionEnum.RE_LOGIN.code, ExceptionEnum.RE_LOGIN.msg);
		}
		line.setTlId(IDUtils.createID20(line.getTlTime()));
		line.setEditor(new User(user.getUserId()));
		int addTimeLine = timeLineService.addTimeLine(line);
		return new BaseResponse<Integer>(addTimeLine);
	}
	
	@RequestMapping("/del")
	public @ResponseBody BaseResponse<Integer> del(HttpSession session, @RequestParam("tlId") String tlId) {
		int deleteTimeLine = timeLineService.deleteTimeLine(tlId);
		return new BaseResponse<Integer>(deleteTimeLine);
	}
}
