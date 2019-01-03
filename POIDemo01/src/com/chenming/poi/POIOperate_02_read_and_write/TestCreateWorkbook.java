package com.chenming.poi.POIOperate_02_read_and_write;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import junit.framework.TestCase;

/**
 * 这是第 1 个文件(按编写测试顺序)
 */
/**
 * 测试获取Workbook对象(Workbook对象是HSSFWorkboo和XSSFWorkbook的父接口)
 * 	这要分情况讨论:
 * 	1.如果是读取Excel文件：
 * 		1)通过WorkbookFactory生成对象
 * 		2)通过POIFSFileSystem生成对象
 * 	2.如果是创建Excel文件：
 * @author Lenovo
 *
 */
public class TestCreateWorkbook extends TestCase
{
	private static final String RESOURCE = "F:\\GitReponsitory\\Note\\Note\\后端\\知识点\\POI\\知识点\\POI测试文件夹\\read\\1.xls";
	/**
	 * 测试读取Excel文件而创建的Workbook对象
	 * @throws IOException 
	 * @throws InvalidFormatException 
	 * @throws EncryptedDocumentException 
	 */
	@Test
	public void testWorkbookForReadExcel() throws EncryptedDocumentException, InvalidFormatException, IOException 
	{
		/**
		 * 两种方式：
		 * 	1.通过WorkbookFactory生成Workbook对象
		 * 	2.通过POIFSFileSystem生成Workbook对象
		 */
		//第一种方式
		File file = new File(RESOURCE);
//		Workbook wb = WorkbookFactory.create(file);
//		System.out.println(wb);	//org.apache.poi.hssf.usermodel.HSSFWorkbook@6536e911
//		//如果成功打开Excel,处理完之后要及时关闭IO
//		if(wb!=null) {
//			wb.close();
//		}
		
		//第二种方式
		POIFSFileSystem poifs = POIFSFileSystem.create(file);
		Workbook wb2 = null;
		if(file.getName().toLowerCase().endsWith(".xls")) {
			//如果打开的是 .xls 格式的Excel文件
			wb2 = new HSSFWorkbook(poifs);
			System.out.println(wb2);
		}else {	
			//如果打开的是 .xlsx 格式的Excel文件,就不能使用POIFSFileSystem对象
			System.out.println("不能打开");
		}
		if(wb2!=null) {
			wb2.close();
		}
	}
	
}
