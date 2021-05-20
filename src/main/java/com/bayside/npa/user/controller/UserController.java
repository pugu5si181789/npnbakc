package com.bayside.npa.user.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.bayside.npa.user.model.User;
import com.bayside.npa.user.model.Userlog;
import com.bayside.npa.user.service.impl.UserImpl;
import com.bayside.npa.util.AddressUtils;
import com.bayside.npa.util.AppConstant;
import com.bayside.npa.util.Response;
import com.bayside.npa.util.ResponseStatus;
import com.bayside.npa.util.UuidUtil;

@RestController
public class UserController {
	
	@Autowired
	private UserImpl userImpl;
	private UserlogController uc;
	private Userlog userlog;
	private static final Logger log = Logger.getLogger(UserController.class);
	
	@RequestMapping(value="/userRegister",method = RequestMethod.GET)
	public Response userRegister(HttpServletRequest request,User user,HttpSession session){
		user.setId(UuidUtil.getUUID());
		int use = userImpl.insertSelective(user);
		if(use>0){
			return new Response(ResponseStatus.Success,"use",true);
		}else{
			return new Response(ResponseStatus.Error,AppConstant.responseInfo.INSERTERROR,false);
		}	
	}
		
	@RequestMapping(value = "/startLogin",method = RequestMethod.GET)
	public Response StartLogin(HttpServletResponse response,HttpServletRequest request,HttpSession session,User user){
		User u = userImpl.loginSelective(user);
		if(u !=null){
			//
			session.setAttribute("user", u);
			String ip=null;
			Date date = new Date();
			String brower = AddressUtils.getRequestBrowserInfo(request);
			try {
				 ip = AddressUtils.getIpAddress(request);
				 AddressUtils ad = new AddressUtils();
				
				 String address = ad.getAddresses("ip=" + ip, "utf-8");
			} catch (IOException e) {
				// TODO Auto-generated catch block
	           System.out.println(e.getMessage());		
			}
			userlog.setAddress(ip);
			userlog.setLogname(u.getUsername());
			uc.insertlog(response, request, userlog);
			return new Response(ResponseStatus.Success,u,true);
		}else{
			return new Response(ResponseStatus.Error,AppConstant.responseInfo.INSERTERROR,false);
		}		
	}

	
//	@RequestMapping(value = "/outlogin", method = RequestMethod.GET)
//	public Response outlogin(HttpServletRequest request) {
//		String requestAddress = request.getRequestURI();
//		String ip="";
//		try {
//			ip = IpUtil.getIpAddr(request);
//		} catch (Exception e) {
//		System.out.println(e.getMessage());
//		}
//		User u = (User) request.getSession().getAttribute("user");
//		log.info("userid:"+u.getId()+",loginip:"+ip+",requestAddress:"+requestAddress);
//		HttpSession session = request.getSession(false);
//		if (session != null) {
//			session.removeAttribute("user");
//			session.removeAttribute("userid");
//			session.removeAttribute("usertype");
//			session.removeAttribute("name");
//		}
//		return new Response(ResponseStatus.Success, AppConstant.responseInfo.DELETESUCCESS, true);
//	}

}
