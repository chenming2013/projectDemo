package com.chenming.poi.testSimple;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import junit.framework.TestCase;

/**
 * 测试简单的写入数据到Excel(创建新的Excel)
 * @author 陈明
 */
public class TestSimpleWriteExcel extends TestCase{
	
	/**
	 * 测试简单写入数据到Excel(使用WorkbookFactory创建 .xsl 格式的Excel)
	 * @throws IOException 
	 * @throws InvalidFormatException 
	 * @throws EncryptedDocumentException 
	 */
	@Test
	public void testSimpleWriteForXSL() throws EncryptedDocumentException, InvalidFormatException, IOException {
		File file = new File("D:/Desktop/GitReponsitory/Note/Note/后端/知识点/POI/知识点/POI测试文件夹/write/testWrite1.xls");
		Workbook wb = new HSSFWorkbook();
		//创建一个Sheet:sheet1
		Sheet sheet1 = wb.createSheet("sheet1");
		//创建三行、五列的表格
		for(int i=0;i<3;i++) {
			Row row = sheet1.createRow(i);
			for(int j=0;j<5;j++) {
				Cell cell = row.createCell(j);
				cell.setCellValue("("+i+","+j+")");
			}
		}
		wb.write(new FileOutputStream(file));
	}
	
	/**
	 * 测试简单写入数据到Excel(使用WorkbookFactory创建 .xslx 格式的Excel)
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@Test
	public void testSimpleWriteForXLSX() throws FileNotFoundException, IOException {
		File file = new File("D:/Desktop/GitReponsitory/Note/Note/后端/知识点/POI/知识点/POI测试文件夹/write/testWrite1.xlsx");
		Workbook wb = new XSSFWorkbook();
		//创建一个Sheet：sheet1
		Sheet sheet1 = wb.createSheet("sheet1");
		//创建三行、五列的表格
		for(int i=0;i<3;i++) {
			Row row = sheet1.createRow(i);
			for(int j=0;j<5;j++) {
				Cell cell = row.createCell(j);
				cell.setCellValue("("+i+","+j+")");
			}
		}
		wb.write(new FileOutputStream(file));
	}
}
