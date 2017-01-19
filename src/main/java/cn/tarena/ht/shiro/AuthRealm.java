package cn.tarena.ht.shiro;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import com.sun.org.apache.xerces.internal.xs.StringList;

import cn.tarena.ht.pojo.Role;
import cn.tarena.ht.pojo.User;
import cn.tarena.ht.service.UserService;

public class AuthRealm extends AuthorizingRealm{
	
	@Resource
	private UserService userService;
	@Override
	//用来做权限管理的
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		/*权限管理实现思路
		 *1.获取用户对象
		 *2.根据用户对象的到userId---->roleId----->moduleId   返回字符串
		 *3.将返回后的字符串设置到moduleList中 ，然后返回
		 */
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		//List<String>  moduleListA = userService.findModuleLists(user.getUserId());	
		
		
		//定义用户的权限列表
		List<String> moduleList = new ArrayList<String>();
		moduleList.add("货运管理");
		//moduleList.add("基础信息");
		///moduleList.add("系统管理");
		
		//创建权限控制的info对象
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addStringPermissions(moduleList);
		
		return info;
	}

	@Override
	//登陆验证
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		/*
		 * 登陆验证的思路
		 * 1.获取用户传入的用户名username  用户名必然唯一
		 * 2.根据用户名查询出真实的用户
		 * 3.将真实的用户、真实的密码、当前realm的名称一起传入AuthenticationInfo  然后返回
		 */
		
		UsernamePasswordToken loginToken = (UsernamePasswordToken) token;
		String username = loginToken.getUsername();
		
		//根据用户名查询用户   该对象是数据库中真实的对象
		User user = userService.findUserByUserName(username);
		
		/*创建认证对象 然后返回    
		 *参数1.真实的user对象
		 *参数2.真实用户密码
		 *参数3.当前realm的名称
		 * 
		 */
		AuthenticationInfo info = 
				new SimpleAuthenticationInfo(user, user.getPassword(), this.getName());
		return info;
	}
	



	
	
	
}
