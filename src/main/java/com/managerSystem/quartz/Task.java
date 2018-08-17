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
	@Scheduled(cron="* * * * ?") 每秒执行一次
	@Scheduled(cron="0 * * * * ?") 每分执行一次
	@Scheduled(cron="0 0 * * * ?") 每时执行一次
	@Scheduled(cron="0 0 0 * * ?") 每天执行一次
	@Scheduled(cron="0 0 10,11,14,16  *  *  ?") 每天上午10点，下午2点，4点
	*/
	
	@Resource
	private PublicService publicService;
	@Resource
	private ConfigService configService;
	
	
	/**
	 * 每1小时刷新一次 微信公众号的token 和js 分享的 ticket
	 */
	@Scheduled(cron="0/20 * * * * ?")
	public void weixin_token_task() {
		Object obj = publicService.refreshToken();
		Logger logg=Logger.getLogger(this.getClass());
		//logg.info("-" + obj.toString());
		System.out.println("111-------------111111111111111111111111111111111111111111111");
	}
	
	/**
	 * 每1小时刷新一次 微信公众号的token 和js 分享的 ticket
	 */
	@Scheduled(cron="30 * * * * ?")
	public void weixin_token_task2() {
		System.out.println("2222--------------2");
	}
	
}
