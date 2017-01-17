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

	public List<Role> findAll() {
		
		return roleMapper.findAll();
	}

	public void saveRole(Role role) {
		
		role.setRoleId(UUID.randomUUID().toString());
		role.setCreateTime(new Date());
		roleMapper.saveRole(role);
		
	}

	public Role findRoleByID(String roleId) {
		
		return roleMapper.findRoleByID(roleId);
	}

	public void updateRole(Role role) {
		role.setUpdateTime(new Date());
		roleMapper.updateRole(role);
		
	}

	public void deleteRoles(String[] roleIds) {
		
		roleMapper.deleteRoles(roleIds);
		
	}

	public void saveRoleModule(String roleId, String[] moduleIds) {
		//闃叉閲嶅鎻愪氦  鍏堝垹闄�  鍚庢彁浜�
		
		roleMapper.deleteRoleModules(roleId);
		
		for (String moduleId : moduleIds) {
			roleMapper.saveRoleModule(roleId,moduleId);
		}
		
		
	}
	
	

}
