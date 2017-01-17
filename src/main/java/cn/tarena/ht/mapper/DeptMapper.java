package cn.tarena.ht.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.tarena.ht.pojo.Dept;

public interface DeptMapper {
	
	public List<Dept> findAll();

	public void updateState(@Param("deptIds")String[] deptIds,@Param("state") int state);
	
	public void deleteDepts(String[] deptId);

	public void saveDept(Dept dept);

	public Dept findOneByID(String deptId);
}
