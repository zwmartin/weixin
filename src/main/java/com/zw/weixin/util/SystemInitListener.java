package com.zw.weixin.util;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 系统初始化监听器
 * 
 * @author martin_zou 2016年8月23日
 * 
 */
public class SystemInitListener implements ServletContextListener {
	Logger logger = LoggerFactory.getLogger(SystemInitListener.class);

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		WeixinContext weixinContext = SpringContextHolder.getBean("weixinContext");
		Properties pro = new Properties();
		try {
			pro.load(this.getClass().getClassLoader()
					.getResourceAsStream("config.properties"));
			String env = pro.getProperty("environment");

			// 开发环境
			if (env.equals("dev")) {
				weixinContext.setTOKEN(pro.getProperty("DEV_TOKEN"));
				weixinContext.setAPPID(pro.getProperty("DEV_APPID"));
				weixinContext.setAPPSECRET(pro.getProperty("DEV_APPSECRET"));
			} else {
				// 生产环境
				weixinContext.setTOKEN(pro.getProperty("PRO_TOKEN"));
				weixinContext.setAPPID(pro.getProperty("PRO_APPID"));
				weixinContext.setAPPSECRET(pro.getProperty("PRO_APPSECRET"));
			}
		} catch (IOException e) {
			logger.error("加载config.properties发生错误");
		}
	}

}
