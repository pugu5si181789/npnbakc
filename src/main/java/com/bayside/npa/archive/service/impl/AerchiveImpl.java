package com.bayside.npa.archive.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bayside.npa.archive.dao.ArchiveMapper;
import com.bayside.npa.archive.model.Archive;
import com.bayside.npa.archive.service.ArchiveService;

@Service("AerchiveImpl")
public class AerchiveImpl implements ArchiveService{

	@Autowired
	private ArchiveMapper arcMapper;
	
	public int deleteByPrimaryKey(String archiveid) {
		
		return arcMapper.deleteByPrimaryKey(archiveid);
	}
	
	public int insert(Archive record) {
		return arcMapper.insert(record);
	}
	
	public int insertSelective(Archive record) {
		return arcMapper.insertSelective(record);
	}

	public Archive selectByPrimaryKey(String archiveid) {
		return arcMapper.selectByPrimaryKey(archiveid);
	}

	public int updateByPrimaryKeySelective(Archive record) {
		return arcMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(Archive record) {
		return arcMapper.updateByPrimaryKey(record);
	}

	public List<Archive> selectList(Archive arc) {
		return arcMapper.selectList(arc);
	}
	

	

	
}
