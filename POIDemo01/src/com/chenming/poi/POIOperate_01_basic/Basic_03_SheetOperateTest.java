package com.chenming.poi.POIOperate_01_basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFFooter;
import org.apache.poi.hssf.usermodel.HSSFHeader;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import junit.framework.TestCase;

/**
 * 这个类是专门用来测试Sheet的
 * @author 陈明
 * @date   2018年8月5日
 */
public class Basic_03_SheetOperateTest extends TestCase
{
	
	/**
	 * 测试 ： 设置默认工作表
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testSetDefaultSheet() throws FileNotFoundException {
		HSSFWorkbook wb = new HSSFWorkbook();
		OutputStream os = new FileOutputStream("F:\\GitReponsitory\\Note\\Note\\后端\\知识点\\POI\\知识点\\POI测试文件夹\\write\\testSetDefaultSheet.xls");
		//创建4个sheet
		wb.createSheet("第一个Sheet");
		wb.createSheet("第二个Sheet");
		wb.createSheet("第三个Sheet");
		wb.createSheet("第四个Sheet");
		//设置默认工作表
		wb.setActiveSheet(2);  //设置第三个Sheet为默认工作表
		try{
			wb.write(os);
		} catch (IOException e){
			e.printStackTrace();
		}finally {
			if(wb!=null) {
				try{
					wb.close();
				} catch (IOException e){
					e.printStackTrace();
				}finally {
					wb = null;
				}
			}
			if(os!=null) {
				try{
					os.close();
				} catch (IOException e){
					e.printStackTrace();
				}finally {
					os = null;
				}
			}
		}
	}
	
	/**
	 * 测试： 重命名工作表
	 * 	在这个方法里我们先创建一张工作表,为重命名工作表做准备
	 * @throws IOException 
	 */
	@Test
	public void testRenameSheetPreparing() throws IOException {
		HSSFWorkbook wb = new HSSFWorkbook();
		//创建两张工作表
		wb.createSheet("第一张Sheet");
		wb.createSheet("第二张Sheet");
		//生成Excel
		OutputStream os = new FileOutputStream("F:\\GitReponsitory\\Note\\Note\\后端\\知识点\\POI\\知识点\\POI测试文件夹\\write\\testRenameSheet.xls");
		wb.write(os);

		wb.close();
		os.close();
		
	}
	/**
	 * 测试： 重命名工作表
	 * 	在这个方法里，我们正式重命名工作表
	 * @throws IOException 
	 */
	@Test
	public void testRenameSheetDoing() throws IOException {
		//读取上一个方法生成的文件
		InputStream is = new FileInputStream("F:\\GitReponsitory\\Note\\Note\\后端\\知识点\\POI\\知识点\\POI测试文件夹\\write\\testRenameSheet.xls");
		HSSFWorkbook wb = new HSSFWorkbook(is);
		wb.setSheetName(1, "这是重命名后的Sheet");
		//输入流和输出流都作用于同一个文件的话,必须先关闭一个流
		is.close();
		OutputStream os = new FileOutputStream("F:\\GitReponsitory\\Note\\Note\\后端\\知识点\\POI\\知识点\\POI测试文件夹\\write\\testRenameSheet.xls");
		wb.write(os);
		wb.close();
		os.close();
	}
	
	
	/**
	 * 测试：表单显示比例
	 * @throws IOException 
	 */
	@Test
	public void testSetSheetZoom() throws IOException {
		HSSFWorkbook wb = new HSSFWorkbook();
		//创建两张Sheet
		HSSFSheet sheet1 = wb.createSheet("第一张Sheet");
		HSSFSheet sheet2 = wb.createSheet("第二张Sheet");
		sheet1.setZoom(1,2);
		sheet2.setZoom(2,1);
		
		OutputStream os = new FileOutputStream("F:\\GitReponsitory\\Note\\Note\\后端\\知识点\\POI\\知识点\\POI测试文件夹\\write\\testSetSheetZoom.xls");
		wb.write(os);
		
		wb.close();
		os.close();
	}
	
	
	/**
	 * 测试：显示/隐藏网格线
	 * @throws IOException 
	 */
	@Test
	public void testGridliines() throws IOException {
		HSSFWorkbook wb = new HSSFWorkbook();
		//创建两张Sheet
		HSSFSheet sheet1 = wb.createSheet("第一张Sheet");
		HSSFSheet sheet2 = wb.createSheet("第二张Sheet");
		sheet1.setDisplayGridlines(false);
		sheet2.setDisplayGridlines(true);
		
		OutputStream os = new FileOutputStream("F:\\GitReponsitory\\Note\\Note\\后端\\知识点\\POI\\知识点\\POI测试文件夹\\write\\testGridlines.xls");
		wb.write(os);
		
		wb.close();
		os.close();
	}
	
	/**
	 * 测试：遍历Sheet
	 * @throws IOException 
	 * @throws InvalidFormatException 
	 * @throws EncryptedDocumentException 
	 */
	@Test
	public void testIteratorSheet_1() throws EncryptedDocumentException, InvalidFormatException, IOException {
		//打开Workbook
		File file = new File("F:\\GitReponsitory\\Note\\Note\\后端\\知识点\\POI\\知识点\\POI测试文件夹\\read\\1.xls");
		HSSFWorkbook wb = (HSSFWorkbook)WorkbookFactory.create(file);
		//获取第一个Sheet
		HSSFSheet sheet1 = wb.getSheetAt(0);
		//遍历sheet
		for(int i=0;i<=sheet1.getLastRowNum();i++) {
			HSSFRow row = sheet1.getRow(i);
			if(row==null) {
				System.out.println();
				continue;
			}
			for(int j=0;j<row.getLastCellNum();j++) {
				HSSFCell cell = row.getCell(j);
				if(cell==null) {
					System.out.println();
					continue;
				}
				if(cell.getCellTypeEnum().equals(CellType.NUMERIC)) {
					System.out.print(cell.getNumericCellValue()+"\t");
				}else {
					System.out.print(cell.getStringCellValue()+"\t");
				}
			}
			System.out.println();
		}
		wb.close();
	}
	
	/**
	 * 测试 ： 遍历Sheet
	 * @throws IOException 
	 * @throws InvalidFormatException 
	 * @throws EncryptedDocumentException 
	 */
	@Test
	public void testIteratorSheet_2() throws EncryptedDocumentException, InvalidFormatException, IOException {
		//打开Workbook
		File file = new File("F:\\GitReponsitory\\Note\\Note\\后端\\知识点\\POI\\知识点\\POI测试文件夹\\read\\1.xls");
		HSSFWorkbook wb = (HSSFWorkbook)WorkbookFactory.create(file);
		//获取第一个Sheet
		HSSFSheet sheet1 = wb.getSheetAt(0);
		//遍历sheet
		Iterator<Row> rowIterator = sheet1.rowIterator();
		while(rowIterator.hasNext()) {
			HSSFRow row = (HSSFRow)rowIterator.next();
			Iterator<Cell> cellIterator = row.cellIterator();
			while(cellIterator.hasNext()) {
				HSSFCell cell = (HSSFCell)cellIterator.next();
				if(cell.getCellTypeEnum().equals(CellType.NUMERIC)) {
					System.out.print(cell.getNumericCellValue()+"\t");
				}else {
					System.out.print(cell.getStringCellValue()+"\t");
				}
			}
			System.out.println();
		}
		wb.close();
	}
	
	/**
	 * 测试：创建页眉和页脚
	 * 	【注：该方法产生的Excel文件没有见到页眉页脚,暂不清楚原因】
	 * @throws IOException 
	 */
	@Test
	public void testHeaderAndFooter() throws IOException {
		HSSFWorkbook wb = new HSSFWorkbook();
		//创建两张Sheet
		HSSFSheet sheet1 = wb.createSheet("第一张Sheet");
		//得到页眉
		HSSFHeader header = sheet1.getHeader();
		header.setCenter("页眉中间");
		header.setLeft("页眉左边");
		header.setRight("页眉右边");
		
		//得到页脚
		HSSFFooter footer = sheet1.getFooter();
		footer.setLeft("页脚左边");
		footer.setCenter("页脚中间");
		footer.setRight("页脚右边");
		
		OutputStream os = new FileOutputStream("F:\\GitReponsitory\\Note\\Note\\后端\\知识点\\POI\\知识点\\POI测试文件夹\\write\\testHeaderAndFooter.xls");
		wb.write(os);
		
		wb.close();
		os.close();
	}
	
}
