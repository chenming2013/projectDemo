package basic.basic_07_1_jdbc_template.test;


import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * 测试一下 Spring的JDBC模板类: JdbcTemplate
 * @author 陈明
 * @date 2018年12月24日
 */
public class JdbcTemplateTest {

	private static JdbcTemplate jdbcTemplate;
	
	
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
		jdbcTemplate = new JdbcTemplate(dataSource);
		
	}
	
	/**
	 * 增加数据
	 */
	@Test
	public void testInsert() {
		jdbcTemplate.update("insert into user values(?,?,?,?)", new Object[] {1,"cm",24,"male"});
		jdbcTemplate.update("insert into user values(?,?,?,?)", new Object[] {2,"xiaohong",22,"female"});
	}
	
	
	/**
	 * 更新数据
	 */
	@Test
	public void testUpdate() {
		jdbcTemplate.update("update user set name = ?,age = ? where id = ?", new Object[] {"chenming",25,1});
	}
	
	
	/**
	 * 查询
	 * 	查询指定Id的name
	 */
	@Test
	public void testQuery() {
		String sql = "select name from user where id = ?";
		String name = jdbcTemplate.queryForObject(sql, String.class, 1);
		System.out.println(name);
	}
	
	/**
	 * 查询
	 * 	查询age>18的name
	 */
	@Test
	public void testQuery2() {
		String sql = "select name from user where age > ?";
		List<String> nameList = jdbcTemplate.queryForList(sql,String.class,18);
		for(String name:nameList) {
			System.out.println(name);
		}
		/**
		 *  chenming
		 *	xiaohong
		 */
	}
	
	
	/**
	 * 查询
	 * 	查询指定Id的所有数据
	 */
	@Test
	public void testQuery3() {
		String sql = "select * from user where id = ?";
		Map<String, Object> userMap = jdbcTemplate.queryForMap(sql, 1);
		System.out.println("{id:"+userMap.get("id")+",name:"+userMap.get("name")+",age:"+userMap.get("age")+",gender:"+userMap.get("gender")+"}");
		//{id:1,name:chenming,age:25,gender:male}
	}
	
	/**
	 * 查询
	 * 	查询age>18的所有数据
	 */
	@Test
	public void testQuery4() {
		String sql = "select * from user where age > ?";
		List<Map<String, Object>> userList = jdbcTemplate.queryForList(sql,18);
		for(Map<String,Object> userMap:userList) {
			System.out.println("{id:"+userMap.get("id")+",name:"+userMap.get("name")+",age:"+userMap.get("age")+",gender:"+userMap.get("gender")+"}");
		}
		/**
		 *  {id:1,name:chenming,age:25,gender:male}
		 *	{id:2,name:xiaohong,age:22,gender:female}
		 */
	}
	
	/**
	 * 删除
	 */
	@Test
	public void testDelete() {
		String sql = "delete from user where id = ?";
		jdbcTemplate.update(sql, 3);
	}
	
	
	/**
	 * 测试：预编译语句创建回调
	 */
	@Test
	public void testPreparedStatement() {
		int count = jdbcTemplate.execute(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				return con.prepareStatement("select count(*) from user");
			}
		},new PreparedStatementCallback<Integer>() {

			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				ps.execute();
				ResultSet rs = ps.getResultSet();
				rs.next();
				return rs.getInt(1);
			}
		});
		System.out.println(count);		//2
	}
	
	/**
	 * 测试: 预编译语句设置回调
	 * 注意: 下标从1开始
	 */
	@Test
	public void testPreparedStatement2() {
		jdbcTemplate.update("update user set name = ? where id = ?", new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setObject(1, "xiaohong2");
				ps.setObject(2, 2);
			}
		});
	}
	
	/**
	 * 测试: 结果集处理回调
	 */
	@Test
	public void testResultSet() {
		String sql = "select * from user";
		List<Map<String, Object>> list = jdbcTemplate.query(sql, new RowMapper<Map<String,Object>>() {
			@Override
			public Map<String,Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
				System.out.println(rowNum);
				Map<String,Object> row = new HashMap<String,Object>();
				row.put("id", rs.getInt(1));
				row.put("name", rs.getString(2));
				row.put("age", rs.getInt(3));
				row.put("gender", rs.getString(4));
				return row;
			}
		});
	}
	
	
	
	
}
