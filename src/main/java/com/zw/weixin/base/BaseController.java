package com.zw.weixin.base;

import java.io.IOException;
import java.io.InputStream;
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
	 * 
	 * response写出
	 * 
	 * @param response
	 * @param str
	 * @throws Exception
	 */
	protected void write(HttpServletResponse response, String str) {
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
	
	protected void close(InputStream is) {
		if(is != null) {
			try {
				is.close();
			} catch (IOException e) {
				logger.error(e.getMessage());
			}
			is = null;
		}
	}

}
