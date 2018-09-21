package com.internetsaying.user.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.internetsaying.exception.CommonException;
import com.internetsaying.user.entity.Role;
import com.internetsaying.user.entity.User;

@Repository
public interface UserDAO {

	/**
	 * 登录查询
	 * @param userEmail
	 * @param password
	 * @return
	 */
	User getUserForLogin(@Param("userEmail") String userEmail, @Param("password") String password);
	
	/**
	 * 查询用户的权限
	 * @param userId
	 * @return
	 */
	List<Role> getUserRoles(@Param("userId") String userId);
	
	/**
	 * 按ID获取用户
	 * @param userId
	 * @return
	 */
	User getUserById(@Param("userId") String userId);
	
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	int addUser(User user);
	
	/**
	 * 更新用户
	 * @param user
	 * @return
	 */
	int updateUser(User user);
	
	/**
	 * 检查邮箱是否存在
	 * @param email
	 * @return
	 */
	int checkEmail(@Param("email") String email);
	
	int checkNickName(@Param("nickname") String nickname);
	
	/**
	 * 给出具体的userId集合，查询用户（一般只需要：id，名字，头像字段）
	 * @param ids
	 * @return
	 */
	List<User> getSpecificUsers(@Param("idList") List<String> ids);
	
	/**
	 * 场景：评论回复列表，评论以及回复涉及的用户肯定有重复的，所以利用Set去重，返回Map（具体为key=id,value=User）
	 * 客户的利用这个Map来安置每个id对应的用户实体
	 * @param ids
	 * @return
	 */
	@MapKey("userId")
	Map<String, User> getSpecificUsersMap(@Param("idSet") Set<String> ids);
	
	/**
	 * 获得用户数量
	 * @return
	 * @throws CommonException
	 */
	int getUserCount();
	
	/**
	 * 获得用户列表
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @throws CommonException
	 */
	List<User> getUserList(@Param("pageNo") int pageNo, @Param("pageSize") int pageSize);
}
