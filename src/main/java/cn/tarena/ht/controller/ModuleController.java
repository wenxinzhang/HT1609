package cn.tarena.ht.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.tarena.ht.pojo.Module;
import cn.tarena.ht.service.ModuleService;

@Controller
@RequestMapping("/sysadmin/module/")
public class ModuleController extends BaseController{
	
	@Resource
	private ModuleService moduleService;
	
	
	@RequestMapping("list")
	public String findAll(Model model){
		
		
		model.addAttribute("moduleList", moduleService.findAll());
		
		return "/sysadmin/module/jModuleList";
	}
	
	//状态启用
	@RequestMapping("start")
	public String start(@RequestParam("moduleId") String[] moduleIds){
		
		moduleService.updateState(moduleIds,1);
		return "redirect:/sysadmin/module/list";
	}
	
	//状态停用
	@RequestMapping("stop")
	public String stop(@RequestParam("moduleId") String[] moduleIds){
		
		moduleService.updateState(moduleIds,0);
		return "redirect:/sysadmin/module/list";
	}
	
	
	//模块删除
	@RequestMapping("delete")
	public String delete(@RequestParam("moduleId")  String[] moduleIds){
		
		moduleService.delete(moduleIds);
		
		return "redirect:/sysadmin/module/list";
	}
	
	
	//模块新增
	@RequestMapping("tocreate")
	public String toCreate(Model model){
		
		//查询上级模块信息
		model.addAttribute("parentList", moduleService.findParentModule());
		
		return "/sysadmin/module/jModuleCreate";
	}
	
	//模块保存
	@RequestMapping("save")
	public String save(Module module){
		
		moduleService.save(module);
		
		return "redirect:/sysadmin/module/list";
	}
	
	@RequestMapping("toview")
	public String toView(String moduleId,Model model){
		
		model.addAttribute("module", moduleService.findOneById(moduleId));
		
		return "/sysadmin/module/jModuleView";
	}
	
	@RequestMapping("toupdate")
	public String toUpdate(String moduleId,Model model){
		
		//根据ID查询模块信息
		Module module = moduleService.findModuleById(moduleId);
		
		//上级模块列表
		List<Module> pModuleList = moduleService.findModuleByIdRM(moduleId);
		model.addAttribute("module", module);
		model.addAttribute("pModuleList",pModuleList);
		
		
		//转向修改页面
		return "/sysadmin/module/jModuleUpdate";
	}
	
	
	@RequestMapping("update")
	public String update(Module module){
		
		moduleService.updateModule(module);
		return "redirect:/sysadmin/module/list";
	}
	
	
	
	
	
	
}
