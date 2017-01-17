package cn.tarena.ht.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tarena.ht.mapper.DeptMapper;
import cn.tarena.ht.pojo.Dept;
@Service
public class DeptServiceImpl implements DeptService {
	
	@Resource
	private DeptMapper deptMapper;
	
	//查询部门列表信息
	public List<Dept> findAll() {
		// TODO Auto-generated method stub
		return deptMapper.findAll();
	}

	public void updateState(String[] deptIds, int state) {
		
		deptMapper.updateState(deptIds,state);
		
	}

	public void deleteDepts(String[] deptId) {
		
		deptMapper.deleteDepts(deptId);
		
	}

	public void saveDept(Dept dept) {
		dept.setState(1);	//启用
		dept.setCreateTime(new Date());
		deptMapper.saveDept(dept);
		
	}

	public Dept findOneByID(String deptId) {
		
		return deptMapper.findOneByID(deptId);
	}

}
