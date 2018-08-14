package com.managerSystem.controller.admin;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.shiro.SecurityUtils;
import org.springframework.jdbc.support.incrementer.SybaseAnywhereMaxValueIncrementer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.managerSystem.entity.Book;
import com.managerSystem.entity.PageBean;
import com.managerSystem.entity.Result;
import com.managerSystem.entity.User;
import com.managerSystem.entity.UserSub;
import com.managerSystem.service.BookService;
import com.managerSystem.service.CuiHaiService;
import com.managerSystem.service.UserSubService;
import com.managerSystem.util.ResponseUtil;
import com.managerSystem.util.StringUtil;

@Controller
@RequestMapping("/admin/user/sub")
public class Admin_User_Sub__Controller {
	
	@Resource
	private UserSubService userSubService;
	@Resource
	private BookService  bookService;
	@Resource
	private CuiHaiService  cuiHaiService;
	
	/**
	 * /admin/user/sub/add
	 */
	@RequestMapping("/add")
	public String add(@RequestParam(value = "bookId", required = false) String bookId, HttpServletResponse response, HttpServletRequest request) throws Exception {
		
		Book book = bookService.findById(Integer.parseInt(bookId));
		Result result = new Result();
		Gson gson = new Gson();
		
		if(book.getKucun()==0){
			result.setSuccess(false);
			result.setMsg("此书库存不足,无法借阅");
			ResponseUtil.write(response, gson.toJson(result));
			return null;
		}
		
		User currentUser =	(User) SecurityUtils.getSubject().getSession().getAttribute("currentUser");
		UserSub sub = new UserSub();
		sub.setBookId(book.getId());
		sub.setSubDateTime(new Date());
		sub.setUserId(currentUser.getId());
		sub.setType(1);
		
		int resultTotal = userSubService.add(sub);
		
		if (resultTotal > 0) {
			book.setKucun(book.getKucun()-1);
			bookService.update(book);
			
			result.setSuccess(true);
			result.setMsg("借阅成功");
		} else {
			result.setSuccess(false);
			result.setMsg("借阅失败");
		}
		
		ResponseUtil.write(response, gson.toJson(result));
		return null;
	}
	
	/**
	 * /admin/user/sub/list
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "limit", required = false) String rows,
			@RequestParam(value = "date1", required = false) String date1, 
			@RequestParam(value = "date2", required = false) String date2, 
			@RequestParam(value = "userId", required = false) String userId, 
			HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		map.put("date1", date1);
		map.put("date2", date2);
		map.put("userId", userId);
		
		List<UserSub> list = userSubService.list(map);
		Integer total = userSubService.getTotal(map);
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
	 * /admin/user/sub/return_
	 */
	@RequestMapping("/return_")
	public String return_(@RequestParam(value = "subId", required = false) String subId, HttpServletResponse response, HttpServletRequest request) throws Exception {
		
		Result result = new Result();
		Gson gson = new Gson();
		
		UserSub sub = userSubService.findById(Integer.parseInt(subId));
		if(sub.getReturnDateTime()!=null){
			result.setSuccess(false);
			result.setMsg("已归还过了");
			ResponseUtil.write(response, gson.toJson(result));
			return null;
		}
		
		sub.setReturnDateTime(new Date());
		sub.setType(2);
		int resultTotal = userSubService.update(sub);
		
		if (resultTotal > 0) {
			Book book = bookService.findById(sub.getBookId());
			book.setKucun(book.getKucun()+1);
			bookService.update(book);
			
			//删除催还记录
			cuiHaiService.deleteBySubId(Integer.parseInt(subId));
			
			result.setSuccess(true);
			result.setMsg("归还成功");
		} else {
			result.setSuccess(false);
			result.setMsg("归还失败");
		}
		
		ResponseUtil.write(response, gson.toJson(result));
		return null;
	}
	
	
	
	
}
