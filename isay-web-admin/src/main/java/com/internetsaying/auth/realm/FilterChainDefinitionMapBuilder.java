package com.internetsaying.auth.realm;

import java.util.LinkedHashMap;

public class FilterChainDefinitionMapBuilder {

	public LinkedHashMap<String, String> build(){
		LinkedHashMap<String, String> map = new LinkedHashMap<>();
		
		// 静态资源
		map.put("/css/**", "anon");
		map.put("/js/**", "anon");
		map.put("/editormd/**", "anon");
		map.put("/fonts/**", "anon");
		map.put("/images/**", "anon");
		map.put("/sys_photo/**", "anon");
		map.put("/login", "anon");
		map.put("/*", "anon");
		
		// 授权
		map.put("/**", "authc,roles[admin]");
		
		// everything else requires authentication:
		map.put("/**", "authc");
		
		
		
		return map;
	}
}
