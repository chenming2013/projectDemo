package com.chenming.poi.formual;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;

import junit.framework.TestCase;

/**
 * 这个类是测试公式的
 * @author 陈明
 */
public class Formual_01_FormualTest extends TestCase{

	/**
	 * 测试：基本计算
	 * @throws IOException 
	 */
	@Test
	public void testBasciCalculate() throws IOException {
		//创建一张工作簿
		HSSFWorkbook wb = new HSSFWorkbook();
		//创建一张表
		HSSFSheet sheet = wb.createSheet();
		//创建一行
		HSSFRow row = sheet.createRow(0);
		//创建一个单元格
		HSSFCell cell = row.createCell(0);
		
		//设置公式
		cell.setCellFormula("2+3*4");
		
		cell = row.createCell(1);
		cell.setCellValue(10);
		
		cell = row.createCell(2);
		//设置公式
		cell.setCellFormula("A1*B1");
		
		OutputStream os = new FileOutputStream("D:\\Desktop\\GitReponsitory\\Note\\Note\\后端\\知识点\\POI\\知识点\\POI测试文件夹\\write\\testBasicCalculate.xls");
		wb.write(os);
		
		wb.close();
		os.close();
	}
	
	
	/**
	 * 测试SUM函数
	 * @throws IOException 
	 */
	@Test
	public void testSUMFunction() throws IOException {
		//创建一张工作簿
		HSSFWorkbook wb = new HSSFWorkbook();
		//创建一张表
		HSSFSheet sheet = wb.createSheet();
		
		//创建一行
		HSSFRow row0 = sheet.createRow(0);
		row0.createCell(0).setCellValue(1);
		row0.createCell(1).setCellValue(2);
		row0.createCell(2).setCellValue(3);
		row0.createCell(3).setCellValue(4);
		row0.createCell(4).setCellValue(5);
		
		//创建一行
		HSSFRow row1 = sheet.createRow(1);
		row1.createCell(0).setCellFormula("SUM(A1,C1)");  
		//上面一句代码等价于下面这一句代码："A1+C1"
		//row1.createCell(0).setCellFormula("A1+C1");
		row1.createCell(1).setCellFormula("SUM(B1:D1)");   //等价于"B1+C1+D1"
		
		OutputStream os = new FileOutputStream("D:\\Desktop\\GitReponsitory\\Note\\Note\\后端\\知识点\\POI\\知识点\\POI测试文件夹\\write\\testSUMFunction.xls");
		wb.write(os);
		
		wb.close();
		os.close();
	}
	
	/**
	 * 测试日期函数
	 * @throws IOException 
	 */
	@Test
	public void testDateFunction() throws IOException {
		//创建一张工作簿
		HSSFWorkbook wb = new HSSFWorkbook();
		//创建一张表
		HSSFSheet sheet = wb.createSheet();
		
		HSSFCellStyle style = wb.createCellStyle();
		style.setDataFormat(wb.createDataFormat().getFormat("yyyy-MM-dd"));
		
		HSSFRow row = sheet.createRow(0);
		//日历对象
		Calendar calendar = Calendar.getInstance();
		//第一个单元格设置开始时间
		HSSFCell cell00 = row.createCell(0);
		calendar.set(2016, 1, 8);
		cell00.setCellValue(calendar.getTime());
		cell00.setCellStyle(style);  
		
		//第二个单元格设置结束时间
		HSSFCell cell01 = row.createCell(1);
		calendar.set(2018, 7, 8);
		cell01.setCellValue(calendar.getTime());
		cell01.setCellStyle(style);
		
		//第三个单元格设置两个日期之间间隔的年
		HSSFCell cell02 = row.createCell(2);
		cell02.setCellFormula("concatenate(datedif(A1,B1,\"y\"),\"年\")");
		
		//第四个单元格设置两个日期之间间隔的月
		HSSFCell cell03 = row.createCell(3);
		cell03.setCellFormula("concatenate(datedif(A1,B1,\"m\"),\"月\")");
		
		//第五个单元格设置两个日期之间间隔的日
		HSSFCell cell04 = row.createCell(4);
		cell04.setCellFormula("concatenate(datedif(A1,B1,\"d\"),\"日\")");
		
		OutputStream os = new FileOutputStream("D:\\Desktop\\GitReponsitory\\Note\\Note\\后端\\知识点\\POI\\知识点\\POI测试文件夹\\write\\testDateFunction.xls");
		wb.write(os);
		
		wb.close();
		os.close();
	}
	
	
	/**
	 * 测试字符串相关的函数
	 * @throws IOException 
	 */
	@Test
	public void testStringFunction() throws IOException {
		//创建一张工作簿
		HSSFWorkbook wb = new HSSFWorkbook();
		//创建一张表
		HSSFSheet sheet = wb.createSheet();
		//创建一行
		HSSFRow row = sheet.createRow(0);
		
		row.createCell(0).setCellValue("abcdefg");
		row.createCell(1).setCellValue("aa bb cc dd ee fF GG");
		row.createCell(3).setCellFormula("upper(A1)");
		row.createCell(4).setCellFormula("proper(B1)");
		
		OutputStream os = new FileOutputStream("D:\\Desktop\\GitReponsitory\\Note\\Note\\后端\\知识点\\POI\\知识点\\POI测试文件夹\\write\\testStringFunction.xls");
		wb.write(os);
		
		wb.close();
		os.close();
	}
	
	
	/**
	 * 测试IF函数
	 * @throws IOException 
	 */
	@Test
	public void testIfFunction() throws IOException {
		//创建一张工作簿
		HSSFWorkbook wb = new HSSFWorkbook();
		//创建一张表
		HSSFSheet sheet = wb.createSheet();
		//创建一行
		HSSFRow row = sheet.createRow(0);
		
		row.createCell(0).setCellValue(12);
		row.createCell(1).setCellValue(23);
		
		row.createCell(3).setCellFormula("IF(A1>B1,\"A1大于B1\",\"A1小于等于B1\")");
		
		OutputStream os = new FileOutputStream("D:\\Desktop\\GitReponsitory\\Note\\Note\\后端\\知识点\\POI\\知识点\\POI测试文件夹\\write\\testIFFunction.xls");
		wb.write(os);
		
		wb.close();
		os.close();
	}
	
	/**
	 * 测试countIf和sumIf函数
	 * @throws IOException 
	 */
	@Test
	public void testCountIfAndSumIfFunction() throws IOException {
		//创建一张工作簿
		HSSFWorkbook wb = new HSSFWorkbook();
		//创建一张表
		HSSFSheet sheet = wb.createSheet();
		//创建一行
		HSSFRow row = sheet.createRow(0);
		
		row.createCell(0).setCellValue(57);
		row.createCell(1).setCellValue(89);
		row.createCell(2).setCellValue(56);
		row.createCell(3).setCellValue(67);
		row.createCell(4).setCellValue(60);
		row.createCell(5).setCellValue(73);
		
		row.createCell(7).setCellFormula("concatenate(\"大于等于60的个数：\",countIF(A1:F1,\">=60\"))");
		row.createCell(8).setCellFormula("concatenate(\"大于等于60的数的总和：\",sumIF(A1:F1,\">=60\",A1:F1))");
		
		OutputStream os = new FileOutputStream("D:\\Desktop\\GitReponsitory\\Note\\Note\\后端\\知识点\\POI\\知识点\\POI测试文件夹\\write\\testCountIfAndSumIfFunction.xls");
		wb.write(os);
		
		wb.close();
		os.close();
	}
	
	
	/**
	 * 测试Lookup函数
	 * @throws IOException 
	 */
	@Test
	public void testLookup() throws IOException {
		//创建一张工作簿
		HSSFWorkbook workbook = new HSSFWorkbook();
	    HSSFSheet sheet = workbook.createSheet("Test");// 创建工作表(Sheet)
	    HSSFRow row = sheet.createRow(0);
	    
	    row.createCell(0).setCellValue(0);
	    row.createCell(1).setCellValue(59);
	    row.createCell(2).setCellValue("不及格");
	    
	    row = sheet.createRow(1);
	    row.createCell(0).setCellValue(60);
	    row.createCell(1).setCellValue(69);
	    row.createCell(2).setCellValue("及格");
	   
	    row = sheet.createRow(2);
	    row.createCell(0).setCellValue(70);
	    row.createCell(1).setCellValue(79);
	    row.createCell(2).setCellValue("良好");
	    
	    row = sheet.createRow(3);
	    row.createCell(0).setCellValue(80);
	    row.createCell(1).setCellValue(100);
	    row.createCell(2).setCellValue("优秀");
	   
	    row = sheet.createRow(4);
	    row.createCell(0).setCellValue(75);
	    row.createCell(1).setCellFormula("LOOKUP(A5,$A$1:$A$4,$C$1:$C$4)");
	    row.createCell(2).setCellFormula("VLOOKUP(A5,$A$1:$C$4,3,true)");

	    OutputStream os = new FileOutputStream("D:\\Desktop\\GitReponsitory\\Note\\Note\\后端\\知识点\\POI\\知识点\\POI测试文件夹\\write\\testLookUpFunction.xls");
	    workbook.write(os);
		
	    workbook.close();
		os.close();
	}
	
	
	
}
