package dom;


import static org.junit.Assert.assertEquals;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

/**
 * 测试DOM操作XML
 * @author 陈明
 * @date 2018年12月3日
 */
public class DOMTest {

	private static final Logger Logger = LogManager.getLogger(DOMTest.class);
	
	private static Document document = null;
	
	/**
	 * DOM加载XML
	 */
	@BeforeClass
	public static void loadXML() throws ParserConfigurationException, SAXException, IOException {
		//1.创建DocumentBuilderFactory
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		//2.通过factory创建DocumentBuilder
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		//3.指定加载的XML文档
		document = builder.parse("resources/xml/dom.xml");
	}
	
	/**
	 * 测试: 遍历XML文档
	 */
	@Test
	public void testIterator() {
		//获取根节点
		Element root = document.getDocumentElement();
		
		//获取根节点下的所有子节点
		NodeList childNodes = root.getChildNodes();
		
		//根节点下面有7个子节点,包括3个元素节点和4和空白文本节点
		assertEquals(childNodes.getLength(), 7);
		
		Node node = null;
		//输出根节点下的所有节点
		for(int i=0;i<childNodes.getLength();i++) {
			node = childNodes.item(i);
			System.out.println("节点名: "+node.getNodeName()+", 节点类型: "+node.getNodeType()+", 节点值: "+node.getNodeValue());
		}
		/**
		 * 输出:
		 *  节点名: #text, 节点类型: 3, 节点值: 
		 *	   
		 *	节点名: student, 节点类型: 1, 节点值: null
		 *	节点名: #text, 节点类型: 3, 节点值: 
		 *	   
		 *	节点名: student, 节点类型: 1, 节点值: null
		 *	节点名: #text, 节点类型: 3, 节点值: 
		 *	   
		 *	节点名: student, 节点类型: 1, 节点值: null
		 *	节点名: #text, 节点类型: 3, 节点值: 
		 */
		
		System.out.println("===================分割====================");
		
		/**
		 * 输出所有的元素节点
		 */
		for(int i=0;i<childNodes.getLength();i++) {
			node = childNodes.item(i);
			if(node.getNodeType()==Node.ELEMENT_NODE) {
				System.out.println("节点名: "+node.getNodeName()+", 节点类型: "+node.getNodeType()+", 节点值: "+node.getNodeValue());
			}
		}
		/**
		 * 输出:
		 *  节点名: student, 节点类型: 1, 节点值: null
		 *	节点名: student, 节点类型: 1, 节点值: null
		 *	节点名: student, 节点类型: 1, 节点值: null
		 */
	}
	
	
	/**
	 * 更新节点(student节点下插入一个元素节点<extra>this is a Node</extra>)
	 * 	保存到文件
	 * @throws TransformerException 
	 */
	@Test
	public void testUpdate() throws TransformerException {
		//获取根节点
		Element root = document.getDocumentElement();
		
		//获取根节点的第一个元素节点<student节点>
		Node firstStudentNode = getFirstElementNode(root);
		
		//新建一个节点
		Element newElement = document.createElement("extra");
		Text newText = document.createTextNode("this is extra Node");
		
		newElement.appendChild(newText);
		firstStudentNode.appendChild(newElement);
		
		//保存更新到文件
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		//通过TransformerFactory得到一个转换器
		Transformer transformer = transformerFactory.newTransformer();
		transformer.transform(new DOMSource(document), new StreamResult("resources/xml/class.xml"));
	}
	
	
	
	
	/**
	 * 测试: 删除元素节点(注意不是空白文本节点)
	 * 	不保存到文件
	 */
	@Test
	public void testDeleteElementNode() {
		//获取根节点
		Element root = document.getDocumentElement();
		
		//删除最后一个元素节点
		//先获取最后一个元素节点
		NodeList childNodes = root.getChildNodes();
		
		//有7个子节点
		assertEquals(childNodes.getLength(), 7);
		
		Node lastNode = null;
		for(int i=childNodes.getLength()-1;i>=0;i--) {
			if(childNodes.item(i).getNodeType()==Node.ELEMENT_NODE) {
				lastNode = childNodes.item(i);
				break;
			}
		}
		root.removeChild(lastNode);
		
		//有6个子节点
		assertEquals(childNodes.getLength(), 6);
	}
	
	/**
	 * 测试删除属性节点(删除第一个元素的name属性)
	 * 	不保存到文件
	 */
	@Test
	public void testDeleteAttribute() {
		//获取根节点
		Element root = document.getDocumentElement();
		
		NodeList childNodes = root.getChildNodes();
		
		Node firstElementNode = null;
		for(int i=0;i<childNodes.getLength();i++) {
			if(childNodes.item(i).getNodeType()==Node.ELEMENT_NODE) {
				firstElementNode = childNodes.item(i);
				break;
			}
		}
		NamedNodeMap namedNodeMap = firstElementNode.getAttributes();
		Node nameNode = namedNodeMap.getNamedItem("name");
		//如果存在name属性
		if(nameNode!=null) {
			System.out.println("修改前的name值: "+nameNode.getNodeValue());
			
			nameNode.setNodeValue("cm");
			
			System.out.println("修改后的name值: "+nameNode.getNodeValue());
		}
	}
	
	/**
	 * 获取第一个元素节点
	 * @return
	 */
	private Node getFirstElementNode(Node node) {
		NodeList childNodes = node.getChildNodes();
		Node firstElementNode = null;
		for(int i=0;i<childNodes.getLength();i++) {
			if(childNodes.item(i).getNodeType()==Node.ELEMENT_NODE) {
				firstElementNode = childNodes.item(i);
				break;
			}
		}
		return firstElementNode;
	}
}
