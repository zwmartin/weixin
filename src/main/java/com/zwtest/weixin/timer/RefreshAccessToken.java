package com.zwtest.weixin.timer;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.zwtest.weixin.base.BaseLogger;
import com.zwtest.weixin.http.HttpHandlerHelper;
import com.zwtest.weixin.module.bean.AccessToken;
import com.zwtest.weixin.module.bean.ErrorMsg;
import com.zwtest.weixin.module.util.WeixinConstant;
import com.zwtest.weixin.util.WeixinContext;

import net.sf.json.JSONObject;

@Component
public class RefreshAccessToken extends BaseLogger {
	
	@Resource
	private WeixinContext weixinContext;

	/**
	 * 刷新AccessToken
	 */
	public void refreshAccessToken() {
		logger.debug("正在刷新access_oken......");
		String accessTokenStr = HttpHandlerHelper.doGet(WeixinConstant.ACCESS_TOKEN_URL);
		try {
			AccessToken accessToken = (AccessToken) JSONObject.toBean(JSONObject.fromObject(accessTokenStr),
					AccessToken.class);
			logger.debug("access_oken刷新成功，结果为：" + accessToken.getAccess_token());
			weixinContext.setAccessToken(accessToken.getAccess_token());
		} catch (Exception e) {
			ErrorMsg errorMsg = (ErrorMsg) JSONObject.toBean(JSONObject.fromObject(accessTokenStr), ErrorMsg.class);
			logger.error("AccessToken刷新发生错误, 错误消息为：" + errorMsg.getErrmsg(), e);
			refreshAccessToken();
		}

	}
}
