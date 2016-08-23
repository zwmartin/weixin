package com.zw.weixin.module.message.response;

import com.zw.weixin.module.message.BaseMsg;
import com.zw.weixin.module.message.response.bean.Voice;

/**
 * 响应消息->语音消息
 * 
 * @author martin_zou
 * @version 创建时间：2016年8月10日
 */
public class VoiceRespMsg extends BaseMsg {
	
	private Voice Voice;

	public Voice getVoice() {
		return Voice;
	}

	public void setVoice(Voice voice) {
		Voice = voice;
	}
	
}
