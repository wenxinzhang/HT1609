package cn.tarena.ht.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tarena.ht.mapper.RoleMapper;
import cn.tarena.ht.pojo.Role;
@Service
public class RoleServiceImpl implements RoleService {
	
	@Resource
	private RoleMapper roleMapper;
	@Override
	public List<Role> findAll() {
		
		return roleMapper.findAll();
	}
	@Override
	public void saveRole(Role role) {
		
		role.setRoleId(UUID.randomUUID().toString());
		role.setCreateTime(new Date());
		roleMapper.saveRole(role);
		
	}
	@Override
	public Role findRoleByID(String roleId) {
		
		return roleMapper.findRoleByID(roleId);
	}
	@Override
	public void updateRole(Role role) {
		role.setUpdateTime(new Date());
		roleMapper.updateRole(role);
		
	}
	@Override
	public void deleteRoles(String[] roleIds) {
		
		roleMapper.deleteRoles(roleIds);
		
	}
	@Override
	public void saveRoleModule(String roleId, String[] moduleIds) {
		//防止重复提交  先删除  后提交
		
		roleMapper.deleteRoleModules(roleId);
		
		for (String moduleId : moduleIds) {
			roleMapper.saveRoleModule(roleId,moduleId);
		}
		
		
	}
	
	

}
