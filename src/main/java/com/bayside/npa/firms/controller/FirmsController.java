package com.bayside.npa.firms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bayside.npa.firms.model.Firms;
import com.bayside.npa.firms.service.impl.FirmsImpl;
import com.bayside.npa.util.AppConstant;
import com.bayside.npa.util.Response;
import com.bayside.npa.util.ResponseStatus;

@RestController
public class FirmsController {
	
	@Autowired
	private FirmsImpl fImpl;
	
	private static final Logger log = Logger.getLogger(FirmsController.class);
	
	/*
	 * 添加/插入
	 */
	@RequestMapping(value="/insertFirms",method = RequestMethod.GET)
	public Response insertFirms(HttpServletRequest request,Firms fir,HttpSession session){
		int use = fImpl.insertSelective(fir);
		if(use>0){
			return new Response(ResponseStatus.Success,"use",true);
		}else{
			return new Response(ResponseStatus.Error,AppConstant.responseInfo.INSERTERROR,false);
		}	
	}
		
	/*
	 * 根据主键查询
	 */
	@RequestMapping(value = "/showByIdFirms",method = RequestMethod.GET)
	public Response showByIdFirms(HttpServletResponse response,HttpServletRequest request,HttpSession session,int firmsid){
		Firms m = fImpl.selectByPrimaryKey(firmsid);
		if(m != null){
			return new Response(ResponseStatus.Success,m,true);
		}else{
			return new Response(ResponseStatus.Error,AppConstant.responseInfo.INSERTERROR,false);
		}		
	}
	
	/*
	 * 根据主键删除
	 */
	@RequestMapping(value = "/deleteFirms",method = RequestMethod.GET)
	public Response deleteFirms(HttpServletResponse response,HttpServletRequest request,HttpSession session,int firmsid){
		
		int m = fImpl.deleteByPrimaryKey(firmsid);
		if(m > 0){
			return new Response(ResponseStatus.Success,m,true);
		}else{
			return new Response(ResponseStatus.Error,AppConstant.responseInfo.INSERTERROR,false);
		}		
	}
	
	/*
	 * 展示表内容
	 */
	@RequestMapping(value = "/showFirms",method = RequestMethod.GET)
	public Response showFirms(HttpServletResponse response,HttpServletRequest request,HttpSession session){
		
		List<Firms> list = fImpl.showFirms();
		if(list != null){
			return new Response(ResponseStatus.Success,list,true);
		}else{
			return new Response(ResponseStatus.Error,AppConstant.responseInfo.INSERTERROR,false);
		}		
	}
	
	
	/*
	 * 更新
	 */
	@RequestMapping(value = "/updateByIdFirms",method = RequestMethod.GET)
	public Response updateByIdFirms(HttpServletResponse response,HttpServletRequest request,HttpSession session,Firms fir){
		
		int m = fImpl.updateByPrimaryKeySelective(fir);
		if(m > 0){
			return new Response(ResponseStatus.Success,m,true);
		}else{
			return new Response(ResponseStatus.Error,AppConstant.responseInfo.INSERTERROR,false);
		}		
	}
	
}