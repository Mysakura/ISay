package com.isay.test;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.connection.RedisZSetCommands.Limit;
import org.springframework.data.redis.connection.RedisZSetCommands.Range;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.internetsaying.post.dao.PostDAO;
import com.internetsaying.post.entity.AreaLabel;
import com.internetsaying.post.entity.Classify;
import com.internetsaying.post.entity.Post;
import com.internetsaying.post.entity.WorkArea;
import com.internetsaying.post.service.PostService;
import com.internetsaying.user.entity.User;
import com.internetsaying.utils.IDUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-core.xml"})
public class TestPostService {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	private static final String POST_ZSET = "zset:post";
	
	@Autowired
	@Qualifier("postService")
	private PostService ps;
	
	@Autowired
	private PostDAO psDAO;
	
	@Test
	public void setOperate() {
		Set<Integer> result = new HashSet<>();
		Set<Integer> a = new HashSet<>();
		Set<Integer> b = new HashSet<>();
		
		a.add(1);
		a.add(8);
		a.add(6);
		a.add(4);
		a.add(7);
		
		b.add(1);
		b.add(12);
		b.add(5);
		b.add(7);
		
		result.addAll(a);
		result.retainAll(b);
		System.out.println(result);	// [1, 7]
		result.clear();
		
		result.addAll(a);
		result.removeAll(b);
		System.out.println(result);	// [4, 6, 8]
		result.clear();
		
		result.addAll(b);
		result.removeAll(a);
		System.out.println(result);	// [5, 12]
		result.clear();
		
		result.addAll(b);
		result.addAll(a);
		System.out.println(result);	// [1, 4, 5, 6, 7, 8, 12]
		result.clear();
		
		
		
	}
	
	@Test
	public void zSetOps() throws InterruptedException {
		//redisTemplate.boundZSetOps(POST_ZSET).remove("1002");	//删除
		
//		for(int i = 2; i < 10; i++) {
//			redisTemplate.boundZSetOps(POST_ZSET).add("100"+i, new Date().getTime());
//			Thread.sleep(1000);
//		}
		
		//redisTemplate.boundZSetOps(POST_ZSET).range(0, -1).forEach(System.out::println);	// 分数从小到大,递增
		//redisTemplate.boundZSetOps(POST_ZSET).reverseRange(0, -1).forEach(System.out::println);	// 分数从大到小,递减
		
		//redisTemplate.boundZSetOps(POST_ZSET).rangeWithScores(0, -1).forEach(System.out::println);	// 
		
		// 分页
//		int pn = 2;
//		int ps = 5;
//		redisTemplate.boundZSetOps(POST_ZSET).rangeByLex(Range.range(), Limit.limit().count(ps).offset(ps*(pn-1)))
//		.forEach(System.out::println);
		
		//System.out.println(redisTemplate.boundZSetOps(POST_ZSET).zCard());
		
		// 分页2
		//int pn = 1;
		//int ps = 5;
		//redisTemplate.boundZSetOps(POST_ZSET).range(ps*(pn-1), ps*pn-1).forEach(System.out::println);	// 分数从小到大,递增
		//redisTemplate.boundZSetOps(POST_ZSET).reverseRange(ps*(pn-1), ps*pn-1).forEach(System.out::println);	// 分数从大到小,递减
		
		// 获得本页对应的id集合，去Hash中查找详细信息（存在的返回，不存在的返回空）全部Set-已得到的Set=缓存中没有的
//		Set<Object> set = new HashSet<>();
//		set.add("0111");
//		set.add("2");
//		List<Object> list = redisTemplate.boundHashOps("users").multiGet(set);
//		list.forEach(obj -> System.out.println((User)obj));
		
		System.out.println(redisTemplate.boundZSetOps(POST_ZSET).size());
	}
	
	@Test
	public void add() throws InterruptedException {
//		Date time = new Date();
//		Post post = new Post(IDUtils.createID20(time), "postTitle", "postShortCut", "postContent", "postMarkdown",
//				"postCover", time, new User("0110"), new Classify(7), new WorkArea(8), new User("0110"), time);
//		Set<AreaLabel> labels = new HashSet<>();
//		labels.add(new AreaLabel(21));
//		labels.add(new AreaLabel(29));
//		post.setLabels(labels);
//		ps.addPost(post);
		
		for(int i = 7; i < 13; i++) {
			for(int j = 1; j < 8; j++) {
				for(int m = 0; m < 3; m++) {
					Date time = new Date();
					psDAO.addPost(new Post(IDUtils.createID20(time), "postTitle-" + i, "postShortCut", "postContent", "postMarkdown",
							"postCover", time, new User("15248859107335YA2M37"), new Classify(i), new WorkArea(j), new User("15248859107335YA2M37"), time));
					Thread.sleep(1000);
				}
			}
		}
	}
	
	@Test
	public void update() {
		Date time = new Date();
		Post post = new Post("", "postTitle-modify", "postShortCut-modify", "postContent-modify", "postMarkdown-modify",
				"postCover-modify", time);
		// 老标签
		Set<AreaLabel> labels = new HashSet<>();
		labels.add(new AreaLabel(1));
		labels.add(new AreaLabel(9));
		post.setLabels(labels);
		// 新标签
		Set<AreaLabel> set = new HashSet<>();
		labels.add(new AreaLabel(5));
		labels.add(new AreaLabel(6));
		ps.updatePost(post, set);
	}
	
	@Test
	public void getOne() {
		Post post = ps.getPostById("1521942956327LIU5ZRG");
		System.out.println(post);
	}
	
	@Test
	public void hashDel() {
		redisTemplate.boundHashOps("posts").delete("15219428645587F69LA7");
	}
	
	@Test
	public void specificGet() {
		Set<Object> ids = new HashSet<>();
		ids.add("15219428645587F69LA7");
		ids.add("1521942956327LIU5ZRG");
		psDAO.getPostOfSpecific(ids).forEach(p ->{
			System.out.println(p);
		});
	}
	
	@Test
	public void getALL() {
		ps.getAllPost(1, 5).forEach(p -> System.out.println(p));;
	}
	
	@Test
	public void visit() {
		
	}
	
	@Test
	public void up() {
		
	}
	
	@Test
	public void down() {
		
	}
	
	@Test
	public void collection() {
		
	}
	
	
}
