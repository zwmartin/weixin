package com.zw.weixin.base;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletResponse;

/**
 * BaseController
 * 
 * @author Administrator
 * @since 2016-06-01
 *
 */
public class BaseController extends BaseLogger {

	/**
	 * д��str����ҳ��
	 * 
	 * @param response
	 * @param str
	 * @throws Exception
	 */
	public void write(HttpServletResponse response, String str) {
		Writer writer = null;
		try {
			writer = response.getWriter();
			writer.write(str);
			writer.flush();
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					logger.error(e.getMessage());
				}
			}
		}
	}

}
