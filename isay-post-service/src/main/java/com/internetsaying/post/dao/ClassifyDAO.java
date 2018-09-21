package com.internetsaying.post.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.internetsaying.post.entity.Classify;

@Repository
public interface ClassifyDAO {

	/**
	 * 添加分类
	 * @param classify
	 * @return
	 */
	int addClassify(Classify classify);
	
	/**
	 * 更新分类
	 * @param classify
	 * @return
	 */
	int updateClassify(Classify classify);
	
	/**
	 * 删除分类
	 * @param classifyId
	 * @return
	 */
	int deleteClassify(@Param("classifyId") int classifyId);
	
	/**
	 * 获取分类列表
	 * @return
	 */
	List<Classify> getClassifies();
	
	/**
	 * 根据id获取分类
	 * @param classifyId
	 * @return
	 */
	Classify getClassifyById(@Param("classifyId") int classifyId);
	
	/**
	 * 根据分类名获得分类ID
	 * @param classifyName
	 * @return
	 */
	int getClassifyIdByName(@Param("classifyName") String classifyName);
}
