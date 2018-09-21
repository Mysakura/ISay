package com.internetsaying.post.service;

import java.util.List;

import com.internetsaying.exception.CommonException;
import com.internetsaying.post.entity.Vote;
import com.internetsaying.post.entity.VoteItem;
import com.internetsaying.post.entity.Voter;

/**
 * 投票业务(投票创建成功不能修改)
 * @author dong
 *
 */
public interface VoteService {

	/**
	 * 添加投票，vote表和vote_item表
	 * @param vote
	 * @return
	 */
	int addVote(Vote vote) throws CommonException;
	
	/**
	 * 更新投票，有点复杂：可能更新投票说明，更改投票选项（增加，修改，删除都有可能），要根据这些操作来更新后台数据。
	 * @param vote
	 * @return
	 */
	@Deprecated
	int updateVote(Vote vote) throws CommonException;
	
	/**
	 * 删除，更新is_delete字段
	 * @param vote
	 * @return
	 */
	int deleteVote(Vote vote) throws CommonException;
	
	/**
	 * 获得投票列表，也要获取投票选项
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<Vote> getVoteList(int pageNo, int pageSize) throws CommonException;
	
	/**
	 * 获得投票列表，也要获取投票选项。按热度查询
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<Vote> getVoteListOfHot(int pageNo, int pageSize) throws CommonException;
	
	/**
	 * 获得投票数量
	 * @return
	 */
	int getVoteCount() throws CommonException;
	
	/**
	 * 获得投票列表，也要获取投票选项。按照领域来查
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<Vote> getVoteListOfArea(int areaId, int pageNo, int pageSize) throws CommonException;
	
	/**
	 * 获得投票数量。按照领域来查
	 * @return
	 */
	int getVoteCountOfArea(int areaId) throws CommonException;
	
	/**
	 * 更新投票选项
	 * @param item
	 * @return
	 */
	@Deprecated
	int updateVoteItem(VoteItem item) throws CommonException;
	
	/**
	 * 删除投票选项
	 * @param item
	 * @return
	 */
	@Deprecated
	int deleteVoteItem(VoteItem item) throws CommonException;
	
	/**
	 * 添加投票人(每个投票只能投一次，一旦提交不能修改或者删除)
	 * @param voter
	 * @return
	 */
	int addVoter(Voter voter) throws CommonException;
	
	/**
	 * 检查用户是否已经投过票
	 * @param voter
	 * @return
	 */
	int checkVoter(Voter voter) throws CommonException;
	
	
	
}
