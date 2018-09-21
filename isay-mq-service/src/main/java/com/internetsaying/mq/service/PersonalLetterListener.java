package com.internetsaying.mq.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.internetsaying.exception.CommonException;
import com.internetsaying.exception.enums.ExceptionEnum;
import com.internetsaying.mq.common.SystemMsgVar;
import com.internetsaying.user.entity.PersonalLetterContent;
import com.internetsaying.user.entity.SystemMessage;
import com.internetsaying.user.entity.User;
import com.internetsaying.user.service.SystemMsgService;
import com.internetsaying.utils.IDUtils;

public class PersonalLetterListener implements MessageListener {

	@Autowired
	private SystemMsgService systemMsgService;
	
	
	
	@Override
	public void onMessage(Message message) {
		TextMessage text = (TextMessage) message;
		try {
			PersonalLetterContent letter = JSONObject.parseObject(text.getText(), PersonalLetterContent.class);
			if(letter == null) {
				throw new CommonException(ExceptionEnum.MQ_RECEIVE_NULL.code, ExceptionEnum.MQ_RECEIVE_NULL.msg);
			}
			Date time = letter.getTime();
			String userId = letter.getSender().getUserId();	// 私信者id
			String userName = letter.getSender().getNickname();
			String targetId = letter.getReceiver().getUserId();	// 目标id
			String letterContent = letter.getContent();
			
			String timeStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(time);
			String content = "<a class='sys-user' href='"+ SystemMsgVar.PRE_FIX +"/user/"+ userId +"'>"+ userName +"</a>私信了你<span class='sys-content'>"+ letterContent +"</span><span class='sys-time'>"+ timeStr +"</span>";
			systemMsgService.addSystemMsg(new SystemMessage(IDUtils.createID20(time), new User(targetId), content, time));
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
