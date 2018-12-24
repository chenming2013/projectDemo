package com.chenming.poi.demo2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 创建一张表
 * @author ADMIN
 *
 */
public class Test1 {
	public static void main(String[] args) throws IOException {
		//创建工作簿
		XSSFWorkbook workbook = new XSSFWorkbook();
		//创建表
		XSSFSheet sheet = workbook.createSheet("Employer Info");
		//行
		XSSFRow row;
		
		Map<String,Object[]> empinfo = new TreeMap<String,Object[]>();
		empinfo.put("0", new Object[] {"Emp Id","Emp Name","称号"});
		empinfo.put("1", new Object[] {"Tp01","a","c_a"});
		empinfo.put("2", new Object[] {"Tp02","b","c_b"});
		empinfo.put("3", new Object[] {"Tp03","c","c_c"});
		empinfo.put("4", new Object[] {"Tp04","d","c_d"});
		empinfo.put("5", new Object[] {"Tp05","e","c_e"});
		
		Set<String> keySet = empinfo.keySet();
		int rowid = 0;
		for(String key:keySet) {
			Object[] objects = empinfo.get(key);
			row = sheet.createRow(rowid);
			rowid++;
			int cellid = 0;
			for(Object obj:objects) {
				Cell cell = row.createCell(cellid);
				cell.setCellValue((String)obj);
				cellid++;
			}
		}
		FileOutputStream fos = new FileOutputStream(new File("F:\\chenming\\APP\\WorkSpace\\testPOI\\WebContent\\workbook\\demo2.xlsx"));
		workbook.write(fos);
		fos.close();
	}
}
