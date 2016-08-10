package com.zwtest.weixin.http;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 处理HTTP请求 GET POST方式帮助类
 * 
 * @author martin_zou
 * @version 创建时间：2016年8月10日
 */
public class HttpHandlerHelper {

	public static final Logger logger = LoggerFactory.getLogger(HttpHandlerHelper.class);

	/**
	 * 发送GET方式
	 * 
	 * @param url
	 * @return
	 */
	public static String doGet(String url) {
		CloseableHttpClient httpClient = null;
		HttpGet get = null;
		CloseableHttpResponse response = null;
		String result = null;
		try {
			httpClient = HttpClients.createDefault();
			get = new HttpGet(url);
			response = httpClient.execute(get);
			int code = response.getStatusLine().getStatusCode();
			if (code >= 200 && code < 300) {
				HttpEntity entity = response.getEntity();
				result = EntityUtils.toString(entity);
			}
		} catch (Exception e) {
			logger.error("发送GET消息期间发生错误", e);
		} finally {
			if (response != null) {
				try {
					response.close();
				} catch (IOException e) {
					logger.error(e.getMessage());
				}
			}
			if (httpClient != null) {
				try {
					httpClient.close();
				} catch (IOException e) {
					logger.error(e.getMessage());
				}
			}
		}
		return result;
	}

	/**
	 * POST消息
	 * 
	 * @param url
	 * @param msg
	 *            post消息内容体
	 * @param contentType
	 *            内容格式型如：application/json application/xml
	 * @return
	 */
	public static String doPost(String url, String msg, String contentType) {
		CloseableHttpClient httpClient = null;
		HttpPost post = null;
		CloseableHttpResponse response = null;
		String result = null;
		try {
			httpClient = HttpClients.createDefault();
			post = new HttpPost(url);
			post.addHeader("content-type", contentType);
			StringEntity msgEntity = new StringEntity(msg, ContentType.create(contentType, "utf-8"));
			post.setEntity(msgEntity);
			response = httpClient.execute(post);
			int status = response.getStatusLine().getStatusCode();
			if (status >= 200 && status < 300) {
				HttpEntity entity = response.getEntity();
				result = EntityUtils.toString(entity);
			}
		} catch (Exception e) {
			logger.error("处理POST消息期间发生错误", e);
		} finally {
			if (response != null) {
				try {
					response.close();
				} catch (IOException e) {
					logger.error(e.getMessage());
				}
			}
			if (httpClient != null) {
				try {
					httpClient.close();
				} catch (IOException e) {
					logger.error(e.getMessage());
				}
			}
		}
		return result;
	}
}
