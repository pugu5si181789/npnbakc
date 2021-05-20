package com.bayside.npa.firms.dao;

import java.util.List;

import com.bayside.npa.firms.model.Firms;

public interface FirmsMapper {
    int deleteByPrimaryKey(Integer firmsid);

    int insert(Firms record);

    int insertSelective(Firms record);
    
    List<Firms> showFirms();

    Firms selectByPrimaryKey(Integer firmsid);

    int updateByPrimaryKeySelective(Firms record);

    int updateByPrimaryKey(Firms record);
}