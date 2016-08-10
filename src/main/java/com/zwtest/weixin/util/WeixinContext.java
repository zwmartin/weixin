package com.zwtest.weixin.util;

import org.springframework.stereotype.Component;

/**
 * 存放微信ACCESS_TOKEN
 * 
 * @author Administrator
 *
 */
@Component
public class WeixinContext {
	private static String ACCESS_TOKEN;

	public void setAccessToken(String accessToken) {
		ACCESS_TOKEN = accessToken;
	}

	public String getAccessToken() {
		return ACCESS_TOKEN;
	}
}
