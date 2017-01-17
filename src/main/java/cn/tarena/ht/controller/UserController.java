package cn.tarena.ht.controller;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.tarena.ht.pojo.Dept;
import cn.tarena.ht.pojo.Role;
import cn.tarena.ht.pojo.User;
import cn.tarena.ht.pojo.UserInfo;
import cn.tarena.ht.service.DeptService;
import cn.tarena.ht.service.RoleService;
import cn.tarena.ht.service.UserInfoService;
import cn.tarena.ht.service.UserService;

@Controller
@RequestMapping("/sysadmin/user/")
public class UserController extends BaseController{
	
	@Resource
	private UserService userService;
	
	@Resource
	private DeptService deptService;
	
	@Resource
	private RoleService roleSerivce;
	
	@Resource
	private UserInfoService userInfoService;
	
	@RequestMapping("list")
	public String findAll(Model model){
		
		model.addAttribute("userList", userService.findAll());
		
		return "/sysadmin/user/jUserList";
	}
	
	//状态改变 启用
	@RequestMapping("start")
	public String toStart(String[] userId){
		int state = 1;
		userService.updateState(userId,state);
		
		//重定向回用户列表页面
		return "redirect:/sysadmin/user/list";
	}
	
	@RequestMapping("stop")
	public String toStop(String[] userId){
		int state = 0;
		userService.updateState(userId,state);
		
		//重定向回用户列表页面
		return "redirect:/sysadmin/user/list";
	}
	
	
	//批量删除
	@RequestMapping("delete")
	public String deleteUsers(String[] userId){
		
		userService.deleteUsers(userId);
		return "redirect:/sysadmin/user/list";
		
	}
	
	//用户新增
	@RequestMapping("tocreate")
	public String tocreate(Model model){
		
		//准备部门下拉列表
		List<Dept> deptList = deptService.findAll();
		
		//查询上级领导
		List<UserInfo> managerList = userInfoService.findManagerList();
		
		
		model.addAttribute("deptList", deptList);
		model.addAttribute("managerList", managerList);
		
		//转向用户新增页面
		return "/sysadmin/user/jUserCreate";
	}
	
	@RequestMapping("save")
	public String save(User user){
		
		userService.save(user);
		
		return "redirect:/sysadmin/user/list";
	}
	
	//用户的修改
	@RequestMapping("toupdate")
	public String toUpdate(String userId,Model model){
		
		User user = userService.findUserByID(userId);	//用户信息
		//准备部门下拉列表
		List<Dept> deptList = deptService.findAll();
		//除自己之外的用户
		List<UserInfo> managerList = userInfoService.findManagerListRM(userId);
		
		model.addAttribute("user", user);
		model.addAttribute("deptList", deptList);
		model.addAttribute("managerList", managerList);
		return "/sysadmin/user/jUserUpdate";
	}
	
	@RequestMapping("update")
	public String update(User user){
		
		userService.updateUser(user);
		return "redirect:/sysadmin/user/list";
	}
	
	
	//为用户分配不同的角色信息
	@RequestMapping("role")
	public String toRole(String userId,Model model) throws JsonProcessingException{
		
		//根据userId查询角色信息
		List<String> user_role = userService.findUserRoleByUserId(userId);
		
		//查询全部的角色信息
		List<Role> roleList = roleSerivce.findAll();
		
		
		//回显角色信息
		for (Role role : roleList) {
			if( user_role.contains(role.getRoleId())){
				role.setChecked("true");
			}
		}
		
		//创建mapper对象
		ObjectMapper objectMapper = new ObjectMapper();
		String zTreeJson = objectMapper.writeValueAsString(roleList);
		System.out.println(zTreeJson);
		
		model.addAttribute("userId", userId);
		model.addAttribute("zTreeJson", zTreeJson);
		
		//转向角色列表页面
		return "/sysadmin/user/jUserRole";
	}
	
	
	@RequestMapping("saveUserRole")
	public String saveUserRole(String userId,String[] roleIds){
		
		//保存角色数据
		userService.saveUserRole(userId,roleIds);
		
		return "redirect:/sysadmin/user/list";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
