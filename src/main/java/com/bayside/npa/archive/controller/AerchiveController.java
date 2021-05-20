package com.bayside.npa.archive.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.nio.reactor.SessionRequest;
import org.apache.log4j.Logger;
import org.apache.zookeeper.server.SessionTracker.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bayside.npa.archive.model.Archive;
import com.bayside.npa.archive.service.impl.AerchiveImpl;
import com.bayside.npa.manager.model.Manager;
import com.bayside.npa.user.dao.UserMapper;
import com.bayside.npa.util.AppConstant;
import com.bayside.npa.util.Response;
import com.bayside.npa.util.ResponseStatus;
import com.bayside.npa.util.UuidUtil;

@RestController
public class AerchiveController {
	
	@Autowired
	private AerchiveImpl arcImpl;
	
//	
//	/**
//	 * 添加数据
//	 */
//	@RequestMapping(value="/addArc",method = RequestMethod.GET)
//	public Response addArc(HttpServletResponse response,HttpServletRequest request,Archive arc){
//		arc.setArchiveid(UuidUtil.getUUID());
//		int m = aImpl.insertSelective(arc);
//		if(m > 0){
//			return new Response(ResponseStatus.Success,m,true);
//		}else{
//			return new Response(ResponseStatus.Error,AppConstant.responseInfo.INSERTERROR,false);
//		}		
//	}

	/**
	 * 根据主键查询
	 */
//	@RequestMapping(value = "/showByIdAer",method = RequestMethod.GET)
//	public Response showByIdAer(HttpServletResponse response,HttpServletRequest request,HttpSession session,int firmsid){
//		Archive m = aImpl.selectByPrimaryKey(firmsid);
//		if(m != null){
//			return new Response(ResponseStatus.Success,m,true);
//		}else{
//			return new Response(ResponseStatus.Error,AppConstant.responseInfo.INSERTERROR,false);
//		}		
//	}
	
	/**
	 * 根据主键删除
	 */
	@RequestMapping(value = "/deleteArc",method = RequestMethod.GET)
	public Response deleteRes(HttpServletResponse response,HttpServletRequest request,HttpSession session,String archiveid){
		
		int m = arcImpl.deleteByPrimaryKey(archiveid);
		if(m > 0){
			return new Response(ResponseStatus.Success,m,true);
		}else{
			return new Response(ResponseStatus.Error,AppConstant.responseInfo.INSERTERROR,false);
		}		
	}
	
	/**
	 * 展示相应部分下的文件
	 */
	@RequestMapping(value = "/showArc",method = RequestMethod.GET)
	public Response showArc(HttpServletResponse response,HttpServletRequest request, Archive arc){
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("mananger");
		arc.setId(id);
		List<Archive> list = arcImpl.selectList(arc);
		if(list != null){
			return new Response(ResponseStatus.Success,list,true);
		}else{
			return new Response(ResponseStatus.Error,AppConstant.responseInfo.INSERTERROR,false);
		}		
	}
	
	
	/**
	 * 更新
	 */
//	@RequestMapping(value = "/updateByIdFirms",method = RequestMethod.GET)
//	public Response updateByIdFirms(HttpServletResponse response,HttpServletRequest request,HttpSession session,Firms fir){
//		
//		int m = fImpl.updateByPrimaryKeySelective(fir);
//		if(m > 0){
//			return new Response(ResponseStatus.Success,m,true);
//		}else{
//			return new Response(ResponseStatus.Error,AppConstant.responseInfo.INSERTERROR,false);
//		}		
//	}

}
