package cn.tarena.ht.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.tarena.ht.pojo.Dept;
import cn.tarena.ht.service.DeptService;

@Controller
@RequestMapping("/sysadmin/dept/")
public class DeptController {
	
	@Resource
	private DeptService deptService;
	
	//用户列表展现
	@RequestMapping("list")
	public String findAll(Model model){
		
		model.addAttribute("deptList", deptService.findAll());
		//展现的列表页面
		return "/sysadmin/dept/jDeptList";
	}
	
	//状态停用  stop?deptId=${d.deptId}
	@RequestMapping("stop")
	public String toStop(@RequestParam("deptId")String[] deptIds){
		
		int stop = 0;		//状态码  停用
		deptService.updateState(deptIds,stop);
		
		//需要使用重定向  再次返回用户列表页面
		return "redirect:/sysadmin/dept/list";
	}
	
	//启用
	@RequestMapping("start")
	public String toStart(@RequestParam("deptId")String[] deptIds){
		
		int start = 1;		//状态码  停用
		deptService.updateState(deptIds,start);
		
		//需要使用重定向  再次返回用户列表页面
		return "redirect:/sysadmin/dept/list";
	}
	
	//批量删除
	@RequestMapping("delete")
	public String toDeleteDept(String[] deptId){
		
		deptService.deleteDepts(deptId);
		return "redirect:/sysadmin/dept/list";
	}
	
	//部门新增tocreate
	@RequestMapping("tocreate")
	public String tocreate(Model model){
		
		//准备上级部门下拉列表
		model.addAttribute("parentList", deptService.findAll());
		return "/sysadmin/dept/jDeptCreate";
	}
	
	//部门保存
	@RequestMapping("save")
	public String saveDept(Dept dept){
		
		deptService.saveDept(dept);
		return "redirect:/sysadmin/dept/list";
	}
	
	//部门查看
	@RequestMapping("toview")
	public String toview(String deptId,Model model){

		model.addAttribute("dept", deptService.findOneByID(deptId));
		//转向部门查看页面
		return "/sysadmin/dept/jDeptView";
	}
	
	
	
	
	
	
	
	
}
