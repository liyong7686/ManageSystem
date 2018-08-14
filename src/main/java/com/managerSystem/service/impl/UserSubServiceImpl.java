package com.managerSystem.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.managerSystem.dao.UserDao;
import com.managerSystem.dao.UserSubDao;
import com.managerSystem.entity.UserSub;
import com.managerSystem.service.UserSubService;



@Service("userSubService")
public class UserSubServiceImpl implements UserSubService {
	

	@Resource
	private UserSubDao  userSubDao;
		
	@Override
	public Integer add(UserSub userSub) {
		// TODO Auto-generated method stub
		return userSubDao.add(userSub);
	}

	@Override
	public Integer update(UserSub userSub) {
		// TODO Auto-generated method stub
		return userSubDao.update(userSub);
	}

	@Override
	public List<UserSub> list(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return userSubDao.list(map);
	}

	@Override
	public Integer getTotal(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return userSubDao.getTotal(map);
	}

	@Override
	public UserSub findById(Integer id) {
		// TODO Auto-generated method stub
		return userSubDao.findById(id);
	}
	
	@Override
	public Integer delete(Integer id) {
		// TODO Auto-generated method stub
		return userSubDao.delete(id);
	}
	
	
}
