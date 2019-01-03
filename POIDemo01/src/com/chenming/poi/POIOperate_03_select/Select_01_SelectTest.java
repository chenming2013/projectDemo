package com.chenming.poi.POIOperate_03_select;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.DVConstraint;
import org.apache.poi.hssf.usermodel.HSSFDataValidation;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.usermodel.DataValidationConstraint;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.junit.Test;

import junit.framework.TestCase;

/**
 * 下拉列表测试
 * @author 陈明
 * @date   2018年8月8日
 */
public class Select_01_SelectTest extends TestCase
{

	/**
	 * 测试一级下来列表
	 * @throws IOException 
	 */
	@SuppressWarnings("resource")
	@Test
	public void testOneLevelSelect() throws IOException {
		//创建一张工作簿
		HSSFWorkbook wb = new HSSFWorkbook();
		//创建一张表
		HSSFSheet sheet = wb.createSheet();
		
		//准备下来列表数据
		String[] data = new String[] {"aa","bb","cc","dd","ee","ff","gg","hh","ii"};
		
		//设置第一列的1-10行为下拉列表
		CellRangeAddressList regions = new CellRangeAddressList(0,9,0,0);
		
		//创建下拉列表数据
		DVConstraint constraint = DVConstraint.createExplicitListConstraint(data);
		
		//数据绑定
		HSSFDataValidation dataValidation = new HSSFDataValidation(regions, constraint);
		
		sheet.addValidationData(dataValidation);
		
		FileOutputStream os = new FileOutputStream("F:\\GitReponsitory\\Note\\Note\\后端\\知识点\\POI\\知识点\\POI测试文件夹\\write\\testOneLevelSelect.xls");
		wb.write(os);
		
		wb.close();
		os.close();
	}
	
}
