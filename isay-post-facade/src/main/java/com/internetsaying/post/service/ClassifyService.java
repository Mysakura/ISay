package com.internetsaying.post.service;

import java.util.List;

import com.internetsaying.exception.CommonException;
import com.internetsaying.post.entity.Classify;

/**
 * 帖子分类（导航）
 * @author dong
 *
 */
public interface ClassifyService {

	/**
	 * 添加分类
	 * @param classify
	 * @return
	 */
	int addClassify(Classify classify) throws CommonException;
	
	/**
	 * 更新分类
	 * @param classify
	 * @return
	 */
	int updateClassify(Classify classify) throws CommonException;
	
	/**
	 * 删除分类
	 * @param classifyId
	 * @return
	 */
	int deleteClassify(int classifyId) throws CommonException;
	
	/**
	 * 获取分类列表
	 * @return
	 */
	List<Classify> getClassifies() throws CommonException;
	
	/**
	 * 根据分类名获得分类ID
	 * @param classifyName
	 * @return
	 */
	int getClassifyIdByName(String classifyName);
	
}
