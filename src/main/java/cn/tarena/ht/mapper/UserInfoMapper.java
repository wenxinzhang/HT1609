package cn.tarena.ht.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.tarena.ht.pojo.User;
import cn.tarena.ht.pojo.UserInfo;

public interface UserInfoMapper {
	
	public void deleteUserInfos(String[] userId);
	@Select("select * from user_info_p")
	public List<UserInfo> findManagerList();
	public void save(UserInfo userInfo);
	
	//排除自己的用户列表
	@Select("SELECT * FROM user_info_p WHERE user_info_id !=#{userId}")
	public List<UserInfo> findManagerListRM(String userId);
	
	public void updateUserInfo(UserInfo userInfo);
}
