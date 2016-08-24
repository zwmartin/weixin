package com.zw.weixin.service;

import com.zw.weixin.bean.User;

public interface UserService extends DaoSupport<User>{

	void saveToUser();
}
