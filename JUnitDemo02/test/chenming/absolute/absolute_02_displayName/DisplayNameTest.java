package chenming.absolute.absolute_02_displayName;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 测试显示名称
 * @author 陈明
 * @date   2018年10月29日
 */
@DisplayName("A special test case")
public class DisplayNameTest
{
	@DisplayName("这是测试方法1")
	@Test
	public void testMethod_1() {
		System.out.println("testMethod_1()...");
	}
	
	@DisplayName("✔☺※")
	@Test
	public void testMethod_2() {
		System.out.println("testMethod_2()...");
	}
	
	@Test
	public void testMethod_3() {
		System.out.println("testMethod_3()...");
	}
	
}
