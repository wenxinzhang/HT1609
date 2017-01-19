package cn.tarena.ht.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.tarena.ht.pojo.Module;
import cn.tarena.ht.pojo.Role;
import cn.tarena.ht.service.ModuleService;
import cn.tarena.ht.service.RoleService;

@Controller
@RequestMapping("/sysadmin/role/")
public class RoleController extends BaseController{
	
	@Resource
	private RoleService roleService;
	
	@Resource
	private ModuleService moduleSerivce;
	
	@RequestMapping("list")
	public String findAll(Model model){
		
		model.addAttribute("roleList", roleService.findAll());
		
		return "/sysadmin/role/jRoleList";
	}
	
	//角色新增
	@RequestMapping("tocreate")
	public String tocreate(){
		
		//转向新增页面
		return "/sysadmin/role/jRoleCreate";
	}
	
	//保存角色信息
	@RequestMapping("save")
	public String save(Role role){
		
		roleService.saveRole(role);
		
		return "redirect:/sysadmin/role/list";
	}
	
	
	//角色查看
	@RequestMapping("toview")
	public String toView(String roleId,Model model){
		Role role = roleService.findRoleByID(roleId);
		model.addAttribute("role", role);
		//转向到角色查看页面
		return "/sysadmin/role/jRoleView";
	}
	
	//角色修改
	@RequestMapping("toupdate")
	public String toupdate(String roleId,Model model){
		Role role = roleService.findRoleByID(roleId);
		model.addAttribute("role", role);
		
		return "/sysadmin/role/jRoleUpdate";
	}
	
	@RequestMapping("update")
	public String update(Role role){
		
		roleService.updateRole(role);
		return "redirect:/sysadmin/role/list";
	}
	
	@RequestMapping("delete")
	public String delete(@RequestParam("roleId")String[] roleIds){
		
		roleService.deleteRoles(roleIds);
		return "redirect:/sysadmin/role/list";
	}
	
	//为角色分配不同的模块
	@RequestMapping("module")
	public String module(String roleId,Model model) throws JsonProcessingException{
		
		//根据角色信息  查询模块信息
		List<String> rModuleList = moduleSerivce.findModuleByRoleId(roleId);
		
		
		//查询全部的模块信息
		List<Module> moduleList = moduleSerivce.findAll();
		
		//数据回显
		for (Module module : moduleList) {
			if(rModuleList.contains(module.getModuleId())){
				module.setChecked("true");
			}
		}
		
		//转化为JSON串
		ObjectMapper objectMapper = new ObjectMapper();
		String zTreeJSON = objectMapper.writeValueAsString(moduleList);
		
		System.out.println(zTreeJSON);
		model.addAttribute("zTreeJSON", zTreeJSON);
		model.addAttribute("roleId", roleId);
		
		return "/sysadmin/role/jRoleModule";
	}
	
	@RequestMapping("saveRoleModule")
	public String saveRoleModule(String roleId,String[] moduleIds){
		
		roleService.saveRoleModule(roleId,moduleIds);
		
		return "redirect:/sysadmin/role/list";
		
	}
	
}
