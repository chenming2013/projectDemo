package com.chenming.poi.POIOperate_02_read_and_write;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import com.chenming.poi.domain.Student;

import junit.framework.TestCase;

/**
 * 测试复杂写入数据到Excel中,包括日期、公式
 * 	这里会从使用预先定义好的数据模拟数据库中的数据,然后对这些数据进行公式计算每个学生的总成绩、平均分
 * @author 陈明
 * @date   2018年7月31日
 */
public class TestComplexWriteExcel extends TestCase
{
	/**
	 * 复杂写入数据到 .xls 格式的Excel文件中,
	 * 	写入的数据包括日期、公式
	 * @throws IOException 
	 * @throws InvalidFormatException 
	 * @throws EncryptedDocumentException 
	 * @throws ParseException 
	 */
	@Test
	public void testComplexWriteExcelForXLS() throws EncryptedDocumentException, InvalidFormatException, IOException, ParseException {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		//获取数据
		List<Student> stuList = createStduents();
		
		//Student类中有多少属性
		Field[] fields = Student.class.getDeclaredFields();
		
		InputStream is = new FileInputStream("F:\\GitReponsitory\\Note\\Note\\后端\\知识点\\POI\\知识点\\POI测试文件夹\\write\\testTemplate.xls");
		
		//初始化一个Workbook
		Workbook wb = WorkbookFactory.create(is);
		//创建一个Sheet
		HSSFSheet sheet1 = (HSSFSheet) wb.getSheetAt(0);
		//创建多行,从列名下一行开始创建
		for(int rowIndex=1;rowIndex<=stuList.size();rowIndex++) {
			HSSFRow row = sheet1.getRow(rowIndex);
			if(row==null) {
				row = sheet1.createRow(rowIndex);
			}
			Student stu = stuList.get(rowIndex-1);
			//穿件多列,不包括ID列
			for(int cellNum=0;cellNum<fields.length;cellNum++) {
				HSSFCell cell = row.getCell(cellNum);
				if(cell==null) {
					cell = row.createCell(cellNum);
				}
				switch(cellNum) {
					case 0:
						cell.setCellValue(new HSSFRichTextString(stu.getName()));
						break;
					case 1:
						cell.setCellValue(new HSSFRichTextString(stu.getNo()));
						break;
					case 2:
						cell.setCellValue(new HSSFRichTextString(stu.getNativePlace()));
						break;
					case 3:
						cell.setCellValue(new HSSFRichTextString(stu.getEdu()));
						break;
					case 4:
						cell.setCellValue(stu.getYear());
						break;
					case 5:
						cell.setCellValue(stu.getMath());
						break;
					case 6:
						cell.setCellValue(stu.getChinese());
						break;
					case 7:
						cell.setCellValue(stu.getEnglish());
						break;
					case 8:
						cell.setCellValue(stu.getScience());
						break;
					case 9:
						cell.setCellFormula("F"+(rowIndex+1)+"+G"+(rowIndex+1)+"+H"+(rowIndex+1)+"+I"+(rowIndex+1));  //写入总成绩公式
						break;
					case 10:
						cell.setCellFormula("AVERAGE(F"+(rowIndex+1)+":I"+(rowIndex+1)+")");  //写入平均成绩公式
						break;
					case 11:
						cell.setCellValue(stu.getIsCity());
						break;
					case 12:
						cell.setCellValue(new HSSFRichTextString(df.format(stu.getSchoolDate())));
						break;
					case 13:
						cell.setCellValue(new HSSFRichTextString(df.format(stu.getBirth())));
						break;
					default:
						System.out.println("不需要显示在Excel中");
				}
			}
		}
		is.close();
		
		OutputStream os = new FileOutputStream("F:\\GitReponsitory\\Note\\Note\\后端\\知识点\\POI\\知识点\\POI测试文件夹\\write\\testTemplate.xls");
		wb.write(os);
		wb.close();
		os.close();
	}
	
	
	/**
	 * 这是创建学生对象,用来模拟从数据库中获取数据
	 * @return
	 * @throws ParseException 
	 */
	private List<Student> createStduents() throws ParseException{
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Student stu1 = new Student(1,"张三","0001","天津","信息学院",2008,140,130,110,280,null,null,true,df.parse("2008-3-1"),df.parse("1990-2-16"));
		Student stu2 = new Student(2,"李四","0002","浙江","物流学院",2008,141,131,111,281,null,null,false,df.parse("2008-3-1"),df.parse("1990-8-5"));
		Student stu3 = new Student(2,"王五","0003","台湾","英语学院",2008,142,132,112,282,null,null,false,df.parse("2008-3-1"),df.parse("1990-12-20"));
		List<Student> list = new ArrayList<Student>();
		list.add(stu1);
		list.add(stu2);
		list.add(stu3);
		return list;
	}
}
