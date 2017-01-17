package cn.tarena.ht.service;

import java.util.List;

import cn.tarena.ht.pojo.Module;

public interface ModuleService {
	public List<Module> findAll();

	public void updateState(String[] moduleIds, int state);

	public void delete(String[] moduleIds);

	public List<Module> findParentModule();

	public void save(Module module);
	
	public Module findOneById(String moduleId);

	public Module findModuleById(String moduleId);

	public List<Module> findModuleByIdRM(String moduleId);

	public void updateModule(Module module);
	
	public List<String> findModuleByRoleId(String roleId);
}
