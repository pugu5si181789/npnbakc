package com.bayside.npa.resource.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bayside.npa.resource.dao.ResourceMapper;
import com.bayside.npa.resource.model.Resource;
import com.bayside.npa.resource.service.ResourceService;

@Service("ResourceImpl")
public class ResourceImpl implements ResourceService {
	
	@Autowired
	private ResourceMapper rMapper;

	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return rMapper.deleteByPrimaryKey(id);
	}

	public int insert(Resource record) {
		// TODO Auto-generated method stub
		return rMapper.insert(record);
	}

	public int insertSelective(Resource record) {
		// TODO Auto-generated method stub
		return rMapper.insertSelective(record);
	}

	public Resource selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return rMapper.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(Resource record) {
		// TODO Auto-generated method stub
		return rMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(Resource record) {
		// TODO Auto-generated method stub
		return rMapper.updateByPrimaryKey(record);
	}

	public List<Resource> selectList(Integer firmsid) {
		// TODO Auto-generated method stub
		return rMapper.selectList(firmsid);
	}
	
	

}
