package com.internetsaying.site.service.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.internetsaying.exception.CommonException;
import com.internetsaying.exception.enums.ExceptionEnum;
import com.internetsaying.site.dao.FriendDAO;
import com.internetsaying.site.entity.FriendLink;
import com.internetsaying.site.service.FriendService;
import com.internetsaying.user.entity.User;
import com.internetsaying.user.service.UserService;
import com.internetsaying.utils.IDUtils;

@Transactional(rollbackFor=Exception.class)
@Service
public class FriendServiceImpl implements FriendService {

	@Autowired
	private FriendDAO friendDAO;
	
	@Autowired
	private UserService userService;
	
	@Override
	public int addFriend(FriendLink link) {
		Date flTime = new Date();
		link.setFlTime(flTime);
		link.setFlId(IDUtils.createID20(flTime));
		int exist = friendDAO.checkExist(link);
		if(exist == 1) {
			throw new CommonException(ExceptionEnum.FRIEND_EXIST.code, ExceptionEnum.FRIEND_EXIST.msg);
		}
		int result = friendDAO.addFriend(link);
		if (result == 0) {
			throw new CommonException(ExceptionEnum.ADD_FRIEND_FAILED.code, ExceptionEnum.ADD_FRIEND_FAILED.msg);
		}
		return result;
	}

	@Override
	public int acceptFriend(String flId, String userId) {
		return friendDAO.updateFriend(new FriendLink(flId, "2", new User(userId)));
	}

	@Override
	public int denyFriend(String flId, String userId) {
		return friendDAO.updateFriend(new FriendLink(flId, "1", new User(userId)));
	}

	@Override
	public int deleteFriend(String flId) {
		return friendDAO.deleteFriend(flId);
	}

	@Override
	public List<FriendLink> getFriendLinkList(int pageNo, int pageSize) {
		List<FriendLink> list = friendDAO.getFriendLinkList(pageSize*(pageNo-1), pageSize);
		if(list.isEmpty()) {
			return list;
		}
		Set<String> ids = new HashSet<>();
		for (FriendLink f : list) {
			ids.add(f.getFlUser().getUserId());
			ids.add(f.getFlAdmin().getUserId());
		}
		Map<String, User> map = userService.getSpecificUsers(ids);
		for (FriendLink f : list) {
			f.setFlAdmin(map.get(f.getFlAdmin().getUserId()));
			f.setFlUser(map.get(f.getFlUser().getUserId()));
		}
		return list;
	}

	@Override
	public List<FriendLink> getFriendLinkListOfNotDeal(int pageNo, int pageSize) {
		List<FriendLink> list = friendDAO.getFriendLinkListOfType("0", pageSize*(pageNo-1), pageSize);
		if(list.isEmpty()) {
			return list;
		}
		Set<String> ids = new HashSet<>();
		for (FriendLink f : list) {
			ids.add(f.getFlUser().getUserId());
			ids.add(f.getFlAdmin().getUserId());
		}
		Map<String, User> map = userService.getSpecificUsers(ids);
		for (FriendLink f : list) {
			f.setFlAdmin(map.get(f.getFlAdmin().getUserId()));
			f.setFlUser(map.get(f.getFlUser().getUserId()));
		}
		return list;
	}
	
	@Override
	public List<FriendLink> getFriendLinkListOfAccept(int pageNo, int pageSize) {
		List<FriendLink> list = friendDAO.getFriendLinkListOfType("2", pageSize*(pageNo-1), pageSize);
		if(list.isEmpty()) {
			return list;
		}
		Set<String> ids = new HashSet<>();
		for (FriendLink f : list) {
			ids.add(f.getFlUser().getUserId());
			ids.add(f.getFlAdmin().getUserId());
		}
		Map<String, User> map = userService.getSpecificUsers(ids);
		for (FriendLink f : list) {
			f.setFlAdmin(map.get(f.getFlAdmin().getUserId()));
			f.setFlUser(map.get(f.getFlUser().getUserId()));
		}
		return list;
	}

	@Override
	public List<FriendLink> getFriendLinkListOfDeny(int pageNo, int pageSize) {
		List<FriendLink> list = friendDAO.getFriendLinkListOfType("1", pageSize*(pageNo-1), pageSize);
		if(list.isEmpty()) {
			return list;
		}
		Set<String> ids = new HashSet<>();
		for (FriendLink f : list) {
			ids.add(f.getFlUser().getUserId());
			ids.add(f.getFlAdmin().getUserId());
		}
		Map<String, User> map = userService.getSpecificUsers(ids);
		for (FriendLink f : list) {
			f.setFlAdmin(map.get(f.getFlAdmin().getUserId()));
			f.setFlUser(map.get(f.getFlUser().getUserId()));
		}
		return list;
	}

	@Override
	public int getFriendLinkCount() {
		// TODO Auto-generated method stub
		return friendDAO.getFriendLinkCount();
	}

	@Override
	public int getFriendLinkCountOfType(String flOk) {
		// TODO Auto-generated method stub
		return friendDAO.getFriendLinkCountOfType(flOk);
	}

}
