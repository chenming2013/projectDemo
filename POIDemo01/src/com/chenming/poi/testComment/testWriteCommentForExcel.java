package com.chenming.poi.testComment;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFComment;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;

import junit.framework.TestCase;

/**
 * 测试为单元格添加注释
 * @author 陈明
 */
public class testWriteCommentForExcel extends TestCase{

	/**
	 * 测试为 .xls 格式的Excel文件的单元格添加注释
	 */
	public void testWriteCommentForXLS() {
		
	}
	
	/**
	 * 设置单元格注释
	 * @param patriarch
	 * @param cell
	 * @param cellNum
	 */
	private void addCommet(HSSFPatriarch patriarch,HSSFCell cell,int cellNum) {
		HSSFComment comment = patriarch.createCellComment(new HSSFClientAnchor(0, 0, 0, 0, (short)1, 2, (short)4, 4));
		
	} 
}
