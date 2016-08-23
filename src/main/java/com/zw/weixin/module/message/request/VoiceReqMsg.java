package com.zw.weixin.module.message.request;

/**
 * 请求消息->语音消息
 * 
 * @author martin_zou
 * @version 创建时间：2016年8月10日
 */
public class VoiceReqMsg extends BaseReqMsg {
	/** 媒体ID */
	private String MediaId;
	/** 语音格式，如amr，speex等 */
	private String Format;

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public String getFormat() {
		return Format;
	}

	public void setFormat(String format) {
		Format = format;
	}
}
