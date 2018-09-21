package com.internetsaying.post.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.internetsaying.post.dao.ThrowPotDAO;
import com.internetsaying.post.dto.ReceivePotDetail;
import com.internetsaying.post.entity.ThrowPot;
import com.internetsaying.post.entity.ThrowPotDetail;
import com.internetsaying.post.service.ThrowPotService;

@Transactional(rollbackFor=Exception.class)
@Service
public class ThrowPotServiceImpl implements ThrowPotService {

	@Autowired
	private ThrowPotDAO throwPotDAO;
	
	@Override
	public ThrowPot getThrowPotByArea(int areaId) {
		return throwPotDAO.getThrowPotByArea(areaId);
	}

	@Override
	public List<ReceivePotDetail> getReceiveInfo(int areaId) {
		List<ReceivePotDetail> list = new ArrayList<>();
		for(int i = 1; i < 6; i++) {
			list.add(new ReceivePotDetail(i, throwPotDAO.getReceiveDetail(areaId, i)));
		}
		return list;
	}

	@Override
	public int addThrowPotDetail(ThrowPotDetail detail) {
		return throwPotDAO.addThrowPotDetail(detail);
	}

	@Override
	public List<ThrowPotDetail> getDetailListByArea(int areaId, int pageNo, int pageSize) {
		List<ThrowPotDetail> list = throwPotDAO.getDetailListByArea(areaId, pageSize*(pageNo-1), pageSize);
		Set<String> ids = new HashSet<>();
		list.forEach(t -> {
			ids.add(t.getUser().getUserId());
		});
		// 调用用户接口
		
		return list;
	}

}
