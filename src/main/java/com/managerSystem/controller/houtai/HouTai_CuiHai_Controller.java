package com.managerSystem.controller.houtai;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.managerSystem.entity.Book;
import com.managerSystem.entity.CuiHai;
import com.managerSystem.entity.PageBean;
import com.managerSystem.entity.Result;
import com.managerSystem.entity.User;
import com.managerSystem.service.CuiHaiService;
import com.managerSystem.util.ResponseUtil;
import com.managerSystem.util.StringUtil;

@Controller
@RequestMapping("/houtai/cuihai")
public class HouTai_CuiHai_Controller {
	
	@Resource
	private CuiHaiService cuiHaiService;
	
	
	/**
	 * /houtai/cuihai/manage
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/manage")
	public ModelAndView manage(@RequestParam(value = "isUser", required = false) String isUser) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("table_url", "/admin/cuihai/list");
		mav.setViewName("/admin/page/cuihai/cuihai_manage");
		return mav;
	}
	
	
	/**
	 * /houtai/cuihai/my
	 * 我的催还记录
	 */
	@RequestMapping("/my")
	public ModelAndView my(@RequestParam(value = "isUser", required = false) String isUser) throws Exception {
		ModelAndView mav = new ModelAndView();
		User user = (User) SecurityUtils.getSubject().getSession().getAttribute("currentUser");
		mav.addObject("table_url", "/admin/cuihai/list?userId="+user.getId());
		mav.setViewName("/admin/page/cuihai/my_cuihai_manage");
		return mav;
	}
	
	
	
	
}
