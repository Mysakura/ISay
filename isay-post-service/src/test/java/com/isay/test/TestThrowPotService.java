package com.isay.test;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.internetsaying.post.dao.ThrowPotDAO;
import com.internetsaying.post.entity.ThrowPotDetail;
import com.internetsaying.post.entity.WorkArea;
import com.internetsaying.post.service.ThrowPotService;
import com.internetsaying.user.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-core.xml"})
public class TestThrowPotService {

	@Autowired
	private ThrowPotService t;
	
	@Test
	public void add() {
		t.addThrowPotDetail(new ThrowPotDetail(new User("1111"), new WorkArea(10), new WorkArea(11), "1", new Date()));
	}
	
	@Test
	public void get() {
		System.out.println(t.getThrowPotByArea(8));
	}
	
	@Test
	public void receive() {
		t.getReceiveInfo(8).forEach(e -> System.out.println(e));	// 累计收到了，每个礼物【总共多少】，分别来自？
	}
	
	@Test
	public void detail() {
		t.getDetailListByArea(8, 1, 10).forEach(e -> System.out.println(e));
	}
}
