package com.isay.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.internetsaying.post.entity.Classify;
import com.internetsaying.post.service.ClassifyService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-core.xml"})
public class TestClassifyService {

	@Autowired
	private ClassifyService cs;
	
	@Test
	public void add() {
		String s = "advice,readme,resource,question,interview,job";
		for(String i : s.split(",")) {
			cs.addClassify(new Classify(i));
		}
	}
	
	@Test
	public void up() {
		
	}
	
	@Test
	public void del() {
		
	}
	
	@Test
	public void get() {
		cs.getClassifies().forEach(System.out::println);
	}
	
}
