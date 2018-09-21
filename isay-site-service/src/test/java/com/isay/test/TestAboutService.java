package com.isay.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.internetsaying.site.entity.About;
import com.internetsaying.site.service.AboutService;
import com.internetsaying.user.entity.User;
import com.internetsaying.utils.IDUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-core.xml"})
public class TestAboutService {

	@Autowired
	private AboutService aboutService;
	
	@Test
	public void testAdd() {
		for(int i = 0; i < 10; i++) {
			aboutService.addAbout(new About(IDUtils.createID20(new Date()), "aboutContent-" + i, "aboutMarkdown-" + i, (i%3+1)+"", new User("0113", null), new Date()));
		}
	}
	
	@Test
	public void testUpdate() {
		About about = new About("1517018229622D41IPS6", "更新内容", "更新markdown", new User("0110", null), new Date());
		int res = aboutService.updateAbout(about);
		System.out.println(res);
	}
	
	@Test
	public void testdelete() {
		
	}
	
	@Test
	public void testSite() {
		About about = aboutService.getAboutSiteOfNew();
		System.out.println(about);
	}
	
	@Test
	public void testAuthor() {
		// 如果查询到数据的时间一样，就会按照原始顺序来选择
		About about = aboutService.getAboutAuthorOfNew();
		System.out.println(about);
	}
	
	@Test
	public void testContact() {
		About about = aboutService.getAboutContactOfNew();
		System.out.println(about);
	}
	
	@Test
	public void testList() {
		List<About> list = aboutService.getAboutList();
		for (About about : list) {
			System.out.println(about);
		}
	}
	
}
