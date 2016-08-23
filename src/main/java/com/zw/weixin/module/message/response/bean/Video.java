package com.zw.weixin.module.message.response.bean;

/**
 * 响应视频消息 Video类
 * 
 * @author martin_zou
 * @version 创建时间：2016年8月10日
 */
public class Video {

	/** 通过素材管理中的接口上传多媒体文件，得到的id。 */
	private String MediaId;
	/** 视频消息的标题 */
	private String Title;
	/** 视频消息的描述 */
	private String Description;

	public String getMediaId() {
		return MediaId;
	}

	public String getTitle() {
		return Title;
	}

	public String getDescription() {
		return Description;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public void setDescription(String description) {
		Description = description;
	}

}
