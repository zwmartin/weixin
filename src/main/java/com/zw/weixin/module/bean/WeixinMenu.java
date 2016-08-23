package com.zw.weixin.module.bean;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 微信菜单
 * @author martin_zou
 * @version 创建时间：2016年8月10日
 */
public class WeixinMenu {

	private String type;
	private String name;
	private String key;
	private String url;
	private List<WeixinMenu> sub_button;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<WeixinMenu> getSub_button() {
		return sub_button;
	}

	public void setSub_button(List<WeixinMenu> sub_button) {
		this.sub_button = sub_button;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
