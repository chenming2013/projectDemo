package validation;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 * 测试DOM验证XML文档
 * @author 陈明
 * @date 2018年12月7日
 */
public class ParseXMLWithValidationByDOM {

	/**
	 * 解析XML文档: 不对XML文档进行验证
	 */
	@Test
	public void testParseXMLWithoutValidation() throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//不对XML文件进行验证(默认是不进行验证)
		factory.setValidating(false);
		
		DocumentBuilder documentBuilder = factory.newDocumentBuilder();
		
		Document document = documentBuilder.parse("resources/xml/validation.xml");
		
		/**
		 * 解释:
		 * 	1. 因为DOM解析器默认是不对validation.xml进行验证的,所以不论在xml是否有声明 <!DOCTYPE users SYSTEM "../dtd/validation.dtd">,都不影响
		 *  2. 因为不需要对XML验证,所以即使我们在XML文档中使用了不在validation.dtd中的元素,也不会报错
		 */
	}
	
	
	/**
	 * 解析XML文档: 对XML文档进行验证
	 * 	注: 按下面的操作的话,会报错(这正是我们想要的效果)
	 */
	@Test
	public void testParseXMLWithValidation() throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		//对XML文档进行验证
		builderFactory.setValidating(true);
		
		DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
		documentBuilder.setErrorHandler(new ErrorHandler() {
			
			@Override
			public void warning(SAXParseException exception) throws SAXException {
				System.out.println("WARNING...");
				throw exception;
			}
			
			@Override
			public void fatalError(SAXParseException exception) throws SAXException {
				System.out.println("FATAL...");
				throw exception;
			}
			
			@Override
			public void error(SAXParseException exception) throws SAXException {
				System.out.println("ERROR...");
				throw exception;
			}
		});
		
		Document document = documentBuilder.parse("resources/xml/validation.xml");
		
		/**
		 * Caused by: org.xml.sax.SAXParseException : 必须声明元素类型 "hello"
		 * 
		 * 解释:
		 * 	1. 因为我们指定了要对XML文档进行验证,所以DOM解析XML文档的时候会去DTD文件中验证XML中的元素是否有效,最终验证为无效,所以报错	
		 */
	}
	
	
	/**
	 * 测试对XML文档进行验证,并且测试EntityResolver的使用
	 * 	EntityResolver指的是引用的外部实体,即我们的DTD/XSD验证文件,即我们可以在程序中指定XML文档的验证文件(DTD/XSD)
	 */
	@Test
	public void testParseXMLWithValidationAndEntityResolver() throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		builderFactory.setValidating(true);
		
		DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
		documentBuilder.setEntityResolver(new EntityResolver() {
			
			@Override
			public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
				return new InputSource(new FileInputStream("F:\\chenming\\APP\\WorkSpace\\JavaXMLDemo01\\resources\\dtd\\validation2.dtd"));
			}
		});
		
		Document document = documentBuilder.parse("resources/xml/validation2.xml");
		
		/**
		 * 解释:
		 * 	1. 我们在XML文档中引用的外部验证文件是 ../dtd/1.dtd,但是1.dtd实际上是不存在的,所以如果我们没有手动指定外部验证文件(reader.setEntityResolver(...)),
		 * 		那么就会报FileNotFountException
		 *  2. 我们在程序中手动指定了引用外部验证文件,即使在validation2.xml中引用了一个存在的dtd文件(不论这个文件是否能够验证xml文件),
		 *  	DOM4J解析器依然会按照我们在程序中指定的DTD文件来进行验证
		 */
	}
	
	/**
	 * 在上一个应用场景中(tsetParseXMLWithValidationAndEntityResolver()),我们测试了EntityResolver的用法,这里再深入一点
	 * 	应用场景:
	 * 		假如在 www.chenming.com 这个服务器上存在validation2.dtd文件,即 http://www.chenming.com/dtd/validation2.dtd,
	 * 		而我们的xml文档正是从这个网络地址的dtd文件进行验证,
	 * 		但是如果,www.chenming.com 这个域名不存在或者这个服务器里面找不到validation2.dtd文件怎么办?那岂不是因为找不到dtd文件而报错?
	 * 		这种情况肯定是不行的,我们下面的方法就是解决这种问题的思路,Spring使用的正是这种思路
	 * 	
	 * 		Spring的思路:
	 * 		Spring找到XML文档上的验证声明,即一个URL地址,根据这个地址在配置文件中找到对应的本地地址的dtd文件,然后加载本地的dtd验证
	 */
	@Test
	public void tsetParseXMLWithValidationAndEntityResolver2() throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(true);
		
		DocumentBuilder builder = factory.newDocumentBuilder();
		builder.setEntityResolver(new EntityResolver() {
			
			@Override
			public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
				if(systemId!=null && systemId.trim()!="") {
					int lastIndexOf = systemId.lastIndexOf("/");
					String dtdFileName = systemId.substring(lastIndexOf+1);
					InputStream resourceAsStream = this.getClass().getResourceAsStream("/dtd/"+dtdFileName);
					return new InputSource(resourceAsStream);
				}
				return null;
			}
		});
		
		Document document = builder.parse("resources/xml/validation3.xml");
	}
	
}
