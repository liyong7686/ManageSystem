package com.managerSystem.dao;

import com.managerSystem.entity.Config;

public interface ConfigDao {
	
	public Integer update(Config config);
	public Config findById(Integer id);
	
	
}
