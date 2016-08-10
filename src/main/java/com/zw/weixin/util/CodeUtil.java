package com.zw.weixin.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 加密解密工具类
 * 
 * @author Administrator
 *
 */
public class CodeUtil {

	public static final Logger logger = LoggerFactory.getLogger(CodeUtil.class);

	/**
	 * sha1加密
	 * 
	 * @param str
	 * @return
	 */
	public static String encodeSha1(String str) {
		StringBuffer result = new StringBuffer();
		try {
			MessageDigest digest = MessageDigest.getInstance("sha1");
			digest.update(str.getBytes());
			byte[] msg = digest.digest();
			for (byte b : msg) {
				result.append(String.format("%02x", b));
			}
		} catch (NoSuchAlgorithmException e) {
			logger.error("加密sha1算法发生错误", e);
		}
		return result.toString();
	}
}
