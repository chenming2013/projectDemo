package basic.basic_004_instruction;

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

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

/**
 * 这个类测试常用的指令
 * @author 陈明
 * @date 2018年11月21日
 */
public class InstructionTest {

	private static final Logger logger = LogManager.getLogger(InstructionTest.class);
	
	private static Configuration config = null;
	
	
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
	 * 测试常用的指令
	 */
	@Test
	public void testMethod_1() {
		try {
			Template template = config.getTemplate("basic_004_instruction.ftl");
			
			Map<String,Object> root = new HashMap<String,Object>();
			
			//字符串
			root.put("name", "chenming");
			//字符串
			root.put("content", "<p>点这有惊喜</p>");
			//数字
			root.put("num", 666);
			//数字
			root.put("num2", null);
			//日期
			root.put("date", new Date());
			//序列
			root.put("nameList", null);
			//序列
			root.put("nameList2", new ArrayList<Object>());
			//序列
			root.put("nameList3", getNameList());
			//集合
			root.put("nameMap", null);
			//集合
			root.put("nameMap2", new HashMap<String,Object>());
			//集合
			root.put("nameMap3", getNameMap());
			
			template.process(root, new PrintWriter(System.out));
		} catch (TemplateException | IOException e) {
			logger.error(e.getMessage(), e);
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
