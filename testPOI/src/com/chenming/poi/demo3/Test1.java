package com.chenming.poi.demo3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 测试单元格
 * @author ADMIN
 *
 */
public class Test1 {
	public static void main(String[] args) throws IOException {
		//创建工作簿
		XSSFWorkbook workbook = new XSSFWorkbook();
		//造工作簿中创建表(sheet)
		XSSFSheet sheet1 = workbook.createSheet("Sheet1");
		//在Sheet中创建Row(注: row的下标是从0开始的,也就是说Excel中显示1的行实际上是Row(0))
		XSSFRow row = sheet1.createRow(2);
		//在row中创建单元格(Cell),注: cell的下标是从0开始的,也就是说Excel中显示为"A"的那一列实际上是Cell(0)
		Cell cell = row.createCell(3);
		cell.setCellValue("("+cell.getRowIndex()+","+cell.getColumnIndex()+")");
		System.out.println("getRowNum: "+cell.getRow().getRowNum());
		System.out.println("getRowIndex: "+cell.getRowIndex());
		System.out.println("getColumnIndex: "+cell.getColumnIndex());
		//将工作簿写到输出流中
		OutputStream os = new FileOutputStream(new File("F:\\chenming\\APP\\WorkSpace\\testPOI\\WebContent\\workbook\\demo3.xlsx"));
		workbook.write(os);
		os.close();
		
	}
}
