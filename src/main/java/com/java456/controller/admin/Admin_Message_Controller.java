package com.java456.controller.admin;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.java456.entity.Book;
import com.java456.entity.Message;
import com.java456.entity.PageBean;
import com.java456.entity.Result;
import com.java456.entity.User;
import com.java456.service.BookService;
import com.java456.service.MessageService;
import com.java456.util.ResponseUtil;
import com.java456.util.StringUtil;

@Controller
@RequestMapping("/admin/message")
public class Admin_Message_Controller {

	@Resource
	private MessageService messageService;
	
	/**
	 * /admin/message/add
	 */
	@RequestMapping("/add")
	public String add(Message msg  , HttpServletResponse response, HttpServletRequest request) throws Exception {
		User currentUser =	(User) SecurityUtils.getSubject().getSession().getAttribute("currentUser");
		msg.setUserId(currentUser.getId());
		msg.setCreateDateTime(new Date());
		
		int resultTotal = messageService.add(msg);
		Result result = new Result();
		Gson gson = new Gson();
		if (resultTotal > 0) {
			result.setSuccess(true);
			result.setMsg("��ӳɹ�");
		} else {
			result.setSuccess(false);
			result.setMsg("���ʧ��");
		}
		ResponseUtil.write(response, gson.toJson(result));
		return null;
	}
	
	
	
	/**
	 * /admin/message/list
	 * @param page
	 * @param rows
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "limit", required = false) String rows,
			@RequestParam(value = "q", required = false) String q, 
			HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		map.put("q", StringUtil.formatLike(q));
		List<Message> list = messageService.list(map);
		Integer total = messageService.getTotal(map);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm").create();
		map.clear();
		map.put("data", list);
		map.put("count", total);
		map.put("code", 0);
		map.put("msg", "");
		ResponseUtil.write(response, gson.toJson(map));
		return null;
	}
	
	
	/**
	 * /admin/message/delete
	 */
	@RequestMapping("/delete")
	public String delete(@RequestParam(value = "ids", required = false) String ids, HttpServletResponse response)
			throws Exception {
		String[] idsStr = ids.split(",");
		Gson gson = new Gson();
		Result result = new Result();
		for (int i = 0; i < idsStr.length; i++) {
			messageService.delete(Integer.parseInt(idsStr[i]));
		}
		result.setSuccess(true);
		ResponseUtil.write(response, gson.toJson(result));
		return null;
	}
	
}
