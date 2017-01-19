package cn.tarena.ht.pojo;

public class Module extends BaseEntity{
	private String moduleId;		//模块ID
	private Module parentModule;	//自关联 关联上级模块信息
	private String name;			//模块名称
	private int ctype;				//模块类型  1主菜单/2左侧菜单/3按钮
	private int state;				//启动停用
	private int orderNo;			//排序号
	private String remark;			//备注信息
	
	private String checked;			//zTree树回显页面
	public String getModuleId() {
		return moduleId;
	}
	
	//zTree树需要的属性 
	public String getId(){
		return moduleId;
	}
	
	public String getpId(){
		//如果没有上级模块则直接返回null
		if(parentModule !=null){
			return parentModule.getModuleId();
		}
		return null;
	}
	
	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}
	public Module getParentModule() {
		return parentModule;
	}
	public void setParentModule(Module parentModule) {
		this.parentModule = parentModule;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCtype() {
		return ctype;
	}
	public void setCtype(int ctype) {
		this.ctype = ctype;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
}
