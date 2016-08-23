package weixin;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;
import com.zw.weixin.module.bean.AccessToken;

public class TestHttpClient {

	public static void main(String[] args) throws Exception {
		CloseableHttpClient client = null;
		HttpGet get = null;
		CloseableHttpResponse resp = null;
		try {
			client = HttpClients.createDefault();
			get = new HttpGet("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wxc145a3c01ede0c79&secret=081c1be1eea408ff9974bed3627f28a9");
			resp = client.execute(get);
			int status = resp.getStatusLine().getStatusCode();
			if(status >= 200 && status < 300) {
				HttpEntity entity = resp.getEntity();
				String content = EntityUtils.toString(entity);
				System.out.println(content);
				AccessToken accessToken = (AccessToken) JSONObject.parseObject(content, AccessToken.class);
				System.out.println(accessToken.getAccess_token());
				
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (resp != null) {
				resp.close();
			}
			if (client != null) {
				client.close();
			}
		}

	}

}
