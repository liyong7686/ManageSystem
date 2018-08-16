package com.managerSystem.util;

public class WeiXinUntil {
	// 应用id
	public static final String appid = "wx8ec32c26063c4f47";
	// 第三方用户唯一凭证密钥
	public static final String appSecret = "c42d427ef1b8b894febef2cfbdf3e7ad";

	// 获取access_token的接口地址（GET） 限200（次/天）
	public final static String access_token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

    

}
