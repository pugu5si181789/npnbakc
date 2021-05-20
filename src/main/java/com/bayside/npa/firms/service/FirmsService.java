package com.bayside.npa.firms.service;

import java.util.List;

import com.bayside.npa.firms.model.Firms;

public interface FirmsService {
	//删除
    int deleteByPrimaryKey(Integer firmsid);
    //插入
    int insertSelective(Firms record);
    //展示
    List<Firms> showFirms();
    //根据主键查询
    Firms selectByPrimaryKey(Integer firmsid);
    //更新
    int updateByPrimaryKeySelective(Firms record);

}
