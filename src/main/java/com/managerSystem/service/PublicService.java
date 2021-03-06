package com.managerSystem.service;

import java.util.Map;

import org.springframework.web.servlet.ModelAndView;


import net.sf.json.JSONObject;

public interface PublicService {
	
	/**
	 * 
	 * @param 添加mav.addObject("leftPage", "/admin/common/left_menu.jsp");
	 * @param 以及添加leftmenu 的内容
	 * @param mav
	 */
	public void addLeftMenu(ModelAndView mav);
		
	public JSONObject refreshToken(); 
	
	public JSONObject refreshTicket(); 
}
