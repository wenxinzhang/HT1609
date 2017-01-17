package cn.tarena.ht.pojo;

public class Role extends BaseEntity{
	private String roleId;  //角色ID
	private String name;	//角色名称
	private String remarks; //备注信息
	private int orderNo;	//排序号
	private String checked;	//为Ztree树设定回显
	
	
	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

	public String getRoleId() {
		return roleId;
	}
	
	//因为zTree树要求属性为id 所以通过getId进行转化
	public String getId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	
	
	
}
