package com.isay.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.internetsaying.site.entity.FriendLink;
import com.internetsaying.site.service.FriendService;
import com.internetsaying.user.entity.User;
import com.internetsaying.utils.IDUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-core.xml"})
public class TestFriendService {

	@Autowired
	private FriendService friendService;
	
	@Test
	public void testAdd() {
		for(int i = 0; i < 10; i++) {
			int res = friendService.addFriend(new FriendLink(IDUtils.createID20(new Date()), "flName-" + i,
					"flUrl-" + i, new User("0110", null), new Date()));
			System.out.println(res);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Test
	public void testAccept() {
		friendService.acceptFriend("1517052394560QFG8WD2", "2222");
		friendService.acceptFriend("1517052395636PKW19NK", "2222");
		friendService.acceptFriend("151705239670293JFCAU", "2222");
	}
	
	@Test
	public void testDeny() {
		friendService.denyFriend("1517052390326UB8NA7W", "1111");
		friendService.denyFriend("1517052391359VG7AMJV", "1111");
		friendService.denyFriend("1517052392424UVR27PM", "1111");
	}
	
	@Test
	public void testDelete() {
		int res = friendService.deleteFriend("1517052387029M9J5RBI");
		System.out.println(res);
	}
	
	@Test
	public void testGetList() {
		List<FriendLink> list = friendService.getFriendLinkList(1, 5);
		for (FriendLink friendLink : list) {
			System.out.println(friendLink);
		}
	}
	
	@Test
	public void testGetListN() {
		List<FriendLink> list = friendService.getFriendLinkListOfNotDeal(1, 5);
		for (FriendLink friendLink : list) {
			System.out.println(friendLink);
		}
	}
	
	@Test
	public void testGetListA() {
		List<FriendLink> list = friendService.getFriendLinkListOfAccept(1, 5);
		for (FriendLink friendLink : list) {
			System.out.println(friendLink);
		}
	}
	
	@Test
	public void testGetListD() {
		List<FriendLink> list = friendService.getFriendLinkListOfDeny(1, 5);
		for (FriendLink friendLink : list) {
			System.out.println(friendLink);
		}
	}
}
