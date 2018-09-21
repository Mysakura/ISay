package com.internetsaying.post.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.internetsaying.post.dao.AreaDAO;
import com.internetsaying.post.entity.AreaLabel;
import com.internetsaying.post.entity.WorkArea;
import com.internetsaying.post.service.AreaService;

@Transactional(rollbackFor=Exception.class)
@Service
public class AreaServiceImpl implements AreaService {

	@Autowired
	private AreaDAO areaDAO;
	
	@Override
	public int addArea(List<WorkArea> area) {
		return areaDAO.addArea(area);
	}

	@Override
	public int updateArea(WorkArea area) {
		return areaDAO.updateArea(area);
	}

	@Override
	public int deleteArea(int areaId) {
		return areaDAO.deleteArea(areaId);
	}

	@Override
	public List<WorkArea> getAreas() {
		return areaDAO.getAreas();
	}

	@Override
	public int addAreaLabel(List<AreaLabel> label) {
		return areaDAO.addAreaLabel(label);
	}

	@Override
	public int updateAreaLabel(AreaLabel label) {
		return areaDAO.updateAreaLabel(label);
	}

	@Override
	public int deleteAreaLabel(int labelId) {
		return areaDAO.deleteAreaLabel(labelId);
	}

	@Override
	public List<AreaLabel> getAreaLabel(int areaId) {
		return areaDAO.getAreaLabel(areaId);
	}

	@Override
	public int getAreaIdByName(String areaName) {
		return areaDAO.getAreaIdByName(areaName);
	}

}
