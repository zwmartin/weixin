package weixin;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zw.weixin.service.TestService;

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

	// 测试事务
	@Test
	public void testTransaction() throws Exception {
		TestService testService = (TestService) ac.getBean("testService");
		testService.saveTwoUsers();
	}
}
