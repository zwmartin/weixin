package com.zw.weixin.module.message.request;

/**
 * 请求消息->地理位置信息
 * 
 * @author martin_zou
 * @version 创建时间：2016年8月10日
 */
public class LocationReqMsg extends BaseReqMsg {

	/** 地理位置维度 */
	private String Location_X;
	/** 地理位置经度 */
	private String Location_Y;
	/** 地图缩放大小 */
	private int Scale;
	/** 地理位置信息 */
	private String Label;

	public String getLocation_X() {
		return Location_X;
	}

	public String getLocation_Y() {
		return Location_Y;
	}

	public int getScale() {
		return Scale;
	}

	public String getLabel() {
		return Label;
	}

	public void setLocation_X(String location_X) {
		Location_X = location_X;
	}

	public void setLocation_Y(String location_Y) {
		Location_Y = location_Y;
	}

	public void setScale(int scale) {
		Scale = scale;
	}

	public void setLabel(String label) {
		Label = label;
	}

}
