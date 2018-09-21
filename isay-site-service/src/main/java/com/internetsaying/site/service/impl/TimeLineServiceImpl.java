package com.internetsaying.site.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.internetsaying.site.dao.TimeLineDAO;
import com.internetsaying.site.entity.TimeLine;
import com.internetsaying.site.service.TimeLineService;

@Transactional(rollbackFor=Exception.class)
@Service
public class TimeLineServiceImpl implements TimeLineService {

	@Autowired
	private TimeLineDAO timeLineDAO;
	
	@Override
	public int addTimeLine(TimeLine line) {
		return timeLineDAO.addTimeLine(line);
	}

	@Override
	public int updateTimeLine(TimeLine line) {
		return timeLineDAO.updateTimeLine(line);
	}

	@Override
	public int deleteTimeLine(String tlId) {
		return timeLineDAO.deleteTimeLine(tlId);
	}

	@Override
	public List<TimeLine> getTimeLineList() {
		return timeLineDAO.getTimeLineList();
	}

}
