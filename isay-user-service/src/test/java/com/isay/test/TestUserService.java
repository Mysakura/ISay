package com.isay.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.internetsaying.user.entity.User;
import com.internetsaying.user.service.UserService;

@RunWith(value=SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-core.xml"})
public class TestUserService {

	@Autowired
	private UserService userService;
	
	@Test
	public void login() {
		User user = userService.getUserForLogin("1", "1");
		System.out.println(user);
	}
	
	@Test
	public void get() {
		User user = userService.getUserById("0110");
		System.out.println(user);
	}
	
	@Test
	public void add() {
		User user = new User();
		user.setUserId("0112");
		user.setUserEmail("3.qq.com");
		user.setPassword("123");
		user.setNickname("BBB");
		int res = userService.addUser(user);
		System.out.println(res);
	}
	
	// 以下是修改
	@Test
	public void baseInfo() {
		User user = new User("0110", "aaa", "男", "南开", "Java开发工程师", "阿里", "杭州");
		int res = userService.updateBaseInfo(user);
		System.out.println(res);
	}
	
	@Test
	public void password() {
		User user = new User("0110", "123456", null, null, null, null);
		int res = userService.updateBaseInfo(user);
		System.out.println(res);
	}
	
	@Test
	public void basePhoto() {
		User user = new User("0110", null, "http://192.168.197.129/35335.jpg", null, null, null);
		int res = userService.updateBaseInfo(user);
		System.out.println(res);
	}
	
	@Test
	public void baseBg() {
		User user = new User("0110", null, null, "http://192.168.197.129/35666.jpg", null, null);
		int res = userService.updateBaseInfo(user);
		System.out.println(res);
	}
	
	@Test
	public void baseAli() {
		User user = new User("0110", null, null, null, "http://192.168.197.129/35777.jpg", null);
		int res = userService.updateBaseInfo(user);
		System.out.println(res);
	}
	
	@Test
	public void baseVxin() {
		User user = new User("0110", null, null, null, null, "http://192.168.197.129/35888.jpg");
		int res = userService.updateBaseInfo(user);
		System.out.println(res);
	}
	
	@Test
	public void delete() {
		User user = new User("0110", "1");
		int res = userService.updateBaseInfo(user);
		System.out.println(res);
	}
	
	@Test
	public void checkEmail() {
		int res = userService.checkEmail("2.qq.com");
		System.out.println(res);
	}
	
	@Test
	public void specificUsers() {
		List<String> ids = new ArrayList<>();
		ids.add("0111");
		ids.add("0112");
		List<User> list = userService.getSpecificUsers(ids);
		for (User user : list) {
			System.out.println(user);
		}
	}
	
	
	@Test
	public void specificUsersMap() {
		Set<String> ids = new HashSet<>();
		ids.add("0111");
		ids.add("0112");
		Map<String, User> map = userService.getSpecificUsers(ids);
		Set<Entry<String,User>> entrySet = map.entrySet();
		for (Entry<String, User> entry : entrySet) {
			System.out.println(entry.getKey() + "|" + entry.getValue());
		}
	}
	
	
	
}
