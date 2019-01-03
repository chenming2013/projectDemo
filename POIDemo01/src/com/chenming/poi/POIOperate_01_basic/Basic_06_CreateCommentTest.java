package com.chenming.poi.POIOperate_01_basic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFComment;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.junit.Test;

import junit.framework.TestCase;

/**
 * 这个类是用来测试批注的
 * @author 陈明
 * @date   2018年8月5日
 */
public class Basic_06_CreateCommentTest extends TestCase
{

	/**
	 * 测试：单表批注
	 * @throws IOException 
	 */
	@Test
	public void testCreateCommentForSingleSheet() throws IOException {
		
		InputStream is = new FileInputStream("F:\\GitReponsitory\\Note\\Note\\后端\\知识点\\POI\\知识点\\POI测试文件夹\\read\\testCommentForSingleSheet.xls");
		HSSFWorkbook wb = new HSSFWorkbook(is);
		
		is.close();
		
		HSSFSheet sheet1 = wb.getSheetAt(0);
		HSSFPatriarch patriarch = sheet1.createDrawingPatriarch();
		//创建批注位置
		HSSFClientAnchor anchor = patriarch.createAnchor(0, 0, 0, 0, 5, 1, 8, 3);
		//创建批注
		HSSFComment comment = patriarch.createCellComment(anchor);
		//设置批注内容
		comment.setString(new HSSFRichTextString("这是对姓名的批注"));
		//设置批注作者
		comment.setAuthor("cm");
		//设置批注默认显示
		//comment.setVisible(true);
		//获取指定单元格
		HSSFCell cell = sheet1.getRow(1).getCell(1);
		cell.setCellComment(comment);
		
		OutputStream os = new FileOutputStream("F:\\GitReponsitory\\Note\\Note\\后端\\知识点\\POI\\知识点\\POI测试文件夹\\read\\testCommentForSingleSheet.xls");
		wb.write(os);
		
		wb.close();
		os.close();
	}
	
	
	/**
	 * 测试：创建多表批注
	 * @throws IOException 
	 */
	@Test
	public void testCreateCommentForMultipleSheet() throws IOException {
		InputStream is = new FileInputStream("F:\\GitReponsitory\\Note\\Note\\后端\\知识点\\POI\\知识点\\POI测试文件夹\\read\\testCommentForMultipleSheet.xls");
		HSSFWorkbook wb = new HSSFWorkbook(is);
		
		is.close();
		
		//创建Sheet1的HSSFPatriarch实例
		HSSFSheet sheet1 = wb.getSheetAt(0);
		HSSFPatriarch patriarch1 = sheet1.createDrawingPatriarch();
		//创建批注位置
		HSSFClientAnchor anchor1 = patriarch1.createAnchor(0, 0, 0, 0, 5, 1, 8, 3);
		//创建批注
		HSSFComment comment1 = patriarch1.createCellComment(anchor1);
		//设置批注内容
		comment1.setString(new HSSFRichTextString("这是对姓名的批注"));
		//设置批注作者
		comment1.setAuthor("cm");
		//设置批注默认显示
		//comment.setVisible(true);
		//获取指定单元格
		HSSFCell cell = sheet1.getRow(1).getCell(1);
		cell.setCellComment(comment1);
		
		//创建Sheet2的HSSFPatriarch实例
		HSSFSheet sheet2 = wb.getSheetAt(1);
		HSSFPatriarch patriarch2 = sheet2.createDrawingPatriarch();
		//创建批注位置
		HSSFClientAnchor anchor2 = patriarch2.createAnchor(0, 0, 0, 0, 5, 1, 8, 3);
		//创建批注
		HSSFComment comment2 = patriarch2.createCellComment(anchor2);
		//设置批注内容
		comment2.setString(new HSSFRichTextString("这是对年龄的批注"));
		//设置批注作者
		comment2.setAuthor("cm");
		//设置批注默认显示
		//comment.setVisible(true);
		//获取指定单元格
		HSSFCell cell2 = sheet2.getRow(1).getCell(2);
		cell2.setCellComment(comment2);
		
		OutputStream os = new FileOutputStream("F:\\GitReponsitory\\Note\\Note\\后端\\知识点\\POI\\知识点\\POI测试文件夹\\read\\testCommentForMultipleSheet.xls");
		wb.write(os);
		
		wb.close();
		os.close();
	}
	
	/**
	 * 测试：空单元格加批注
	 * @throws IOException 
	 */
	@Test
	public void testCreateCommentForEmptyCell() throws IOException {
		//初始化一个Workbook
		HSSFWorkbook wb = new HSSFWorkbook();
		//初始化第一张Sheet
		HSSFSheet sheet1 = wb.createSheet();
		//创建此表的HSSFPatriarch实例
		HSSFPatriarch patriarch = sheet1.createDrawingPatriarch();
		//创建一行
		HSSFRow row = sheet1.createRow(0);
		//创建一个空的单元格
		HSSFCell cell = row.createCell(0);
		cell.setCellType(CellType.BLANK);
		//添加批注
		//创建锚点
		HSSFClientAnchor anchor = patriarch.createAnchor(0, 0, 0, 0, 1, 0, 2, 0);
		HSSFComment comment = patriarch.createComment(anchor);
		comment.setString(new HSSFRichTextString("这是空单元格的注释"));
		cell.setCellComment(comment);
		
		OutputStream os = new FileOutputStream("F:\\GitReponsitory\\Note\\Note\\后端\\知识点\\POI\\知识点\\POI测试文件夹\\write\\testCommentForEmptyCell.xls");
		wb.write(os);
		
		wb.close();
		os.close();
	}
}
