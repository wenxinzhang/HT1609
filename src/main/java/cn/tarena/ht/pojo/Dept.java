package cn.tarena.ht.pojo;
//继承BaseEntity 实现代码复用
public class Dept extends BaseEntity{
	private String deptId;			//部门id
	private Dept parentDept;		//自关联  管理上级部门
	private String deptName;		//部门名称
	private int state;				//状态  1启用  0停用
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public Dept getParentDept() {
		return parentDept;
	}
	public void setParentDept(Dept parentDept) {
		this.parentDept = parentDept;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	
}
