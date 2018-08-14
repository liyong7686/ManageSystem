package com.managerSystem.service;

import com.managerSystem.entity.Config;

public interface ConfigService {
	
	public Integer update(Config config);
	
	public Config findById(Integer id);
	
}
