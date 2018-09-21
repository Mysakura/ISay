package com.internetsaying.post.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.internetsaying.exception.CommonException;
import com.internetsaying.exception.enums.ExceptionEnum;
import com.internetsaying.post.dao.VoteDAO;
import com.internetsaying.post.entity.Vote;
import com.internetsaying.post.entity.VoteItem;
import com.internetsaying.post.entity.Voter;
import com.internetsaying.post.service.VoteService;
import com.internetsaying.user.entity.User;
import com.internetsaying.user.service.UserService;

@Transactional(rollbackFor=Exception.class)
@Service
public class VoteServiceImpl implements VoteService {

	@Autowired
	private VoteDAO voteDAO;
	
	@Autowired
	private UserService userService;
	
	@Override
	public int addVote(Vote vote) {
		int v1 = voteDAO.addVote(vote);
		int v2 = voteDAO.addVoteItem(vote.getItems());
		if(v1 != 1 || v2 != vote.getItems().size()) {
			throw new CommonException(ExceptionEnum.ADD_VOTE_FAILED.code, ExceptionEnum.ADD_VOTE_FAILED.msg);
		}
		return 1;
	}

	@Override
	public int updateVote(Vote vote) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteVote(Vote vote) {
		return voteDAO.deleteVote(vote);
	}

	/**
	 * 通用处理
	 * @param list
	 * @return
	 */
	private List<Vote> commonDeal(List<Vote> list){
		if(list.isEmpty())
			return list;
		Set<String> ids = new HashSet<>();
		for(Vote v : list) {
			ids.add(v.getUser().getUserId());
		}
		Map<String, User> users = userService.getSpecificUsers(ids);
		for(Vote v : list) {
			v.setUser(users.get(v.getUser().getUserId()));
		}
		return list;
	}
	
	@Override
	public List<Vote> getVoteList(int pageNo, int pageSize) {
		List<Vote> list = voteDAO.getVoteList(pageSize*(pageNo-1), pageSize);
		return commonDeal(list);
	}

	@Override
	public List<Vote> getVoteListOfHot(int pageNo, int pageSize) throws CommonException {
		
		List<Vote> list = voteDAO.getVoteListOfHot(pageSize*(pageNo-1), pageSize);
		return commonDeal(list);
	}
	
	@Override
	public List<Vote> getVoteListOfArea(int areaId, int pageNo, int pageSize) throws CommonException {
		
		List<Vote> list = voteDAO.getVoteListOfArea(areaId, pageSize*(pageNo-1), pageSize);
		return commonDeal(list);
	}
	
	@Override
	public int getVoteCount() throws CommonException {
		
		return voteDAO.getVoteCount();
	}
	
	@Override
	public int getVoteCountOfArea(int areaId) throws CommonException {
		
		return voteDAO.getVoteCountOfArea(areaId);
	}
	
	@Override
	public int updateVoteItem(VoteItem item) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteVoteItem(VoteItem item) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addVoter(Voter voter) {
		return voteDAO.addVoter(voter);
	}

	@Override
	public int checkVoter(Voter voter) {
		return voteDAO.checkVoter(voter);
	}

}
