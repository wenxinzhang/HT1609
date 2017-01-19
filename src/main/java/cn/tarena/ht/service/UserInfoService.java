package cn.tarena.ht.service;

import java.util.List;

import cn.tarena.ht.pojo.UserInfo;

public interface UserInfoService {
	
	public List<UserInfo> findManagerList();

	public List<UserInfo> findManagerListRM(String userId);
}
