package com.internetsaying.post.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.internetsaying.post.entity.Vote;
import com.internetsaying.post.entity.VoteItem;
import com.internetsaying.post.entity.Voter;

@Repository
public interface VoteDAO {

	int addVote(Vote vote);
	
	int deleteVote(Vote vote);
	
	
	List<Vote> getVoteList(@Param("pageNo") int pageNo, @Param("pageSize") int pageSize);
	
	/**
	 * 获得投票列表，也要获取投票选项。按热度查询，这里查询不是真正的！详细看SQL
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<Vote> getVoteListOfHot(@Param("pageNo") int pageNo, @Param("pageSize") int pageSize);
	
	/**
	 * 获得投票数量
	 * @return
	 */
	int getVoteCount();
	
	/**
	 * 获得投票列表，也要获取投票选项。按照领域来查
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<Vote> getVoteListOfArea(@Param("areaId") int areaId, @Param("pageNo") int pageNo, @Param("pageSize") int pageSize);
	
	/**
	 * 获得投票数量。按照领域来查
	 * @return
	 */
	int getVoteCountOfArea(@Param("areaId") int areaId);
	
	/**
	 * 批量插入
	 * @param items
	 * @return
	 */
	int addVoteItem(@Param("items") List<VoteItem> items);
	
	
	List<VoteItem> getVoteItems(@Param("voteId") String voteId);
	
	int addVoter(Voter voter);
	
	/**
	 * 检查用户是否已经投过票
	 * @param voter
	 * @return
	 */
	int checkVoter(Voter voter);
	
}
