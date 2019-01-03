<<<<<<< HEAD
package basic.basic_001_specialVariable;

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
 * 测试 Freemarker 一些特殊变量
 * @author 陈明
 * @date 2018年11月21日
 */
public class SpecialVariableTest {
	
	private static final Logger logger = LogManager.getLogger(SpecialVariableTest.class);
	
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
	 * 测试一些基本的特殊变量
	 * @throws Exception
	 */
	@Test
	public void testMethod_1() {
		try {
			
			Template template = config.getTemplate("basic_001_special_variable.ftl");
			template.process(null, new PrintWriter(System.out));
			
		}catch(Exception e) {
			logger.error(e.getMessage(),e);
		}
	}

}
=======
package basic.basic_001_specialVariable;

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
 * 测试 Freemarker 一些特殊变量
 * @author 陈明
 * @date 2018年11月21日
 */
public class SpecialVariableTest {
	
	private static final Logger logger = LogManager.getLogger(SpecialVariableTest.class);
	
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
	 * 测试一些基本的特殊变量
	 * @throws Exception
	 */
	@Test
	public void testMethod_1() {
		try {
			
			Template template = config.getTemplate("basic_001_special_variable.ftl");
			template.process(null, new PrintWriter(System.out));
			
		}catch(Exception e) {
			logger.error(e.getMessage(),e);
		}
	}

}
>>>>>>> 9a23723de0eac87773e4ba0adc56ee6ecbc22f3e
