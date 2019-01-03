package com.chenming.poi.POIOperate_04_template;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 这是Excel模板
 * @author 陈明
 * @date   2018年8月12日
 */
public class ExcelTemplate
{
	/**
	 * 设置成单例
	 */
	private static ExcelTemplate template = new ExcelTemplate();
	/**
	 * 构造方法私有化,不让别人new,以保证是单例
	 */
	private ExcelTemplate() {};
	/**
	 * 获取单例对象的入口
	 * @return
	 */
	public static ExcelTemplate getInstance() {
		return template;
	}
	
	
	/**
	 * 导出数据
	 */
	public int ExportData() {
		//记录导出了多少条数据
		int count = 0;
		
		//1.获取数据库数据
		try{
			List<UserScoreDTO> dataList = getDataListFormDB();
		} catch (ParseException e){
			e.printStackTrace();
			return count;
		}
		
		//2.打开Workbook
		openExcel();
		
		//3.
		return count;
	}
	
	
	/**
	 * 打开Excel,返回代表Excel的Workbook对象
	 * @return
	 */
	private InputStream is = null;
	private OutputStream os = null;
	private Workbook wb = null;
	public Workbook openExcel() {
		is = ExcelTemplate.class.getResourceAsStream("/com/chenming/poi/POIOperate_04_template/template.xls");
		try{
			wb = WorkbookFactory.create(is);
		} catch (EncryptedDocumentException | InvalidFormatException | IOException e){
			e.printStackTrace();
		}
		return wb;
	}
	
	
	/**
	 * 插入数据
	 * @return
	 */
	public int insertData() {
		//记录成功插入了多少条数据
		int count = 0;
		return count;
	}
	
	
	
	/**
	 * 这里我们模拟从数据库中获取数据
	 * @throws ParseException 
	 */
	public List<UserScoreDTO> getDataListFormDB() throws ParseException {
		List<UserScoreDTO> list = new ArrayList<UserScoreDTO>();
		BigDecimal bd = new BigDecimal(0);
		//准备20条数据
		for(int i=0;i<20;i++) {
			UserScoreDTO userScore = new UserScoreDTO();
			userScore.setId("100"+(i+1));
			userScore.setName("name"+(i+1));
			userScore.setAge(18);
			userScore.setEntryDate(new SimpleDateFormat("yyyy-MM-dd").parse("2010-09-01"));
			userScore.setMathScore(bd.add(new BigDecimal(i+60)));
			userScore.setChineseScore(bd.add(new BigDecimal(i+70)));
			userScore.setEnglishScore(bd.add(new BigDecimal(i+50)));
			list.add(userScore);
		}
		return list;
	}
	
	/**
	 * 关闭输入流
	 */
	public void closeInputStream() {
		if(is!=null) {
			try{
				is.close();
			} catch (IOException e){
				e.printStackTrace();
			}finally {
				is = null;
			}
		}
	}
	
	/**
	 * 关闭Excel文档
	 */
	public void closeWorkbook() {
		if(wb!=null) {
			try{
				wb.close();
			} catch (IOException e){
				e.printStackTrace();
			}finally {
				wb = null;
			}
		}
	}
	
	/**
	 * 关闭输出流
	 */
	public void closeOutputStream() {
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
