package com.managerSystem.entity;

import java.util.Date;


/**
 * �����û� ��ʾ�˵���˼·���˵�����ǰ̨֮ǰ Ӧ�ù���һ�ߡ�
 * �õ��û���treeMenusIdsȻ�����һ�£�
 */
public class User {
	private Integer id;
	private String num_;//���ߺ�
	private String trueName;//��ʵ���� 
	private String phone;//�绰 
	private String sex_;//�Ա�
	private String menuIds;
	private Date createDateTime;
	private String password;//����
	private String remark;//��ע
	private Integer type;//1����Ա 2����
	
	
	
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNum_() {
		return num_;
	}
	public void setNum_(String num_) {
		this.num_ = num_;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public String getSex_() {
		return sex_;
	}
	public void setSex_(String sex_) {
		this.sex_ = sex_;
	}
	public String getMenuIds() {
		return menuIds;
	}
	public void setMenuIds(String menuIds) {
		this.menuIds = menuIds;
	}
	public Date getCreateDateTime() {
		return createDateTime;
	}
	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	
	
	
	
	
	
}
