package com.managerSystem.entity;

import java.util.Date;

public class Book {
	
	private Integer id;
	private String bianhao;//ͼ����
	private String name;//����
	private String banhao;//�������
	private String bianzhu;//������
	private String chubanshe;//������
	private Date chubanDate;//��������
	private String danjia;//����
	private Integer kucun;//������� 
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBianhao() {
		return bianhao;
	}
	public void setBianhao(String bianhao) {
		this.bianhao = bianhao;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBanhao() {
		return banhao;
	}
	public void setBanhao(String banhao) {
		this.banhao = banhao;
	}
	public String getBianzhu() {
		return bianzhu;
	}
	public void setBianzhu(String bianzhu) {
		this.bianzhu = bianzhu;
	}
	public String getChubanshe() {
		return chubanshe;
	}
	public void setChubanshe(String chubanshe) {
		this.chubanshe = chubanshe;
	}
	
	
	public Date getChubanDate() {
		return chubanDate;
	}
	public void setChubanDate(Date chubanDate) {
		this.chubanDate = chubanDate;
	}
	public String getDanjia() {
		return danjia;
	}
	public void setDanjia(String danjia) {
		this.danjia = danjia;
	}
	public Integer getKucun() {
		return kucun;
	}
	public void setKucun(Integer kucun) {
		this.kucun = kucun;
	}
	
	
	
	
}
