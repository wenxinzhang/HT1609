package cn.tarena.ht.service;

import java.util.List;

import cn.tarena.ht.pojo.Role;
import cn.tarena.ht.pojo.User;

public interface UserService {
	public List<User> findAll();	//查询全部用户信息

	public void updateState(String[] userId, int state);

	public void deleteUsers(String[] userId);

	public void save(User user);

	public User findUserByID(String userId);

	public void updateUser(User user);

	public void saveUserRole(String userId, String[] roleIds);

	public List<String> findUserRoleByUserId(String userId);

	public User findUserByU_P(String username, String password);

	public User findUserByUserName(String username);
}
