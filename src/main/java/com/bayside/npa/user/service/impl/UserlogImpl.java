package com.bayside.npa.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bayside.npa.user.dao.UserlogMapper;
import com.bayside.npa.user.model.Userlog;
import com.bayside.npa.user.service.UserlogService;
@Service("UserlogImpl")
public class UserlogImpl implements UserlogService {
    @Autowired
	private UserlogMapper userlogMapper;
	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return userlogMapper.deleteByPrimaryKey(id);
	}
	public int insert(Userlog record) {
		// TODO Auto-generated method stub
		return userlogMapper.insert(record);
	}
	public int insertSelective(Userlog record) {
		// TODO Auto-generated method stub
		return userlogMapper.insertSelective(record);
	}
	public Userlog selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return userlogMapper.selectByPrimaryKey(id);
	}
	public int updateByPrimaryKeySelective(Userlog record) {
		// TODO Auto-generated method stub
		return userlogMapper.updateByPrimaryKeySelective(record);
	}
	public int updateByPrimaryKey(Userlog record) {
		// TODO Auto-generated method stub
		return userlogMapper.updateByPrimaryKey(record);
	}
	public List<Userlog> selectLog() {
		// TODO Auto-generated method stub
		return userlogMapper.selectLog();
	}

}
