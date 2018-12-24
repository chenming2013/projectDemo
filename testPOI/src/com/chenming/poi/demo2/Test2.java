package com.chenming.poi.demo2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 读取Excel表中的内容
 * @author ADMIN
 *
 */
public class Test2 {
	public static void main(String[] args) throws IOException {
		InputStream is = new FileInputStream(new File("F:\\chenming\\APP\\WorkSpace\\testPOI\\WebContent\\workbook\\demo2.xlsx"));
		//为指定的Excel文件创建工作簿
		XSSFWorkbook workbook = new XSSFWorkbook(is);
		//获取工作簿中的第一张表
		XSSFSheet sheet = workbook.getSheetAt(0);
		//遍历整张表,得到所有的Row
		Iterator<Row> rows = sheet.iterator();
		while(rows.hasNext()) {
			XSSFRow row = (XSSFRow)rows.next();
			//遍历每一个Row,得到所有的Cell
			Iterator<Cell> cells = row.iterator();
			while(cells.hasNext()) {
				Cell cell = cells.next();
				if(CellType.NUMERIC == cell.getCellTypeEnum()) {
					double numericCellValue = cell.getNumericCellValue();
					System.out.print(numericCellValue+"\t\t");
				}else if(CellType.STRING == cell.getCellTypeEnum()) {
					String stringCellValue = cell.getStringCellValue();
					System.out.print(stringCellValue+"\t\t");
				}else {
					System.out.print("其他类型"+"\t\t");	
				}
			}
			System.out.println();
		}
	}
}
