package com.isay.test;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.internetsaying.site.dao.MessageBoardDAO;
import com.internetsaying.site.entity.MessageBoard;
import com.internetsaying.site.entity.MessageBoardReply;
import com.internetsaying.site.service.MessageBoardService;
import com.internetsaying.user.entity.User;
import com.internetsaying.utils.IDUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-core.xml"})
public class TestMessageBoardService {

	@Autowired
	private MessageBoardService messageBoardService;
	
	@Autowired
	private MessageBoardDAO messageBoardDAO;
	
	@Test
	public void testgetM() {
		List<MessageBoard> list = messageBoardDAO.getMessageList(0, 10);
		if(list == null) {
			System.err.println("null");
		}
		if(list.isEmpty()) {
			System.err.println("empty");
		}
		if(list.size() == 0) {
			System.err.println("0");
		}
		// empty
		// 0
	}
	
	
	@Test
	public void testAddM() {
		for(int i = 0; i < 10; i++) {
			messageBoardService.addMessage(new MessageBoard(IDUtils.createID20(new Date()),
					"messageContent-" + 10 + i, new Date(), new User("011" + i)));
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Test
	public void testAddR() {
		Random rand = new Random();
		for(int i = 20; i < 25; i++) {
			messageBoardService.addReply(new MessageBoardReply(IDUtils.createID20(new Date()), "mrContent-" + i, new Date(),
					new MessageBoard("1517188802552ZQNMCDL"), new User("011" + rand.nextInt(10)), new User("011" + rand.nextInt(10))));
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Test
	public void testUpdate() {
		
	}
	
	@Test
	public void testDelete() {
		
	}
	
	@Test
	public void testGetReplyList() {
		List<MessageBoardReply> list = messageBoardService.getReplyList("1517188800019RDS7WEG");
		for (MessageBoardReply r : list) {
			System.out.println(r);
		}
	}
	
	@Test
	public void testGetList() {
		List<MessageBoard> list = messageBoardService.getMessageList(1, 20);
		for (MessageBoard m : list) {
			System.out.println(m);
		}
	}
	
}
