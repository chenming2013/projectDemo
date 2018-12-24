package chenming.absolute.absolute_02_ignore;

import org.junit.Ignore;
import org.junit.Test;

/**
 * 忽略测试
 * 	通过@Ignore注解标注不参与测试的方法
 * 	@Test注解标注的方法是测试,如果不想让该方法进行测试,那么可以有下面两种做法:
 * 		1)去掉@Test注解
 * 		2)加上@Ignore注解,Junit会忽略该方法
 * @author 陈明
 * @date 2018年10月24日
 */
public class IgnoreTest {

	@Test
	public void testIgnore_1() {
		System.out.println("hello");
	}
	
	
	@Ignore
	@Test
	public void testIgnore_2() {
		System.out.println("world");
	}
	
}