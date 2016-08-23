package com.zw.weixin.module.message.response.bean;

/**
 * 响应语音消息 Voice类
 * 
 * @author martin_zou
 * @version 创建时间：2016年8月10日
 */
public class Voice {
	
	/** 通过素材管理中的接口上传多媒体文件，得到的id。 */
	private String MediaId;

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
}
