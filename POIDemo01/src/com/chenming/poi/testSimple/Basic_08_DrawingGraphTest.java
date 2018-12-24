package com.chenming.poi.testSimple;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;

import junit.framework.TestCase;

/**
 * 这个类是测试POI画图形
 * @author 陈明
 */
public class Basic_08_DrawingGraphTest extends TestCase{

	/**
	 * 测试：画线
	 * @throws IOException 
	 */
	@Test
	public void testDrawingLine() throws IOException {
		//创建一个工作簿
		HSSFWorkbook wb = new HSSFWorkbook();
		//创建一张工作表
		HSSFSheet sheet = wb.createSheet();
		//创建一行
		HSSFRow row = sheet.createRow(0);
		
		HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
		//创建锚点
		HSSFClientAnchor anchor = new HSSFClientAnchor(0,0,0,0,(short)1,0,(short)4,4);
		
		
		
		OutputStream os = new FileOutputStream("D:\\Desktop\\GitReponsitory\\Note\\Note\\后端\\知识点\\POI\\知识点\\POI测试文件夹\\write\\testCellFormat.xls");
		wb.write(os);
		
		wb.close();
		os.close();
	}
	
}
