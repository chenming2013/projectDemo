package com.chenming.poi.POIOperate_01_basic;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;

import junit.framework.TestCase;

/**
 * 这个是测试Excel的
 * @author 陈明
 * @date   2018年8月5日
 */
public class Basic_03_ExcelOperateTest extends TestCase
{

	/**
	 * 测试：创建文档摘要信息
	 * @throws IOException 
	 */
	@Test
	public void testCreateInformation() throws IOException {
		
		HSSFWorkbook wb = new HSSFWorkbook();
		//创建文档信息
		wb.createInformationProperties();
		//摘要信息
		DocumentSummaryInformation dsi = wb.getDocumentSummaryInformation();
		dsi.setCategory("类别：Excel文件"); //类别
		dsi.setManager("管理者：陈明");  //管理者
		dsi.setCompany("公司：--");   //公司
		SummaryInformation si = wb.getSummaryInformation();
		si.setSubject("主题：--");  //主题
		si.setTitle("标题：测试文档");  //标题
		si.setAuthor("作者：陈明");  //作者
		si.setComments("备注：POI测试文档");  //备注
		
		OutputStream os = new FileOutputStream("F:\\GitReponsitory\\Note\\Note\\后端\\知识点\\POI\\知识点\\POI测试文件夹\\write\\testCreateInformation.xls");
		wb.write(os);
	}
	
}
