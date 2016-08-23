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

	/** 微信接入TOKEN */
	private String TOKEN;
	/** 微信测试公众号APPID */
	private String APPID;
	/** 微信测试公众号AppSecret */
	private String APPSECRET;

	public void setAccessToken(String accessToken) {
		this.access_Token = accessToken;
	}

	public String getAccessToken() {
		return access_Token;
	}

	public String getAccess_Token() {
		return access_Token;
	}

	public void setAccess_Token(String access_Token) {
		this.access_Token = access_Token;
	}

	public String getTOKEN() {
		return TOKEN;
	}

	public void setTOKEN(String tOKEN) {
		TOKEN = tOKEN;
	}

	public String getAPPID() {
		return APPID;
	}

	public void setAPPID(String aPPID) {
		APPID = aPPID;
	}

	public String getAPPSECRET() {
		return APPSECRET;
	}

	public void setAPPSECRET(String aPPSECRET) {
		APPSECRET = aPPSECRET;
	}
}
