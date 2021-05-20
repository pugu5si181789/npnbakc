package com.bayside.npa.projectform.service;

import java.util.List;

import com.bayside.npa.projectform.model.Projectform;

public interface ProjectformService {
	
	int insertSelective(Projectform record);
	//用于展示在itemList
	List<Projectform> selectByPrimaryKeyPF(Integer id);
	//用于展示在projectForm 页面
	Projectform selectIdPF(String id);
	
	//删除
    int deleteByPrimaryKey(String id);

    //修改
    int updateByPrimaryKeySelective(Projectform record);
    
    List<Projectform> selectPF(Projectform record);

}
