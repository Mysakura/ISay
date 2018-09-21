package com.isay.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.internetsaying.user.dto.TimeCountDTO;
import com.internetsaying.user.entity.PersonalLetter;
import com.internetsaying.user.entity.PersonalLetterContent;
import com.internetsaying.user.entity.User;
import com.internetsaying.user.service.PersonalLetterService;
import com.internetsaying.utils.IDUtils;

@RunWith(value=SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-core.xml"})
public class TestPersonalLetterService {

	@Autowired
	private PersonalLetterService letterService;
	
	@Test
	public void addL() {
		String letterId = IDUtils.createID20(new Date());
		PersonalLetter letter = new PersonalLetter(letterId, new User("0110"), new User("0112"), new Date());
		PersonalLetterContent content = new PersonalLetterContent(new PersonalLetter(letterId), new User("0110"), new User("0112"),
				"Content:0110->0112，咱俩已经建立关系，但是我不知道", new Date());
		int i = letterService.addLetter(letter, content);
		System.out.println(i);
	}
	
	@Test
	public void addC() {
		String letterId = "15172256740948H3JAL6";
		for(int i = 0; i < 10; i++) {
			PersonalLetterContent content = null;
			if(i % 2 == 0) {
				// 0发送2
				content = new PersonalLetterContent(new PersonalLetter(letterId), new User("0110"), new User("0112"),
						"Content:0110->0112【" + i + "】", new Date());
			}else {
				// 2发送0
				content = new PersonalLetterContent(new PersonalLetter(letterId), new User("0112"), new User("0110"),
						"Content:0112->0110【" + i + "】", new Date());
			}
			System.out.println(letterService.addLetter(content));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Test
	public void getLetterList() {
		List<PersonalLetter> list = letterService.getLetterList("0110", 1, 5);
		for (PersonalLetter letter : list) {
			System.out.println(letter);
		}
	}
	
	@Test
	public void getUserLetterCount() {
		System.out.println(letterService.getUserLetterCount("0110"));
	}
	
	@Test
	public void getLetterContentList() {
		String letterId = "15172256740948H3JAL6";
		String date = "2018-01-29";
		List<PersonalLetterContent> list = letterService.getLetterContentList(letterId, date);
		for (PersonalLetterContent c : list) {
			System.out.println(c);
		}
	}
	
	@Test
	public void getEveryMonthContentCount() {
		String letterId = "15172256740948H3JAL6";
		List<TimeCountDTO> list = letterService.getEveryMonthContentCount(letterId);
		for (TimeCountDTO tc : list) {
			System.out.println(tc);
		}
	}
	
	@Test
	public void getEveryDayContentCount() {
		String letterId = "15172256740948H3JAL6";
		String month = "2018-01";
		List<TimeCountDTO> list = letterService.getEveryDayContentCount(letterId, month);
		for (TimeCountDTO tc : list) {
			System.out.println(tc);
		}
	}
//	mysql> select DATE_FORMAT(time,'%Y-%m') t,count(*) c from personal_letter_content where letter_id = '15172256740948H3JAL6' group by DATE_FORMAT(time,'%Y-%m');
//	+---------+----+
//	| t       | c  |
//	+---------+----+
//	| 2017-12 |  1 |
//	| 2018-01 | 20 |
//	| 2018-02 |  1 |
//	+---------+----+
//	3 rows in set
//
//	mysql> select DATE_FORMAT(time,'%Y-%m-%d') t,count(*) c from personal_letter_content where letter_id = '15172256740948H3JAL6' and DATE_FORMAT(time,'%Y-%m') = '2018-01' group by DATE_FORMAT(time,'%Y-%m-%d');
//	+------------+----+
//	| t          | c  |
//	+------------+----+
//	| 2018-01-29 | 10 |
//	| 2018-01-30 |  3 |
//	| 2018-01-31 |  7 |
//	+------------+----+
//	3 rows in set
}
