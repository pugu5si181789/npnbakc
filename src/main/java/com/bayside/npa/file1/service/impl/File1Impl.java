package com.bayside.npa.file1.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bayside.npa.file1.dao.File1Mapper;
import com.bayside.npa.file1.model.File1;
import com.bayside.npa.file1.service.File1Service;
@Service("file1Impl")
public class File1Impl implements File1Service {
	
	@Autowired
	private File1Mapper file1Mapper;
	
	@Override
	public List<File1> selectFileById(String id, String part) {
		return file1Mapper.selectFileById(id, part);
	}

	@Override
	public int delFileById(String archiveid) {
		return file1Mapper.delFileById(archiveid);
	}

	@Override
	public List<File1> selectFileByArchiveid(String archiveid) {
		return file1Mapper.selectFileByArchiveid(archiveid);
	}

	@Override
	public int updateFileByArchiveid(String archiveid, String id) {
		return file1Mapper.updateFileByArchiveid(archiveid, id);
	}

	@Override
	public List<File1> selectFileByArchiveidNew(Map<String, Object> map) {
		return file1Mapper.selectFileByArchiveidNew(map);
	}

	@Override
	public int updateFileByArchiveidNew(Map<String, Object> map) {
		return file1Mapper.updateFileByArchiveidNew(map);
	}

}
