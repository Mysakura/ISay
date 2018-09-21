package com.internetsaying.user.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.internetsaying.exception.CommonException;
import com.internetsaying.user.entity.User;

/**
 * 
 * 模块名称：用户服务接口
 *
 * @author 董昕杰
 * @since 2017年10月21日
 */
public interface UserService {

	/**
	 * 登录查询
	 * @param userEmail
	 * @param password
	 * @return
	 */
	User getUserForLogin(String userEmail, String password) throws CommonException;
	
	/**
	 * 按ID获取用户
	 * @param userId
	 * @return
	 */
	User getUserById(String userId) throws CommonException;
	
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	int addUser(User user) throws CommonException;
	
	/**
	 * 更新基本信息
	 * @param user
	 * @return
	 */
	int updateBaseInfo(User user) throws CommonException;
	
	/**
	 * 更新密码
	 * @param user
	 * @return
	 */
	int updatePassword(User user) throws CommonException;
	
	/**
	 * 更新头像
	 * @param user
	 * @return
	 */
	int updatePhoto(User user) throws CommonException;
	
	/**
	 * 更新背景
	 * @param user
	 * @return
	 */
	int updateBg(User user) throws CommonException;
	
	/**
	 * 更新支付宝二维码
	 * @param user
	 * @return
	 */
	int updateAlipay(User user) throws CommonException;
	
	/**
	 * 更新微信二维码
	 * @param user
	 * @return
	 */
	int updateVxin(User user) throws CommonException;
	
	/**
	 * 删除用户（实际上也是更新）
	 * @param user
	 * @return
	 */
	int deleteUser(User user) throws CommonException;
	
	/**
	 * 检查邮箱是否存在
	 * @param email
	 * @return
	 */
	int checkEmail(String email) throws CommonException;
	
	/**
	 * 检查用户名是否存在
	 * @param email
	 * @return
	 */
	int checkNickName(String nickname) throws CommonException;
	
	/**
	 * 不推荐使用，由 Map<String, User> getSpecificUsers(Set<String> ids) 代替
	 * 给出具体的userId集合，查询用户（一般只需要：id，名字，头像字段）
	 * @param ids
	 * @return
	 */
	@Deprecated
	List<User> getSpecificUsers(List<String> ids) throws CommonException;
	
	/**
	 * 场景：评论回复列表，评论以及回复涉及的用户肯定有重复的，所以利用Set去重，返回Map（具体为key=id,value=User）
	 * 客户的利用这个Map来安置每个id对应的用户实体
	 * @param ids
	 * @return
	 */
	Map<String, User> getSpecificUsers(Set<String> ids) throws CommonException;
	
	/**
	 * 获得用户数量
	 * @return
	 * @throws CommonException
	 */
	int getUserCount() throws CommonException;
	
	/**
	 * 获得用户列表
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @throws CommonException
	 */
	List<User> getUserList(int pageNo, int pageSize) throws CommonException;
}
