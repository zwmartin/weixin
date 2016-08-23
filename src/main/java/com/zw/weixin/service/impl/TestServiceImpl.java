package com.zw.weixin.service.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import com.zw.weixin.bean.User;
import com.zw.weixin.service.TestService;

@Service("testService")
public class TestServiceImpl implements TestService {

	@Resource
	SessionFactory sessionFactory;

	@Override
	public void saveTwoUsers() {
		sessionFactory.getCurrentSession().save(new User(null, "tomcat"));
		int i = 1 / 0;
		sessionFactory.getCurrentSession().save(new User(null, "tomcat"));
	}

}
