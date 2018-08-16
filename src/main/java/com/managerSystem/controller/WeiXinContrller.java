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
		
		System.out.println("΢����֤���򡣡�����");
		
		// ΢�ż���ǩ��
        String signature = request.getParameter("signature");
        // ʱ���
        String timestamp = request.getParameter("timestamp");
        // �����
        String nonce = request.getParameter("nonce");
        // ����ַ���
        String echostr = request.getParameter("echostr");

        
        // ͨ������signature���������У�飬��У��ɹ���ԭ������echostr����ʾ����ɹ����������ʧ��
        if (SignUtil.checkSignature(signature, timestamp, nonce)) {
            return echostr;
        } else{
            return "fail";
        }
	}
}
