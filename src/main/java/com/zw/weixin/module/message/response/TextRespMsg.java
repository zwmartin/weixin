package com.zw.weixin.module.message.response;

import com.zw.weixin.module.message.BaseMsg;

/**
 * 响应消息->文本消息
 * 
 * @author martin_zou
 * @version 创建时间：2016年8月10日
 */
public class TextRespMsg extends BaseMsg {
	
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}
	
}
