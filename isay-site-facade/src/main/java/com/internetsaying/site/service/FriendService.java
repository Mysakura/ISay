package com.internetsaying.site.service;

import java.util.List;

import com.internetsaying.exception.CommonException;
import com.internetsaying.site.entity.FriendLink;

public interface FriendService {

	/**
	 * 申请友链(首先判断是否已经申请过)
	 * @param link
	 * @return 1-成功，0-失败，-1-已存在
	 */
	int addFriend(FriendLink link) throws CommonException;
	
	/**
	 * 通过审核{0-未处理；1-不通过；2-通过}
	 * @param flId
	 * @param userId
	 * @return
	 */
	int acceptFriend(String flId, String userId) throws CommonException;
	
	/**
	 * 拒绝
	 * @param flId
	 * @param userId
	 * @return
	 */
	int denyFriend(String flId, String userId) throws CommonException;
	
	/**
	 * 删除友链
	 * @param flId
	 * @return
	 */
	int deleteFriend(String flId) throws CommonException;
	
	/**
	 * 获取友链列表，分页
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<FriendLink> getFriendLinkList(int pageNo, int pageSize) throws CommonException;
	
	/**
	 * 获取未处理友链列表，分页
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<FriendLink> getFriendLinkListOfNotDeal(int pageNo, int pageSize) throws CommonException;
	
	/**
	 * 获取通过友链列表，分页
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<FriendLink> getFriendLinkListOfAccept(int pageNo, int pageSize) throws CommonException;
	
	/**
	 * 获取未通过友链列表，分页
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<FriendLink> getFriendLinkListOfDeny(int pageNo, int pageSize) throws CommonException;
	
	/**
	 * 获得友链数量
	 * @return
	 */
	int getFriendLinkCount() throws CommonException;
	
	/**
	 * 获得对应类型的友链数量
	 * @param flOk
	 * @return
	 */
	int getFriendLinkCountOfType(String flOk) throws CommonException;
}
