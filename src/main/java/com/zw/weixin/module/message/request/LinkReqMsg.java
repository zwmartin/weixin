package com.zw.weixin.module.message.request;

/**
 * 请求消息->链接消息
 * 
 * @author martin_zou
 * @version 创建时间：2016年8月10日
 */
public class LinkReqMsg extends BaseReqMsg {
	
	/** 消息标题  */
	private String Title;
	/** 消息描述  */
	private String Description;
	/** 消息链接 */
	private String Url;
	
	public String getTitle() {
		return Title;
	}
	
	public String getDescription() {
		return Description;
	}
	
	public String getUrl() {
		return Url;
	}
	
	public void setTitle(String title) {
		Title = title;
	}
	
	public void setDescription(String description) {
		Description = description;
	}
	
	public void setUrl(String url) {
		Url = url;
	}
	
}
