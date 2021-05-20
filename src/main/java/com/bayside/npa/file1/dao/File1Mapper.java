package com.bayside.npa.file1.dao;

import java.util.List;
import java.util.Map;

import com.bayside.npa.file1.model.File1;

public interface File1Mapper {
	// 寻找附件
	List<File1> selectFileById(String id ,String part);
	
	// 删除附件
	int delFileById(String archiveid);
	
	// 通过archiveid获取附件详情
	List<File1> selectFileByArchiveid(String archiveid);
	
	// 通过archiveid修改附件详情
	int updateFileByArchiveid(String archiveid, String id);
	
	// 通过archiveids获取附件详情new
	List<File1> selectFileByArchiveidNew(Map<String, Object> map);
	
	// 通过archiveids修改附件详情new
	int updateFileByArchiveidNew(Map<String, Object> map);
}
