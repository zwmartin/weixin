package weixin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.zw.weixin.http.HttpHelper;
import com.zw.weixin.module.bean.AccessToken;
import com.zw.weixin.module.bean.WeixinMenu;
import com.zw.weixin.module.util.WeixinConstant;

import net.sf.json.JSONObject;

public class TestWeixin {

	private String accessToken;

	@Before
	public void setUp() {
		String result = HttpHelper.doGet(WeixinConstant.ACCESS_TOKEN_URL);
		AccessToken accessToken = (AccessToken) JSONObject.toBean(JSONObject.fromObject(result), AccessToken.class);
		this.accessToken = accessToken.getAccess_token();
	}

	public static void main(String[] args) {
		String result = HttpHelper.doGet(WeixinConstant.ACCESS_TOKEN_URL);
		System.out.println(result);
		AccessToken accessToken = (AccessToken) JSONObject.toBean(JSONObject.fromObject(result), AccessToken.class);
		System.out.println(accessToken.getAccess_token());
	}

	@Test
	public void testMenu() {
		List<WeixinMenu> menus = new ArrayList<WeixinMenu>();
		WeixinMenu m1 = new WeixinMenu();
		m1.setType("click");
		m1.setName("���ո���1");
		m1.setKey("001");

		WeixinMenu m2 = new WeixinMenu();
		m2.setName("�˵�1");

		WeixinMenu m2_1 = new WeixinMenu();
		m2_1.setType("view");
		m2_1.setName("����1");
		m2_1.setUrl("http://www.soso.com/");

		WeixinMenu m2_2 = new WeixinMenu();
		m2_2.setType("view");
		m2_2.setName("��Ƶ1");
		m2_2.setUrl("http://v.qq.com/");

		WeixinMenu m2_3 = new WeixinMenu();
		m2_3.setType("click");
		m2_3.setName("��һ������1");
		m2_3.setKey("002003");

		List<WeixinMenu> m2_childrens = new ArrayList<WeixinMenu>();
		m2_childrens.add(m2_1);
		m2_childrens.add(m2_2);
		m2_childrens.add(m2_3);
		m2.setSub_button(m2_childrens);
		menus.add(m1);
		menus.add(m2);

		Map<String, List<WeixinMenu>> menu = new HashMap<String, List<WeixinMenu>>();
		menu.put("button", menus);
		String json = JSONObject.fromObject(menu).toString();
		System.out.println(json);
		String url = WeixinConstant.MENU_ADDRESS.replace("ACCESS_TOKEN", accessToken);
		String result = HttpHelper.doPost(url, json, "application/json");
		System.out.println(result);
	}

}
