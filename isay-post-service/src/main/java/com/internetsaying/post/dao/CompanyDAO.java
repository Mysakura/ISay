package com.internetsaying.post.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.internetsaying.post.entity.Company;
import com.internetsaying.post.entity.CompanyLabel;

@Repository
public interface CompanyDAO {

	/**
	 * 添加公司
	 * @param company
	 * @return
	 */
	int addCompany(Company company);
	
	/**
	 * 更新公司
	 * @param companyId
	 * @return
	 */
	int updateCompany(Company company);
	
	/**
	 * 获得公司列表
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<Company> getCompanyList(@Param("pageNo") int pageNo, @Param("pageSize") int pageSize);
	
	/**
	 * 获得公司详细
	 * @param companyId
	 * @return
	 */
	Company getCompanyById(@Param("companyId") int companyId);
	
	/**
	 * 添加公司标签
	 * @param label
	 * @return
	 */
	int addCompanyLabel(CompanyLabel label);
	
	/**
	 * 更新标签
	 * @param labelId
	 * @return
	 */
	int updateCompanyLabel(CompanyLabel label);
	
	/**
	 * 获得公司对应的标签
	 * @param companyId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<CompanyLabel> getCompanyLabelList(@Param("companyId") int companyId, @Param("pageNo") int pageNo, @Param("pageSize") int pageSize);
	
	/**
	 * 公司数量
	 * @return
	 */
	int getCompanyCount();
	
	/**
	 * 公司对应的标签数量
	 * @param companyId
	 * @return
	 */
	int getCompanyLabelCount(@Param("companyId") int companyId);
	
	/**
	 * 获得公司详细
	 * @param companyId
	 * @return
	 */
	Company getCompanyByName(@Param("companyName") String companyName);
	
	/**
	 * 
	 * @param companyId
	 * @return
	 */
	int checkCompany(@Param("companyName") String companyName);
}
