package com.chenming.poi.POIOperate_02_read_and_write;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import junit.framework.TestCase;

/**
 * 测试POI简单读取Excel
 * @author 陈明
 *
 */
public class TestSimpleReadExcel extends TestCase{

	/**
	 * 简单读取 .xls 格式的Excel文件(使用WorkbookFactory读取Excel)
	 * 	文件绝对路径：D:\Desktop\GitReponsitory\Note\Note\后端\知识点\POI\知识点\POI测试文件夹\read\1.xls
	 *  这个方法只是简短的读取内容,对于单元格没有内容,单元格格式,单元格样式等等都没有做处理
	 * @throws IOException 
	 * @throws InvalidFormatException 
	 * @throws EncryptedDocumentException 
	 */
	@Test
	public void testSimpleReadExcelForXSL() throws EncryptedDocumentException, InvalidFormatException, IOException {
		File file = new File("D:\\Desktop\\GitReponsitory\\Note\\Note\\后端\\知识点\\POI\\知识点\\POI测试文件夹\\read\\1.xls");
		//获取Workbook对象
		Workbook wb = WorkbookFactory.create(file);
		//循环遍历所有Sheet对象
		for(int i=0;i<wb.getNumberOfSheets();i++) {
			Sheet sheet = wb.getSheetAt(i);
			//获取所有的Row集合
			Iterator<Row> rowIt = sheet.rowIterator();
			while(rowIt.hasNext()) {
				Row row = (Row) rowIt.next();
				if(row!=null) {
					//System.out.println(row.getRowNum());
					//获取所有的Cell集合
					Iterator<Cell> cellIt = row.cellIterator();
					while(cellIt.hasNext()) {
						Cell cell = (Cell)cellIt.next();
						String value = cell.getStringCellValue();
						System.out.print(value+"\t");
					}
				}
				//换一行
				System.out.println();
			}
		}
	}
	
	/**
	 * 简单读取 .xls 格式的Excel文件(使用POIFSFIleSystem读取Excel)
	 * 	文件绝对路径：D:\Desktop\GitReponsitory\Note\Note\后端\知识点\POI\知识点\POI测试文件夹\read\1.xls
	 *  这个方法只是简短的读取内容,对于单元格没有内容,单元格格式,单元格样式等等都没有做处理
	 * @throws IOException 
	 */
	@Test
	public void testSimpleReadExcelForXLS_2() throws IOException {
		File file = new File("D:\\Desktop\\GitReponsitory\\Note\\Note\\后端\\知识点\\POI\\知识点\\POI测试文件夹\\read\\1.xls");
		POIFSFileSystem poifsFileSystem = new POIFSFileSystem(file);
		Workbook wb = WorkbookFactory.create(poifsFileSystem);
		Iterator<Sheet> sheetIterator = wb.sheetIterator();
		while(sheetIterator.hasNext()) {
			Sheet sheet = sheetIterator.next();
			Iterator<Row> rowIterator = sheet.rowIterator();
			while(rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				while(cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					String value = cell.getStringCellValue();
					System.out.print(value+"\t");
				}
				System.out.println();
			}
		}
	}
	
	
	/**
	 * 简单读取 .xlsx 格式的Excel文件(使用WorkbookFactory)
	 * 	文件绝对路径：D:\Desktop\GitReponsitory\Note\Note\后端\知识点\POI\知识点\POI测试文件夹\read\1.xlsx
	 *  这个方法只是简短的读取内容,对于单元格没有内容,单元格格式,单元格样式等等都没有做处理
	 * @throws IOException 
	 * @throws InvalidFormatException 
	 * @throws EncryptedDocumentException 
	 */
	@Test
	public void testSimpleReadExcelForXLSX() throws EncryptedDocumentException, InvalidFormatException, IOException {
		File file = new File("D:\\Desktop\\GitReponsitory\\Note\\Note\\后端\\知识点\\POI\\知识点\\POI测试文件夹\\read\\1.xlsx");
		Workbook wb = WorkbookFactory.create(file);
		int sheets = wb.getNumberOfSheets();
		//循环遍历每一张Sheet
		for(int i=0;i<sheets;i++) {
			//得到具体的Sheet
			Sheet sheet = wb.getSheetAt(i);
			//获取所有的row集合
			Iterator<Row> rowIterator = sheet.rowIterator();
			while(rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				while(cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					String value = cell.getStringCellValue();
					System.out.print(value+"\t");
				}
				System.out.println();
			}
		}
	}
	
	/**
	 * 简单读取 .xlsx 格式的Excel文件(使用POIFSFileSystem)
	 * 	文件绝对路径：D:\Desktop\GitReponsitory\Note\Note\后端\知识点\POI\知识点\POI测试文件夹\read\1.xlsx
	 *  这个方法只是简短的读取内容,对于单元格没有内容,单元格格式,单元格样式等等都没有做处理
	 * @throws IOException 
	 */
	@Test
	public void testSimpleReadExcelForXLSX_2() throws IOException {
		File file = new File("D:\\Desktop\\GitReponsitory\\Note\\Note\\后端\\知识点\\POI\\知识点\\POI测试文件夹\\read\\1.xlsx");
		POIFSFileSystem fs = new POIFSFileSystem(file);
		Workbook wb = WorkbookFactory.create(fs);
		Iterator<Sheet> sheetIterator = wb.sheetIterator();
		while(sheetIterator.hasNext()) {
			Sheet sheet = sheetIterator.next();
			Iterator<Row> rowIterator = sheet.rowIterator();
			while(rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				while(cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					String value = cell.getStringCellValue();
					System.out.print(value+"\t");
				}
				System.out.println();
			}
		}
	}
	
}
