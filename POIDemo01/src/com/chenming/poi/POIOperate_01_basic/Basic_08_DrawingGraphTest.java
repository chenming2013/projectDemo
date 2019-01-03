package com.chenming.poi.POIOperate_01_basic;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFSimpleShape;
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
		HSSFSimpleShape shape = patriarch.createSimpleShape(anchor);
		//设置图形类型
		shape.setShapeType(HSSFSimpleShape.OBJECT_TYPE_LINE);
		shape.setLineStyle(HSSFSimpleShape.LINESTYLE_SOLID);
		shape.setLineWidth(6350);
		
		OutputStream os = new FileOutputStream("F:\\GitReponsitory\\Note\\Note\\后端\\知识点\\POI\\知识点\\POI测试文件夹\\write\\testDrawingLine.xls");
		wb.write(os);
		
		wb.close();
		os.close();
	}
	
	
	/**
	 * 测试：画矩形
	 * @throws IOException 
	 */
	@Test
	public void testDrawingRectangle() throws IOException {
		//创建一个工作簿
		HSSFWorkbook wb = new HSSFWorkbook();
		//创建一张工作表
		HSSFSheet sheet = wb.createSheet();
		
		HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
		//确定锚点
		HSSFClientAnchor anchor = new HSSFClientAnchor(255,122,255,122,(short)1,0,(short)4,3);
		HSSFSimpleShape shape = patriarch.createSimpleShape(anchor);
		//画矩形
		shape.setShapeType(HSSFSimpleShape.OBJECT_TYPE_RECTANGLE);
		//设置边框样式
		shape.setLineStyle(HSSFSimpleShape.LINESTYLE_DASHGEL);
		//设置填充色
		shape.setFillColor(255,0,0);
		//设置边框宽度
		shape.setLineWidth(25400);
		//设置边框颜色
		shape.setLineStyleColor(0,0,255);
		
		OutputStream os = new FileOutputStream("F:\\GitReponsitory\\Note\\Note\\后端\\知识点\\POI\\知识点\\POI测试文件夹\\write\\testDrawingRectangle.xls");
		wb.write(os);
		
		wb.close();
		os.close();
	}
	
	
	/**
	 * 测试：画圆形
	 * @throws IOException 
	 */
	@Test
	public void testDrawingCycle() throws IOException {
		//创建一个工作簿
		HSSFWorkbook wb = new HSSFWorkbook();
		//创建一张工作表
		HSSFSheet sheet = wb.createSheet();
		
		HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
		//缺点锚点
		HSSFClientAnchor anchor = new HSSFClientAnchor(255,122,255,122,(short)1,0,(short)4,3);
		HSSFSimpleShape shape = patriarch.createSimpleShape(anchor);
		
		//画圆形
		shape.setShapeType(HSSFSimpleShape.OBJECT_TYPE_OVAL);
		//设置填充色
		shape.setFillColor(255,0,0);
		//设置边框样式
		shape.setLineStyle(HSSFSimpleShape.LINESTYLE_DASHGEL);
		//设置边框宽度
		shape.setLineWidth(25400);
		//设置边框颜色
		shape.setLineStyleColor(0,0,255);
		
		OutputStream os = new FileOutputStream("F:\\GitReponsitory\\Note\\Note\\后端\\知识点\\POI\\知识点\\POI测试文件夹\\write\\testDrawingCycle.xls");
		wb.write(os);
		
		wb.close();
		os.close();
	}
	
	
	/**
	 * 测试：画Grid
	 * @throws IOException 
	 */
	@Test
	public void testDrawingGrid() throws IOException{
		// 创建一个工作簿
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("Test");// 创建工作表(Sheet)
		HSSFRow row = sheet.createRow(2);
		row.createCell(1);
		row.setHeightInPoints(240);
		sheet.setColumnWidth(2, 9000);
		int linesCount = 20;
		HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
		// 因为HSSFClientAnchor中dx只能在0-1023之间,dy只能在0-255之间，这里采用比例的方式
		double xRatio = 1023.0 / (linesCount * 10);
		double yRatio = 255.0 / (linesCount * 10);
		// 画竖线
		int x1 = 0;
		int y1 = 0;
		int x2 = 0;
		int y2 = 200;
		for (int i = 0; i < linesCount; i++){
			HSSFClientAnchor a2 = new HSSFClientAnchor();
			a2.setAnchor((short) 2, 2, (int) (x1 * xRatio), (int) (y1 * yRatio), (short) 2, 2, (int) (x2 * xRatio),
					(int) (y2 * yRatio));
			HSSFSimpleShape shape2 = patriarch.createSimpleShape(a2);
			shape2.setShapeType(HSSFSimpleShape.OBJECT_TYPE_LINE);
			x1 += 10;
			x2 += 10;
		}
		// 画横线
		x1 = 0;
		y1 = 0;
		x2 = 200;
		y2 = 0;
		for (int i = 0; i < linesCount; i++){
			HSSFClientAnchor a2 = new HSSFClientAnchor();
			a2.setAnchor((short) 2, 2, (int) (x1 * xRatio), (int) (y1 * yRatio), (short) 2, 2, (int) (x2 * xRatio),
					(int) (y2 * yRatio));
			HSSFSimpleShape shape2 = patriarch.createSimpleShape(a2);
			shape2.setShapeType(HSSFSimpleShape.OBJECT_TYPE_LINE);
			y1 += 10;
			y2 += 10;
		}
		
		OutputStream os = new FileOutputStream("F:\\GitReponsitory\\Note\\Note\\后端\\知识点\\POI\\知识点\\POI测试文件夹\\write\\testDrawingGrid.xls");
		wb.write(os);
		
		wb.close();
		os.close();
	}
}
