package com.java456.entity;

import java.util.Date;

/**
 * ͼ��߻���Ϣ��
 * @author Administrator
 * ���ߺš����������������ۡ��������ڣ���ͼ������Ϣ���Ͷ��߽�����Ϣ���Զ�����ͼ��߻���Ϣ����������ʱ�䳬��2������߻����� 
 * 
 */
public class CuiHai {
	
	private Integer id;
	private Integer userSubId;//���ļ�¼id
	private Integer jieyuerenId;//������id
	private Integer bookId;//����id
	private Date createDateTime;//�߻�����ʱ�� 
	
	//////////////////////
	private UserSub userSub;//���ļ�¼
	private User jieyueren;//������
	private Book book;//�����
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
