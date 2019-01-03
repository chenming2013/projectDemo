package com.chenming.poi.POIOperate_01_basic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;

import junit.framework.TestCase;

/**
 * 这个类测试Excel行列操作
 * @author 陈明
 * @date   2018年8月5日
 */
public class Basic_04_RowAndColumnOperateTest extends TestCase
{
	
	/**
	 * 测试行、列组合
	 * 	所谓组合就是让n行或n列组合成一个集合,能够进行展开和合拢操作。
	 * @throws IOException 
	 */
	@Test
	public void testGroup() throws IOException {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet1 = wb.createSheet("第一个Sheet");
		sheet1.groupRow(1, 3);  //组合行
		sheet1.groupRow(2, 5);  //组合列
		sheet1.groupColumn(2, 9); //组合列
		
		OutputStream os = new FileOutputStream("F:\\GitReponsitory\\Note\\Note\\后端\\知识点\\POI\\知识点\\POI测试文件夹\\write\\testGroup.xls");
		wb.write(os);
		
		wb.close();
		os.close();
	}
	
	
	/**
	 * 测试锁定列
	 * @throws IOException 
	 */
	@Test
	public void testFreezePane() throws IOException {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet1 = wb.createSheet("第一个Sheet");
		sheet1.createFreezePane(2, 3, 15, 25);
		
		OutputStream os = new FileOutputStream("F:\\GitReponsitory\\Note\\Note\\后端\\知识点\\POI\\知识点\\POI测试文件夹\\write\\testFreezePane.xls");
		wb.write(os);
		
		wb.close();
		os.close();
	}
	
	
	/**
	 * 测试：上下移动行
	 * @throws IOException 
	 */
	@Test
	public void testMoveRows() throws IOException {
		InputStream in = new FileInputStream("F:\\GitReponsitory\\Note\\Note\\后端\\知识点\\POI\\知识点\\POI测试文件夹\\read\\testMove.xls");
		HSSFWorkbook wb = new HSSFWorkbook(in);
		HSSFSheet sheet1 = wb.getSheetAt(0);
		sheet1.shiftRows(3, 4, 3);  //把第四行到第五行向下移动3行
		in.close();
		
		OutputStream os = new FileOutputStream("F:\\GitReponsitory\\Note\\Note\\后端\\知识点\\POI\\知识点\\POI测试文件夹\\read\\testMove.xls");
		wb.write(os);
		
		wb.close();
		os.close();
	}
}
