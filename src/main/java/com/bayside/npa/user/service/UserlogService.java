package com.bayside.npa.user.service;

import java.util.List;

import com.bayside.npa.user.model.Userlog;

public interface UserlogService {
	

    int deleteByPrimaryKey(String id);

    int insert(Userlog record);

    int insertSelective(Userlog record);

    Userlog selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Userlog record);

    int updateByPrimaryKey(Userlog record);
    
    List<Userlog> selectLog();

}
