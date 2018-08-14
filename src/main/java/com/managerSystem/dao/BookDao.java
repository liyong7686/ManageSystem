package com.managerSystem.dao;

import java.util.List;
import java.util.Map;

import com.managerSystem.entity.Book;


public interface BookDao {
	
	public Integer add(Book book);
	
	public Integer update(Book book);
	
	public List<Book> list(Map<String,Object> map);
	
	public Integer getTotal(Map<String,Object> map);
	
	public Book findById(Integer id);
	
	public Integer delete(Integer id);
	
}
