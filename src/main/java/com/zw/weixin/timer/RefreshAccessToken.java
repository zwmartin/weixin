package com.zw.weixin.timer;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.zw.weixin.base.BaseLogger;
import com.zw.weixin.http.HttpHelper;
import com.zw.weixin.module.bean.AccessToken;
import com.zw.weixin.module.bean.ErrorMsg;
import com.zw.weixin.module.util.WeixinConstant;
import com.zw.weixin.util.WeixinContext;

@Component
public class RefreshAccessToken extends BaseLogger {

	@Resource
	private WeixinContext weixinContext;

	private int errorCount = 0;

	/**
	 * 刷新AccessToken
	 */
	public void refreshAccessToken() {
		logger.debug("正在刷新access_oken......");
		String accessTokenStr = HttpHelper.doGet(WeixinConstant.ACCESS_TOKEN_URL);
		AccessToken accessToken = JSONObject.parseObject(accessTokenStr, AccessToken.class);
		if (accessToken.getAccess_token() == null) {
			errorCount++;
			ErrorMsg errorMsg = JSONObject.parseObject(accessTokenStr, ErrorMsg.class);
			logger.error("AccessToken刷新发生错误, 错误消息为：" + errorMsg.getErrmsg());
			// 错误次数大于3次
			if (errorCount >= 3) {
				logger.error("刷新access_token错误次数过多,请检查配置!");
				errorCount = 0;
			} else {
				try {
					Thread.sleep(5000 + (errorCount - 1) * 1000);
				} catch (InterruptedException e) {
					logger.error(e.getMessage());
				}
				refreshAccessToken();
			}
		} else {
			logger.debug("access_oken刷新成功，结果为：" + accessToken.getAccess_token());
			weixinContext.setAccessToken(accessToken.getAccess_token());
		}

	}
}
