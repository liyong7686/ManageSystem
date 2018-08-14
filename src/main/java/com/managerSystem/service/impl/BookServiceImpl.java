package com.managerSystem.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.managerSystem.dao.BookDao;
import com.managerSystem.dao.TreeDao;
import com.managerSystem.entity.Book;
import com.managerSystem.service.BookService;


@Service("bookService")
public class BookServiceImpl implements BookService {
	
	

	@Resource
	private BookDao  bookDao;
	
	
	@Override
	public Integer add(Book book) {
		// TODO Auto-generated method stub
		return bookDao.add(book);
	}

	@Override
	public Integer update(Book book) {
		// TODO Auto-generated method stub
		return bookDao.update(book);
	}

	@Override
	public List<Book> list(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return bookDao.list(map);
	}

	@Override
	public Integer getTotal(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return bookDao.getTotal(map);
	}

	@Override
	public Book findById(Integer id) {
		// TODO Auto-generated method stub
		return bookDao.findById(id);
	}

	@Override
	public Integer delete(Integer id) {
		// TODO Auto-generated method stub
		return bookDao.delete(id);
	}

}
