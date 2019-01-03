package dom4j;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 * 测试DOM4J操作XML
 * @author 陈明
 * @date 2018年12月4日
 */
public class DOM4JTest {
	
	private static final Logger LOGGER = LogManager.getLogger(DOM4JTest.class);
	
	private static Document document = null;
	
	/**
	 * 加载XML文档：不对XML进行DTD或XSD验证
	 */
	@BeforeClass
	public static void loadXML() throws DocumentException {
		SAXReader saxReader = new SAXReader();
		document = saxReader.read("resources/xml/dom4j.xml");
	}
	
	
	/**
	 * 遍历XML文档
	 */
	@Test
	public void testIterator() {
		//获取根节点
		Element root = document.getRootElement();
		
		//root节点下面的所有节点(包括文本节点)
		int nodeCount = root.nodeCount();
		assertEquals(nodeCount, 7);
		
		//获取所有的元素节点(所有student节点)
		Iterator<Element> iterator = root.elementIterator();
		
		Element element = null;
		while(iterator.hasNext()) {
			System.out.println("=============student 开始");
			element = iterator.next();
			
			Iterator<Element> elementIterator = element.elementIterator();
			Element element2 = null;
			while(elementIterator.hasNext()) {
				element2 = elementIterator.next();
				System.out.println("\t"+element2.getName()+" : "+element2.getStringValue());
			}
			
			System.out.println("============student 结束");
		}
		
		/**
		 * 输出
		 *  =============student 开始
		 *		name : zhangsan
		 *		age : 20
		 *		grade : 85
		 *	============student 结束
		 *	=============student 开始
		 *		name : lisi
		 *		age : 22
		 *		grade : 78
		 *	============student 结束
		 *	=============student 开始
		 *		name : wangwu
		 *		age : 18
		 *		grade : 97
		 *	============student 结束
		 */
	}
	
	/**
	 * 测试Xpath查找
	 * 	注意: XPath下标是从1开始的,不是从0开始
	 */
	@Test
	public void testXPath() {
		List<Node> nodeList = document.selectNodes("/class/student[1]");
		//找不到第一个student节点
		assertEquals(nodeList.size(), 1);
		
		for(Node node : nodeList) {
			Element element = (Element)node;
			Iterator<Node> nodeIterator = element.nodeIterator();
			while(nodeIterator.hasNext()) {
				Node node2 = nodeIterator.next();
				if(node2.getNodeType()==Node.ELEMENT_NODE) {
					System.out.println(node2.getName()+"-"+node2.getStringValue());
				}
			}
		}
		/**
		 * 输出:
		 *  name-zhangsan
		 *	age-20
		 *	grade-85
		 */
	}
	
	/**
	 * 创建XML文档
	 */
	@Test
	public void createXML() throws IOException {
		//1.创建一个空白的Document
		Document document2 = DocumentHelper.createDocument();
		
		//2.创建根节点
		Element root = document2.addElement("bookstore");
		
		//3.创建两个root下面的子节点
		Element book1 = root.addElement("book");
		Element book2 = root.addElement("book");
		
		Element nameElement1 = book1.addElement("name");
		Element ageElement1 = book1.addElement("price");
		Element nameElement2 = book2.addElement("name");
		Element ageElement2 = book2.addElement("price");
		
		nameElement1.setText("Java");
		ageElement1.setText("99");
		nameElement2.setText("HTML");
		ageElement2.setText("49");
		
		//4.输出流输出到文档
		XMLWriter xmlWriter = new XMLWriter(new FileOutputStream("resources/xml/dom4j2.xml"),OutputFormat.createPrettyPrint());
		xmlWriter.write(document2);
	}
	
	/**
	 * 修改XML文档,在第二个book节点中添加<author>cm</author>
	 * 	注意: 在运行本方法之前请先运行 createXML() 方法
	 * @throws DocumentException 
	 */
	@Test
	public void updateXML() throws DocumentException, IOException {
		//1.加载 dom4j2.xml
		Document document2 = new SAXReader().read("resources/xml/dom4j2.xml");
		
		//2.XPath查找节点
		List<Node> nodeList = document2.selectNodes("/bookstore/book[2]");
		Element bookElement = (Element)nodeList.get(0);
		
		//3.新增节点
		Element authorElement = bookElement.addElement("author");
		authorElement.setText("cm");
		
		//4.输出流输出到文档
		XMLWriter xmlWriter = new XMLWriter(new FileOutputStream("resources/xml/dom4j2.xml"),OutputFormat.createPrettyPrint());
		xmlWriter.write(document2);
	}
	
}
