package com.internetsaying.site.service;

import java.util.List;

import com.internetsaying.exception.CommonException;
import com.internetsaying.post.dto.StatisticsAreaLabel;
import com.internetsaying.post.dto.StatisticsAreaPost;
import com.internetsaying.post.dto.StatisticsMonthPostNum;
import com.internetsaying.site.dto.CommonStatistics;
import com.internetsaying.site.dto.PostStatistics;
import com.internetsaying.site.dto.PostTenStatistics;
import com.internetsaying.site.dto.PostUserStatistics;
import com.internetsaying.site.dto.UserStatistics;

public interface StatisticsService {

	// 获赞最多的，反对最多的，发帖最多的(用户)--柱形图
	// select count(*) c,author_id from post group by author_id order by c desc limit 10;#发帖最多
	// select SUM(up_num) c,author_id from post group by author_id order by c desc limit 10;#获赞最多
	// select SUM(down_num) c,author_id from post group by author_id order by c desc limit 10;#反对最多
	UserStatistics getUserStatistics() throws CommonException;
	
	
	// 浏览最多的，评论最多的，收藏最多的，获赞最多的，反对最多的(帖子)--柱形图
	// select post_id,visit_num 浏览量 from post order by visit_num desc limit 10;
	// select post_id,comment_num 评论量 from post order by comment_num desc limit 10;
	// select post_id,collection_num 收藏量 from post order by collection_num desc limit 10;
	// select post_id,up_num 赞成量 from post order by up_num desc limit 10;
	// select post_id,down_num 反对量 from post order by down_num desc limit 10;
	PostStatistics getPostStatistics() throws CommonException;
	
	// 总用户数,总帖子数,评论数,留言数,闲聊数--雷达图
	CommonStatistics getCommonStatistics() throws CommonException;
	
	// 不同area里面的帖子数（甜甜圈图）
	// select p.area_id,a.area_name 领域,count(*) 数量 from post p left join work_area a on p.area_id = a.area_id group by area_id;
	List<StatisticsAreaPost> getAreaPostStatistics() throws CommonException;
	
	// 每个领域的标签数（饼图）
	// select a.area_id,a.area_name,count(*) 标签数 from work_area a left join area_label l on a.area_id = l.area_id GROUP BY l.area_id;
	List<StatisticsAreaLabel> getAreaLabelStatistics() throws CommonException;
	
	// 每月的帖子数(折线图)
	// select isay_time,count(p.post_id) from isay_time_list left join post p on DATE_FORMAT(p.post_time,'%Y-%m') = isay_time where SUBSTR(isay_time,1,4) = '2019' group by isay_time;
	List<StatisticsMonthPostNum> getMonthPostNumStatistics(String year) throws CommonException;
	
	// 根据发帖量选出前10名用户，在查出10名用户的赞成数，反对数，以及浏览量（气泡图）
	// select count(*) c,author_id,sum(up_num),sum(down_num),sum(visit_num) from post group by author_id order by c desc limit 5;
	List<PostUserStatistics> getPostUserStatistics() throws CommonException;
	
	// 根据赞成数选出前十名文章，并获取浏览量与评论数（散点图）
	// select visit_num 浏览量,comment_num 评论数,up_num 赞成量,post_id,post_title from post order by up_num desc limit 10;
	List<PostTenStatistics> getPostTenStatistics() throws CommonException;
	
	// 把DTO分配到各个服务中去！！防止出现循环依赖
}
