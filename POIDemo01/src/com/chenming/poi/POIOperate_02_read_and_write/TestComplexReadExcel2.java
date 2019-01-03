package com.chenming.poi.POIOperate_02_read_and_write;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import junit.framework.TestCase;

/**
 * 测试复杂读取单元格数据
 * 	这里是专门用来测试Date类型的数据
 * @author 陈明
 * @date   2018年7月30日
 */
public class TestComplexReadExcel2 extends TestCase
{

	/**
	 * 复杂读取 .xls 格式的Excel文件
	 * 	主要是测试读取Date类型数据
	 * @throws IOException 
	 * @throws InvalidFormatException 
	 * @throws EncryptedDocumentException 
	 */
	@Test
	public void testComplexReadExcelForXLS2() throws EncryptedDocumentException, InvalidFormatException, IOException {
		//本地Excel文件
		File file = new File("F:\\GitReponsitory\\Note\\Note\\后端\\知识点\\POI\\知识点\\POI测试文件夹\\read\\3.xls");
		//打开Workbook对象
		HSSFWorkbook wb = (HSSFWorkbook)WorkbookFactory.create(file);
		//循环workbook中所有Sheet
		for(int sheetIndex=0;sheetIndex<wb.getNumberOfSheets();sheetIndex++) {
			HSSFSheet sheet = wb.getSheetAt(sheetIndex);
			//循环该sheet中有数据的每一行
			for(int rowIndex=0;rowIndex<=sheet.getLastRowNum();rowIndex++) {
				HSSFRow row = sheet.getRow(rowIndex);
				if(row==null) {
					continue;
				}
				//循环该行的每一个单元格
				for(int cellIndex=0;cellIndex<=row.getLastCellNum();cellIndex++) {
					HSSFCell cell = row.getCell(cellIndex);
					getCellValue(cell,rowIndex,cellIndex);
				}
			}
		}
	}
	
	
	/**
	 * 判断单元格类型
	 * @param cell
	 * @param rowIndex
	 * @param cellIndex
	 */
	public void getCellValue(Cell cell,int rowIndex,int cellIndex) {
		if(cell==null) {
			return;
		}else if(cell.getCellTypeEnum()==CellType.BLANK) {
			//如果是空值
			System.out.println("第"+(rowIndex+1)+"行,第"+(cellIndex+1)+"列 cellType为: CELL_TYPE_BLANK");
		}else if(cell.getCellTypeEnum()==CellType.STRING) {
			//如果单元格是String类型的
			System.out.println("第"+(rowIndex+1)+"行,第"+(cellIndex+1)+"列 cellType为: CELL_TYPE_STRING, 值为:"+cell.getStringCellValue());
		}else if(cell.getCellTypeEnum()==CellType.NUMERIC) {
			//如果单元格是数值类型的,还需要进一步判断是不是Date类型的
			if(HSSFDateUtil.isCellDateFormatted(cell)) {
				//如果是日期类型数据
				Date date = cell.getDateCellValue();
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				String dateStr = df.format(date);
				System.out.println("第"+(rowIndex+1)+"行,第"+(cellIndex+1)+"列 cellType为: Date, 值为:"+dateStr);
			}else {
				//如果不是日期类型数据
				System.out.println("第"+(rowIndex+1)+"行,第"+(cellIndex+1)+"列 cellType为: CELL_TYPE_NUMERIC, 值为:"+cell.getNumericCellValue());
			}
			
		}else if(cell.getCellTypeEnum()==CellType.BOOLEAN) {
			//如果单元格是布尔类型的
			System.out.println("第"+(rowIndex+1)+"行,第"+(cellIndex+1)+"列 cellType为: CELL_TYPE_BOOLEAN, 值为:"+cell.getBooleanCellValue());
		}else if(cell.getCellTypeEnum()==CellType.FORMULA) {
			//如果单元格是公式类型的
			System.out.println("第"+(rowIndex+1)+"行,第"+(cellIndex+1)+"列 cellType为: CELL_TYPE_FOTMULA, 值为:"+cell.getNumericCellValue()+", 公式为:"+cell.getCellFormula());
		}
	}
}
