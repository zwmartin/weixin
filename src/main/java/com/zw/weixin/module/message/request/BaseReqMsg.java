package com.zw.weixin.module.message.request;

import com.zw.weixin.module.message.BaseMsg;

/**
 * 请求消息基类
 * 
 * @author martin_zou
 * @version 创建时间：2016年8月10日
 */
public class BaseReqMsg extends BaseMsg {

	/** 消息id，64位整型 */
	private long MsgId;

	public long getMsgId() {
		return MsgId;
	}

	public void setMsgId(long msgId) {
		MsgId = msgId;
	}

}
