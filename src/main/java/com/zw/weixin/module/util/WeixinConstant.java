package com.zw.weixin.module.util;


/**
 * 微信常量类
 * 
 * @author martin_zou
 * @version 创建时间：2016年8月10日
 */
public class WeixinConstant {

	/** 刷新access——token URL */
	public static String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

	/** 建立菜单URl */
	public static final String MENU_ADDRESS = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

}
