package com.internetsaying.user.service.impl;

import java.util.List;

import javax.jms.Destination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.internetsaying.exception.CommonException;
import com.internetsaying.exception.enums.ExceptionEnum;
import com.internetsaying.user.dao.PersonalLetterDAO;
import com.internetsaying.user.dto.TimeCountDTO;
import com.internetsaying.user.entity.PersonalLetter;
import com.internetsaying.user.entity.PersonalLetterContent;
import com.internetsaying.user.service.PersonalLetterService;

@Transactional(rollbackFor=Exception.class)
@Service
public class PersonalLetterServiceImpl implements PersonalLetterService {

	@Autowired
	private PersonalLetterDAO personalLetterDAO;
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Autowired
	@Qualifier("personalLetterDestination")
	private Destination personalLetterDestination;
	
	private void jmsForUpdate(PersonalLetterContent content) {
		jmsTemplate.send(personalLetterDestination, session -> {
			return session.createTextMessage(JSONObject.toJSONString(content));
		});
	}
	
	@Override
	public int addLetter(PersonalLetter letter, PersonalLetterContent content) {
		String letterId = personalLetterDAO.checkLetter(letter);
		// 没有建立关系，需要先建立关系
		if(letterId == null) {
			int i = personalLetterDAO.addLetter(letter);
			if(i == 0) {
				throw new CommonException(ExceptionEnum.CREATE_RELATIONSHIP_FAILED.code, ExceptionEnum.CREATE_RELATIONSHIP_FAILED.msg);
			}
		}else {
			// 已有关系，不使用创建的ID，而是利用返回的letter_id来完成私信的添加
			content.getLetter().setLetterId(letterId);
		}
		jmsForUpdate(content);
		return personalLetterDAO.addLetterContent(content);
	}

	@Override
	public int addLetter(PersonalLetterContent content) {
		jmsForUpdate(content);
		return personalLetterDAO.addLetterContent(content);
	}

	@Override
	public List<PersonalLetter> getLetterList(String userId, int pageNo, int pageSize) {
		return personalLetterDAO.getLetterList(userId, pageSize*(pageNo-1), pageSize);
	}

	@Override
	public int getUserLetterCount(String userId) {
		return personalLetterDAO.getUserLetterCount(userId);
	}
	
	@Override
	public List<PersonalLetterContent> getLetterContentList(String letterId, String date) {
		return personalLetterDAO.getLetterContentList(letterId, date);
	}

	@Override
	public List<TimeCountDTO> getEveryMonthContentCount(String letterId) {
		// TODO Auto-generated method stub
		return personalLetterDAO.getEveryMonthContentCount(letterId);
	}

	@Override
	public List<TimeCountDTO> getEveryDayContentCount(String letterId, String month) {
		// TODO Auto-generated method stub
		return personalLetterDAO.getEveryDayContentCount(letterId, month);
	}

	
}
