package com.internetsaying.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PostUtils {

	/**
	 * 提取markdown中图片
	 * @param s
	 * @return
	 */
	public static String getArticleImage(String s){
		Pattern p = Pattern.compile("!\\[[^!\\[\\]\\(\\)]*\\]\\([^!\\[\\]\\(\\)]*\\)");
		Matcher m = p.matcher(s);
		if(m.find()){
			String temp = m.group().replaceAll("^(!\\[)|\\)$", "");
			String[] ss = temp.split("\\]\\(");
			p = Pattern.compile("\".*\"");
			m = p.matcher(ss[1]);
			String sss = m.replaceAll("").trim();
			return sss;
		}
		return "";
	}
}
