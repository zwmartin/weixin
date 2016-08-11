package com.zw.weixin.util;

import org.springframework.stereotype.Component;

/**
 * 存放微信ACCESS_TOKEN
 * 
 * @author Administrator
 *
 */
@Component
public class WeixinContext {
	private String access_Token;

	public void setAccessToken(String accessToken) {
		this.access_Token = accessToken;
	}

	public String getAccessToken() {
		return access_Token;
	}
}
