package com.bayside.npa.resource.controller;

import java.io.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.bayside.npa.resource.model.Resource;
import com.bayside.npa.resource.service.impl.ResourceImpl;
import com.bayside.npa.util.UuidUtil;

@RestController
public class FileController {
	/**
	 * 文件上传功能
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 */
	@Autowired
	private ResourceImpl rImpl;
	@RequestMapping(value = "/uploadFile", method = { RequestMethod.GET,RequestMethod.POST }, produces = "text/html;charset=UTF-8")
	public String uploadFile(MultipartHttpServletRequest multipartRequest, HttpServletRequest request, Resource res,Integer firmsid) {
		InputStream in = null;
		String newfileName = null;
		String newpathname = null;
		String resourcename = null;
		String filePath2 = null;
		String fileAddre = "/numUp";
	  //MultipartHttpServletRequest multipartRequest。。。。multipartRequest.getFile("inputfile"); 用来接收上传过来的文件
		MultipartFile file = multipartRequest.getFile("inputfile");
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
			filePath2 = "numUp"+"\\"+newfileName;//存储相对路径到数据库
			newpathname = filePath + "\\" + newfileName;//存储文件的路径
			OutputStream bos = new FileOutputStream(newpathname);
			resourcename = file.getOriginalFilename();//上传时的文件名字
			int bytesRead = 0;
			byte[] buffer = new byte[81920];
			while ((bytesRead = stream.read(buffer, 0, 81920)) != -1) {
				bos.write(buffer, 0, bytesRead);// 将文件以字节流的方式写入服务器
			}
			bos.close();//释放流
			stream.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//封装
		res.setId(UuidUtil.getUUID());
		res.setResourceurl(filePath2);
		res.setFirmsid(firmsid);
		res.setResourcename(resourcename);
		
		rImpl.insertSelective(res);

		return "";

	}

	/**
	 * 文件下载功能
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/downloadFile", method = { RequestMethod.GET,RequestMethod.POST })
	public String downloadFile(String resourcename, String resourceurl,HttpServletRequest request, HttpServletResponse response) {
					if (resourcename != null) {
			              String realPath = request.getServletContext().getRealPath(resourceurl);
			              File file = new File(realPath);
			              if (file.exists()) {
			                  response.setContentType("application/force-download");
			                  response.addHeader("Content-Disposition","attachment;fileName=" + resourcename);// 设置文件名
			                 byte[] buffer = new byte[81920];
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
