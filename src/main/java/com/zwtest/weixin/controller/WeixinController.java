package com.zwtest.weixin.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zwtest.weixin.base.BaseController;
import com.zwtest.weixin.module.util.WeixinConstant;
import com.zwtest.weixin.util.CodeUtils;

/**
 * WeixinController
 * 
 * @author martin_zou
 * @version 创建时间：2016年8月10日
 */
@Controller
public class WeixinController extends BaseController {
	/**
	 * 微信接入
	 * 
	 * @param request
	 * @param reponse
	 * @throws Exception
	 */
	@RequestMapping(value = "/wx", method = RequestMethod.GET)
	public void access(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");
		String[] arrs = { timestamp, WeixinConstant.TOKEN, nonce };
		Arrays.sort(arrs);
		StringBuffer str = new StringBuffer();
		for (String s : arrs) {
			str.append(s);
		}
		String sha1 = CodeUtils.encodeSha1(str.toString());
		if (signature.equals(sha1)) {
			write(response, echostr);
		}

	}

	/**
	 * 处理微信消息
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/wx", method = RequestMethod.POST)
	public void handleMessage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String str = null;
		while ((str = reader.readLine()) != null) {
			System.out.println(str);
		}
	}
}
