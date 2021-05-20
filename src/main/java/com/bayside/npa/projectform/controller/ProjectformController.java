package com.bayside.npa.projectform.controller;

import java.io.*;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bayside.npa.util.ExportExcelUtil;
import com.bayside.npa.util.MD5;
import com.bayside.npa.projectform.model.Projectform;
import com.bayside.npa.projectform.service.ProjectformService;
import com.bayside.npa.util.AppConstant;
import com.bayside.npa.util.DateFormatUtil;
import com.bayside.npa.util.Response;
import com.bayside.npa.util.ResponseStatus;
import com.bayside.npa.util.UuidUtil;

@RestController
public class ProjectformController {

	@Autowired
	private ProjectformService projectformImpl;

	@RequestMapping(value = "/addPF", method = RequestMethod.POST)
	public Response addPF(HttpServletResponse response, HttpServletRequest request, @RequestBody Projectform pro) {
		pro.setId(UuidUtil.getUUID());
		int pronum = projectformImpl.insertSelective(pro);

		if (pronum > 0) {
			return new Response(ResponseStatus.Success, pro.getId(), true);
		} else {
			return new Response(ResponseStatus.Error, AppConstant.responseInfo.INSERTERROR, false);
		}
	}

	@RequestMapping(value = "/delPF", method = RequestMethod.GET)
	public Response delPF(HttpServletResponse response, HttpServletRequest request, String id) {
		int num = projectformImpl.deleteByPrimaryKey(id);
		if (num > 0) {
			return new Response(ResponseStatus.Success, id, true);
		} else {
			return new Response(ResponseStatus.Error, AppConstant.responseInfo.INSERTERROR, false);
		}

	}

	@RequestMapping(value = "/upPF", method = RequestMethod.POST)
	public Response upPF(HttpServletResponse response, HttpServletRequest request, @RequestBody Projectform pro) {
		int num = projectformImpl.updateByPrimaryKeySelective(pro);
		if (num > 0) {
			return new Response(ResponseStatus.Success, pro, true);
		} else {
			return new Response(ResponseStatus.Error, AppConstant.responseInfo.INSERTERROR, false);
		}

	}

	@RequestMapping(value = "/showListPF", method = RequestMethod.GET)
	public Response showListPF(HttpServletResponse response, HttpServletRequest request, Projectform pro) {
		List<Projectform> m = projectformImpl.selectPF(pro);
		if (m != null) {
			return new Response(ResponseStatus.Success, m, true);
		} else {
			return new Response(ResponseStatus.Error, AppConstant.responseInfo.INSERTERROR, false);
		}
	}

	@RequestMapping(value = "/showPF", method = RequestMethod.GET)
	public Response showPF(HttpServletResponse response, HttpServletRequest request, HttpSession session, Integer id) {
		List<Projectform> m = projectformImpl.selectByPrimaryKeyPF(id);
		if (m != null) {
			return new Response(ResponseStatus.Success, m, true);
		} else {
			return new Response(ResponseStatus.Error, AppConstant.responseInfo.INSERTERROR, false);
		}
	}

	@RequestMapping(value = "/showByIdPF", method = RequestMethod.GET)
	public Response showByIdPF(HttpServletResponse response, HttpServletRequest request, HttpSession session,
			String id) {
		Projectform m = projectformImpl.selectIdPF(id);
		if (m != null) {
			return new Response(ResponseStatus.Success, m, true);
		} else {
			return new Response(ResponseStatus.Error, AppConstant.responseInfo.INSERTERROR, false);
		}
	}

	/**************************************************************************************/
	
	@RequestMapping(value = "/downOne", method = RequestMethod.POST)
	public Map<String, Object> exportExcel(@RequestBody Projectform mBo, HttpServletRequest request,HttpServletResponse response) {
		List<Projectform> list = getMetaSearchData(mBo);
		Map<String, Object> map = new HashMap<String, Object>();
		if (list == null || list.isEmpty()) {
			map.put("flag", false);
			map.put("result", "没有查询到数据");
		}
		HSSFWorkbook workbook = new HSSFWorkbook();// 创建一个excel 文件
		HSSFSheet sheet = workbook.createSheet(mBo.getBorrower() + mBo.getCityoforigin()); // 创建excel
																							// sheet
		sheet.setColumnWidth(0, 10 * 256); // 设置列宽度
		sheet.setColumnWidth(1, 50 * 256);
		sheet.setColumnWidth(2, 50 * 256);
		sheet.setColumnWidth(3, 20 * 256);
		sheet.setColumnWidth(4, 20 * 256);
		sheet.setColumnWidth(5, 20 * 256);
		OutputStream out = null;
		String loadurl = "";
		try {
			HSSFRow rowm = sheet.createRow(0); // 标题行
			String top[] = { "借款人", "所属市", "所属县", "借款金额", "借款日期", "合同编号","担保方式","担保人","担保金额" };
			for (int i = 0; i < top.length; i++) {
				HSSFCell cellm = rowm.createCell(i);// 创建单元格
				cellm.setCellValue(top[i]);
				cellm.setCellStyle(ExportExcelUtil.getColumnTopStyle(workbook)); // 设置单元格样式
			}
			HSSFCellStyle style = ExportExcelUtil.getStyle(workbook);
			// 遍历数据集 创建excel 的行
				HSSFRow row = sheet.createRow(1);
				HSSFCell cell = row.createCell(0);
				cell.setCellValue(mBo.getBorrower());
				cell.setCellStyle(style);
				cell = row.createCell(1);
				cell.setCellValue(mBo.getCityoforigin());
				cell.setCellStyle(style);
				cell = row.createCell(2);
				cell.setCellValue(mBo.getSubocounty());
				cell.setCellStyle(style);
				cell = row.createCell(3);
//				cell.setCellValue(mBo.getBorbalance());
				cell.setCellStyle(style);
				cell = row.createCell(4);
				cell.setCellValue(mBo.getBorrowingdate());
				cell.setCellStyle(style);
				cell = row.createCell(5);
				cell.setCellValue(mBo.getConnumber());
				cell.setCellStyle(style);
				cell = row.createCell(6);
				cell.setCellValue(mBo.getGuaranteemode());
				cell.setCellStyle(style);
				cell = row.createCell(7);
				cell.setCellValue(mBo.getBail());
				cell.setCellStyle(style);
				cell = row.createCell(8);
//				cell.setCellValue(mBo.getAmountguaranteed());
				cell.setCellStyle(style);
			String date = DateFormatUtil.getCurrentTime("yyyyMMddHHmmss");
			String fileName = date + mBo.getBorrower() + mBo.getBail() + ".xls";// 设置下载时excel
			String headStr = "attachment; filename=" + fileName;
			response.setContentType("application/vnd.ms-excel;charset=utf-8");
			response.setHeader("Content-Disposition", headStr);
			String userid = (String) request.getSession().getAttribute("userid");
			String folderName = MD5.GetMD5Code(userid);
			String path = request.getSession().getServletContext()
					.getRealPath("/upload/" + folderName + "/" + DateFormatUtil.getCurrentTime("yyyy-MM-dd"));
			File targetFile = new File(path, fileName);
			if (!targetFile.getParentFile().exists()) {
				targetFile.getParentFile().mkdirs();
			}
			if (!targetFile.exists()) {
				targetFile.createNewFile();
			}
			path = path + "/" + fileName;
			loadurl = "upload/" + folderName + "/" + DateFormatUtil.getCurrentTime("yyyy-MM-dd") + "/" + fileName;
			out = new FileOutputStream(new File(path));
			workbook.write(out);
			map.put("flag", true);
			map.put("result", loadurl);
		} catch (IOException e) {
		
			map.put("flag", false);
			map.put("result", e.getMessage());
		} finally {
			if (out != null) {
				try {
					out.flush();
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return map;
	}

	private List<Projectform> getMetaSearchData(Projectform pro) {
		return null;
	}

	/***************************************************************************************/

}
