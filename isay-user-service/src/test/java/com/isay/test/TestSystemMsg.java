package com.isay.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.internetsaying.user.entity.SystemMessage;
import com.internetsaying.user.entity.User;
import com.internetsaying.user.service.SystemMsgService;
import com.internetsaying.utils.IDUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-core.xml"})
public class TestSystemMsg {

	@Autowired
	private SystemMsgService systemMsgService;
	
	@Test
	public void add() {
		for (int i = 0; i < 10; i++) {
			systemMsgService.addSystemMsg(new SystemMessage(IDUtils.createID20(new Date()),
					new User("0111"), "msgContent-" + i, new Date()));
		}
		
	}
	
	@Test
	public void del() {
		System.out.println(systemMsgService.deleteSystemMsg(new SystemMessage("")));
	}
	
	@Test
	public void getListUser() {
		List<SystemMessage> list = systemMsgService.getSystemMsgList("0110", 1, 5);
		for (SystemMessage m : list) {
			System.out.println(m);
		}
	}
	
	@Test
	public void getListAll() {
		List<SystemMessage> list = systemMsgService.getSystemMsgList(1, 5);
		for (SystemMessage m : list) {
			System.out.println(m);
		}
	}
	
	@Test
	public void getListCount() {
		int i = systemMsgService.getSysCountForAll();
		int j = systemMsgService.getSysCountForUser("0110");
		
		System.out.println(i + "," + j);
	}
	
	
	
}
