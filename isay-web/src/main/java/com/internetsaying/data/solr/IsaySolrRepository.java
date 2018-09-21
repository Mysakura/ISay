package com.internetsaying.data.solr;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.slf4j.Logger;

import com.internetsaying.web.dto.SolrPostDTO;

/**
 * @author dong
 *
 */
public class IsaySolrRepository {

	public static SolrClient getClient(){
		final String solrUrl = "http://localhost:8983/solr";
		return new HttpSolrClient.Builder(solrUrl)
		    .withConnectionTimeout(1000)
		    .withSocketTimeout(6000)
		    .build();
	}
	
	public static List<SolrPostDTO> queryOfHighlightIsayPost(Logger log, String searchKey) throws SolrServerException, IOException, ParseException{
		final SolrClient client = getClient();
		
		final SolrQuery query = new SolrQuery(searchKey);
		query.setParam("df", "sp_query");
		query.setHighlight(true)
		.setHighlightSimplePre("<b style='color: #df2d4f;'>")
		.setHighlightSimplePost("</b>");
		query.setParam("hl.fl", "sp_title,sp_content");
		query.setParam("fl", "id,sp_id,sp_title,sp_content,sp_cover,sp_time");
		
		final QueryResponse response = client.query("isay_post", query);
		Map<String, SolrPostDTO> hlMap = new HashMap<>();	// 键值对：id-实体
		List<SolrPostDTO> result = new ArrayList<>();
		// 这段代码获取的是不加处理的结构
		SolrDocumentList results = response.getResults();
		log.info("关键字：{}，搜索结果：{}",searchKey, results.getNumFound());
		for (SolrDocument sd : results) {
			Collection<String> names = sd.getFieldNames();
			SolrPostDTO sp = new SolrPostDTO();	// 实体
			String id = "";
			log.info("---------------------------------");
			for (String s : names) {
				Object value = sd.getFieldValue(s);
				log.info("字段名：{}，值：{}",s, value);
				if("id".equals(s)){
					id = value.toString();
				}else if("sp_id".equals(s)){
					sp.setPostId(value.toString());
				}else if("sp_title".equals(s)){
					sp.setPostTitle(value.toString());
				}else if("sp_content".equals(s)){
					sp.setPostContent(value.toString());
				}else if("sp_cover".equals(s)){
					sp.setPostCover(value.toString());
				}else if("sp_time".equals(s)){
					sp.setPostTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse((String) value));
				}
			}
			hlMap.put(id, sp);
		}
		
		// 高亮查询的结果集
		log.info("######################################");
		Map<String, Map<String, List<String>>> highlighting = response.getHighlighting();
		Set<String> set = highlighting.keySet();
		for (String id : set) {
			log.info("id:{}", id);
			Map<String, List<String>> map = highlighting.get(id);	// id对应的查询结果，可能有多个字段，所以是map结构
			Set<String> set2 = map.keySet();	// 字段名集合
			SolrPostDTO sp = hlMap.get(id);
			// 遍历字段
			for (String key2 : set2) {
				List<String> list = map.get(key2);	// 字段对应的值，因为分词了，所以是一个String列表
				StringBuilder sb = new StringBuilder("");
				for (String s : list) {
					sb.append(s + " ");
				}
				String value = sb.toString().trim();
				log.info("高亮字段名：{}，高亮字段对应的值：{}", key2, value);
				if("sp_title".equals(key2)){
					sp.setPostTitle(value);
				}else if("sp_content".equals(key2)){
					sp.setPostContent(value);
				}
			}
			result.add(sp);
		}
		
		return result;
		
	}
	
//	public static void main(String[] args) throws SolrServerException, IOException, ParseException {
//		queryOfHighlightIsayPost("\"区块链\"").forEach(e -> {
//			System.out.println(e);
//		});
//		Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2018-09-21 10:15:28.0");
//		System.out.println(date);
//		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
//	}
}
