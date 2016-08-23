package com.zw.weixin.module.message;

/**
 * 微信消息类型enum
 * 
 * @author martin_zou
 * @version 创建时间：2016年8月10日
 */
public enum MsgTypeEnum {

	Text("text", "文本消息"), //
	IMAGE("image", "图片消息"), //
	VOICE("voice", "语音消息"), //
	VIDEO("video", "视频消息"), //
	SHORT_VIDEO("shortvideo", "小视频消息"), //
	LOCATION("location", "位置信息"), //
	LINK("link", "链接信息"), //
	EVENT("event", "事件信息"), //
	NEWS("news", "图文消息");

	private String name;
	private String description;

	MsgTypeEnum(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public MsgTypeEnum getByName(String name) {
		for (MsgTypeEnum msgTypeEnum : MsgTypeEnum.values()) {
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
