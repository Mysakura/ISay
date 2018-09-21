
package com.internetsaying.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.internetsaying.user.dao.FansDAO;
import com.internetsaying.user.dto.FansDTO;
import com.internetsaying.user.entity.Fans;
import com.internetsaying.user.service.FansService;

@Transactional(rollbackFor=Exception.class)
@Service
public class FansServiceImpl implements FansService {
	
	@Autowired
	private FansDAO fansDAO;
	
	@Autowired
	@Qualifier("serviceRedisTemplate")
	private RedisTemplate<String, Object> redisTemplate;
	
	//private static final String SET_USER_FANS = "set:fans:";				// 用户的粉丝，其他用户id为member。key为用户id
	//private static final String SET_USER_FOLLOWS = "set:follows:";			// 用户的关注，其他用户id为member。key为用户id

	@Override
	public int addFans(Fans fans) {
		return fansDAO.addFans(fans);
	}
	
	@Override
	public int delFans(Fans fans) {
		return fansDAO.deleteRelation(fans.getFollowerId(), fans.getMasterId());
	}
	
	@Override
	public List<FansDTO> getFocus(String userId, int pageNo, int pageSize) {
		return fansDAO.getFocus(userId, pageSize*(pageNo-1), pageSize);
	}

	@Override
	public List<FansDTO> getFans(String userId, int pageNo, int pageSize) {
		return fansDAO.getFans(userId, pageSize*(pageNo-1), pageSize);
	}

	@Override
	public int countFocus(String userId) {
		return fansDAO.countFocus(userId);
	}

	@Override
	public int countFans(String userId) {
		return fansDAO.countFans(userId);
	}

	@Override
	public int checkRelation(String userA, String userB) {
		return fansDAO.checkRelation(userA, userB);
	}

}
