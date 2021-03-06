package com.managerSystem.dao;

import java.util.List;
import java.util.Map;

import com.managerSystem.entity.UserSub;

public interface UserSubDao {
	
	public Integer add(UserSub userSub);
	
	public Integer update(UserSub userSub);
	
	public List<UserSub> list(Map<String,Object> map);
	
	public Integer getTotal(Map<String,Object> map);
	
	public UserSub findById(Integer id);
	
	public Integer delete(Integer id);
	
	
}
