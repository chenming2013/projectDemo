package com.chenming.poi.POIOperate_02_read_and_write;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import junit.framework.TestCase;

/**
 * 简单测试追加数据到已有的Excel
 * @author 陈明
 */
public class TestSimpleAddToExcel extends TestCase{

	/**
	 * 简单追加数据到 .xls 格式的Excel文件
	 * 	文件绝对路径：D:\Desktop\GitReponsitory\Note\Note\后端\知识点\POI\知识点\POI测试文件夹\write\testAdd1.xls
	 *  这个方法只是简短的追加内容,对于单元格没有内容,单元格格式,单元格样式等等都没有做处理
	 * @throws IOException 
	 * @throws InvalidFormatException 
	 * @throws EncryptedDocumentException 
	 */
	@Test
	public void testSimpleAddToExcelForXLS() throws EncryptedDocumentException, InvalidFormatException, IOException {
		File file = new File("D:/Desktop/GitReponsitory/Note/Note/后端/知识点/POI/知识点/POI测试文件夹/write/testAdd1.xls");
		InputStream is = new FileInputStream(file);
		Workbook wb = WorkbookFactory.create(is);
		Iterator<Sheet> sheetIterator = wb.sheetIterator();
		while(sheetIterator.hasNext()) {
			Sheet sheet = sheetIterator.next();
			int lastRowNum = sheet.getLastRowNum();
			int lastCellNum = sheet.getRow(lastRowNum-1).getLastCellNum();
			Row row = sheet.createRow(lastRowNum+1);
			for(int i=0;i<lastCellNum;i++) {
				Cell cell = row.createCell(i);
				cell.setCellValue("新增("+(lastRowNum+1)+","+i+")");
			}
		}
		is.close();
		OutputStream os = new FileOutputStream("D:/Desktop/GitReponsitory/Note/Note/后端/知识点/POI/知识点/POI测试文件夹/write/testAdd1.xls");
		os.flush();
		wb.write(os);
		os.close();
	}
	
	/**
	 * 简单追加数据到 .xls 格式的Excel文件
	 * 	文件绝对路径：D:\Desktop\GitReponsitory\Note\Note\后端\知识点\POI\知识点\POI测试文件夹\write\testAdd1.xlsx
	 *  这个方法只是简短的追加内容,对于单元格没有内容,单元格格式,单元格样式等等都没有做处理
	 * @throws IOException 
	 * @throws InvalidFormatException 
	 * @throws EncryptedDocumentException 
	 */
	@Test
	public void testSimpleAddToExcelForXLSX() throws IOException, EncryptedDocumentException, InvalidFormatException {
		InputStream is = new FileInputStream("D:/Desktop/GitReponsitory/Note/Note/后端/知识点/POI/知识点/POI测试文件夹/write/testAdd1.xlsx");
		//打开Excel(Workbook)
		Workbook wb = WorkbookFactory.create(is);
		Iterator<Sheet> sheetIterator = wb.sheetIterator();
		while(sheetIterator.hasNext()) {
			Sheet sheet = sheetIterator.next();
			int lastRowNum = sheet.getLastRowNum();
			int lastCellNum = sheet.getRow(lastRowNum-1).getLastCellNum();
			Row row = sheet.createRow(lastRowNum+1);
			for(int i=0;i<lastCellNum;i++) {
				Cell cell = row.createCell(i);
				cell.setCellValue("新增("+(lastRowNum+1)+","+i+")");
			}
		}
		is.close();
		OutputStream os = new FileOutputStream("D:/Desktop/GitReponsitory/Note/Note/后端/知识点/POI/知识点/POI测试文件夹/write/testAdd1.xlsx");
		os.flush();
		wb.write(os);
		os.close();
	}
	
}
