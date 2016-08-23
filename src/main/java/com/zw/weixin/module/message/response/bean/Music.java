package com.zw.weixin.module.message.response.bean;

/**
 * 响应音乐消息 Music类
 * 
 * @author martin_zou
 * @version 创建时间：2016年8月10日
 */
public class Music {

	/** 音乐标题 */
	private String Title;
	/** 音乐描述 */
	private String Description;
	/** 音乐链接 */
	private String MusicUrl;
	/** 高质量音乐链接，WIFI环境优先使用该链接播放音乐 */
	private String HQMusicUrl;
	/** 缩略图的媒体id，通过素材管理中的接口上传多媒体文件，得到的id */
	private String ThumbMediaId;

	public String getTitle() {
		return Title;
	}

	public String getDescription() {
		return Description;
	}

	public String getMusicUrl() {
		return MusicUrl;
	}

	public String getHQMusicUrl() {
		return HQMusicUrl;
	}

	public String getThumbMediaId() {
		return ThumbMediaId;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public void setMusicUrl(String musicUrl) {
		MusicUrl = musicUrl;
	}

	public void setHQMusicUrl(String hQMusicUrl) {
		HQMusicUrl = hQMusicUrl;
	}

	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}

}
