package com.managerSystem.controller;


import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.google.gson.Gson;
import com.managerSystem.entity.Result;
import com.managerSystem.entity.User;
import com.managerSystem.service.PublicService;
import com.managerSystem.service.UserService;
import com.managerSystem.util.CryptographyUtil;
import com.managerSystem.util.ResponseUtil;


@Controller
@RequestMapping("/user")
public class UserController {
	
	
	@Resource
	private UserService  userService;
	@Resource
	private PublicService  publicService;
	
	
	/**
	 *   /user/add
	 */
	@RequestMapping("/add")
	public String add(User user, HttpServletResponse response, HttpServletRequest request) throws Exception {
		user.setPassword(CryptographyUtil.md5(user.getPassword(), "chenhao"));
		user.setCreateDateTime(new Date());
		user.setMenuIds("17,171000,171005,171009,171011,171010");
		int resultTotal = userService.add(user);
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
	 * /user/login
	 * ���Ե�½
	 */
	@RequestMapping("/login")
	public String login(User user,HttpServletResponse response,HttpServletRequest request
			,RedirectAttributes attr)throws Exception{
		Result result = new  Result();
		Gson gson = new Gson();
		Subject subject=SecurityUtils.getSubject();
		
		SecurityUtils.getSubject().getSession().setAttribute("login_type", "user_login");
		
		UsernamePasswordToken token=new UsernamePasswordToken(user.getNum_(), CryptographyUtil.md5(user.getPassword(), "chenhao"));
		
		try{
			subject.login(token); // ��¼��֤
			//�����½�ɹ� �Ͳ��ᱨ��  ������ǵ�½ʧ����
			user = userService.findByNum(user.getNum_());
			SecurityUtils.getSubject().getSession().setAttribute("currentUser", user); //�ѵ�ǰ�û���Ϣ�浽session��
			
			result.setSuccess(true);
			result.setMsg("��½�ɹ�");
			ResponseUtil.write(response, gson.toJson(result));
			return null;
		}catch(Exception e){
			e.printStackTrace();
			result.setSuccess(false);
			result.setMsg("�ʺŻ��������");
			ResponseUtil.write(response, gson.toJson(result));
			return null;
		}
	}
	
	/**
	 * /user/logout
	 * @throws Exception
	 */
	@RequestMapping("/logout")
	public String logout()throws Exception{
		SecurityUtils.getSubject().logout(); //shiro���˳�
		return "redirect:/login";
	}
	
	
}
