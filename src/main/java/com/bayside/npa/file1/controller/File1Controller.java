package com.bayside.npa.file1.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bayside.npa.file1.model.File1;
import com.bayside.npa.file1.service.File1Service;
import com.bayside.npa.util.AppConstant;
import com.bayside.npa.util.Response;
import com.bayside.npa.util.ResponseStatus;
@RestController
public class File1Controller {
	@Autowired
	private File1Service file1Impl;
	
	@RequestMapping(value = "/selectFileById", method = RequestMethod.GET)
	public Response selectFileById(HttpServletResponse response, HttpServletRequest request, String id, String part) {
		List<File1> m = file1Impl.selectFileById(id, part);
		if (m != null) {
			return new Response(ResponseStatus.Success, m, true);
		} else {
			return new Response(ResponseStatus.Error, AppConstant.responseInfo.INSERTERROR, false);
		}
	}
	
	@RequestMapping(value = "/delFile1", method = RequestMethod.GET)
	public Response delFile1(HttpServletResponse response, HttpServletRequest request, String archiveid) {
		int num = file1Impl.delFileById(archiveid);
		if (num > 0) {
			return new Response(ResponseStatus.Success, archiveid, true);
		} else {
			return new Response(ResponseStatus.Error, AppConstant.responseInfo.INSERTERROR, false);
		}

	}
	
	@RequestMapping(value = "/selectFileByArchiveids", method = RequestMethod.GET)
	public Response selectFileByArchiveids(HttpServletResponse response, HttpServletRequest request, String archiveids) {
		String[] arr = archiveids.split(",");
		List<File1> m = new ArrayList();
		for(int i=0; i<arr.length; i++){
			m.add(file1Impl.selectFileByArchiveid(arr[i]).get(0));
//			System.out.println(file1Impl.selectFileByArchiveid(arr[i]).get(0).getPartname());
		}
		
//		List<File1> m = file1Impl.selectFileByArchiveid(id);
		if (m != null) {
			return new Response(ResponseStatus.Success, m, true);
		} else {
			return new Response(ResponseStatus.Error, AppConstant.responseInfo.INSERTERROR, false);
		}
	}
	
	@RequestMapping(value = "/updateFile1", method = RequestMethod.GET)
	public Response updateFile1(HttpServletResponse response, HttpServletRequest request, String archiveids, String id) {
		String[] arr = archiveids.split(",");
		int num = 0;
		for(int i=0; i<arr.length; i++){
			num += file1Impl.updateFileByArchiveid(arr[i], id);
		}
		
		if (num > 0) {
			return new Response(ResponseStatus.Success, num, true);
		} else {
			return new Response(ResponseStatus.Error, AppConstant.responseInfo.INSERTERROR, false);
		}

	}
	
	@RequestMapping(value = "/selectFileByArchiveidsNew", method = RequestMethod.GET)
	public Response selectFileByArchiveidsNew(HttpServletResponse response, HttpServletRequest request, String archiveids) {
		String[] arr = archiveids.split(",");
		List<String> cr = Arrays.asList(arr);
		
		Map<String, Object> map = new HashMap<String, Object>();
	    map.put("listds", cr);
	    
	    List<File1> m = file1Impl.selectFileByArchiveidNew(map);
		if (m != null) {
			return new Response(ResponseStatus.Success, m, true);
		} else {
			return new Response(ResponseStatus.Error, AppConstant.responseInfo.INSERTERROR, false);
		}
	}
	
	@RequestMapping(value = "/updateFile1New", method = RequestMethod.GET)
	public Response updateFile1New(HttpServletResponse response, HttpServletRequest request, String archiveids, String id) {
		String[] arr = archiveids.split(",");
		List<String> cr = Arrays.asList(arr);
		Map<String, Object> map = new HashMap<String, Object>();
	    map.put("listds", cr);
	    map.put("id", id);
		int num = file1Impl.updateFileByArchiveidNew(map);
		if (num > 0) {
			return new Response(ResponseStatus.Success, num, true);
		} else {
			return new Response(ResponseStatus.Error, AppConstant.responseInfo.INSERTERROR, false);
		}

	}
}
