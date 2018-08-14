package com.java456.dao;

import java.util.List;
import java.util.Map;

import com.java456.entity.Message;


public interface MessageDao {
	
	public Integer  add(Message  msg);
	
	public Integer  update(Message  msg);
	
	public List<Message> list(Map<String,Object> map);
	
	public Integer getTotal(Map<String,Object> map);
	
	public Integer delete(Integer id);
	
	public Message findById(Integer id);
	
	
}
