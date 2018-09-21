package com.isay.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.internetsaying.post.entity.Vote;
import com.internetsaying.post.entity.VoteItem;
import com.internetsaying.post.entity.Voter;
import com.internetsaying.post.entity.WorkArea;
import com.internetsaying.post.service.VoteService;
import com.internetsaying.user.entity.User;
import com.internetsaying.utils.IDUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-core.xml"})
public class TestVoteService {

	@Autowired
	private VoteService voteService;
	
	@Test
	public void add() {
		Date voteTime = new Date();
		String voteId = IDUtils.createID20(voteTime);
		String voteContent = "我是真的爱上你 - 王杰\r\n" + 
				"词：汤小康/刘杰胜\r\n" + 
				"曲：汤小康\r\n" + 
				"你有一双会说话的眼睛\r\n" + 
				"你有善解人意的心\r\n" + 
				"不知天高地厚的我\r\n" + 
				"你的微笑总是让我为你着迷\r\n" + 
				"你有一双深情的眼睛\r\n" + 
				"你有融化冰雪的魔力\r\n" + 
				"从来不敢奢求的我\r\n" + 
				"你的美丽总是让我躲不过去\r\n" + 
				"什么原因你的发香 总挥之不去\r\n" + 
				"我的世界 什么时候\r\n" + 
				"开始昼夜难分\r\n" + 
				"翻天覆地来去都是因为想你\r\n" + 
				"喔 偷偷的爱上你\r\n" + 
				"却不敢告诉你\r\n" + 
				"因为我知道我给不到你要的东西\r\n" + 
				"喔 只能偷偷的爱上你\r\n" + 
				"只能偷偷看着你\r\n" + 
				"总是没勇气\r\n" + 
				"总说不出我是真的爱上你\r\n" + 
				"你有一双深情的眼睛 oh\r\n" + 
				"你有融化冰雪的魔力 oh\r\n" + 
				"从来不敢奢求的我\r\n" + 
				"你的美丽总是让我躲不过去\r\n" + 
				"什么原因你的发香 总挥之不去\r\n" + 
				"我的世界 什么时候\r\n" + 
				"开始昼夜难分\r\n" + 
				"翻天覆地来去都是因为想你\r\n" + 
				"喔 偷偷的爱上你\r\n" + 
				"却不敢告诉你\r\n" + 
				"因为我知道我给不到你要的东西\r\n" + 
				"喔 只能偷偷的爱上你\r\n" + 
				"只能偷偷看着你\r\n" + 
				"总是没勇气\r\n" + 
				"总说不出我是真的爱上你\r\n" + 
				"喔 偷偷的爱上你\r\n" + 
				"却不敢告诉你\r\n" + 
				"因为我知道我给不到你要的东西\r\n" + 
				"喔 只能偷偷的爱上你\r\n" + 
				"只能偷偷看着你\r\n" + 
				"总是没勇气\r\n" + 
				"总说不出我是真的爱上你\r\n" + 
				"";
		Vote vote = new Vote(voteContent, voteTime, new User("0110"), 0);
		vote.setVoteId(voteId);
		List<VoteItem> items = new ArrayList<>();
		items.add(new VoteItem("最近一直在听王杰的歌。他最火的那段时间，我没有留下任何回忆的样子奇怪的是，以前你根本听不懂，也不喜欢的歌曲，到了一定的时间节点，有了一定的人生阅历之后，你瞬间就听懂了这些歌曲里面表达的心声歌曲从来都不会过时，但岁月无法常驻而我只相信时过境迁之后真情永驻", 0, new Vote(voteId)));
		items.add(new VoteItem("不知道怎么形容王杰 并不是有多喜欢他 但是他这几首歌（我是真的爱上你 谁明浪子心等）总是可以让人单曲循环 听完一遍迫不及待的再来一遍", 0, new Vote(voteId)));
		items.add(new VoteItem("这个歌杰哥唱的很投入，歌词也很有故事，不愧是，作日的浪子，今天的巨星，明天的传奇", 0, new Vote(voteId)));
		vote.setItems(items);
		voteService.addVote(vote);
	}
	
	@Test
	public void delete() {
		voteService.deleteVote(new Vote("15239372439769694TCW", "1"));
	}
	
	@Test
	public void getVoteList() {
		voteService.getVoteList(1, 10).forEach(e -> {
			System.out.println(e.getUser().getUserId() + "\n" + e.getVoteId() + "\n" + e.getVoteContent() + "\n" + e.getVoteTime());
			e.getItems().forEach(ee -> {
				System.err.println(ee.getItemId() + "," + ee.getItemContent() + "," + ee.getVoteNum());
			});
		});;
	}
	
	@Test
	public void addVoter() {
		voteService.addVoter(new Voter("1111", 1, "15239372439769694TCW"));
		voteService.addVoter(new Voter("1111", 5, "1523945155899PUQJ11M"));
	}
	
	@Test
	public void checkVoter() {
		System.err.println(voteService.checkVoter(new Voter("1111", 0, "15239372439769694TCW")));
	}
}
