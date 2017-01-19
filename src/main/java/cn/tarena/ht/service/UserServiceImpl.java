package cn.tarena.ht.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tarena.ht.mapper.UserInfoMapper;
import cn.tarena.ht.mapper.UserMapper;
import cn.tarena.ht.pojo.Role;
import cn.tarena.ht.pojo.User;
import cn.tarena.ht.pojo.UserInfo;
import cn.tarena.ht.tool.Encrypt;
@Service
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserMapper userMapper;
	@Resource
	private UserInfoMapper userInfoMapper;
	
	@Override
	public List<User> findAll() {
		
		return userMapper.findAll();
	}


	@Override
	public void updateState(String[] userId, int state) {
		
		userMapper.updateState(userId,state);
		
	}


	@Override
	public void deleteUsers(String[] userId) {
		//批量删除
		userInfoMapper.deleteUserInfos(userId);
		userMapper.deleteUsers(userId);
		
	}


	@Override
	public void save(User user) {
		
		String userId = UUID.randomUUID().toString();	//uuid
		
		//提取用户扩展信息
		UserInfo userInfo = user.getUserInfo();
		
		user.setUserId(userId);
		user.setState(1);
		user.setCreateTime(new Date());
		//密码加密
		String password = Encrypt.getMd5(user.getUsername(), user.getPassword());
		user.setPassword(password);
		userInfo.setUserInfoId(userId);
		userInfo.setCreateTime(new Date());
		
		userMapper.save(user);
		userInfoMapper.save(userInfo);
	}


	@Override
	public User findUserByID(String userId){
		
		return userMapper.findUserByID(userId);
	}


	@Override
	public void updateUser(User user) {
		
		user.setUpdateTime(new Date());
		UserInfo userInfo = user.getUserInfo();
		userInfo.setUpdateTime(new Date());
		userInfo.setUserInfoId(user.getUserId());
		userMapper.updateUser(user);
		userInfoMapper.updateUserInfo(userInfo);
		
	}


	@Override
	public void saveUserRole(String userId, String[] roleIds) {
		
		//删除userId所拥有的角色信息
		userMapper.delteRoleByUserId(userId);
		
		//循环插入中间表
		for (String roleId : roleIds) {
			userMapper.saveUserRole(userId,roleId);
		}
		
	}


	@Override
	public List<String> findUserRoleByUserId(String userId) {
		
		
		return userMapper.findUserRoleByUserId(userId);
	}

	
	//根据用户名和密码查询用户
	@Override
	public User findUserByU_P(String username, String password) {
		
		return userMapper.findUserByU_P(username, password);
	}


	@Override
	public User findUserByUserName(String username) {
		
		return userMapper.findUserByUserName(username);
	}

}
