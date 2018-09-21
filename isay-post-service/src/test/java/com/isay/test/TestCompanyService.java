package com.isay.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.internetsaying.post.entity.Company;
import com.internetsaying.post.entity.CompanyLabel;
import com.internetsaying.post.service.CompanyService;
import com.internetsaying.user.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-core.xml"})
public class TestCompanyService {

	@Autowired
	private CompanyService companyService;
	
	@Test
	public void add() {
		String s = "百度 " + 
				"阿里 " + 
				"腾讯 " + 
				"360 " + 
				"小米 " + 
				"京东 " + 
				"亚马逊 " + 
				"口袋购物 " + 
				"当当网 " + 
				"聚美优品 " + 
				"美团 " + 
				"拉手网 " + 
				"明星衣橱 " + 
				"美丽说 " + 
				"去哪儿 " + 
				"艺龙 " + 
				"豆瓣 " + 
				"知乎 " + 
				"人人 " + 
				"Nice " + 
				"脉脉 " + 
				"果壳 " + 
				"陌陌 " + 
				"凤凰网 " + 
				"豌豆荚 " + 
				"友盟 " + 
				"Hulu " + 
				"优酷 " + 
				"爱奇艺 " + 
				"乐视网 " + 
				"优米网 " + 
				"暴风影音 " + 
				"风行网 " + 
				"新浪 " + 
				"网易 " + 
				"搜狐 " + 
				"搜狗 " + 
				"今日头条 " + 
				"极客公园 " + 
				"微软 " + 
				"36氪 " + 
				"Flipboard " + 
				"锤子科技 " + 
				"融360 " + 
				"穷游网 " + 
				"58同城&赶集 " + 
				"央视网 " + 
				"搜房网 " + 
				"易车网 " + 
				"汽车之家 " + 
				"印象笔记 " + 
				"金山 " + 
				"猎豹移动 " + 
				"滴滴&快的打车 " + 
				"Uber " + 
				"联想 " + 
				"APUS";
		String[] split = s.split(" ");
		for(int i = 0; i < 20; i++) {
			companyService.addCompany(new Company(split[i], new User("0110")));
		}
	}
	
	@Test
	public void up() {
		System.out.println(companyService.deleteCompany(1));
	}
	
	@Test
	public void list() {
		companyService.getCompanyList(2, 5).forEach(System.out::println);
	}
	
	@Test
	public void get() {
		System.out.println(companyService.getCompanyById(1, 10));
	}
	
	@Test
	public void addL() {
		for(int i = 0; i < 20; i++) {
			if(i % 2 == 0)
				companyService.addCompanyLabel(new CompanyLabel("labelName-" + i, "0", new Company(1), new User("0110")));
			else
				companyService.addCompanyLabel(new CompanyLabel("labelName-" + i, "1", new Company(1), new User("0110")));
				
		}
	}
	
	@Test
	public void upL() {
		companyService.deleteCompanyLabel(1);
	}
	
	@Test
	public void listL() {
		companyService.getCompanyLabelList(1, 1, 5).forEach(System.out::println);
	}
	
	@Test
	public void count() {
		System.out.println(companyService.getCompanyCount());
		System.out.println(companyService.getCompanyLabelCount(1));
	}
	
}
