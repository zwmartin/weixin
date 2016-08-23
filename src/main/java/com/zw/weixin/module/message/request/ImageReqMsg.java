package com.zw.weixin.module.message.request;

/**
 * 请求消息->图片消息
 * 
 * @author martin_zou
 * @version 创建时间：2016年8月10日
 */
public class ImageReqMsg extends BaseReqMsg {

	/** 图片链接（由系统生成） */
	private String PicUrl;
	/** 图片消息媒体id，可以调用多媒体文件下载接口拉取数据。 */
	private String MediaId;

	public String getPicUrl() {
		return PicUrl;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

}
