package com.zw.weixin.controller;

import java.io.InputStream;
import java.util.Arrays;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zw.weixin.base.BaseController;
import com.zw.weixin.module.bean.WeiXinAccess;
import com.zw.weixin.module.message.MsgCenter;
import com.zw.weixin.util.CodeUtil;
import com.zw.weixin.util.WeixinContext;

/**
 * WeixinController
 * 
 * @author martin_zou
 * @version 创建时间：2016年8月10日
 */
@Controller
@RequestMapping("/wx")
public class WeixinController extends BaseController {
	
	@Resource
	private MsgCenter msgCenter;
	
	@Resource
	private WeixinContext weixinContext;
	
	/**
	 * 微信接入
	 * 
	 * @param request
	 * @param reponse
	 * @throws Exception
	 */
	@RequestMapping(value = "/access", method = RequestMethod.GET)
	public void access(HttpServletRequest request, HttpServletResponse response, WeiXinAccess access) throws Exception {
		String[] arrs = { access.getTimestamp(), weixinContext.getTOKEN(), access.getNonce() };
		Arrays.sort(arrs);
		StringBuffer str = new StringBuffer();
		for (String s : arrs) {
			str.append(s);
		}
		String sha1 = CodeUtil.encodeSha1(str.toString());
		if (access.getSignature().equals(sha1)) {
			write(response, access.getEchostr());
		}

	}

	/**
	 * 处理微信消息
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/access", method = RequestMethod.POST)
	public void handleMessage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		setCharacterEncoding(request, response);
		InputStream is = request.getInputStream();
		SAXReader saxReader = new SAXReader();
		Document document = saxReader.read(is);
		String respContent = msgCenter.handlerReq(document);
		write(response, respContent);
		close(is);
	}
}
