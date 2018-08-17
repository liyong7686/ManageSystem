package com.managerSystem.util;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.log4j.Logger;

import com.managerSystem.http.HttpClient;

import net.sf.json.JSONObject;

public class WeiXinUntil {
	// 应用id
	public static final String appid = "wx8ec32c26063c4f47";
	// 第三方用户唯一凭证密钥
	public static final String appSecret = "18fb466a8232cb8b1ce9acc8eaad9d9e";

	// 获取access_token的接口地址（GET） 限200（次/天）
	public final static String access_token_url = "https://api.weixin.qq.com/cgi-bin/token";    
	//获取token信息
	public static JSONObject refreshToken(){
		String requestUrl = "grant_type=client_credential&appid=APPID&secret=APPSECRET".replace("APPID", appid).replace("APPSECRET", appSecret);
		try {
			
			System.out.println("insert...：" + requestUrl);
			String retusnStr = HttpClient.httpPost(access_token_url,requestUrl);
			
			System.out.println("------");
			System.out.println(retusnStr);
			
			Logger logg = Logger.getLogger(Logger.class);
			logg.info("insert...：" + requestUrl);
			logg.info("out...：" + retusnStr);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
