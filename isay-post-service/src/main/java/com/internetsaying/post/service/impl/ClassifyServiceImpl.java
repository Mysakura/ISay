package com.internetsaying.post.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.internetsaying.post.dao.ClassifyDAO;
import com.internetsaying.post.entity.Classify;
import com.internetsaying.post.service.ClassifyService;

@Transactional(rollbackFor=Exception.class)
@Service
public class ClassifyServiceImpl implements ClassifyService {

	@Autowired
	private ClassifyDAO classifyDAO;
	
	@Override
	public int addClassify(Classify classify) {
		return classifyDAO.addClassify(classify);
	}

	@Override
	public int updateClassify(Classify classify) {
		return classifyDAO.updateClassify(classify);
	}

	@Override
	public int deleteClassify(int classifyId) {
		return classifyDAO.deleteClassify(classifyId);
	}

	@Override
	public List<Classify> getClassifies() {
		return classifyDAO.getClassifies();
	}

	@Override
	public int getClassifyIdByName(String classifyName) {
		return classifyDAO.getClassifyIdByName(classifyName);
	}

}
