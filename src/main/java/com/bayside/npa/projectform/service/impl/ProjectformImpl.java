package com.bayside.npa.projectform.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bayside.npa.projectform.dao.ProjectformMapper;
import com.bayside.npa.projectform.model.Projectform;
import com.bayside.npa.projectform.service.ProjectformService;
import com.bayside.npa.user.model.User;
@Service("projectformImpl")
public class ProjectformImpl implements ProjectformService {
    @Autowired
	private ProjectformMapper projectformMapper;
	public int insertSelective(Projectform record) {
		 return projectformMapper.insertSelective(record);
	}
	
	//用于展示在itemList
		public List<Projectform> selectByPrimaryKeyPF(Integer id) {
			
			return projectformMapper.selectByPrimaryKeyPF(id);
		}
	//用于展示在ProjectForm
	public Projectform selectIdPF(String id) {
			
		return projectformMapper.selectByIdPF(id);
	}

	public int deleteByPrimaryKey(String id) {
		//删除
		return projectformMapper.deleteByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(Projectform record) {
		// 更新数据
		return projectformMapper.updateByPrimaryKeySelective(record);
	}

	public List<Projectform> selectPF(Projectform record) {
		
		return projectformMapper.selectPF(record);
	}

}
