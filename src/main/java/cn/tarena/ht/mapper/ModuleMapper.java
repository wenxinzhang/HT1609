package cn.tarena.ht.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.tarena.ht.pojo.Module;

public interface ModuleMapper {
	
	public List<Module> findAll();
	
	public void updateState(@Param("moduleIds")String[] moduleIds, @Param("state")int state);

	public void delete(String[] moduleIds);
	@Select("select * from module_p")
	public List<Module> findParentModule();

	public void save(Module module);
	@Select("select * from module_p where module_id =#{moduleId}")
	public Module findOneById(String moduleId);
	
	public Module findModuleById(String moduleId);
	
	@Select("select * from module_p where module_id !=#{moduleId}")
	public List<Module> findModuleByIdRM(String moduleId);
	
	public void updateModule(Module module);
	@Select("select module_id from role_module_p where role_id = #{roleId}")
	public List<String> findModuleByRoleId(String roleId);
	
	
	
	
	
	
}
