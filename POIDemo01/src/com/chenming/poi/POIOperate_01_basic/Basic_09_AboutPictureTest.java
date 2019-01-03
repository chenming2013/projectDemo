package com.chenming.poi.POIOperate_01_basic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFPicture;
import org.apache.poi.hssf.usermodel.HSSFPictureData;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;

import junit.framework.TestCase;

/**
 * 这个测试单元格插入图片和读取图片
 * @author 陈明
 * @date   2018年8月8日
 */
public class Basic_09_AboutPictureTest extends TestCase
{

	/**
	 * 测试：单元格插入图片
	 * @throws IOException 
	 */
	@Test
	public void testInsertPicture() throws IOException {
		//创建一个工作簿
		HSSFWorkbook wb = new HSSFWorkbook();
		//创建一张工作表
		HSSFSheet sheet = wb.createSheet();
		
		FileInputStream fis = new FileInputStream("F:\\GitReponsitory\\Note\\Note\\后端\\知识点\\POI\\知识点\\POI测试文件夹\\image\\IOC容器工作原理.jpg");
		byte[] bytes = new byte[(int) fis.getChannel().size()];
		//读取图片到二进制数据
		fis.read(bytes);
		int pictureIdx = wb.addPicture(bytes, HSSFWorkbook.PICTURE_TYPE_JPEG);
		HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
		HSSFClientAnchor anchor = new HSSFClientAnchor(0,0,0,0,(short)0,0,(short)5,5);
		HSSFPicture picture = patriarch.createPicture(anchor, pictureIdx);
		//自动调节图片大小,图片位置信息可能丢失
		//picture.resize();
		
		fis.close();
		
		OutputStream os = new FileOutputStream("F:\\GitReponsitory\\Note\\Note\\后端\\知识点\\POI\\知识点\\POI测试文件夹\\write\\testInsertPicture.xls");
		wb.write(os);
		
		wb.close();
		os.close();
		
	}
	
	/**
	 * 测试读取图片
	 * @throws IOException 
	 */
	@Test
	public void testReadPicture() throws IOException{
		InputStream inp = new FileInputStream("F:\\GitReponsitory\\Note\\Note\\后端\\知识点\\POI\\知识点\\POI测试文件夹\\write\\testInsertPicture.xls");
		HSSFWorkbook workbook = new HSSFWorkbook(inp);// 读取现有的Excel文件
		List<HSSFPictureData> pictures = workbook.getAllPictures();
		for (int i = 0; i < pictures.size(); i++){
			HSSFPictureData pic = pictures.get(i);
			String ext = pic.suggestFileExtension();
			if (ext.equals("png"))// 判断文件格式
			{
				FileOutputStream png = new FileOutputStream("F:\\GitReponsitory\\Note\\Note\\后端\\知识点\\POI\\知识点\\POI测试文件夹\\write\\IOC.png");
				png.write(pic.getData());
				png.close();// 保存图片
			}
		}
	}
}
