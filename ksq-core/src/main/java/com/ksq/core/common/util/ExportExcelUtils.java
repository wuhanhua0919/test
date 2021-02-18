/**
 * 
 */
package com.ksq.core.common.util;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.write.*;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.List;


/**
 * @author 韩忠诚
 *
 */
public class ExportExcelUtils {

	// 表头
	public static String[] tableHeader;
	// 数据表字段数
	public static Integer colNumber;

	/**
	 * 导出Excel
	 * 
	 * @param entities
	 * @param fileName
	 */
	public static void exportExcelDocument(HttpServletResponse response, List<List<String>> entities, String fileName, String title) {
		try {
			response.reset();// 清空输出流
			fileName = new String(fileName.getBytes("utf-8"), "iso8859-1");
			response.setContentType("application/msexcel");// 定义输出类型
			response.setHeader("Content-disposition", "attachment; filename="+fileName+".xls");// 设定输出文件头
			OutputStream os = response.getOutputStream();// 取得输出流
			WritableWorkbook wbook = Workbook.createWorkbook(os); // 建立excel文件
			WritableSheet wsheet = null; // sheet名称
			if(StringUtils.isNotBlank(title))
			{
				 wsheet = wbook.createSheet(title, 0); // sheet名称
			}else
			{
				 wsheet = wbook.createSheet(fileName, 0); 
			}
			// 1.设置报表文字和格式
			// 1.1设置excel标题文字和格式
			WritableFont titleFont = new WritableFont(WritableFont.ARIAL, 15,
					WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE,
					Colour.BLACK);
			WritableCellFormat titleFormat = new WritableCellFormat(titleFont);
			titleFormat.setAlignment(Alignment.CENTRE);
			titleFormat.setBackground(Colour.AQUA);
			// 1.2设置excel正文标题文字和格式
			WritableFont headFont = new jxl.write.WritableFont(
					WritableFont.ARIAL, 14, WritableFont.BOLD, false,
					UnderlineStyle.NO_UNDERLINE, Colour.BLACK);
			WritableCellFormat headFormat = new WritableCellFormat(headFont);
			headFormat.setAlignment(Alignment.CENTRE);
			// 1.3设置excel正文文体文字和格式
			WritableFont bodyFont = new jxl.write.WritableFont(
					WritableFont.ARIAL, 12, WritableFont.NO_BOLD, false,
					UnderlineStyle.NO_UNDERLINE, Colour.BLACK);
			WritableCellFormat bodyFormat = new WritableCellFormat(bodyFont);
			bodyFormat.setAlignment(Alignment.CENTRE);
			// 2.开始生成报表内容
			// 2.1生成报表标题
			wsheet.mergeCells(0, 0, tableHeader.length - 1, 0); // 合并单元格
			if(StringUtils.isNotBlank(title))
			{
				wsheet.addCell(new Label(0, 0, title, titleFormat));
			}
			// 2.2生成报表内容标题
			for (int i = 0; i < colNumber; i++) {
				wsheet.addCell(new Label(i, 1, tableHeader[i], headFormat));
				if(i==5||i==6){
					wsheet.setColumnView(i, 23);
				}else{
					wsheet.setColumnView(i, 17);
				}

			}
			// 2.3生成报表正文内容
			for (int i = 0; i < entities.size(); i++) {
				List<String> stringList = entities.get(i);
				for (int j = 0; j < colNumber; j++) {
					wsheet.addCell(new Label(j, i + 2, stringList.get(j),
							bodyFormat));
				}
			}
			wbook.write(); // 写入文件
			wbook.close();
			os.close(); // 关闭流
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void exportExcelDocumentCash(HttpServletResponse response, String url){
		 String inputPath=url;//url
         //response.setHeader("content-disposition", "attachment;filename=certificate" );
     	response.setHeader("Content-disposition", "attachment; filename=DF_V1.0.0.xls");// 设定输出文件头
         byte[] buf = new byte[1000];
         String file = new ExportExcelUtils().getWebRoot()+"DF_V1.0.0.xls";
         FileInputStream fos = null;
         try {
             fos = new FileInputStream(file);
             ServletOutputStream out = response.getOutputStream();
             while (fos.read(buf) != -1) {
                 out.write(buf);
             }
             response.flushBuffer();
             out.close();
         } catch (Exception e) {
             e.printStackTrace();
         } finally {
             try {
                 fos.close();
             } catch (Exception f) {
             }
         }

	}





	/**
	 * 导出Excel
	 *
	 * @param entities
	 * @param fileName
	 */
	public static void exportExcelDocumentCash(HttpServletResponse response, List<List<String>> entities,
                                               String fileName, String title) {
		try {
			response.reset();// 清空输出流
			fileName = new String(fileName.getBytes("utf-8"), "iso8859-1");
			response.setContentType("application/msexcel");// 定义输出类型
			response.setHeader("Content-disposition", "attachment; filename="+fileName+".xls");// 设定输出文件头
			OutputStream os = response.getOutputStream();// 取得输出流
			WritableWorkbook wbook = Workbook.createWorkbook(os); // 建立excel文件
			WritableSheet wsheet = null; // sheet名称
			if(StringUtils.isNotBlank(title))
			{
				 wsheet = wbook.createSheet(title, 0); // sheet名称
			}else
			{
				 wsheet = wbook.createSheet(fileName, 0);
			}
			// 1.设置报表文字和格式
			// 1.1设置excel标题文字和格式
			WritableFont titleFont = new WritableFont(WritableFont.ARIAL, 15,
					WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE,
					Colour.BLACK);
			WritableCellFormat titleFormat = new WritableCellFormat(titleFont);
			titleFormat.setAlignment(Alignment.CENTRE);
			titleFormat.setBackground(Colour.AQUA);
			// 1.2设置excel正文标题文字和格式
			WritableFont headFont = new jxl.write.WritableFont(
					WritableFont.ARIAL, 14, WritableFont.BOLD, false,
					UnderlineStyle.NO_UNDERLINE, Colour.BLACK);
			WritableCellFormat headFormat = new WritableCellFormat(headFont);
			headFormat.setAlignment(Alignment.CENTRE);
			// 1.3设置excel正文文体文字和格式
			WritableFont bodyFont = new jxl.write.WritableFont(
					WritableFont.ARIAL, 12, WritableFont.NO_BOLD, false,
					UnderlineStyle.NO_UNDERLINE, Colour.BLACK);
			WritableCellFormat bodyFormat = new WritableCellFormat(bodyFont);
			bodyFormat.setAlignment(Alignment.CENTRE);
			// 2.开始生成报表内容
			// 2.1生成报表标题
//			wsheet.mergeCells(0, 0, tableHeader.length - 1, 0); // 合并单元格
			// 2.2生成报表内容标题
			for (int i = 0; i < colNumber; i++) {
				wsheet.addCell(new Label(i, 0, tableHeader[i], headFormat));
				if(i==5||i==6){
					wsheet.setColumnView(i, 23);
				}else{
					wsheet.setColumnView(i, 17);
				}
				
			}
			// 2.3生成报表正文内容
			for (int i = 0; i < entities.size(); i++) {
				List<String> stringList = entities.get(i);
				for (int j = 0; j < colNumber; j++) {
					wsheet.addCell(new Label(j, i + 1, stringList.get(j),
							bodyFormat));
				}
			}
			wbook.write(); // 写入文件
			wbook.close();
			os.close(); // 关闭流
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
 
	/**
	* 获取路径
	* 
	* @return
	*/
	public String getWebRoot()
	{
		String realUrl = getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
		String newUrl = "";
		if(realUrl.contains("/WEB-INF/"))
		{
		newUrl = realUrl.substring(0, realUrl.lastIndexOf("WEB-INF/"));
		}
	
		realUrl = newUrl.replace("%20", " ");// 此路径不兼容jboss
	
		return realUrl;
	}
	 
	
	/**
	* 获取路径
	* 
	* @return
	*/
	public String getRootPath()
	{
		String realUrl = getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
		String newUrl = "";
		if(realUrl.contains("/classes/"))
		{
		newUrl = realUrl.substring(0, realUrl.lastIndexOf("classes/"));
		}
		realUrl = newUrl.replace("%20", " ");// 此路径不兼容jboss
		return realUrl;
	}
	 
	
	public String[] getTableHeader() {
		return tableHeader;
	}

	public void setTableHeader(String[] tableHeader) {
		this.tableHeader = tableHeader;
	}

	public Integer getColNumber() {
		return colNumber;
	}

	public void setColNumber(Integer colNumber) {
		this.colNumber = colNumber;
	}

}
