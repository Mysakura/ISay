package com.internetsaying.utils;

import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class TimeConverter implements Converter<String, Date> {

	@Override
	public Date convert(String time) {
		if(time != null){
			return new Date(Long.valueOf(time));
		}
		return null;
	}
}