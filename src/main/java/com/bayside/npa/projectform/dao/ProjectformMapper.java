package com.bayside.npa.projectform.dao;

import java.util.List;

import com.bayside.npa.projectform.model.Projectform;

public interface ProjectformMapper {
	
	//删除
    int deleteByPrimaryKey(String id);
    
    //添加
    int insertSelective(Projectform record);
    
    int insert(Projectform record);

    Projectform selectByPrimaryKey(String id);
    //修改
    int updateByPrimaryKeySelective(Projectform record);

    int updateByPrimaryKey(Projectform record);
    
    //用来展示在itemList页面
    List<Projectform> selectByPrimaryKeyPF(Integer id);
    
    //用于展示在projectForm页面 
    Projectform selectByIdPF(String id);
    
    List<Projectform> selectPF(Projectform record);
    
}