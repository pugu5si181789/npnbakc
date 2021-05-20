package com.bayside.npa.archive.dao;


import java.util.List;

import com.bayside.npa.archive.model.Archive;

public interface ArchiveMapper {
    int deleteByPrimaryKey(String archiveid);

    int insert(Archive record);

    int insertSelective(Archive record);

    Archive selectByPrimaryKey(String archiveid);
   
    List<Archive> selectList(Archive arc);

    int updateByPrimaryKeySelective(Archive record);

    int updateByPrimaryKey(Archive record);
}