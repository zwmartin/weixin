package com.zwtest.weixin.service.impl;

import org.springframework.stereotype.Service;

import com.zwtest.weixin.bean.User;
import com.zwtest.weixin.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public User getById(String id) {
		return new User(id, "tomcat");
	}

}
