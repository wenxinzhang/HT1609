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

	public List<User> findAll() {
		
		return userMapper.findAll();
	}

	public void updateState(String[] userId, int state) {
		
		userMapper.updateState(userId,state);
		
	}


	public void deleteUsers(String[] userId) {
		//鎵归噺鍒犻櫎
		userInfoMapper.deleteUserInfos(userId);
		userMapper.deleteUsers(userId);
		
	}


	public void save(User user) {
		
		String userId = UUID.randomUUID().toString();	//uuid
		
		//鎻愬彇鐢ㄦ埛鎵╁睍淇℃伅
		UserInfo userInfo = user.getUserInfo();
		
		user.setUserId(userId);
		user.setState(1);
		user.setCreateTime(new Date());
		//瀵嗙爜鍔犲瘑
		String password = Encrypt.getMd5(user.getUsername(), user.getPassword());
		user.setPassword(password);
		userInfo.setUserInfoId(userId);
		userInfo.setCreateTime(new Date());
		
		userMapper.save(user);
		userInfoMapper.save(userInfo);
	}


	public User findUserByID(String userId){
		
		return userMapper.findUserByID(userId);
	}


	public void updateUser(User user) {
		
		user.setUpdateTime(new Date());
		UserInfo userInfo = user.getUserInfo();
		userInfo.setUpdateTime(new Date());
		userInfo.setUserInfoId(user.getUserId());
		userMapper.updateUser(user);
		userInfoMapper.updateUserInfo(userInfo);
		
	}


	public void saveUserRole(String userId, String[] roleIds) {
		
		//鍒犻櫎userId鎵�鎷ユ湁鐨勮鑹蹭俊鎭�
		userMapper.delteRoleByUserId(userId);
		
		//寰幆鎻掑叆涓棿琛�
		for (String roleId : roleIds) {
			userMapper.saveUserRole(userId,roleId);
		}
		
	}


	public List<String> findUserRoleByUserId(String userId) {
		
		
		return userMapper.findUserRoleByUserId(userId);
	}

	
	//鏍规嵁鐢ㄦ埛鍚嶅拰瀵嗙爜鏌ヨ鐢ㄦ埛

	public User findUserByU_P(String username, String password) {
		
		return userMapper.findUserByU_P(username, password);
	}


	public User findUserByUserName(String username) {
		
		return userMapper.findUserByUserName(username);
	}

}
