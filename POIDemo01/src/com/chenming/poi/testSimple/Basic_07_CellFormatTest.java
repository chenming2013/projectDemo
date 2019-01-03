package com.chenming.poi.testSimple;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;

import junit.framework.TestCase;

/**
 * 测试 单元格格式
 * @author 陈明
 */
public class Basic_07_CellFormatTest extends TestCase{

	/**
	 * 测试单元格格式
	 * @throws IOException 
	 */
	@Test
	public void testCellFormat() throws IOException {
		//创建一个工作簿
		HSSFWorkbook wb = new HSSFWorkbook();
		//创建一张工作表
		HSSFSheet sheet = wb.createSheet();
		//创建一行
		HSSFRow row = sheet.createRow(0);
		
		//设置日期格式--使用Excel内嵌的格式
		HSSFCell cell00 = row.createCell(0);
		cell00.setCellValue(new Date());
		HSSFCellStyle style = wb.createCellStyle();
		style.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm"));
		cell00.setCellStyle(style);
		
		
		//设置保留2位小数--使用Excel内置的格式
		HSSFCell cell01 = row.createCell(1);
		cell01.setCellValue(12.3456789);
		HSSFCellStyle style2 = wb.createCellStyle();
		style2.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00"));
		cell01.setCellStyle(style2);
		
		
		//设置货币格式--使用自定义的格式
		HSSFCell cell02 = row.createCell(2);
		cell02.setCellValue(12345.6789);
		HSSFCellStyle style3 = wb.createCellStyle();
		style3.setDataFormat(wb.createDataFormat().getFormat("￥#,##0"));
		cell02.setCellStyle(style3);
		
		
		//设置百分比格式--使用自定义的格式
		HSSFCell cell03 = row.createCell(3);
		cell03.setCellValue(0.123456789);
		HSSFCellStyle style4 = wb.createCellStyle();
		style4.setDataFormat(wb.createDataFormat().getFormat("0.00%"));
		cell03.setCellStyle(style4);
		
		
		//设置中文大小写格式--使用自定义的格式
		HSSFCell cell04 = row.createCell(4);
		cell04.setCellValue(12345);
		HSSFCellStyle style5 = wb.createCellStyle();
		style5.setDataFormat(wb.createDataFormat().getFormat("[DbNum2][$-804]0"));
		cell04.setCellStyle(style5);
		
		
		//设置科学计数法格式--使用自定义的格式
		HSSFCell cell05 = row.createCell(5);
		cell05.setCellValue(12345);
		HSSFCellStyle style6 = wb.createCellStyle();
		style6.setDataFormat(wb.createDataFormat().getFormat("0.00E+00"));
		cell05.setCellStyle(style6);
		
		
		OutputStream os = new FileOutputStream("D:\\Desktop\\GitReponsitory\\Note\\Note\\后端\\知识点\\POI\\知识点\\POI测试文件夹\\write\\testCellFormat.xls");
		wb.write(os);
		
		wb.close();
		os.close();
	}
}
