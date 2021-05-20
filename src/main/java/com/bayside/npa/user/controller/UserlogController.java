package com.bayside.npa.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bayside.npa.user.model.Userlog;
import com.bayside.npa.user.service.impl.UserlogImpl;
import com.bayside.npa.util.AppConstant;
import com.bayside.npa.util.IpUtil;
import com.bayside.npa.util.Response;
import com.bayside.npa.util.ResponseStatus;
import com.bayside.npa.util.UuidUtil;

@RestController
public class UserlogController {
	
	@Autowired
	private UserlogImpl logImpl;
	
	
	/*
	 * 添加/插入
	 */
	@RequestMapping(value="/insertlog",method = RequestMethod.GET)
	public Response insertlog(HttpServletResponse response,HttpServletRequest request,Userlog log){
		log.setId(UuidUtil.getUUID());
		int use = logImpl.insertSelective(log);
		if(use>0){
			return new Response(ResponseStatus.Success,"use",true);
		}else{
			return new Response(ResponseStatus.Error,AppConstant.responseInfo.INSERTERROR,false);
		}	
	}
		
	/*
	 * 根据主键查询
	 */
	@RequestMapping(value = "/showByIdLog",method = RequestMethod.GET)
	public Response showByIdLog(HttpServletResponse response,HttpServletRequest request,String id){
		Userlog m = logImpl.selectByPrimaryKey(id);
		if(m != null){
			return new Response(ResponseStatus.Success,m,true);
		}else{
			return new Response(ResponseStatus.Error,AppConstant.responseInfo.INSERTERROR,false);
		}		
	}
	
	/*
	 * 根据主键删除
	 */
	@RequestMapping(value = "/deleteLog",method = RequestMethod.GET)
	public Response deleteLog(HttpServletResponse response,HttpServletRequest request,HttpSession session,String id){
		
		int m = logImpl.deleteByPrimaryKey(id);
		if(m > 0){
			return new Response(ResponseStatus.Success,m,true);
		}else{
			return new Response(ResponseStatus.Error,AppConstant.responseInfo.INSERTERROR,false);
		}		
	}
	
	/*
	 * 展示表内容
	 */
	@RequestMapping(value = "/showL",method = RequestMethod.GET)
	public Response showL(HttpServletResponse response,HttpServletRequest request){
		
		List<Userlog> list = logImpl.selectLog();
		
		if(list != null){
			for(Userlog u:list ){
				System.out.println(u.getLogintime());
			}
			return new Response(ResponseStatus.Success,list,true);
		}else{
			return new Response(ResponseStatus.Error,AppConstant.responseInfo.INSERTERROR,false);
		}		
	}
	
}
