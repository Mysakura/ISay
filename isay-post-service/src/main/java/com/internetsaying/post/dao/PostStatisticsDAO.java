package com.internetsaying.post.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.internetsaying.post.dto.StatisticsAreaLabel;
import com.internetsaying.post.dto.StatisticsAreaPost;
import com.internetsaying.post.dto.StatisticsMonthPostNum;
import com.internetsaying.post.dto.StatisticsTopPost;
import com.internetsaying.post.dto.StatisticsTopTenPost;
import com.internetsaying.post.dto.StatisticsTopTenUser;
import com.internetsaying.post.dto.StatisticsTopUser;

public interface PostStatisticsDAO {

	// select count(*) c,author_id from post group by author_id order by c desc limit 1;#发帖最多
	// select SUM(up_num) c,author_id from post group by author_id order by c desc limit 1;#获赞最多
	// select SUM(down_num) c,author_id from post group by author_id order by c desc limit 1;#反对最多
	StatisticsTopUser getReleaseTopUser();
	StatisticsTopUser getUpTopUser();
	StatisticsTopUser getDownTopUser();
	
	// select post_id,visit_num 浏览量 from post order by visit_num desc limit 1;
	// select post_id,comment_num 评论量 from post order by comment_num desc limit 1;
	// select post_id,collection_num 收藏量 from post order by collection_num desc limit 1;
	// select post_id,up_num 赞成量 from post order by up_num desc limit 1;
	// select post_id,down_num 反对量 from post order by down_num desc limit 1;
	StatisticsTopPost getVisitTopPost();
	StatisticsTopPost getCommentTopPost();
	StatisticsTopPost getCollectTopPost();
	StatisticsTopPost getUpTopPost();
	StatisticsTopPost getDownTopPost();
	
	/**
	 * 总帖子数
	 * @return
	 */
	int getAllPostCount();
	
	/**
	 * 直接为最终数据
	 * select p.area_id,a.area_name 领域,count(*) 数量 from post p left join work_area a on p.area_id = a.area_id group by area_id;
	 * @return
	 */
	List<StatisticsAreaPost> getAreaPostStatistics();
	
	/**
	 * 直接为最终数据
	 * select a.area_id,a.area_name,count(*) 标签数 from work_area a left join area_label l on a.area_id = l.area_id GROUP BY l.area_id;
	 * @return
	 */
	List<StatisticsAreaLabel> getAreaLabelStatistics();
	
	/**
	 * 直接为最终数据
	 * select isay_time,count(p.post_id) from isay_time_list left join post p on DATE_FORMAT(p.post_time,'%Y-%m') = isay_time where SUBSTR(isay_time,1,4) = '2019' group by isay_time;
	 * @param year
	 * @return
	 */
	List<StatisticsMonthPostNum> getMonthPostNumStatistics(@Param("year") String year);
	
	List<StatisticsTopTenUser> getPostUserStatistics();
	
	List<StatisticsTopTenPost> getPostTenStatistics();
}
