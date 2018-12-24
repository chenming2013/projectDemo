package com.chenming.poi.demo1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 创建一个工作簿
 * @author ADMIN
 *
 */
public class Test1 {
	public static void main(String[] args) throws IOException {
		//
		XSSFWorkbook workbook = new XSSFWorkbook();
		File file = new File("F:\\chenming\\APP\\WorkSpace\\testPOI\\WebContent\\workbook\\demo1.xlsx");
		FileOutputStream fos = new FileOutputStream(file);
		workbook.write(fos);
		
	}
}
