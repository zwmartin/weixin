package com.zw.weixin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zw.weixin.bean.User;
import com.zw.weixin.dao.UserDao;
import com.zw.weixin.service.TestService;

@Service("testService")
public class TestServiceImpl implements TestService {

	@Resource
	private UserDao userDao;

	@Override
	public void saveTwoUsers() {
		userDao.save(new User(null, "tomcat"));
		userDao.save(new User(null, "tomcat"));
	}

	@Override
	public List<User> findAll() {
		
		User u = userDao.getById(2L);
		
		System.out.println(u);
		
		return userDao.getByIds(new Long[]{0L, 1L, 2L});
	}

}
