package com.chenming.poi.testSimple;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.FontFormatting;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.junit.Test;

import junit.framework.TestCase;

public class Basic_06_CellOperateTest extends TestCase{

	/**
	 * 测试：设置单元格对齐
	 * @throws IOException 
	 */
	@Test
	public void testCellAlignment() throws IOException {
		//创建一个工作簿
		HSSFWorkbook wb = new HSSFWorkbook();
		//创建一张工作表
		HSSFSheet sheet = wb.createSheet();
		//创建一行
		HSSFRow row = sheet.createRow(0);
		//获取第一个单元格
		HSSFCell cell00 = row.createCell(0);
		cell00.setCellValue("单元格对齐");
		
		//创建单元格样式实例
		HSSFCellStyle style = wb.createCellStyle();
		//水平居中
		style.setAlignment(HorizontalAlignment.CENTER);
		//垂直居中
		style.setVerticalAlignment(VerticalAlignment.CENTER);
		//自动换行
		style.setWrapText(true);
		//缩进
		style.setIndention((short)5);
		//文本旋转
		style.setRotation((short)60);  //这里取值是从-90到90，而不是0-180
		cell00.setCellStyle(style);
		
		OutputStream os = new FileOutputStream("D:\\Desktop\\GitReponsitory\\Note\\Note\\后端\\知识点\\POI\\知识点\\POI测试文件夹\\write\\testCellAlignment.xls");
		wb.write(os);
		
		wb.close();
		os.close();
	}
	
	/**
	 * 测试：设置边框
	 * @throws IOException 
	 */
	@Test
	public void testCellBorder() throws IOException {
		//创建一个工作簿
		HSSFWorkbook wb = new HSSFWorkbook();
		//创建一张工作表
		HSSFSheet sheet = wb.createSheet();
		//创建一行
		HSSFRow row = sheet.createRow(1);
		//获取第一个单元格
		HSSFCell cell11 = row.createCell(1);
		cell11.setCellValue("单元格对齐");
		
		//创建样式
		HSSFCellStyle style = wb.createCellStyle();
		//上边框样式(虚线、实线、点线、双线等等)
		style.setBorderTop(BorderStyle.DASH_DOT);
		//右边框样式
		style.setBorderRight(BorderStyle.DOTTED);
		//下边框样式
		style.setBorderBottom(BorderStyle.DASHED);
		//左边框样式
		style.setBorderLeft(BorderStyle.DASH_DOT_DOT);
		
		//设置边框颜色
		//上边框颜色
		style.setTopBorderColor(HSSFColor.BLUE.index);
		//右边框颜色
		style.setRightBorderColor(HSSFColor.RED.index);
		//下边框颜色
		style.setBottomBorderColor(HSSFColor.YELLOW.index);
		//左边框颜色
		style.setLeftBorderColor(HSSFColor.BROWN.index);
		
		cell11.setCellStyle(style);
		
		OutputStream os = new FileOutputStream("D:\\Desktop\\GitReponsitory\\Note\\Note\\后端\\知识点\\POI\\知识点\\POI测试文件夹\\write\\testCellBorder.xls");
		wb.write(os);
		
		wb.close();
		os.close();
	}
	

	/**
	 * 测试设置字体
	 * @throws IOException 
	 */
	@Test
	public void testSetFont() throws IOException{
		//创建一个工作簿
		HSSFWorkbook wb = new HSSFWorkbook();
		//创建一张工作表
		HSSFSheet sheet = wb.createSheet();
		//创建一行
		HSSFRow row = sheet.createRow(1);
		//获取第一个单元格
		HSSFCell cell11 = row.createCell(1);
		cell11.setCellValue("设置字体");
		
		//创建字体
		HSSFFont font = wb.createFont();
		//设置字体名称
		font.setFontName("华文行楷");
		//设置字号
		font.setFontHeightInPoints((short)28);
		//设置字体颜色
		font.setColor(HSSFColor.RED.index);
		//设置下划线
		font.setUnderline(FontFormatting.U_SINGLE);
		//设置上标下标
		font.setTypeOffset(FontFormatting.SS_SUPER);
		//设置删除线
		font.setStrikeout(true);
		
		//创建样式
		HSSFCellStyle style = wb.createCellStyle();
		style.setFont(font);
		cell11.setCellStyle(style);
		
		OutputStream os = new FileOutputStream("D:\\Desktop\\GitReponsitory\\Note\\Note\\后端\\知识点\\POI\\知识点\\POI测试文件夹\\write\\testFont.xls");
		wb.write(os);
		
		wb.close();
		os.close();
	}
	
	/**
	 * 设置单元格背景色
	 * @throws IOException 
	 */
	@Test
	public void testBackgroundColor() throws IOException {
		//创建一个工作簿
		HSSFWorkbook wb = new HSSFWorkbook();
		//创建一张工作表
		HSSFSheet sheet = wb.createSheet();
		//创建一行
		HSSFRow row = sheet.createRow(1);
		//获取第一个单元格
		HSSFCell cell11 = row.createCell(1);
		cell11.setCellValue("背景色和纹理");
		
		HSSFCellStyle style = wb.createCellStyle();
		//设置图案前景色
		style.setFillForegroundColor(HSSFColor.YELLOW.index);
		//设置图案背景色
		style.setFillBackgroundColor(HSSFColor.RED.index);
		//设置图案样式
		style.setFillPattern(FillPatternType.SQUARES);
		
		cell11.setCellStyle(style);
		
		OutputStream os = new FileOutputStream("D:\\Desktop\\GitReponsitory\\Note\\Note\\后端\\知识点\\POI\\知识点\\POI测试文件夹\\write\\testBackgroundColor.xls");
		wb.write(os);
		
		wb.close();
		os.close();
	}
	
	
	/**
	 * 设置宽度和高度
	 * @throws IOException 
	 */
	@Test
	public void testWidthAndHeight() throws IOException {
		//创建一个工作簿
		HSSFWorkbook wb = new HSSFWorkbook();
		//创建一张工作表
		HSSFSheet sheet = wb.createSheet();
		//创建一行
		HSSFRow row = sheet.createRow(1);
		//获取第一个单元格
		HSSFCell cell11 = row.createCell(1);
		cell11.setCellValue("宽度和高度");
		
		//设置第二行的高度是40px
		row.setHeight((short)(15.625*40));
		row.setHeightInPoints((float)40);
		//设置第二列的宽度是100px
		sheet.setColumnWidth(1, (int)35.7*100);
		
		OutputStream os = new FileOutputStream("D:\\Desktop\\GitReponsitory\\Note\\Note\\后端\\知识点\\POI\\知识点\\POI测试文件夹\\write\\testWidthAndHeight.xls");
		wb.write(os);
		
		wb.close();
		os.close();
	}
}
