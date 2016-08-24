package weixin;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zw.weixin.service.UserService;

public class TestHibernate {

	private ApplicationContext ac = new ClassPathXmlApplicationContext(
			"application-context.xml");

	// 测试SessionFactory
	@Test
	public void testSessionFactory() throws Exception {
		SessionFactory sessionFactory = (SessionFactory) ac
				.getBean("sessionFactory");
		System.out.println(sessionFactory);
	}

	@Test
	public void testBaseDao() throws Exception {
		UserService userService = (UserService) ac.getBean("userService");
		userService.findAll();
	}
}
