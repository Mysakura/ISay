package com.internetsaying.site.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.internetsaying.post.dto.StatisticsAreaLabel;
import com.internetsaying.post.dto.StatisticsAreaPost;
import com.internetsaying.post.dto.StatisticsMonthPostNum;
import com.internetsaying.post.dto.StatisticsTopPost;
import com.internetsaying.post.dto.StatisticsTopTenPost;
import com.internetsaying.post.dto.StatisticsTopTenUser;
import com.internetsaying.post.dto.StatisticsTopUser;
import com.internetsaying.post.entity.Post;
import com.internetsaying.post.service.PostStatisticsFacade;
import com.internetsaying.site.dto.CommonStatistics;
import com.internetsaying.site.dto.PostStatistics;
import com.internetsaying.site.dto.PostTenStatistics;
import com.internetsaying.site.dto.PostUserStatistics;
import com.internetsaying.site.dto.UserStatistics;
import com.internetsaying.site.service.MessageBoardService;
import com.internetsaying.site.service.StatisticsService;
import com.internetsaying.user.entity.User;
import com.internetsaying.user.service.UserService;

@Transactional(rollbackFor=Exception.class)
@Service
public class StatisticsServiceImpl implements StatisticsService {

	@Autowired
	private PostStatisticsFacade postStatisticsFacade;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MessageBoardService messageBoardService;
	
	@Override
	public UserStatistics getUserStatistics() {
		StatisticsTopUser releaseTopUser = postStatisticsFacade.getReleaseTopUser();
		StatisticsTopUser upTopUser = postStatisticsFacade.getUpTopUser();
		StatisticsTopUser downTopUser = postStatisticsFacade.getDownTopUser();
		Set<String> ids = new HashSet<>();
		ids.add(releaseTopUser.getUserId());
		ids.add(upTopUser.getUserId());
		ids.add(downTopUser.getUserId());
		Map<String, User> users = userService.getSpecificUsers(ids);
		return new UserStatistics(releaseTopUser.getNum(), users.get(releaseTopUser.getUserId()), 
				upTopUser.getNum(), users.get(upTopUser.getUserId()),
				downTopUser.getNum(), users.get(downTopUser.getUserId()));
	}

	@Override
	public PostStatistics getPostStatistics() {
		StatisticsTopPost visitTopPost = postStatisticsFacade.getVisitTopPost();
		StatisticsTopPost commentTopPost = postStatisticsFacade.getCommentTopPost();
		StatisticsTopPost collectTopPost = postStatisticsFacade.getCollectTopPost();
		StatisticsTopPost upTopPost = postStatisticsFacade.getUpTopPost();
		StatisticsTopPost downTopPost = postStatisticsFacade.getDownTopPost();
		return new PostStatistics(visitTopPost.getNum(), new Post(visitTopPost.getPostId(),visitTopPost.getPostTitle()), 
				commentTopPost.getNum(), new Post(commentTopPost.getPostId(),commentTopPost.getPostTitle()), 
				collectTopPost.getNum(), new Post(collectTopPost.getPostId(),collectTopPost.getPostTitle()), 
				upTopPost.getNum(), new Post(upTopPost.getPostId(),upTopPost.getPostTitle()), 
				downTopPost.getNum(), new Post(downTopPost.getPostId(),downTopPost.getPostTitle()));
	}

	@Override
	public CommonStatistics getCommonStatistics() {
		int userNum = userService.getUserCount();
		int postNum = postStatisticsFacade.getAllPostCount();
		int massageNum = messageBoardService.getMessageCount();
		// 其他两个到Controller再查
		return new CommonStatistics(userNum, postNum, null, massageNum, null);
	}

	@Override
	public List<StatisticsAreaPost> getAreaPostStatistics() {
		return postStatisticsFacade.getAreaPostStatistics();
	}

	@Override
	public List<StatisticsAreaLabel> getAreaLabelStatistics() {
		return postStatisticsFacade.getAreaLabelStatistics();
	}

	@Override
	public List<StatisticsMonthPostNum> getMonthPostNumStatistics(String year) {
		return postStatisticsFacade.getMonthPostNumStatistics(year);
	}

	@Override
	public List<PostUserStatistics> getPostUserStatistics() {
		List<PostUserStatistics> list = new ArrayList<>();
		List<StatisticsTopTenUser> statistics = postStatisticsFacade.getPostUserStatistics();
		Set<String> ids = new HashSet<>();
		for (StatisticsTopTenUser s : statistics) {
			ids.add(s.getUserId());
		}
		Map<String, User> users = userService.getSpecificUsers(ids);
		for (StatisticsTopTenUser s : statistics) {
			list.add(new PostUserStatistics(users.get(s.getUserId()), s.getUpNum(), s.getDownNum(), s.getVisitNum()));
		}
		
		return list;
	}

	@Override
	public List<PostTenStatistics> getPostTenStatistics() {
		List<PostTenStatistics> list = new ArrayList<>();
		List<StatisticsTopTenPost> statistics = postStatisticsFacade.getPostTenStatistics();
		for (StatisticsTopTenPost s : statistics) {
			list.add(new PostTenStatistics(new Post(s.getPostId(), s.getPostTitle()), s.getVisitNum(), s.getCommentNum()));
		}
		
		return list;
	}

}
