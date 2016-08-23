package com.zw.weixin.module.message.response;

import com.zw.weixin.module.message.BaseMsg;
import com.zw.weixin.module.message.response.bean.Video;

/**
 * 响应消息->视频消息
 * 
 * @author martin_zou
 * @version 创建时间：2016年8月10日
 */
public class VideoRespMsg extends BaseMsg {
	
	private Video Video;

	public Video getVideo() {
		return Video;
	}

	public void setVideo(Video video) {
		Video = video;
	}
	
}
