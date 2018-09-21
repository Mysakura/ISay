package com.isay.test;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.internetsaying.post.entity.Post;
import com.internetsaying.post.entity.PostComment;
import com.internetsaying.post.entity.PostReply;
import com.internetsaying.post.service.PostCommentService;
import com.internetsaying.user.entity.User;
import com.internetsaying.utils.IDUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-core.xml"})
public class TestPostCommentService {

	@Autowired
	private PostCommentService pc;
	
	@Test
	public void addC() {
		Date time = new Date();
		pc.addPostComment(new PostComment(IDUtils.createID20(time), "你流连过的篇章永不凋谢", time, new User("0010"), new Post("15219428645587F69LA7")));
	}
	
	@Test
	public void delC() {
		pc.deletePostComment(new PostComment("15223161680749I198TV","1", new Post("15219428645587F69LA7")));
	}
	
	@Test
	public void listC() {
		pc.getPostCommentList("15219428645587F69LA7", 1, 10).forEach(e -> System.out.println(e));
	}
	
	@Test
	public void addR() {
		Date time = new Date();
		pc.addPostReply(new PostReply(IDUtils.createID20(time), "你就是我追随不落的日月", time, new User("0010"), new User("0012"), new PostComment("15223161680749I198TV")));
	}
	
	@Test
	public void delR() {
		pc.deletePostReply(new PostReply("1522682613986IW4VPYF","1", new PostComment("15223161680749I198TV")));
	}
	
	@Test
	public void listR() {
		pc.getCommentReplyList("15223161680749I198TV", 1, 10).forEach(e -> System.out.println(e));
	}
	
	@Test
	public void count() {
		System.out.println(pc.getAllCommentCount());
		System.out.println(pc.getCommentCount("15219428645587F69LA7"));
		System.out.println(pc.getReplyCount("15223161680749I198TV"));
	}
	
	
}
