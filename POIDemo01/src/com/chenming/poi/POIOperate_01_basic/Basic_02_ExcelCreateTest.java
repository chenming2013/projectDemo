package com.chenming.poi.POIOperate_01_basic;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import junit.framework.TestCase;

/**
 * 这个类是专门用来测试生成Excel文件
 * 	打开Excel有三种方式,但是创建Excel只有一种方式,那就是new对象的方式
 * @author 陈明
 * @date   2018年8月5日
 */
public class Basic_02_ExcelCreateTest extends TestCase
{
	
	/**
	 * 创建新的Excel文件：
	 * 	这个方法是专门测试生成 .xls 格式的Excel文件
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testCreateExcelForXLSUsingNew() throws FileNotFoundException {
		HSSFWorkbook hwb = new HSSFWorkbook();
		OutputStream os = new FileOutputStream("F:\\GitReponsitory\\Note\\Note\\后端\\知识点\\POI\\知识点\\POI测试文件夹\\write\\testCreateExcelForXLSUsingNew.xls");
		try{
			hwb.write(os);
		} catch (IOException e){
			e.printStackTrace();
		}finally {
			if(hwb!=null) {
				try{
					hwb.close();
				} catch (IOException e){
					e.printStackTrace();
				}finally {
					hwb = null;
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
	 * 创建新的Excel文件：
	 * 	这个方法是专门测试生成 .xlsx 格式的Excel文件
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testCreateExcelForXLSXUsingNew() throws FileNotFoundException {
		XSSFWorkbook xwb = new XSSFWorkbook();
		OutputStream os = new FileOutputStream("F:\\GitReponsitory\\Note\\Note\\后端\\知识点\\POI\\知识点\\POI测试文件夹\\write\\testCreateExcelForXLSUsingNew.xlsx");
		try {
			xwb.write(os);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(xwb!=null) {
				try{
					xwb.close();
				} catch (IOException e){
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					xwb = null;
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
}
