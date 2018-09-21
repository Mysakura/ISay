package com.utils.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.internetsaying.common.base.BasePageResponse;
import com.internetsaying.exception.CommonException;
import com.internetsaying.exception.IsayException;
import com.internetsaying.exception.enums.ExceptionEnum;

public class TestException {

	public void e() {
		throw new CommonException(ExceptionEnum.FRIEND_EXIST.code, ExceptionEnum.FRIEND_EXIST.msg);
	}
	
	@Test
	public void test() {
		try {
			e();
		} catch (Exception e) {
			if(e instanceof CommonException) {
				System.out.println(((CommonException)e).getMessage());
			}
			
			if(e instanceof IsayException) {
				System.out.println(((IsayException)e).getMessage());
			}
			
			if(e instanceof RuntimeException) {
				System.out.println(e.getMessage());
			}
			
		}
	}
	
	@Test
	public void test2() {
		BasePageResponse<Integer> response = new BasePageResponse<>(1, 0);
		System.out.println(response.getPageNo() + "," + response.getPageSize());
	}
	
	@Test
	public void test3() {
		Date time = new Date(1521942967000L);
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(time));
	}
}
