package com.managerSystem.quartz;


import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.managerSystem.service.ConfigService;
import com.managerSystem.service.PublicService;



@Component
public class Task {
	
	/*
	@Scheduled(cron="* * * * ?") ÿ��ִ��һ��
	@Scheduled(cron="0 * * * * ?") ÿ��ִ��һ��
	@Scheduled(cron="0 0 * * * ?") ÿʱִ��һ��
	@Scheduled(cron="0 0 0 * * ?") ÿ��ִ��һ��
	@Scheduled(cron="0 0 10,11,14,16  *  *  ?") ÿ������10�㣬����2�㣬4��
	*/
	
	@Resource
	private PublicService publicService;
	@Resource
	private ConfigService configService;
	
	
	/**
	 * ÿ1Сʱˢ��һ�� ΢�Ź��ںŵ�token ��js ����� ticket
	 */
	@Scheduled(cron="0/20 * * * * ?")
	public void weixin_token_task() {
		Object obj = publicService.refreshToken();
		Logger logg=Logger.getLogger(this.getClass());
		//logg.info("-" + obj.toString());
		System.out.println("111-------------111111111111111111111111111111111111111111111");
	}
	
	/**
	 * ÿ1Сʱˢ��һ�� ΢�Ź��ںŵ�token ��js ����� ticket
	 */
	@Scheduled(cron="30 * * * * ?")
	public void weixin_token_task2() {
		System.out.println("2222--------------2");
	}
	
}
