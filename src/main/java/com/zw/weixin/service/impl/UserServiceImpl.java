package com.zw.weixin.service.impl;

import org.springframework.stereotype.Service;

import com.zw.weixin.bean.User;
import com.zw.weixin.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public User getById(String id) {
		return new User(id, "tomcat");
	}

}
