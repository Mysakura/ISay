package com.internetsaying.user.service;

import java.util.List;

import com.internetsaying.exception.CommonException;
import com.internetsaying.user.dto.TimeCountDTO;
import com.internetsaying.user.entity.PersonalLetter;
import com.internetsaying.user.entity.PersonalLetterContent;

public interface PersonalLetterService {

	/**
	 * 添加私信。【不知道两人是否私信过的情况】
	 * 先判断这两个人的私信关系是否建立，去PersonalLetter数据库查询是否有这两个人的记录。
	 * 如果建立（获取letter_id），则向PersonalLetterContent数据库添加一条记录，同时（利用触发器或利用DAO更新PersonalLetter数据库的letter_id记录的最后时间）
	 * 如果没建立，先添加PersonalLetter数据库，再添加PersonalLetterContent数据库
	 * @param letter
	 * @param content
	 * @return
	 */
	int addLetter(PersonalLetter letter, PersonalLetterContent content) throws CommonException;
	
	/**
	 * 已知两人私信过，直接添加并且更新即可
	 * @param content
	 * @return
	 */
	int addLetter(PersonalLetterContent content) throws CommonException;
	
	/**
	 * 获取某人的私信列表
	 * @param userId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<PersonalLetter> getLetterList(String userId, int pageNo, int pageSize) throws CommonException;
	
	/**
	 * 获得用户私信数目
	 * @param userId
	 * @return
	 */
	int getUserLetterCount(String userId) throws CommonException;
	
	/**
	 * 根据日期获取私信列表
	 * @param letterId
	 * @param date (Year-Month-Day)
	 * @return
	 */
	List<PersonalLetterContent> getLetterContentList(String letterId, String date) throws CommonException;
	
	/**
	 * 获得A与B的私信记录，按照月份（Year-Month）分组
	 * @param letterId
	 * @return
	 */
	List<TimeCountDTO> getEveryMonthContentCount(String letterId) throws CommonException;
	
	/**
	 * 获取A与B的私信记录，按照日期（Year-Month-Day）分组
	 * @param letterId
	 * @param month	(Year-Month)
	 * @return
	 */
	List<TimeCountDTO> getEveryDayContentCount(String letterId, String month) throws CommonException;
	
}
