package dom4j;


import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
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
	 * 加载XML文档
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
	 */
	@Test
	public void testXPath() {
		List<Node> nodeList = document.selectNodes("/class/student[0]");
	}
}
