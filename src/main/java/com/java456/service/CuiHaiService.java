package com.java456.service;

import java.util.List;
import java.util.Map;

import com.java456.entity.CuiHai;

public interface CuiHaiService {
	
	public Integer add(CuiHai cuihai);
	
	public Integer update(CuiHai cuihai);
	
	public List<CuiHai> list(Map<String,Object> map);
	
	public  Integer getTotal(Map<String,Object> map);
	
	public CuiHai findById(Integer id);
	
	public Integer delete(Integer id);
	
	public CuiHai findBySubId(Integer subId);
	
	public Integer deleteBySubId(Integer subId);
	
}

