package com.java456.service;

import java.util.List;
import java.util.Map;

import com.java456.entity.User;

public interface UserService {
	
	public Integer add(User user);
	
	public Integer update(User user);

	public List<User> list(Map<String, Object > map);
	
	public Integer getTotal(Map<String, Object > map);

	public User findByNum(String num);
	
	public User findById(Integer id); 
	
	public Integer delete(Integer id);
}
