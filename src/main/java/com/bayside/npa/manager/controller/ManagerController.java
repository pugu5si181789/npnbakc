package com.bayside.npa.manager.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bayside.npa.manager.model.Manager;
import com.bayside.npa.manager.service.impl.ManagerImpl;
import com.bayside.npa.user.controller.UserlogController;
import com.bayside.npa.user.model.Userlog;
import com.bayside.npa.util.AddressUtils;
import com.bayside.npa.util.AppConstant;

import com.bayside.npa.util.Response;
import com.bayside.npa.util.ResponseStatus;
import com.bayside.npa.util.UuidUtil;

@RestController
public class ManagerController {
	
	@Autowired
	private ManagerImpl manImpl;
	@Autowired
	private UserlogController uc;
	Userlog userlog = new Userlog();
	
	
	
	private static final Logger log = Logger.getLogger(ManagerController.class);
	
	/*
	 * 添加/插入
	 */
	@RequestMapping(value="/insertManager",method = RequestMethod.GET)
	public Response insertManager(HttpServletRequest request,Manager man,HttpSession session){
		man.setId(UuidUtil.getUUID());
		int use = manImpl.insertSelective(man);
		if(use>0){
			return new Response(ResponseStatus.Success,"use",true);
		}else{
			return new Response(ResponseStatus.Error,AppConstant.responseInfo.INSERTERROR,false);
		}	
	}
		
	/*
	 * 根据主键查询
	 */
	@RequestMapping(value = "/showByIdManager",method = RequestMethod.GET)
	public Response showByIdManager(HttpServletResponse response,HttpServletRequest request,HttpSession session,String id){
		Manager m = manImpl.selectByPrimaryKey(id);
		if(m != null){
			return new Response(ResponseStatus.Success,m,true);
		}else{
			return new Response(ResponseStatus.Error,AppConstant.responseInfo.INSERTERROR,false);
		}		
	}
	
	/*
	 * 根据主键删除
	 */
	@RequestMapping(value = "/deleteManager",method = RequestMethod.GET)
	public Response deleteManager(HttpServletResponse response,HttpServletRequest request,HttpSession session,String id){
		
		int m = manImpl.deleteByPrimaryKey(id);
		if(m > 0){
			return new Response(ResponseStatus.Success,m,true);
		}else{
			return new Response(ResponseStatus.Error,AppConstant.responseInfo.INSERTERROR,false);
		}		
	}
	
	/*
	 * 展示表内容
	 */
	@RequestMapping(value = "/showManager",method = RequestMethod.GET)
	public Response showManager(HttpServletResponse response,HttpServletRequest request){
		List<Manager> list = manImpl.select();
		if(list != null){
			return new Response(ResponseStatus.Success,list,true);
		}else{
			return new Response(ResponseStatus.Error,AppConstant.responseInfo.INSERTERROR,false);
		}		
	}
	
	
	/*
	 * 更新
	 */
	@RequestMapping(value = "/updateByIdManager",method = RequestMethod.GET)
	public Response updateByIdManager(HttpServletResponse response,HttpServletRequest request,HttpSession session,Manager man){
		
		int m = manImpl.updateByPrimaryKeySelective(man);
		if(m > 0){
			return new Response(ResponseStatus.Success,m,true);
		}else{
			return new Response(ResponseStatus.Error,AppConstant.responseInfo.INSERTERROR,false);
		}		
	}
	/*
	 * 普通用户登录
	 */
	@RequestMapping(value = "/loginManager", method = RequestMethod.GET)
	public Response loginManager(HttpServletResponse response,HttpServletRequest request,HttpSession session,Manager man){
		Manager m = manImpl.loginManager(man);
		if(m !=null){
			session.setAttribute("mananger", m.getId());
			String ip = "";
			String sdate;
			Date date = new Date();
			//java.util.Date转换为Timestamp
			Timestamp time = new Timestamp(date.getTime());
			
			sdate=(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(date);
			try {
				ip = AddressUtils.getIpAddress(request);
				
			} catch (IOException e) {
				System.out.print(e.getMessage());
			}
			userlog.setAddress(ip);
			userlog.setLogintime(time);
			userlog.setLogname(m.getUsername());
			uc.insertlog(response, request, userlog);
			return new Response(ResponseStatus.Success,m,true);
		}else{
			return new Response(ResponseStatus.Error,AppConstant.responseInfo.INSERTERROR,false);
		}	
		
	}
}
