package com.java456.entity;

import java.util.Date;


/**
 * 关于用户 显示菜单的思路，菜单传到前台之前 应该过虑一边。
 * 拿到用户的treeMenusIds然后过虑一下，
 */
public class User {
	private Integer id;
	private String num_;//读者号
	private String trueName;//真实姓名 
	private String phone;//电话 
	private String sex_;//性别
	private String menuIds;
	private Date createDateTime;
	private String password;//密码
	private String remark;//备注
	private Integer type;//1管理员 2读者
	
	
	
	
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
