package com.internetsaying.auth.realm;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.internetsaying.exception.CommonException;
import com.internetsaying.exception.enums.ExceptionEnum;
import com.internetsaying.user.entity.Role;
import com.internetsaying.user.entity.User;
import com.internetsaying.user.service.UserService;
import com.internetsaying.utils.IDUtils;

public class PermissionRealm extends AuthorizingRealm {

	@Autowired
	private UserService userService;
	
	//Authorization-授权 [ɔːθəraɪ'zeɪʃ(ə)n]
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		Object principal = principals.getPrimaryPrincipal();
		User user = (User) principal;
		
		Set<String> roles = new HashSet<>();
		// 用户身份
		List<Role> list = user.getRoles();
		for (Role role : list) {
			roles.add(role.getRoleName());	// 注意：shiro定义的角色名要与数据库一致
		}
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);
		return info;
	}

	//Authentication-认证 [ɔː,θentɪ'keɪʃən]
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) {
		
		UsernamePasswordToken uToken = (UsernamePasswordToken) token;
		
		String username = uToken.getUsername();
		String password = String.valueOf(uToken.getPassword());
		
		User user = userService.getUserForLogin(username, IDUtils.saltAndMd5(username, password));
		if(user == null){
			throw new CommonException(ExceptionEnum.LOGIN_FAILED.code, ExceptionEnum.LOGIN_FAILED.msg);
		}
		//认证的实体信息
		Object principal = user;
		//从数据库获取的密码
		Object hashedCredentials = user.getPassword();
		//盐值
		ByteSource credentialsSalt = ByteSource.Util.bytes(user.getUserEmail());
		//当前Realm对象的name，调用父类的getName方法
		String realmName = getName();
		
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal, hashedCredentials, credentialsSalt, realmName);
		
		return info;
	}
}
