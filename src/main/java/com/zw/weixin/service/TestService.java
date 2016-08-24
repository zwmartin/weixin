package com.zw.weixin.service;

import java.util.List;

import com.zw.weixin.bean.User;

public interface TestService {
	
	public void saveTwoUsers();
	
	public List<User> findAll();
}
