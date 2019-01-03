package jdom;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jdom2.Content;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

/**
 * 测试JDOM操作XML
 * @author 陈明
 * @date 2018年12月4日
 */
public class JDOMTest {

	private static final Logger Logger = LogManager.getLogger(JDOMTest.class);
	
	private static Document document = null;
	
	/**
	 * 加载XML文档
	 */
	@BeforeClass
	public static void loadXML() throws JDOMException, IOException {
		//1. 创建SAXBuilder
		SAXBuilder saxBuilder = new SAXBuilder();
		
		//2. 加载XML文档
		document = saxBuilder.build("resources/xml/jdom.xml");
	}
	
	/**
	 * 遍历XML文档
	 */
	@Test
	public void testIterator() {
		//获取根节点
		Element root = document.getRootElement();
		
		//获取根节点下的所有元素节点(不包括文本节点)
		List<Element> studentList = root.getChildren();
		//有3个元素节点
		assertEquals(studentList.size(), 3);
		
		Element student = null;
		for(int i=0;i<studentList.size();i++) {
			System.out.println("=============第"+i+"个student 开始");
			
			student = studentList.get(i);
			List<Element> children = student.getChildren();
			Element element = null;
			for(int j=0;j<children.size();j++) {
				element = children.get(j);
				System.out.println("\t"+element.getName()+" : "+element.getValue());
			}
			
			System.out.println("=============第"+i+"个student 结束");
		}
		/**
		 * 输出
		 *  =============第0个student 开始
		 *		name : zhangsan
		 *		age : 20
		 *		grade : 85
		 *	=============第0个student 结束
		 *	=============第1个student 开始
		 *		name : lisi
		 *		age : 22
		 *		grade : 78
		 *	=============第1个student 结束
		 *	=============第2个student 开始
		 *		name : wangwu
		 *		age : 18
		 *		grade : 97
		 *	=============第2个student 结束
		 */
	}
	
	/**
	 * 创建XML文档
	 */
	@Test
	public void createXML() throws IOException {
		//创建一个空白的文档
		Document document2 = new Document();
		
		//创建根节点
		Element root = new Element("bookstore");
		
		//将根节点绑定到文档
		document2.setRootElement(root);
		
		//创建根节点的子节点(book节点)
		Element book1 = new Element("book");
		Element book2 = new Element("book");
		root.addContent(book1);
		root.addContent(book2);
		
		//创建Book节点的子节点
		Element nameElement1 = new Element("name");
		Element priceElement1 = new Element("price");
		nameElement1.setText("Java");
		priceElement1.setText("99");
		
		Element nameElement2 = new Element("name");
		Element priceElement2 = new Element("price");
		nameElement2.setText("HTML");
		priceElement2.setText("49");
		
		//将name节点、age节点绑定到book节点
		book1.addContent(nameElement1);
		book1.addContent(priceElement1);
		book2.addContent(nameElement2);
		book2.addContent(priceElement2);
		
		//文件流输出
		XMLOutputter xmlOutputter = new XMLOutputter();
		xmlOutputter.setFormat(Format.getPrettyFormat());
		xmlOutputter.output(document2, new FileOutputStream(new File("resources/xml/jdom2.xml")));
	}
	
	/**
	 * 修改XML文档
	 * 	在第二个<book>节点里面新增一个元素节点<author>cm</author>
	 * 	(注意: 运行本实例之前请先运行createXML()方法)
	 */
	@Test
	public void updateXML() throws JDOMException, IOException {
		//读取jdom2.xml文档
		SAXBuilder saxBuilder = new SAXBuilder();
		//加载XML文档
		Document document2 = saxBuilder.build("resources/xml/jdom2.xml");
		
		//获取根节点
		Element root = document2.getRootElement();
		//获取根节点下的所有元素节点
		List<Element> bookList = root.getChildren();
		//获取最后一个book节点
		Element bookElement = bookList.get(bookList.size()-1);
		
		//创建新的元素节点
		Element authorElement = new Element("author");
		authorElement.setText("cm");
		//将该节点绑定到book节点下
		bookElement.addContent(authorElement);
		
		//文档流输出
		XMLOutputter xmlOutputter = new XMLOutputter();
		xmlOutputter.setFormat(Format.getPrettyFormat());
		xmlOutputter.output(document2, new FileOutputStream("resources/xml/jdom2.xml"));
	}
	
}
