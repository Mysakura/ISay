package com.isay.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.internetsaying.site.entity.TimeLine;
import com.internetsaying.site.service.TimeLineService;
import com.internetsaying.user.entity.User;
import com.internetsaying.utils.IDUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-core.xml"})
public class TestTimeLineService {

	@Autowired
	private TimeLineService timeLineService;
	
	@Test
	public void testAdd() {
		for(int i = 0; i < 10; i++) {
			timeLineService.addTimeLine(new TimeLine(IDUtils.createID20(new Date()), "Content-" + i, new Date(), new User("0110")));
		}
	}
	
	@Test
	public void testUpdate() {
		TimeLine line = new TimeLine("1517121193453QPJ8ELQ", "2018-02-15准时收工！！！", new User("8888"));
		timeLineService.updateTimeLine(line);
	}
	
	@Test
	public void testDelete() {
		
	}
	
	@Test
	public void testList() {
		List<TimeLine> list = timeLineService.getTimeLineList();
		for (TimeLine timeLine : list) {
			System.out.println(timeLine);
		}
	}
	
}
