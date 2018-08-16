package com.managerSystem.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.managerSystem.util.SignUtil;

@Controller
@RequestMapping("/weixin")
public class WeiXinContrller {

	@ResponseBody
    @RequestMapping("/check")
	public String check(HttpServletResponse response,HttpServletRequest request)throws Exception{
		
		System.out.println("微信验证程序。。。。");
		
		// 微信加密签名
        String signature = request.getParameter("signature");
        // 时间戳
        String timestamp = request.getParameter("timestamp");
        // 随机数
        String nonce = request.getParameter("nonce");
        // 随机字符串
        String echostr = request.getParameter("echostr");

        
        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
        if (SignUtil.checkSignature(signature, timestamp, nonce)) {
            return echostr;
        } else{
            return "fail";
        }
	}
}
