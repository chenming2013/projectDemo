package summary;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import sax.handler.UserHandler;

/**
 * 总结测试: DOM/SAX/JDOM/DOM4J 加载XML文档生成Document对象的方式
 * @author 陈明
 * @date 2018年12月6日
 */
public class LoadXMLTest {

	/**
	 * 使用DOM加载XML生成Document对象
	 */
	@Test
	public void loadXMLByDOM() throws ParserConfigurationException, SAXException, IOException {
		//1. 获取DocumentBuilderFactory
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		//2. 获取DocumentBuilder
		DocumentBuilder documentBuilder = factory.newDocumentBuilder();
		
		//3. 生成Document
		Document document = documentBuilder.parse("resources/xml/dom.xml");
	}
	
	/**
	 * 使用SAX加载XML生成Document对象
	 */
	@Test
	public void loadXMLBySAX() throws ParserConfigurationException, SAXException, IOException {
		//1. 获取SAXParseFactory
		SAXParserFactory factory = SAXParserFactory.newInstance();
		
		//2.创建SAXParse解析器
		SAXParser saxParser = factory.newSAXParser();
		
		//3.把XML文件和事件处理对象关联
		saxParser.parse("resources/xml/sax.xml", new UserHandler());
	}
	
	/**
	 * 使用JDOM加载XML生成Document对象
	 */
	@Test
	public void loadXMLByJDOM() throws JDOMException, IOException {
		//1. 获取SAXBuilder
		SAXBuilder saxBuilder = new SAXBuilder();
		
		//2. 加载XML生成Document对象
		org.jdom2.Document document = saxBuilder.build("resources/xml/jdom.xml");
	}
	
	/**
	 * 使用DOM4J加载XML生成Document对象
	 */
	@Test
	public void loadXMLByDOM4J() throws DocumentException {
		//1. 获取SAXReader对象
		SAXReader saxReader = new SAXReader();
		
		//2. 加载XML生成Document对象
		org.dom4j.Document document = saxReader.read("resources/xml/dom4j.xml");
	}
	
}
