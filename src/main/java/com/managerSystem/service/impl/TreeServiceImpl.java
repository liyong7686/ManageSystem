package com.managerSystem.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

import com.managerSystem.dao.TreeDao;
import com.managerSystem.entity.Tree;
import com.managerSystem.service.TreeService;

import javax.annotation.Resource;



@Service("treeService")
public class TreeServiceImpl implements TreeService {

	@Resource
	private TreeDao  treeDao;



	public Tree findById(Integer id) {
		return treeDao.findById(id);
	}
	
	

	public List<Tree> getTreesByFatherOrIds(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return treeDao.getTreesByFatherOrIds(map);
	}
 
	


	 
}
