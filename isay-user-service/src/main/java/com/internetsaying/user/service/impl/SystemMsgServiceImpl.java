package com.internetsaying.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.internetsaying.user.dao.SystemMsgDAO;
import com.internetsaying.user.entity.SystemMessage;
import com.internetsaying.user.service.SystemMsgService;

@Transactional(rollbackFor=Exception.class)
@Service
public class SystemMsgServiceImpl implements SystemMsgService {

	@Autowired
	private SystemMsgDAO systemMsgDAO;
	
	@Override
	public int addSystemMsg(SystemMessage msg) {
		return systemMsgDAO.addSystemMsg(msg);
	}

	@Override
	public int deleteSystemMsg(SystemMessage msg) {
		return systemMsgDAO.deleteSystemMsg(msg);
	}

	@Override
	public List<SystemMessage> getSystemMsgList(String userId, int pageNo, int pageSize) {
		return systemMsgDAO.getSystemMsgListForUser(userId, (pageNo-1)*pageSize, pageSize);
	}

	@Override
	public List<SystemMessage> getSystemMsgList(int pageNo, int pageSize) {
		return systemMsgDAO.getSystemMsgListForAll((pageNo-1)*pageSize, pageSize);
	}

	@Override
	public int getSysCountForUser(String userId) {
		return systemMsgDAO.getSysCountForUser(userId);
	}

	@Override
	public int getSysCountForAll() {
		return systemMsgDAO.getSysCountForAll();
	}

}
