package com.zw.weixin.service.impl;

import org.springframework.stereotype.Service;

import com.zw.weixin.bean.User;
import com.zw.weixin.service.UserService;

@Service("userService")
public class UserServiceImpl extends DaoSupportImpl<User> implements UserService {

	@Override
	public void saveToUser() {
		getSession().save(new User(null, "123"));
		getSession().save(new User(null, "456"));
	}
	
}
