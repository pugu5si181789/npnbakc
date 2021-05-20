package com.bayside.npa.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bayside.npa.user.dao.UserMapper;
import com.bayside.npa.user.model.User;
import com.bayside.npa.user.service.UserService;
@Service("userRegisterImpl")
public class UserImpl implements UserService {
    @Autowired
	private UserMapper userMapper;
	public int insertSelective(User record) {
		return userMapper.insertSelective(record);
	}
	public User loginSelective(User user) {
		return userMapper.loginSelective(user);
	}

}
