package cn.tarena.ht.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tarena.ht.mapper.ModuleMapper;
import cn.tarena.ht.pojo.Module;
@Service
public class ModuleServiceImpl implements ModuleService {
	
	@Resource
	private ModuleMapper moduleMapper;

	public List<Module> findAll() {
		// TODO Auto-generated method stub
		return moduleMapper.findAll();
	}


	public void updateState(String[] moduleIds, int state) {
		
		moduleMapper.updateState(moduleIds,state);
		
	}


	public void delete(String[] moduleIds) {
		// TODO Auto-generated method stub
		moduleMapper.delete(moduleIds);
	}


	public List<Module> findParentModule() {
		
		return moduleMapper.findParentModule();
	}


	public void save(Module module) {
		
		module.setModuleId(UUID.randomUUID().toString());
		module.setCreateTime(new Date());
		moduleMapper.save(module);
		
	}


	public Module findOneById(String moduleId) {
		
		
		return moduleMapper.findOneById(moduleId);
	}


	public Module findModuleById(String moduleId) {
		
		return moduleMapper.findModuleById(moduleId);
	}

	//鏌ヨ闄や簡鑷繁涔嬪鐨勫垪琛ㄤ俊鎭�
	public List<Module> findModuleByIdRM(String moduleId) {
		
		return moduleMapper.findModuleByIdRM(moduleId);
	}


	public void updateModule(Module module) {
		module.setUpdateTime(new Date());
		moduleMapper.updateModule(module);
	}


	public List<String> findModuleByRoleId(String roleId) {
		
		return moduleMapper.findModuleByRoleId(roleId);
	}
	
	
	

}
