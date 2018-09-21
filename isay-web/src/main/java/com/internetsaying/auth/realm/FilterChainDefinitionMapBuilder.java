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
		// 临时：访问文件配置，以后使用文件系统，这些就可以取消
		map.put("/pay_photo/**", "anon");
		map.put("/post_photo/**", "anon");
		map.put("/sys_photo/**", "anon");
		map.put("/user_photo/**", "anon");
		map.put("/message_photo/**", "anon");
		map.put("/comment_photo/**", "anon");
		
		// 公共路径
		map.put("/announcement/*", "anon");		// 公告
		map.put("/announcement_list", "anon");	// 公告列表
		map.put("/announcement_list/*", "anon");// 公告列表
		map.put("/message_board", "anon");		// 留言板分页
		map.put("/message_board/*", "anon");	// 留言板分页
		map.put("/user/*", "anon");				// 访问他人主页
		map.put("/user/pk/*", "anon");			// 与他人PK
		map.put("/user/focus", "anon");			// 关注
		map.put("/user/cancelFocus", "anon");	// 取关
		map.put("/*", "anon");
		
		// 公共板块
		map.put("/card/statistics", "anon");			// 社区统计
		map.put("/card/advice", "anon");				// 忠告
		map.put("/card/advice/*", "anon");				// 忠告
		map.put("/card/company", "anon");				// 公司
		map.put("/card/company_search", "anon");		// 公司查询
		map.put("/card/interview", "anon");				// 面经
		map.put("/card/interview/*", "anon");			// 面经
		map.put("/card/job", "anon");					// 技能图
		map.put("/card/job/*", "anon");					// 技能图
		map.put("/card/question", "anon");				// 疑问
		map.put("/card/question/*", "anon");			// 疑问
		map.put("/card/readme", "anon");				// 自述
		map.put("/card/readme/*", "anon");				// 自述
		map.put("/card/resource", "anon");				// 资源
		map.put("/card/resource/*", "anon");			// 资源
		map.put("/card/vote", "anon");					// 投票
		map.put("/card/join_vote", "anon");				// 投票
		map.put("/card/vote/*", "anon");				// 投票
		
		map.put("/card/throw_pot", "anon");				// 甩锅
		map.put("/card/throw_pot_chat", "anon");		// 闲聊
		map.put("/card/throw_pot_chat_ajax", "anon");	// 闲聊
		map.put("/card/add_chat", "anon");				// 闲聊
		map.put("/card/del_chat", "anon");				// 闲聊
		map.put("/card/add_chat_reply", "anon");		// 闲聊
		map.put("/card/del_chat_reply", "anon");		// 闲聊
		
		map.put("/card/post_details/*", "anon");		// 帖子详细
		map.put("/card/share_post_details/*", "anon");	// 帖子详细
		map.put("/card/share_content", "anon");			// 获得共享帖子的某一个修改者的修改内容
		map.put("/card/del_post", "anon");				// Ajax-删除帖子
		map.put("/card/collect_post", "anon");			// Ajax-收藏帖子
		map.put("/card/cancel_collect_post", "anon");	// Ajax-取消收藏帖子
		map.put("/card/support_post", "anon");			// Ajax-赞成帖子
		map.put("/card/deny_post", "anon");				// Ajax-反对帖子
		
		map.put("/card/company_ajax", "anon");				// 公司相关
		map.put("/card/company_add", "anon");				// 公司相关
		map.put("/card/company_search_by_name", "anon");	// 公司相关
		map.put("/card/company_search_by_id", "anon");		// 公司相关
		map.put("/card/company_add_label", "anon");			// 公司相关
		
		map.put("/card/stat/**", "anon");		// 社区统计
		
		// 登出,项目中没有/user/logout路径,因为shiro是过滤器,而SpringMVC是Servlet,Shiro会先执行
		map.put("/logout", "logout");
		
		// 通过记住我，可以访问的页面
		//map.put("/user/home", "user");
		
		// 授权
		map.put("/user/**", "authc,roles[user]");
		map.put("/admin/**", "authc,roles[admin]");
		
		// 需要验证的
		map.put("/submit_message", "authc");
		map.put("/submit_message_reply", "authc");
		map.put("/delete_message", "authc");
		map.put("/delete_message_reply", "authc");
		
		// everything else requires authentication:
		map.put("/**", "authc");
		
		
		
		return map;
	}
}
