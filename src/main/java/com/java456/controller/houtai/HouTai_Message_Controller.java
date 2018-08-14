package com.java456.controller.houtai;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.java456.entity.Book;
import com.java456.entity.Message;
import com.java456.service.BookService;
import com.java456.service.MessageService;


@Controller
@RequestMapping("/houtai/message")
public class HouTai_Message_Controller {
	
	@Resource
	private MessageService messageService;
	
	
	/**
	 * /houtai/message/manage
	 */
	@RequestMapping("/manage")
	public ModelAndView manage() throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/admin/page/message/message_manage");
		return mav;
	}
	
	
	/**
	 * /houtai/message/my
	 */
	@RequestMapping("/my")
	public ModelAndView my() throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/admin/page/message/my_message_manage");
		return mav;
	}
	
	
	
	/**
	 * /houtai/message/add
	 */
	@RequestMapping("/add")
	public ModelAndView add() throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("btn_text", "Ìí¼Ó");
		mav.addObject("save_url", "/admin/message/add");
		mav.setViewName("/admin/page/message/add_or_update");
		return mav;
	}
	
	
	/**
	 * /houtai/message/edit?id=22
	 */
	@RequestMapping("/edit")
	public ModelAndView edit(@RequestParam(value="id",required=false)String id
			,HttpServletResponse response
			,HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		Message message = messageService.findById(Integer.parseInt(id));
		mav.addObject("message", message);
		mav.addObject("btn_text", "ÐÞ¸Ä");
		mav.addObject("save_url", "/admin/message/update?id="+id);
		mav.setViewName("/admin/page/message/add_or_update");
		return mav;
	}
}
