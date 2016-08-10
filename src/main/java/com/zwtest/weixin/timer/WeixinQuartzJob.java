package com.zwtest.weixin.timer;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

/**
 * 刷新access_token定时器
 * 
 * @author Administrator
 *
 */
@Component
public class WeixinQuartzJob {
	@Resource
	private RefreshAccessToken refreshAccessToken;

	public void run() {
		refreshAccessToken.refreshAccessToken();
	}

}
