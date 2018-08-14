package com.java456.controller.houtai;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.java456.entity.Book;
import com.java456.service.BookService;


@Controller
@RequestMapping("/houtai/book")
public class HouTai_Book_Controller {
	
	@Resource
	private BookService bookService;
	
	/**
	 * /houtai/book/manage
	 */
	@RequestMapping("/manage")
	public ModelAndView manage() throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/admin/page/book/book_manage");
		return mav;
	}
	
	
	/**
	 * /houtai/book/add
	 */
	@RequestMapping("/add")
	public ModelAndView add() throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("btn_text", "���");
		mav.addObject("save_url", "/admin/book/add");
		mav.setViewName("/admin/page/book/add_or_update");
		return mav;
	}
	
	
	/**
	 * /houtai/book/edit?id=22
	 */
	@RequestMapping("/edit")
	public ModelAndView edit(@RequestParam(value="id",required=false)String id
			,HttpServletResponse response
			,HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		Book book = bookService.findById(Integer.parseInt(id));
		mav.addObject("book", book);
		mav.addObject("btn_text", "�޸�");
		mav.addObject("save_url", "/admin/book/update?id="+id);
		mav.setViewName("/admin/page/book/add_or_update");
		return mav;
	}
	
	
	
	
	
}
