package com.chenming.poi.POIOperate_01_basic;


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
import org.apache.poi.ss.util.CellRangeAddress;
import org.junit.Test;

import junit.framework.TestCase;

/**
 * 这个类是用于测试一些单元格操作
 * @author 陈明
 * @date   2018年8月5日
 */
public class Basic_05_CellOperateTest extends TestCase
{

	/**
	 * 测试合并单元格
	 * @throws IOException 
	 */
	@Test
	public void testMergeCell() throws IOException {
		//初始化一个Workbook
		HSSFWorkbook wb = new HSSFWorkbook();
		//创建第一张Sheet
		HSSFSheet sheet1 = wb.createSheet();
		//创建合并单元格的第一个单元格数据
		HSSFRow row = sheet1.createRow(0);
		HSSFCell cell0 = row.createCell(0);
		cell0.setCellValue("工号");
		HSSFCell cell1 = row.createCell(1);
		cell1.setCellValue("姓名");
		HSSFCell cell2 = row.createCell(2);
		cell2.setCellValue("部门");
		HSSFCell cell3 = row.createCell(3);
		cell3.setCellValue("2010年度休假数据");
		HSSFCell cell4 = row.createCell(7);
		cell4.setCellValue("2011年度休假数据");
		
		
		HSSFRow row1 = sheet1.createRow(1);
		HSSFCell cell5 = row1.createCell(3);
		cell5.setCellValue("2010法定总假(天)");
		HSSFCell cell6 = row1.createCell(4);
		cell6.setCellValue("2010弹性总假");
		HSSFCell cell7 = row1.createCell(5);
		cell7.setCellValue("2010病假总假");
		HSSFCell cell8 = row1.createCell(6);
		cell8.setCellValue("2010补充总假");

		HSSFCell cell9 = row1.createCell(7);
		cell9.setCellValue("2011法定总假(天)");
		HSSFCell cell10 = row1.createCell(8);
		cell10.setCellValue("2011弹性总假");
		HSSFCell cell11 = row1.createCell(9);
		cell11.setCellValue("2011病假总假");
		HSSFCell cell12 = row1.createCell(10);
		cell12.setCellValue("2011补充总假");

		//设置合并单元格的区域
		CellRangeAddress region1 = new CellRangeAddress(0,1,0,0); //A1与A2进行合并
		CellRangeAddress region2 = new CellRangeAddress(0,1,1,1); //B1与B2进行合并
		CellRangeAddress region3 = new CellRangeAddress(0,1,2,2); //C1与C2进行合并
		CellRangeAddress region4 = new CellRangeAddress(0,0,3,6); //D1与G1进行合并
		CellRangeAddress region5 = new CellRangeAddress(0,0,7,10); //H1与K1进行合并
		
		sheet1.addMergedRegionUnsafe(region1);
		sheet1.addMergedRegionUnsafe(region2);
		sheet1.addMergedRegionUnsafe(region3);
		sheet1.addMergedRegionUnsafe(region4);
		sheet1.addMergedRegionUnsafe(region5);
		
		OutputStream os = new FileOutputStream("F:\\GitReponsitory\\Note\\Note\\后端\\知识点\\POI\\知识点\\POI测试文件夹\\write\\testMergeCell.xls");
		wb.write(os);
		
		wb.close();
		os.close();
	}
	
	

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
