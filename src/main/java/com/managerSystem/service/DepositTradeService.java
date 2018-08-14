package com.managerSystem.service;

import java.util.List;
import java.util.Map;

import com.managerSystem.entity.DepositTrade;

public interface DepositTradeService {
	
	public Integer add(DepositTrade depositTrade);
	
	public Integer update(DepositTrade depositTrade);
	
	public List<DepositTrade> list(Map<String,Object> map);
	
	public Integer getTotal(Map<String,Object> map);
	
}
