package com.managerSystem.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.managerSystem.dao.ClientDao;
import com.managerSystem.entity.Client;
import com.managerSystem.service.ClientService;


@Service("clientService")
public class ClientServiceImpl implements ClientService {

	@Resource
	private ClientDao clientDao;
	
	
	public Integer add(Client client) {
		return clientDao.add(client);
	}

	public Integer update(Client client) {
		return clientDao.update(client);
	}

	public List<Client> list(Map<String, Object> map) {
		return clientDao.list(map);
	}

	public Integer getTotal(Map<String, Object> map) {
		return clientDao.getTotal(map);
	}
	
	public Client list_heji(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return clientDao.list_heji(map);
	}
	
	public Client findById(Integer id) {
		return clientDao.findById(id);
	}

	public Integer delete(Integer id) {
		return clientDao.delete(id);
	}
	
	public Client findByWXUserId(Integer wxId) {
		return clientDao.findByWXUserId(wxId);
	}
	
	public Client finbByOpenid(String openid) {
		return clientDao.finbByOpenid(openid);
	}

	

}