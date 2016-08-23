package com.zw.weixin.module.util;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 微信常量类
 * 
 * @author martin_zou
 * @version 创建时间：2016年8月10日
 */
public class WeixinConstant {

	private static final Logger logger = LoggerFactory.getLogger(WeixinConstant.class);

	static {
		Properties pro = new Properties();
		try {
			pro.load(WeixinConstant.class.getClassLoader().getResourceAsStream("config.properties"));
			String env = pro.getProperty("environment");

			// 开发环境
			if (env.equals("dev")) {
				TOKEN = pro.getProperty("DEV_TOKEN");
				APPID = pro.getProperty("DEV_APPID");
				APPSECRET = pro.getProperty("DEV_APPSECRET");
			} else {
				//生产环境
				TOKEN = pro.getProperty("PRO_TOKEN");
				APPID = pro.getProperty("PRO_APPID");
				APPSECRET = pro.getProperty("PRO_APPSECRET");
			}
		} catch (IOException e) {
			logger.error("加载config.properties发生错误");
		}
	}

	/** 微信接入TOKEN */
	public static String TOKEN;
	/** 微信测试公众号APPID */
	public static String APPID;
	/** 微信测试公众号AppSecret */
	public static String APPSECRET;

	/** 刷新access——token URL */
	public static String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
			+ APPID + "&secret=" + APPSECRET;

	/** 建立菜单URl */
	public static final String MENU_ADDRESS = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

}
