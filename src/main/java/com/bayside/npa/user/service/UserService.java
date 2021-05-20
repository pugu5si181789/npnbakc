package com.bayside.npa.user.service;

import com.bayside.npa.user.model.User;

public interface UserService {
	
	int insertSelective(User record);
	
	User loginSelective(User user);

}
