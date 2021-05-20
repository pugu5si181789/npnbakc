package com.bayside.npa.resource.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bayside.npa.resource.model.Resource;
import com.bayside.npa.resource.service.impl.ResourceImpl;
import com.bayside.npa.util.AppConstant;
import com.bayside.npa.util.Response;
import com.bayside.npa.util.ResponseStatus;

@RestController
public class ResourceController {
	
	@Autowired
	private ResourceImpl rImpl;
	
	private static final Logger log = Logger.getLogger(ResourceController.class);
	

	/*
	 * 根据主键查询
	 */
//	@RequestMapping(value = "/showByIdRes",method = RequestMethod.GET)
//	public Response showByIdRes(HttpServletResponse response,HttpServletRequest request,HttpSession session,int firmsid){
//		Firms m = fImpl.selectByPrimaryKey(firmsid);
//		if(m != null){
//			return new Response(ResponseStatus.Success,m,true);
//		}else{
//			return new Response(ResponseStatus.Error,AppConstant.responseInfo.INSERTERROR,false);
//		}		
//	}
	
	/*
	 * 根据主键删除
	 */
	@RequestMapping(value = "/deleteRes",method = RequestMethod.GET)
	public Response deleteRes(HttpServletResponse response,HttpServletRequest request,HttpSession session,String id){
		
		int m = rImpl.deleteByPrimaryKey(id);
		if(m > 0){
			return new Response(ResponseStatus.Success,m,true);
		}else{
			return new Response(ResponseStatus.Error,AppConstant.responseInfo.INSERTERROR,false);
		}		
	}
	
	/*
	 * 根据公司ID展示表内容
	 */
	@RequestMapping(value = "/showRes",method = RequestMethod.GET)
	public Response showRes(HttpServletResponse response,HttpServletRequest request,Integer firmsid){
		
		List<Resource> list = rImpl.selectList(firmsid);
		if(list != null){
			return new Response(ResponseStatus.Success,list,true);
		}else{
			return new Response(ResponseStatus.Error,AppConstant.responseInfo.INSERTERROR,false);
		}		
	}
	
	
	/*
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