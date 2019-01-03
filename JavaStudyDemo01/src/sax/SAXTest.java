package sax;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.xml.sax.SAXException;

import sax.handler.UserHandler;
import sax.handler.UserHandler2;

/**
 * 测试SAX解析XML文档
 * @author 陈明
 * @date 2018年12月4日
 */
public class SAXTest {

	@SuppressWarnings("unused")
	private static final Logger Logger = LogManager.getLogger(SAXTest.class);
	
	/**
	 * 解析XML文档
	 */
	@Test
	public void parseXML() throws ParserConfigurationException, SAXException, IOException {
		//1.创建SAXParseFactory
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		
		//2.创建SAXParse解析器
		SAXParser saxParser = saxParserFactory.newSAXParser();
		
		//3.把XML文件和事件处理对象关联
		saxParser.parse("resources/xml/sax.xml", new UserHandler());
	}
	
	
	/**
	 * 修改XML文档
	 * 	在<grade></grade>节点之前添加<category></category>节点
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 * @throws IOException 
	 */
	@Test
	public void updateXML() throws ParserConfigurationException, SAXException, IOException {
		//1. 创建SAXParseFactory
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		
		//2. 创建SAXParse解析器
		SAXParser saxParser = saxParserFactory.newSAXParser();
		
		//3. 把XML文件和事件处理对象关联
		saxParser.parse("resources/xml/sax2.xml", new UserHandler2());
	}
}
