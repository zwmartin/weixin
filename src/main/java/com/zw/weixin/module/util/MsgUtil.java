package com.zw.weixin.module.util;

import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import com.zw.weixin.module.message.BaseMsg;
import com.zw.weixin.module.message.response.NewsRespMsg;
import com.zw.weixin.module.message.response.bean.Article;

/**
 * 微信消息工具类
 * 
 * @author martin_zou
 * @version 创建时间：2016年8月10日
 */
@SuppressWarnings("unchecked")
public class MsgUtil {

	public static final Logger logger = LoggerFactory.getLogger(MsgUtil.class);

	/**
	 * XML转MAP
	 * 
	 * @param msg
	 * @return
	 */
	public static Map<String, String> parseXML2Map(Document document) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			// 得到xml根元素
			Element root = document.getRootElement();
			// 得到根元素的所有子节点
			List<Element> elementList = root.elements();
			// 遍历所有子节点
			for (Element e : elementList) {
				map.put(e.getName(), e.getText());
			}
		} catch (Exception e) {
			logger.error("XML转MAP发生错误，错误信息为:" + e.getMessage(), e);
		}
		return map;
	}

	/**
	 * 消息转XML
	 * 
	 * @param t
	 * @return
	 */
	public static <T> String parseMsg2XML(T t) {
		if (!(t instanceof BaseMsg)) {
			return null;
		}
		xstream.alias("xml", t.getClass());
		if (t instanceof NewsRespMsg) {
			xstream.alias("item", Article.class);
		}
		return xstream.toXML(t);
	}

	/**
	 * 扩展xstream，使其支持CDATA块
	 */
	private static XStream xstream = new XStream(new XppDriver() {
		@Override
		public HierarchicalStreamWriter createWriter(Writer out) {
			return new PrettyPrintWriter(out) {
				// 对所有xml节点的转换都增加CDATA标记
				boolean cdata = true;

				@Override
				protected void writeText(QuickWriter writer, String text) {
					if (cdata) {
						writer.write("<![CDATA[");
						writer.write(text);
						writer.write("]]>");
					} else {
						writer.write(text);
					}
				}
			};
		}
	});

}
