package com.internetsaying.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.internetsaying.user.dto.TimeCountDTO;
import com.internetsaying.user.entity.PersonalLetter;
import com.internetsaying.user.entity.PersonalLetterContent;

@Repository
public interface PersonalLetterDAO {

	/**
	 * 检查这两个人是否建立了关系
	 * @param letter
	 * @return 返回值，已建立关系的letter_id
	 */
	String checkLetter(PersonalLetter letter);
	
	/**
	 * 添加私信关联
	 * @param letter
	 * @return
	 */
	int addLetter(PersonalLetter letter);
	
	/**
	 * 添加私信内容
	 * @param content
	 * @return
	 */
	int addLetterContent(PersonalLetterContent content);
	
	/**
	 * 获得用户的私信列表
	 * @param userId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<PersonalLetter> getLetterList(@Param("userId") String userId, @Param("pageNo") int pageNo, @Param("pageSize") int pageSize);

	/**
	 * 获得用户的私信数量
	 * @param userId
	 * @return
	 */
	int getUserLetterCount(@Param("userId") String userId);
	
	/**
	 * 获得A与B某个日期（Year-Month-Day）的全部私信记录
	 * @param letterId
	 * @param date
	 * @return
	 */
	List<PersonalLetterContent> getLetterContentList(@Param("letterId") String letterId, @Param("date") String date);
	
	/**
	 * 获得A与B的私信记录，按照月份（Year-Month）分组
	 * @param letterId
	 * @return
	 */
	List<TimeCountDTO> getEveryMonthContentCount(@Param("letterId") String letterId);
	
	/**
	 * 获取A与B的私信记录，按照日期（Year-Month-Day）分组
	 * @param letterId
	 * @param month	(Year-Month)
	 * @return
	 */
	List<TimeCountDTO> getEveryDayContentCount(@Param("letterId") String letterId, @Param("month") String month);
	
}
