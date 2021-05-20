package com.bayside.npa.firms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bayside.npa.firms.dao.FirmsMapper;
import com.bayside.npa.firms.model.Firms;
import com.bayside.npa.firms.service.FirmsService;

@Service("FirmsImpl")
public class FirmsImpl implements FirmsService{
	
	@Autowired
	private FirmsMapper fMapper;
	public int deleteByPrimaryKey(Integer firmsid) {
		
		return fMapper.deleteByPrimaryKey(firmsid);
	}

	public int insertSelective(Firms record) {
		
		return fMapper.insertSelective(record);
	}

	public List<Firms> showFirms() {
		
		return fMapper.showFirms();
	}

	public Firms selectByPrimaryKey(Integer firmsid) {
		
		return fMapper.selectByPrimaryKey(firmsid);
	}

	public int updateByPrimaryKeySelective(Firms record) {
		
		return fMapper.updateByPrimaryKeySelective(record);
	}
	
	
		
}
