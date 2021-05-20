package com.bayside.npa.manager.service;

import java.util.List;

import com.bayside.npa.manager.model.Manager;

public interface ManagerService {
	
    int deleteByPrimaryKey(String id);

    int insert(Manager record);

    int insertSelective(Manager record);
    
    Manager loginManager(Manager record);

    Manager selectByPrimaryKey(String id);
    
    List<Manager> select();
    
    int updateByPrimaryKeySelective(Manager record);
    
    int updateByPrimaryKey(Manager record);

  

}
