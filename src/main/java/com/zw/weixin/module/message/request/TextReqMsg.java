package com.zw.weixin.module.message.request;

/**
 * 请求消息之文本消息
 * 
 * @author martin_zou
 * @version 创建时间：2016年8月10日
 */
public class TextReqMsg extends BaseReqMsg {
	// 消息内容
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}
}
