package com.bayside.npa.resource.service;

import java.util.List;

import com.bayside.npa.resource.model.Resource;

public interface ResourceService {
	
	
	
    int deleteByPrimaryKey(String id);

    int insert(Resource record);

    int insertSelective(Resource record);

    Resource selectByPrimaryKey(String id);
    
    List<Resource> selectList(Integer firmsid);

    int updateByPrimaryKeySelective(Resource record);

    int updateByPrimaryKey(Resource record);

}
