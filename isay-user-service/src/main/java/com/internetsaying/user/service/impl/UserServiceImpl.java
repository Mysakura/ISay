package com.internetsaying.user.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.internetsaying.exception.CommonException;
import com.internetsaying.user.dao.RoleDAO;
import com.internetsaying.user.dao.UserDAO;
import com.internetsaying.user.entity.User;
import com.internetsaying.user.service.UserService;
import com.internetsaying.utils.IDUtils;

@Transactional(rollbackFor=Exception.class)
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private RoleDAO roleDAO;
	
	@Autowired
	@Qualifier("serviceRedisTemplate")
	private RedisTemplate<String, Object> redisTemplate;
	
	private static final String USER_KEY = "users";
	
	@Override
	public User getUserForLogin(String userEmail, String password) {
		
		return userDAO.getUserForLogin(userEmail, password);
	}

	@Override
	public User getUserById(String userId) {
		User user = (User) redisTemplate.boundHashOps(USER_KEY).get(userId);
		if(user == null){
			User userFromDB = userDAO.getUserById(userId);
			if(userFromDB == null){
				return null;
			}else{
				redisTemplate.boundHashOps(USER_KEY).put(userId, userFromDB);
				return userFromDB;
			}
		}
		return user;
	}

	@Override
	public int addUser(User user) {
		String id = IDUtils.createID20(new Date());
		user.setUserId(id);
		user.setPassword(IDUtils.saltAndMd5(user.getUserEmail(), user.getPassword())); // 加密存储
		// 添加进数据库
		int res = userDAO.addUser(user);
		roleDAO.insertUserRole(roleDAO.getRoleIdByName("user"), id);
		// 添加进缓存
		redisTemplate.boundHashOps(USER_KEY).put(user.getUserId(), user);
		return res;
	}

	private int updateUser(User user) {
		// 更新数据库
		int res = userDAO.updateUser(user);
		// 更新缓存
		User userFromDB = userDAO.getUserById(user.getUserId());
		redisTemplate.boundHashOps(USER_KEY).put(user.getUserId(), userFromDB);
		return res;
	}
	
	@Override
	public int updateBaseInfo(User user) {
		// TODO Auto-generated method stub
		return updateUser(user);
	}

	@Override
	public int updatePassword(User user) {
		// TODO Auto-generated method stub
		return updateUser(user);
	}
	
	@Override
	public int updatePhoto(User user) {
		// TODO Auto-generated method stub
		return updateUser(user);
	}

	@Override
	public int updateBg(User user) {
		// TODO Auto-generated method stub
		return updateUser(user);
	}

	@Override
	public int updateAlipay(User user) {
		// TODO Auto-generated method stub
		return updateUser(user);
	}

	@Override
	public int updateVxin(User user) {
		// TODO Auto-generated method stub
		return updateUser(user);
	}
	

	@Override
	public int deleteUser(User user) {
		return updateUser(user);
	}

	@Override
	public int checkEmail(String email) {
		// TODO Auto-generated method stub
		return userDAO.checkEmail(email);
	}
	
	@Override
	public int checkNickName(String nickname) {
		// TODO Auto-generated method stub
		return userDAO.checkNickName(nickname);
	}

	@Override
	public List<User> getSpecificUsers(List<String> ids) {
		return userDAO.getSpecificUsers(ids);
	}

	@Override
	public Map<String, User> getSpecificUsers(Set<String> ids) {
		return userDAO.getSpecificUsersMap(ids);
	}

	@Override
	public int getUserCount() throws CommonException {
		return userDAO.getUserCount();
	}

	@Override
	public List<User> getUserList(int pageNo, int pageSize) throws CommonException {
		return userDAO.getUserList(pageSize*(pageNo-1), pageSize);
	}

}
