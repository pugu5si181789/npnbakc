package com.bayside.npa.archive.controller;

import java.io.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.bayside.npa.archive.model.Archive;
import com.bayside.npa.archive.service.impl.AerchiveImpl;
import com.bayside.npa.util.UuidUtil;

@RestController
public class ArcFileController {
	/**
	 * 文件上传功能
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 */
	@Autowired
	private AerchiveImpl aImpl;
	@RequestMapping(value = "/uploadFileArc", method = { RequestMethod.GET,RequestMethod.POST }, produces = "text/html;charset=UTF-8")
	public String uploadFileArc(MultipartHttpServletRequest multipartRequest, HttpServletRequest request, Archive arc,String id,String part1,String part2,String part3
			,String part4,String part5,String part6,String part7,String part8) {
		String part="";
		InputStream in = null;
		String newfileName = null;
		String newpathname = null;
		String resourcename = null;
		String filePath2 = null;
		String fileAddre = "/fileLoad";
	  //MultipartHttpServletRequest multipartRequest。。。。multipartRequest.getFile("inputfile"); 用来接收上传过来的文件
		MultipartFile file = null;
	  //判断哪个部分上传的
		if("1".equals(part1)){
			file = multipartRequest.getFile("inputfile1");
			part=part1;
		}else if("2".equals(part2)){
			file = multipartRequest.getFile("inputfile2");
			part = part2;
		}else if("3".equals(part3)){
			file = multipartRequest.getFile("inputfile3");
			part = part3;
		}else if("4".equals(part4)){
			file = multipartRequest.getFile("inputfile4");
			part = part4;
		}else if("5".equals(part5)){
			file = multipartRequest.getFile("inputfile5");
			part = part5;
		}else if("6".equals(part6)){
			file = multipartRequest.getFile("inputfile6");
			part = part6;
		}else if("7".equals(part7)){
			file = multipartRequest.getFile("inputfile7");
			part = part7;
		}else if("8".equals(part8)){
			file = multipartRequest.getFile("inputfile8");
			part = part8;
		}
		
		if (file.isEmpty()) {
			try {
				System.out.println("文件不存在！");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		try {
			in = file.getInputStream();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		try {
			InputStream stream = file.getInputStream();// 把文件读入
			String filePath = request.getServletContext().getRealPath(fileAddre);// 取系统当前路径
			// 添加了自动创建目录的功能
			File file1 = new File(filePath);
			((File) file1).mkdir();
			//新命名文件
			newfileName = System.currentTimeMillis()+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.'));
			filePath2 = "fileLoad"+"\\"+newfileName;//存储相对路径到数据库
			newpathname = filePath + "\\" + newfileName;//存储文件的路径
			OutputStream bos = new FileOutputStream(newpathname);
			resourcename = file.getOriginalFilename();//上传时的文件名字
			int bytesRead = 0;
			byte[] buffer = new byte[8192];
			while ((bytesRead = stream.read(buffer, 0, 8192)) != -1) {
				bos.write(buffer, 0, bytesRead);// 将文件以字节流的方式写入服务器
			}
			bos.close();//释放流
			stream.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		arc.setArchiveid(UuidUtil.getUUID());
		arc.setId(id);
		arc.setPart(part);
		arc.setParturl(filePath2);
		arc.setPartname(resourcename);
		aImpl.insertSelective(arc);
		

		return arc.getArchiveid();

	}

	/**
	 * 文件下载功能
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/downloadFileArc", method = { RequestMethod.GET,RequestMethod.POST })
	public String downloadFileArc(String partname, String parturl,HttpServletRequest request, HttpServletResponse response) {
					if (partname != null) {
			              String realPath = request.getServletContext().getRealPath(parturl);
			              File file = new File(realPath);
			              if (file.exists()) {
			                  response.setContentType("application/force-download");
			                  response.addHeader("Content-Disposition","attachment;fileName=" + partname);// 设置文件名
			                 byte[] buffer = new byte[8192];
			                 FileInputStream fis = null;
			                 BufferedInputStream bis = null;
			                  try {
			                      fis = new FileInputStream(file);
			                      bis = new BufferedInputStream(fis);
			                      OutputStream os = response.getOutputStream();
			                      int i = bis.read(buffer);
			                      while (i != -1) {
			                          os.write(buffer, 0, i);
			                          i = bis.read(buffer);
			                      }
			                  } catch (Exception e) {
			                      e.printStackTrace();
			                  } finally {
			                      if (bis != null) {
			                          try {
			                              bis.close();
			                          } catch (IOException e) {
			                              e.printStackTrace();
			                          }
			                    }
			                    if (fis != null) {
			                          try {
			                             fis.close();
			                        } catch (IOException e) {
			                             e.printStackTrace();
			                          }
			                      }
			                 }
			             }
			          }
			          return null;
			      }
	}
