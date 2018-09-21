package com.internetsaying.post.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.internetsaying.common.enums.DeleteStatus;
import com.internetsaying.exception.CommonException;
import com.internetsaying.post.dao.CompanyDAO;
import com.internetsaying.post.entity.Company;
import com.internetsaying.post.entity.CompanyLabel;
import com.internetsaying.post.service.CompanyService;
import com.internetsaying.user.entity.User;
import com.internetsaying.user.service.UserService;

@Transactional(rollbackFor=Exception.class)
@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyDAO companyDAO;
	
	@Autowired
	private UserService userService;
	
	@Override
	public int addCompany(Company company) {
		return companyDAO.addCompany(company);
	}

	@Override
	public int deleteCompany(int companyId) {
		return companyDAO.updateCompany(new Company(companyId, DeleteStatus.ALR_DEL.code));
	}

	@Override
	public List<Company> getCompanyList(int pageNo, int pageSize) {
		return companyDAO.getCompanyList((pageNo-1)*pageSize, pageSize);
	}

	@Override
	public Company getCompanyById(int companyId, int pageSize) {
		Company company = companyDAO.getCompanyById(companyId);
		List<CompanyLabel> labelList = companyDAO.getCompanyLabelList(companyId, 0, pageSize);
		Set<String> ids = new HashSet<>();
		// 获得涉及到的用户名
		if(!labelList.isEmpty()) {
			for(CompanyLabel c : labelList) {
				ids.add(c.getUser().getUserId());
			}
			Map<String, User> map = userService.getSpecificUsers(ids);
			for(CompanyLabel c : labelList) {
				c.setUser(map.get(c.getUser().getUserId()));
			}
		}
		company.setLabels(labelList);
		return company;
	}

	@Override
	public int addCompanyLabel(CompanyLabel label) {
		return companyDAO.addCompanyLabel(label);
	}

	@Override
	public int deleteCompanyLabel(int labelId) {
		return companyDAO.updateCompanyLabel(new CompanyLabel(labelId, DeleteStatus.ALR_DEL.code));
	}

	@Override
	public List<CompanyLabel> getCompanyLabelList(int companyId, int pageNo, int pageSize) {
		// 获得涉及到的用户名
		return companyDAO.getCompanyLabelList(companyId, (pageNo-1)*pageSize, pageSize);
	}

	@Override
	public int getCompanyCount() {
		return companyDAO.getCompanyCount();
	}

	@Override
	public int getCompanyLabelCount(int companyId) {
		return companyDAO.getCompanyLabelCount(companyId);
	}

	@Override
	public Company getCompanyByName(String name, int pageSize) throws CommonException {
		Company company = companyDAO.getCompanyByName(name);
		if(company == null)
			return company;
		List<CompanyLabel> labelList = companyDAO.getCompanyLabelList(company.getCompanyId(), 0, pageSize);
		Set<String> ids = new HashSet<>();
		// 获得涉及到的用户名
		if(!labelList.isEmpty()) {
			for(CompanyLabel c : labelList) {
				ids.add(c.getUser().getUserId());
			}
			Map<String, User> map = userService.getSpecificUsers(ids);
			for(CompanyLabel c : labelList) {
				c.setUser(map.get(c.getUser().getUserId()));
			}
		}
		company.setLabels(labelList);
		return company;
	}
	
	@Override
	public int checkCompany(String companyName) throws CommonException {
		return companyDAO.checkCompany(companyName);
	}

	@Override
	public int updateCompany(Company company) {
		return companyDAO.updateCompany(company);
	}
}
