package com.xx.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.bayside.npa.projectform.model.Projectform;
import com.bayside.npa.util.DateFormatUtil;
import com.bayside.npa.util.ExportExcelUtil;

public class Test01 {
	public Map<String, Object> exportExcel(Projectform pro, HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HSSFWorkbook workbook = new HSSFWorkbook();// 创建一个excel 文件
		HSSFSheet sheet = workbook.createSheet("名字" + "类型"); // 创建excel
		// sheet
		sheet.setColumnWidth(0, 10 * 256); // 设置列宽度
		sheet.setColumnWidth(1, 50 * 256);
		sheet.setColumnWidth(2, 50 * 256);
		sheet.setColumnWidth(3, 20 * 256);
		OutputStream out = null;
		String loadurl = "";
		try {
			HSSFRow rowm = sheet.createRow(0); // 标题行
			String top[] = { "序号", "标题", "简介"};
			for (int i = 0; i < top.length; i++) {
				HSSFCell cellm = rowm.createCell(i);// 创建单元格
				cellm.setCellValue(top[i]);
				cellm.setCellStyle(ExportExcelUtil.getColumnTopStyle(workbook)); // 设置单元格样式
			}
			int rownum = 1;
			HSSFCellStyle style = ExportExcelUtil.getStyle(workbook);
			// 遍历数据集 创建excel 的行
				HSSFRow row = sheet.createRow(rownum);
				HSSFCell cell = row.createCell(0);
				cell.setCellValue(rownum);
				cell.setCellStyle(style);
				cell = row.createCell(1);
				cell.setCellValue("测试标题");
				cell.setCellStyle(style);
				cell = row.createCell(2);
				cell.setCellValue("1111");
				cell.setCellStyle(style);
				cell = row.createCell(3);
				cell.setCellValue("2222");
				cell.setCellStyle(style);
			String date = DateFormatUtil.getCurrentTime("yyyyMMddHHmmss");
			String fileName = date + "名字" + "类型" + ".xls";// 设置下载时excel的名字
			String headStr = "attachment; filename=" + fileName;
			response.setContentType("application/vnd.ms-excel;charset=utf-8");
			response.setHeader("Content-Disposition", headStr);
			String path = request.getSession().getServletContext()
					.getRealPath("/upload/" + "mingzi" + "/" + DateFormatUtil.getCurrentTime("yyyy-MM-dd"));
			File targetFile = new File(path, fileName);
			if (!targetFile.getParentFile().exists()) {
				targetFile.getParentFile().mkdirs();
			}
			if (!targetFile.exists()) {
				targetFile.createNewFile();
			}
			path = path + "/" + fileName;
			loadurl = "upload/" + "mingzi" + "/" + DateFormatUtil.getCurrentTime("yyyy-MM-dd") + "/" + fileName;
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
		System.out.println(map.get("flag"));
		return map;
	}
	
	public static void main(String[] args) {
		new Test01();
	}
}