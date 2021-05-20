package com.bayside.npa.user.dao;

import java.util.List;

import com.bayside.npa.user.model.Userlog;

public interface UserlogMapper {
    int deleteByPrimaryKey(String id);

    int insert(Userlog record);

    int insertSelective(Userlog record);

    Userlog selectByPrimaryKey(String id);
    
    List<Userlog> selectLog();

    int updateByPrimaryKeySelective(Userlog record);

    int updateByPrimaryKey(Userlog record);
}