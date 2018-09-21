package com.internetsaying.admin.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.internetsaying.common.base.BaseResponse;
import com.internetsaying.post.entity.AreaLabel;
import com.internetsaying.post.entity.WorkArea;
import com.internetsaying.post.service.AreaService;

@Controller
@RequestMapping("/area")
public class AreaController {

	@Autowired
	private AreaService areaService;
	
	@RequestMapping("/list")
	public String areaList(Map<String, Object> map) {
		List<WorkArea> areas = areaService.getAreas();
		map.put("data", areas);
		return "admin_area_manage";
	}
	
	@RequestMapping("/labels/{areaId}")
	public String labelList(Map<String, Object> map, @PathVariable("areaId") int areaId) {
		List<AreaLabel> areaLabel = areaService.getAreaLabel(areaId);
		map.put("data", areaLabel);
		return "admin_area_label_manage";
	}
	
	@RequestMapping("/addLabel")
	public @ResponseBody BaseResponse<Integer> addLabel(AreaLabel label) {
		int addAreaLabel = areaService.addAreaLabel(Arrays.asList(label));
		return new BaseResponse<Integer>(addAreaLabel);
	}
	
	@RequestMapping("/delLabel")
	public @ResponseBody BaseResponse<Integer> delLabel(@RequestParam("labelId") int labelId) {
		int deleteAreaLabel = areaService.deleteAreaLabel(labelId);
		return new BaseResponse<Integer>(deleteAreaLabel);
	}
	
	
}
