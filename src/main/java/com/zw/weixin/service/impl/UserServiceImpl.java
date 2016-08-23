package com.zw.weixin.service.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import com.zw.weixin.bean.User;
import com.zw.weixin.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Resource
	SessionFactory sessionFactory;
	
	@Override
	public User getById(int id) {
		return new User(id, "tomcat");
	}

}
