package com.java456.entity;

import java.util.Date;

/**
 * 图书催还信息表单
 * @author Administrator
 * 读者号、姓名、书名、单价、借阅日期（由图书库存信息表单和读者借阅信息表单自动生成图书催还信息表单，凡借阅时间超过2个月则催还。） 
 * 
 */
public class CuiHai {
	
	private Integer id;
	private Integer userSubId;//借阅记录id
	private Integer jieyuerenId;//借阅人id
	private Integer bookId;//借书id
	private Date createDateTime;//催还创建时间 
	
	//////////////////////
	private UserSub userSub;//借阅记录
	private User jieyueren;//借阅人
	private Book book;//借的书
	//////////////////////
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserSubId() {
		return userSubId;
	}
	public void setUserSubId(Integer userSubId) {
		this.userSubId = userSubId;
	}
	public Integer getJieyuerenId() {
		return jieyuerenId;
	}
	public void setJieyuerenId(Integer jieyuerenId) {
		this.jieyuerenId = jieyuerenId;
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public Date getCreateDateTime() {
		return createDateTime;
	}
	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}
	public UserSub getUserSub() {
		return userSub;
	}
	public void setUserSub(UserSub userSub) {
		this.userSub = userSub;
	}
	public User getJieyueren() {
		return jieyueren;
	}
	public void setJieyueren(User jieyueren) {
		this.jieyueren = jieyueren;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
	
	
}
