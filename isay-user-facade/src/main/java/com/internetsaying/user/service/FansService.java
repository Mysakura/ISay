package com.internetsaying.user.service;

import java.util.List;

import com.internetsaying.user.dto.FansDTO;
import com.internetsaying.user.entity.Fans;

public interface FansService {

	/**
	 * 添加粉丝联系
	 * @param fans
	 * @return
	 */
	int addFans(Fans fans);
	
	/**
	 * 删除粉丝联系
	 * @param fans
	 * @return
	 */
	int delFans(Fans fans);
	
	/**
	 * 获取用户关注的
	 * @param userId
	 * @return
	 */
	List<FansDTO> getFocus(String userId, int pageNo, int pageSize);
	
	/**
	 * 获取关注用户的
	 * @param userId
	 * @return
	 */
	List<FansDTO> getFans(String userId, int pageNo, int pageSize);
	
	/**
	 * 关注数量
	 * @param userId
	 * @return
	 */
	int countFocus(String userId);
	
	/**
	 * 粉丝数量
	 * @param userId
	 * @return
	 */
	int countFans(String userId);
	
	/**
	 * 查看联系
	 * @param userA
	 * @param userB
	 * @return
	 */
	int checkRelation(String userA, String userB);
	
}
