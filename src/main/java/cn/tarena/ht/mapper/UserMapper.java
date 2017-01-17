package cn.tarena.ht.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.tarena.ht.pojo.Role;
import cn.tarena.ht.pojo.User;

public interface UserMapper {
	
	public List<User> findAll();	//查询全部用户信息

	public void updateState(@Param("userId")String[] userId, @Param("state")int state);

	public void deleteUsers(String[] userId);

	public void save(User user);	//保存用户信息

	public User findUserByID(String userId);

	public void updateUser(User user);
	
	@Insert("insert into role_user_p values(#{roleId},#{userId})")
	public void saveUserRole(@Param("userId")String userId, @Param("roleId")String roleId);
	
	@Select("select role_id from role_user_p where user_id=#{userId}")
	public List<String> findUserRoleByUserId(String userId);
	
	@Delete("delete from role_user_p where user_id=#{userId}")
	public void delteRoleByUserId(String userId);

	public User findUserByU_P(@Param ("username")String username, @Param("password")String password);
	
	public User findUserByUserName(String username);
}
