package chenming.absolute.absolute_03_exception;

import org.junit.Test;

/**
 * 异常测试
 * 	通过注解@Test(expected=Class类型)来标注期待测试方法执行时抛出哪种异常对象。
 * 		1)若测试方法不抛出异常,则测试失败   Errors:0  Failures:1
 * 		2)若测试方法抛出的异常与期待的异常一致,测试通过
 * 		3)若测试方法抛出的异常与期待的异常不一致,测试失败  Errors:1  Failures:0
 * @author 陈明
 * @date 2018年10月24日
 */
public class ExceptionTest {

	/**
	 * 测试方法不抛出异常
	 */
	@Test(expected=ArithmeticException.class)
	public void testException_1() {
		System.out.println("hello world");
		
		/**
		 * 输出结果：hello world
		 * 	Errors:0  Failures:1
		 */
	}
	
	/**
	 * 测试方法抛出的异常与期待的异常一致
	 */
	@Test(expected=ArithmeticException.class)
	public void testException_2() {
		int result = 5 / 0;
		System.out.println(result);
		
		/**
		 * 输出结果: 什么都不输出
		 * 
		 * Errors:0   Failures:0
		 */
	}
	
	/**
	 * 测试方法抛出的异常与期待的异常不一致
	 */
	@Test(expected=NullPointerException.class)
	public void testException_3() {
		int result = 5 / 0;
		System.out.println(result);
		
		/**
		 * 输出结果:  什么都不输出
		 * 
		 * Errors:1  Failures:0
		 */
	}
}
