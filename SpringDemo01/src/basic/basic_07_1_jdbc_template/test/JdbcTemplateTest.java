package basic.basic_07_1_jdbc_template.test;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * 测试一下 Spring的JDBC模板类: JdbcTemplate
 * @author 陈明
 * @date 2018年12月24日
 */
public class JdbcTemplateTest {

	
	/**
	 * 实例化JdbcTemplate类
	 * @throws IOException 
	 */
	@SuppressWarnings("resource")
	@BeforeClass
	public static void getJdbcTemplate() throws IOException {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:basic/basic_07_1_jdbc_template/jdbcTemplate.xml");
		
		//读取配置文件
		InputStream is = context.getClassLoader().getResourceAsStream("basic/basic_07_1_jdbc_template/db.properties");
		Properties pp = new Properties();
		pp.load(is);
		
		String user = pp.getProperty("jdbc.user");
		String password = pp.getProperty("jdbc.password");
		String url = pp.getProperty("jdbc.url");
		String driverClass = pp.getProperty("jdbc.driverClass");
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource(url, user, password);
		dataSource.setDriverClassName(driverClass);
		
		//获取JdbcTemplate
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
	}
	
	@Test
	public void testInsert() {
		
	}
	
}
