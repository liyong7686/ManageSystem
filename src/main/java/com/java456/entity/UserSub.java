package com.java456.entity;

import java.util.Date;

/**
 * ���߽�����Ϣ��
 * @author Administrator
 * ��Ҫ�ֶ��У����ߺš�����������ͼ���š��������ڡ��黹����
 * Ҫ�󣺽���ͼ��ʱ�����Զ����ĸ���������������󣬽������������Զ����� 
 */
public class UserSub {
	
	private Integer id;
	private Integer userId;
	private Integer bookId;
	private Date subDateTime;//����ʱ�� 
	private Date returnDateTime;//�黹 ʱ�� 
	private Integer type;//1δ�� 2�ѻ�
	
	
	//////////////////
	private User user;
	private Book book;
	//////////////////
	
	
	public Integer getId() {
		return id;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public Date getSubDateTime() {
		return subDateTime;
	}
	public void setSubDateTime(Date subDateTime) {
		this.subDateTime = subDateTime;
	}
	public Date getReturnDateTime() {
		return returnDateTime;
	}
	public void setReturnDateTime(Date returnDateTime) {
		this.returnDateTime = returnDateTime;
	}
	
	
	
	
	
}
