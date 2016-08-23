package com.zw.weixin.module.message.response;

import com.zw.weixin.module.message.BaseMsg;
import com.zw.weixin.module.message.response.bean.Image;

/**
 * 响应消息->图片消息
 * 
 * @author martin_zou
 * @version 创建时间：2016年8月10日
 */
public class ImageRespMsg extends BaseMsg {
	
	private Image Image;

	public Image getImage() {
		return Image;
	}

	public void setImage(Image image) {
		Image = image;
	}
	
}
