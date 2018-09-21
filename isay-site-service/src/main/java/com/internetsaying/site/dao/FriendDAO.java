package com.internetsaying.site.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.internetsaying.site.entity.FriendLink;

@Repository
public interface FriendDAO {

	/**
	 * 添加友链
	 * @param link
	 * @return
	 */
	int addFriend(FriendLink link);
	
	/**
	 * 检查是否存在
	 * @param link
	 * @return
	 */
	int checkExist(FriendLink link);
	
	/**
	 * 更新友链
	 * @param link
	 * @return
	 */
	int updateFriend(FriendLink link);
	
	/**
	 * 删除友链
	 * @param flId
	 * @return
	 */
	int deleteFriend(@Param("flId") String flId);
	
	/**
	 * 获取友链列表，分页
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<FriendLink> getFriendLinkList(@Param("pageNo") int pageNo, @Param("pageSize") int pageSize);
	
	/**
	 * 根据类型获取友链列表，分页
	 * @param flOk
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<FriendLink> getFriendLinkListOfType(@Param("flOk") String flOk, @Param("pageNo") int pageNo, @Param("pageSize") int pageSize);
	
	/**
	 * 获得友链数量
	 * @return
	 */
	int getFriendLinkCount();
	
	/**
	 * 获得对应类型的友链数量
	 * @param flOk
	 * @return
	 */
	int getFriendLinkCountOfType(@Param("flOk") String flOk);
	
}
