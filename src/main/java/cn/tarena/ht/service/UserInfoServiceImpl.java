package cn.tarena.ht.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tarena.ht.mapper.UserInfoMapper;
import cn.tarena.ht.pojo.UserInfo;
@Service
public class UserInfoServiceImpl implements UserInfoService {

	private UserInfoMapper userInfoMapper;

	public List<UserInfo> findManagerList() {
		
		return userInfoMapper.findManagerList();
	}


	public List<UserInfo> findManagerListRM(String userId) {
		
		return userInfoMapper.findManagerListRM(userId);
	}

}
