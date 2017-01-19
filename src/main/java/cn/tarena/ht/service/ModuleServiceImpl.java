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
	
	@Override
	public List<Module> findAll() {
		// TODO Auto-generated method stub
		return moduleMapper.findAll();
	}

	@Override
	public void updateState(String[] moduleIds, int state) {
		
		moduleMapper.updateState(moduleIds,state);
		
	}

	@Override
	public void delete(String[] moduleIds) {
		// TODO Auto-generated method stub
		moduleMapper.delete(moduleIds);
	}

	@Override
	public List<Module> findParentModule() {
		
		return moduleMapper.findParentModule();
	}

	@Override
	public void save(Module module) {
		
		module.setModuleId(UUID.randomUUID().toString());
		module.setCreateTime(new Date());
		moduleMapper.save(module);
		
	}

	@Override
	public Module findOneById(String moduleId) {
		
		
		return moduleMapper.findOneById(moduleId);
	}

	@Override
	public Module findModuleById(String moduleId) {
		
		return moduleMapper.findModuleById(moduleId);
	}

	//查询除了自己之外的列表信息
	public List<Module> findModuleByIdRM(String moduleId) {
		
		return moduleMapper.findModuleByIdRM(moduleId);
	}

	@Override
	public void updateModule(Module module) {
		module.setUpdateTime(new Date());
		moduleMapper.updateModule(module);
	}

	@Override
	public List<String> findModuleByRoleId(String roleId) {
		
		return moduleMapper.findModuleByRoleId(roleId);
	}
	
	
	

}
