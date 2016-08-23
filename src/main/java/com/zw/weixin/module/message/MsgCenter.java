package com.zw.weixin.module.message;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.springframework.stereotype.Component;

import com.zw.weixin.module.message.response.NewsRespMsg;
import com.zw.weixin.module.message.response.TextRespMsg;
import com.zw.weixin.module.message.response.bean.Article;
import com.zw.weixin.module.util.MsgUtil;

/**
 * 微信消息处理中心
 * 
 * @author martin_zou
 * @version 创建时间：2016年8月10日
 */
@Component
public class MsgCenter {

	/**
	 * 处理请求消息
	 * 
	 * @return
	 */
	public String handlerReq(Document document) {
		// 默认返回的文本消息内容
		String respContent = "请求处理异常，请稍候尝试！";
		// xml请求解析
		Map<String, String> msgMap = MsgUtil.parseXML2Map(document);

		// 发送方帐号（open_id）
		String fromUserName = msgMap.get("FromUserName");
		// 公众帐号
		String toUserName = msgMap.get("ToUserName");
		// 消息类型
		String msgType = msgMap.get("MsgType");

		TextRespMsg respMsg = new TextRespMsg();

		respMsg.setToUserName(fromUserName);
		respMsg.setFromUserName(toUserName);
		respMsg.setCreateTime(new Date().getTime());
		respMsg.setMsgType(MsgTypeEnum.Text.getName());

		// 文本消息
		if (msgType.equals(MsgTypeEnum.Text.getName())) {
			respContent = "您发送的是文本消息！";
			String content = msgMap.get("Content");
			// 创建图文消息
			NewsRespMsg photoMsg = new NewsRespMsg();
			photoMsg.setToUserName(fromUserName);
			photoMsg.setFromUserName(toUserName);
			photoMsg.setCreateTime(new Date().getTime());
			photoMsg.setMsgType(MsgTypeEnum.NEWS.getName());
			List<Article> articleList = new ArrayList<Article>();
			// 多图文消息
			if ("1".equals(content)) {
				Article article1 = new Article();
				article1.setTitle("微信公众帐号开发教程\n引言");
				article1.setDescription("");
				article1.setPicUrl("http://0.xiaoqrobot.duapp.com/images/avatar_liufeng.jpg");
				article1.setUrl("http://blog.csdn.net/lyq8479/article/details/8937622");

				Article article2 = new Article();
				article2.setTitle("第2篇\n微信公众帐号的类型");
				article2.setDescription("");
				article2.setPicUrl("http://avatar.csdn.net/1/4/A/1_lyq8479.jpg");
				article2.setUrl("http://blog.csdn.net/lyq8479/article/details/8941577");

				Article article3 = new Article();
				article3.setTitle("第3篇\n开发模式启用及接口配置");
				article3.setDescription("");
				article3.setPicUrl("http://avatar.csdn.net/1/4/A/1_lyq8479.jpg");
				article3.setUrl("http://blog.csdn.net/lyq8479/article/details/8944988");

				articleList.add(article1);
				articleList.add(article2);
				articleList.add(article3);
				photoMsg.setArticleCount(articleList.size());
				photoMsg.setArticles(articleList);
			}
			return MsgUtil.parseMsg2XML(photoMsg);
		}
		// 图片消息
		else if (msgType.equals(MsgTypeEnum.IMAGE.getName())) {
			respContent = "您发送的是图片消息！";
		}
		// 地理位置消息
		else if (msgType.equals(MsgTypeEnum.LOCATION.getName())) {
			respContent = "您发送的是地理位置消息！";
		}
		// 链接消息
		else if (msgType.equals(MsgTypeEnum.LINK.getName())) {
			respContent = "您发送的是链接消息！";
		}
		// 音频消息
		else if (msgType.equals(MsgTypeEnum.VOICE.getName())) {
			respContent = "您发送的是音频消息！";
		}
		// 事件推送
		else if (msgType.equals(MsgTypeEnum.EVENT.getName())) {
			// 事件类型
			String eventType = msgMap.get("Event");
			// 订阅
			if (eventType.equals(EventTypeEnum.SUBSCRIBE.getName())) {
				respContent = "谢谢您的关注！";
			}
			// 取消订阅
			else if (eventType.equals(EventTypeEnum.UNSUBSCRIBE.getName())) {
				// TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
			}
			// 自定义菜单点击事件
			else if (eventType.equals(EventTypeEnum.CLICK.getName())) {
				// TODO 自定义菜单权没有开放，暂不处理该类消息
			}
		}
		respMsg.setContent(respContent);
		return MsgUtil.parseMsg2XML(respMsg);
	}

}
