package com.internetsaying.post.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.internetsaying.post.dao.PostStatisticsDAO;
import com.internetsaying.post.dto.StatisticsAreaLabel;
import com.internetsaying.post.dto.StatisticsAreaPost;
import com.internetsaying.post.dto.StatisticsMonthPostNum;
import com.internetsaying.post.dto.StatisticsTopPost;
import com.internetsaying.post.dto.StatisticsTopTenPost;
import com.internetsaying.post.dto.StatisticsTopTenUser;
import com.internetsaying.post.dto.StatisticsTopUser;
import com.internetsaying.post.service.PostStatisticsFacade;

@Transactional(rollbackFor=Exception.class)
@Service
public class PostStatisticsFacadeImpl implements PostStatisticsFacade {

	@Autowired
	private PostStatisticsDAO postStatisticsDAO;
	
	@Override
	public StatisticsTopUser getReleaseTopUser() {
		return postStatisticsDAO.getReleaseTopUser();
	}

	@Override
	public StatisticsTopUser getUpTopUser() {
		return postStatisticsDAO.getUpTopUser();
	}

	@Override
	public StatisticsTopUser getDownTopUser() {
		return postStatisticsDAO.getDownTopUser();
	}

	@Override
	public StatisticsTopPost getVisitTopPost() {
		return postStatisticsDAO.getVisitTopPost();
	}

	@Override
	public StatisticsTopPost getCommentTopPost() {
		return postStatisticsDAO.getCommentTopPost();
	}

	@Override
	public StatisticsTopPost getCollectTopPost() {
		return postStatisticsDAO.getCollectTopPost();
	}

	@Override
	public StatisticsTopPost getUpTopPost() {
		return postStatisticsDAO.getUpTopPost();
	}

	@Override
	public StatisticsTopPost getDownTopPost() {
		return postStatisticsDAO.getDownTopPost();
	}

	@Override
	public int getAllPostCount() {
		return postStatisticsDAO.getAllPostCount();
	}

	@Override
	public List<StatisticsAreaPost> getAreaPostStatistics() {
		return postStatisticsDAO.getAreaPostStatistics();
	}

	@Override
	public List<StatisticsAreaLabel> getAreaLabelStatistics() {
		return postStatisticsDAO.getAreaLabelStatistics();
	}

	@Override
	public List<StatisticsMonthPostNum> getMonthPostNumStatistics(String year) {
		return postStatisticsDAO.getMonthPostNumStatistics(year);
	}

	@Override
	public List<StatisticsTopTenUser> getPostUserStatistics() {
		return postStatisticsDAO.getPostUserStatistics();
	}

	@Override
	public List<StatisticsTopTenPost> getPostTenStatistics() {
		return postStatisticsDAO.getPostTenStatistics();
	}

}
