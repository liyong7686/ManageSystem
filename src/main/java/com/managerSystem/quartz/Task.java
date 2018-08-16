package com.managerSystem.quartz;


import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.managerSystem.service.ConfigService;
import com.managerSystem.service.PublicService;



@Component
public class Task {
	
	/*
	@Scheduled(cron="* * * * * ?") ÿ��ִ��һ��
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
	@Scheduled(cron="* * * * * ?")
	public void weixin_token_task() {
		System.out.println("111");
	}
	
	/**
	 * ÿ1Сʱˢ��һ�� ΢�Ź��ںŵ�token ��js ����� ticket
	 */
	@Scheduled(cron="0 * * * * ?")
	public void weixin_token_task2() {
		System.out.println("22222");
	}
	
}
