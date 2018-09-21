package com.isay.test;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.internetsaying.post.entity.Chat;
import com.internetsaying.post.entity.ChatReply;
import com.internetsaying.post.service.ChatService;
import com.internetsaying.user.entity.User;
import com.internetsaying.utils.IDUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-core.xml"})
public class TestChatService {

	@Autowired
	private ChatService chatService;
	
	@Test
	public void add() throws InterruptedException {
		for(int i = 10; i < 20; i++) {
			int j = chatService.addChat(new Chat(IDUtils.createID20(new Date()), "chatContent-" + i, new Date(), new User("0111")));
			System.out.println(j);
			Thread.sleep(1000);
		}
	}
	
	@Test
	public void Del() {
		int i = chatService.deleteChat(new Chat("1517735852087U2ZF256", new User("0110")), new User("0110"));
		System.out.println(i);
	}
	
	@Test
	public void chats() {
		chatService.getChats(1, 20).forEach(System.out::println);
	}
	
	@Test
	public void userChats() {
		chatService.getChatsPersonally("0110",1, 5).forEach(System.out::println);
	}
	
	@Test
	public void addReply() throws InterruptedException {
		for(int i = 0; i < 10; i++) {
			int j = chatService.addChatReply(new ChatReply(IDUtils.createID20(new Date()), "replyContent-" + i,
					new Date(), new User("0110"), new User("0111"), new Chat("1517735852087U2ZF256")));
			System.out.println(j);
			Thread.sleep(1000);
		}
	}
	
	@Test
	public void delReply() {
		int i = chatService.deleteChatReply(new ChatReply("1517736416951PK4MW9G", new User("0110")), new User("0110"));
		System.out.println(i);
	}
	
	@Test
	public void getReply() {
		chatService.getReplies("1517735852087U2ZF256").forEach(System.out::println);
	}
	
	@Test
	public void getReplyCount() {
		System.out.println(chatService.getChatCount());
	}
	
	
}
