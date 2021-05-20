package com.bayside.npa.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bayside.npa.manager.dao.ManagerMapper;
import com.bayside.npa.manager.model.Manager;
import com.bayside.npa.manager.service.ManagerService;

@Service("ManagerImpl")
public class ManagerImpl implements ManagerService {
	
	@Autowired
	private ManagerMapper manMapper;
	
	public int insertSelective(Manager record) {
		return manMapper.insertSelective(record);
	}
	//添加
	public int insert(Manager man) {
		return manMapper.insert(man);
	}
	//删除
	public int deleteByPrimaryKey(String id) {
		return manMapper.deleteByPrimaryKey(id);
	}
	//根据主键查询
	public Manager selectByPrimaryKey(String id) {
		return manMapper.selectByPrimaryKey(id);
	}
	//展示表内容
	public List<Manager> select() {
		return manMapper.select();
	}
	
	//更新
	public int updateByPrimaryKeySelective(Manager record) {
		
		return manMapper.updateByPrimaryKeySelective(record);
	}
	
	public int updateByPrimaryKey(Manager record) {
		
		return manMapper.updateByPrimaryKey(record);
	}
	
	//用户登录
	public Manager loginManager(Manager record) {
		
		return manMapper.loginManager(record);
	}
	
}
