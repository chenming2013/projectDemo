<<<<<<< HEAD
package basic.basic_002_helloworld;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * 测试 Freemarker 的五种数据类型(字符串、数字、日期、序列、集合)
 * @author 陈明
 * @date 2018年11月21日
 */
public class HelloworldTest {
	
	private static final Logger logger = LogManager.getLogger(HelloworldTest.class);
	
	private static Configuration config;
	
	@BeforeClass
	public static void beforeClass() {
		config = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
		try {
			config.setDirectoryForTemplateLoading(new File("ftl"));
			config.setEncoding(Locale.CHINA, "utf-8");
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
	}
	
	/**
	 * 测试 根节点
	 * 	简单测试五种数据类型(字符串、数字、日期、序列、集合)
	 */
	@Test
	public void testMethod_1() {
		try {
			
			Template template = config.getTemplate("basic_002_helloworld.ftl");
			
			Map<String,Object> root = new HashMap<String,Object>();
			
			//字符串
			root.put("name", "chenming");
			//日期
			root.put("date", new Date());
			//数字
			root.put("num", 666);
			//序列
			root.put("nameList", getNameList());
			//集合
			root.put("nameMap", getNameMap());
			
			template.process(root, new PrintWriter(System.out));
			
		}catch(Exception e) {
			logger.error(e.getMessage(),e);
		}
	}
	
	
	private List<Object> getNameList() {
		List<Object> list = new ArrayList<Object>();
		list.add("zhangsan");
		list.add("lisi");
		list.add("wangwu");
		list.add("zhaoliu");
		list.add("qianqi");
		return list;
	}
	private Map<String,Object> getNameMap(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("zhangsan", "张三");
		map.put("lisi", "李四");
		map.put("wangwu", "王五");
		map.put("zhaoliu", "赵六");
		map.put("qianqi", "钱七");
		return map;
	}
}
=======
package basic.basic_002_helloworld;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * 测试 Freemarker 的五种数据类型(字符串、数字、日期、序列、集合)
 * @author 陈明
 * @date 2018年11月21日
 */
public class HelloworldTest {
	
	private static final Logger logger = LogManager.getLogger(HelloworldTest.class);
	
	private static Configuration config;
	
	@BeforeClass
	public static void beforeClass() {
		config = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
		try {
			config.setDirectoryForTemplateLoading(new File("ftl"));
			config.setEncoding(Locale.CHINA, "utf-8");
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
	}
	
	/**
	 * 测试 根节点
	 * 	简单测试五种数据类型(字符串、数字、日期、序列、集合)
	 */
	@Test
	public void testMethod_1() {
		try {
			
			Template template = config.getTemplate("basic_002_helloworld.ftl");
			
			Map<String,Object> root = new HashMap<String,Object>();
			
			//字符串
			root.put("name", "chenming");
			//日期
			root.put("date", new Date());
			//数字
			root.put("num", 666);
			//序列
			root.put("nameList", getNameList());
			//集合
			root.put("nameMap", getNameMap());
			
			template.process(root, new PrintWriter(System.out));
			
		}catch(Exception e) {
			logger.error(e.getMessage(),e);
		}
	}
	
	
	private List<Object> getNameList() {
		List<Object> list = new ArrayList<Object>();
		list.add("zhangsan");
		list.add("lisi");
		list.add("wangwu");
		list.add("zhaoliu");
		list.add("qianqi");
		return list;
	}
	private Map<String,Object> getNameMap(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("zhangsan", "张三");
		map.put("lisi", "李四");
		map.put("wangwu", "王五");
		map.put("zhaoliu", "赵六");
		map.put("qianqi", "钱七");
		return map;
	}
}
>>>>>>> 9a23723de0eac87773e4ba0adc56ee6ecbc22f3e
