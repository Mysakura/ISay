package com.isay.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.internetsaying.site.entity.Announcement;
import com.internetsaying.site.service.AnnouncementService;
import com.internetsaying.user.entity.User;
import com.internetsaying.utils.IDUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-core.xml"})
public class TestAnnounceService {

	@Autowired
	private AnnouncementService announcementService;
	
	@Test
	public void testAdd() {
		for(int i = 0; i < 10; i++) {
			announcementService.addAnnouncement(new Announcement(IDUtils.createID20(new Date()), "AnnTitle-" + i,
					"annContent-" + i, "annMarkdown-" + i, new User("0110", null), new Date()));
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Test
	public void testUpdate() {
		Announcement announcement = new Announcement("1517050413523MGEDCDE", "annTitle-00", "annContent-00",
				"annMarkdown-00", new User("1111", null), new Date());
		announcementService.updateAnnouncement(announcement);
	}
	
	@Test
	public void testDelete() {
		int res = announcementService.deleteAnnouncement("215");
		System.out.println(res);
	}
	
	@Test
	public void testGetOne() {
		Announcement announcement = announcementService.getAnnouncement("15170504142799K7FUV1");
		System.out.println(announcement);
	}
	
	@Test
	public void testGetList() {
		List<Announcement> list = announcementService.getAnnouncementList(2, 5);
		for (Announcement a : list) {
			System.out.println(a);
		}
	}
	
	
}
