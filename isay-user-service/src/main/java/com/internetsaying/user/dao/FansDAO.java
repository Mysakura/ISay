package com.internetsaying.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.internetsaying.user.dto.FansDTO;
import com.internetsaying.user.entity.Fans;

public interface FansDAO {

	/**
	 * 添加粉丝联系
	 * @param fans
	 * @return
	 */
	int addFans(Fans fans);
	
	/**
	 * 获取用户关注的
	 * @param userId
	 * @return
	 */
	List<FansDTO> getFocus(@Param("userId") String userId, @Param("limitStart") int limitStart, @Param("pageSize") int pageSize);
	
	/**
	 * 获取关注用户的
	 * @param userId
	 * @return
	 */
	List<FansDTO> getFans(@Param("userId") String userId, @Param("limitStart") int limitStart, @Param("pageSize") int pageSize);
	
	/**
	 * 关注数量
	 * @param userId
	 * @return
	 */
	int countFocus(@Param("userId") String userId);
	
	/**
	 * 粉丝数量
	 * @param userId
	 * @return
	 */
	int countFans(@Param("userId") String userId);
	
	/**
	 * 查看联系(A-follower,B-master)A是否关注了B
	 * @param userA
	 * @param userB
	 * @return
	 */
	int checkRelation(@Param("userA") String userA, @Param("userB") String userB);
	
	/**
	 * 解除联系(A-follower,B-master)A不再关注B
	 * @param userA
	 * @param userB
	 * @return
	 */
	int deleteRelation(@Param("userA") String userA, @Param("userB") String userB);
}
