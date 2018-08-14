package com.java456.service;

import java.util.List;
import java.util.Map;
import com.java456.entity.Book;

public interface BookService {
	
	
	public Integer add(Book book);
	
	public Integer update(Book book);
	
	public List<Book> list(Map<String,Object> map);
	
	public Integer getTotal(Map<String,Object> map);
	
	public Book findById(Integer id);
	
	public Integer delete(Integer id);
	
	
}
