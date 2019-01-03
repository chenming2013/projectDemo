package chenming.absolute.absolute_01_testMethod;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 测试 JUnit5的测试方法
 * @author 陈明
 * @date   2018年10月29日
 */
public class TestMethodTest
{
	
	/**
	 * 该方法在所有测试方法调用开始之前执行
	 */
	@BeforeAll
	public static void testBeforeAll() {
		System.out.println("beforeAll...");
	}
	
	
	/**
	 * 该方法在每个测试方法调用之前都执行一次
	 */
	@BeforeEach
	public void testBeforeEach() {
		System.out.println("beforeEach...");
	}
	
	
	@Test
	public void testMethod_1() {
		System.out.println("testMethod_1()...");
	}
	@Test
	public void testMethod_2() {
		System.out.println("testMethod_2()...");
	}
	@Test
	public void testMethod_3() {
		System.out.println("testMethod_3()...");
	}
	
	
	/**
	 * 该方法在每个测试方法调用结束之后都执行一次
	 */
	@AfterEach
	public void testAfterEach() {
		System.out.println("afterEach...");
	}
	/**
	 * 该方法在所有测试方法调用完毕之后执行
	 */
	@AfterAll
	public static void testAfterAll() {
		System.out.println("afterAll...");
	}

}
