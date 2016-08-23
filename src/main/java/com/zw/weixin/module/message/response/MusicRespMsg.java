package com.zw.weixin.module.message.response;

import com.zw.weixin.module.message.BaseMsg;
import com.zw.weixin.module.message.response.bean.Music;

/**
 * 响应消息->音乐消息
 * 
 * @author martin_zou
 * @version 创建时间：2016年8月10日
 */
public class MusicRespMsg extends BaseMsg {
	
	private Music Music;

	public Music getMusic() {
		return Music;
	}

	public void setMusic(Music music) {
		Music = music;
	}
	
}
