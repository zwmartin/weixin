package com.zw.weixin.module.message;

/**
 * 事件类型
 * 
 * @author martin_zou
 * @version 创建时间：2016年8月10日
 */
public enum EventTypeEnum {
	SUBSCRIBE("subscribe", "订阅"), //
	UNSUBSCRIBE("unsubscribe", "取消订阅"), //
	SCAN("SCAN", "扫描二维码"), //
	LOCATION("LOCATION", "上报地理位置"), //
	CLICK("CLICK", "点击菜单"), //
	VIEW("VIEW", "点击菜单跳转链接");

	private String name;
	private String description;

	EventTypeEnum(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public EventTypeEnum getByName(String name) {
		for (EventTypeEnum msgTypeEnum : EventTypeEnum.values()) {
			if (msgTypeEnum.getName().equals(name)) {
				return msgTypeEnum;
			}
		}
		return null;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
