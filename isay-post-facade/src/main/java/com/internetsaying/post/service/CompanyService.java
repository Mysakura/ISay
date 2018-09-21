package com.internetsaying.post.service;

import java.util.List;

import com.internetsaying.exception.CommonException;
import com.internetsaying.post.entity.Company;
import com.internetsaying.post.entity.CompanyLabel;

public interface CompanyService {

	/**
	 * 添加公司
	 * @param company
	 * @return
	 */
	int addCompany(Company company) throws CommonException;
	
	/**
	 * 删除公司（更新删除字段）
	 * @param companyId
	 * @return
	 */
	int deleteCompany(int companyId) throws CommonException;
	
	/**
	 * 获得公司列表
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<Company> getCompanyList(int pageNo, int pageSize) throws CommonException;
	
	/**
	 * 获得公司详细（公司+第一页标签）
	 * @param companyId
	 * @return
	 */
	Company getCompanyById(int companyId, int pageSize) throws CommonException;
	
	/**
	 * 添加公司标签
	 * @param label
	 * @return
	 */
	int addCompanyLabel(CompanyLabel label) throws CommonException;
	
	/**
	 * 删除标签（更新删除字段）
	 * @param labelId
	 * @return
	 */
	int deleteCompanyLabel(int labelId) throws CommonException;
	
	/**
	 * 获得公司对应的标签
	 * @param companyId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<CompanyLabel> getCompanyLabelList(int companyId, int pageNo, int pageSize) throws CommonException;
	
	/**
	 * 公司数量
	 * @return
	 */
	int getCompanyCount() throws CommonException;
	
	/**
	 * 公司对应的标签数量
	 * @param companyId
	 * @return
	 */
	int getCompanyLabelCount(int companyId) throws CommonException;
	
	/**
	 * 根据公司名获取公司
	 * @param name
	 * @return
	 */
	Company getCompanyByName(String name, int pageSize) throws CommonException;
	
	/**
	 * 检查公司是否存在
	 * @param companyName
	 * @return
	 * @throws CommonException
	 */
	int checkCompany(String companyName) throws CommonException;
	
	/**
	 * 更新
	 * @param company
	 * @return
	 */
	int updateCompany(Company company);
}
