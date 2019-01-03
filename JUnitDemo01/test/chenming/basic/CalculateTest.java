<<<<<<< HEAD
package chenming.basic;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Request;
import org.junit.runner.Result;

import chenming.absolute.absolute_05_paramterized.ParameterizedTest;

public class CalculateTest {

	/**
	 * 测试两数相加
	 */
	@Test
	public void testAdd() {
		Calculate calculate = new Calculate();
		int result = calculate.add(2, 5);
		
		assertEquals(7, result);
		System.out.println(1);
		
		assertEquals(10, result);
		System.out.println(2);
		
		/**
		 * 输出结果: 1
		 * 
		 * 从输出结果可以知道,当断言为true的时候会继续向下执行,知道方法结束;当断言为false的时候,Junit会中断执行并抛出AssertError
		 */
	}

	/**
	 * 测试两数相减
	 */
	@Test
	public void testSubtract() {
		Calculate calcuate = new Calculate();
		int result = calcuate.subtract(12, 2); 
		assertEquals("减法有问题", 10000, result); //故意设置减法期望值为10000
	}

	/**
	 * 测试两数相乘
	 */
	@Test
	public void testMultiply() {
		Calculate calcuate = new Calculate();
		int result = calcuate.multiply(2, 0);
		assertEquals("乘法有问题", 0, result);
	}

	/**
	 * 测试两数相除
	 */
	@Test
	public void testDivide() {
		
		Calculate calcuate = new Calculate();
		int result = calcuate.divide(6, 0);
		System.out.println(1);
		assertEquals("除法有问题", 6, result);
		
		/**
		 * 执行 calculate.divide(6,0)的时候抛出了异常,程序中断执行,所以下面的代码并没有执行,因此Junit执行的结果才会出现 Errors:1  Failures:0
		 */
	}
	
	/**
	 * 从这几个测试案例中可以知道：
	 * 	1. 如果程序本身抛出了异常,那么就不会执行Junit的断言(参考testDevide()方法):
	 * 		1)程序会在该代码处中断执行,并抛出异常,那么之后的代码都不会执行(不考虑捕获的情况),那么JUnit的Assert根本就没有执行
	 * 		2)正是因为程序本身抛出了异常,所以Junit的测试结果是  Errors:1   Failures:0
	 * 	2. 如果程序本身没有抛出异常,那么会继续执行JUnit断言:
	 * 		1)如果Junit的断言通过,代码会向下继续执行,直到方法结束;
	 * 		2)如果JUnit的断言不通过,代码会在此处中断,并排除Junit自定义的异常,所以JUnit的执行结果是  Errors:0   Failures:1  (参考testAdd()方法)
	 */
	
	
	
	/**
	 * 下面是测试产生Error的常见情况(产生Error的情况一般与JUnit无关)：
	 * 	1.被测试的代码有bug
	 * 	2.测试的代码有bug
	 */
	@Test
	public void testError_1() {
		//1.被测试的代码有bug
		Calculate calcuate = new Calculate();
		int result = calcuate.divide(6, 0);
		assertEquals("除法有问题", 6, result);
		/**
		 * 测试结果产生了Error,这是因为在执行Calculate对象的divide()方法的时候,产生了异常,所以Junit测试结果为Error
		 */
	}
	@Test
	public void testError_2() {
		//2.测试的代码有bug
		int temp = 5 / 0;
		
		Calculate calcuate = new Calculate();
		int result = calcuate.divide(6, 0);
		assertEquals("除法有问题", 6, result);
		/**
		 * 测试结果产生了Error,这是因为在执行 "int temp = 5 / 0;" 这一行代码的时候产生了异常,所以Junit测试结果为Error
		 */
	}
	
	
	/**
	 * 下面是测试产生Failure的常见情况(产生Failure的情况一般就是因为测试结果与我们的期望不一致)
	 */
	@Test
	public void testFailure() {
		Calculate calcuate = new Calculate();
		int result = calcuate.add(6, 8);
		assertEquals("加法有问题", 20, result);
		/**
		 * 测试结果产生Failure,这是因为Junit断言的时候发现期望结果(20)与实际结果(14)不一致,所以Junit测试结果为Failure
		 */
	}
	
}
=======
package chenming.basic;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Request;
import org.junit.runner.Result;

import chenming.absolute.absolute_05_paramterized.ParameterizedTest;

public class CalculateTest {

	/**
	 * 测试两数相加
	 */
	@Test
	public void testAdd() {
		Calculate calculate = new Calculate();
		int result = calculate.add(2, 5);
		
		assertEquals(7, result);
		System.out.println(1);
		
		assertEquals(10, result);
		System.out.println(2);
		
		/**
		 * 输出结果: 1
		 * 
		 * 从输出结果可以知道,当断言为true的时候会继续向下执行,知道方法结束;当断言为false的时候,Junit会中断执行并抛出AssertError
		 */
	}

	/**
	 * 测试两数相减
	 */
	@Test
	public void testSubtract() {
		Calculate calcuate = new Calculate();
		int result = calcuate.subtract(12, 2); 
		assertEquals("减法有问题", 10000, result); //故意设置减法期望值为10000
	}

	/**
	 * 测试两数相乘
	 */
	@Test
	public void testMultiply() {
		Calculate calcuate = new Calculate();
		int result = calcuate.multiply(2, 0);
		assertEquals("乘法有问题", 0, result);
	}

	/**
	 * 测试两数相除
	 */
	@Test
	public void testDivide() {
		
		Calculate calcuate = new Calculate();
		int result = calcuate.divide(6, 0);
		System.out.println(1);
		assertEquals("除法有问题", 6, result);
		
		/**
		 * 执行 calculate.divide(6,0)的时候抛出了异常,程序中断执行,所以下面的代码并没有执行,因此Junit执行的结果才会出现 Errors:1  Failures:0
		 */
	}
	
	/**
	 * 从这几个测试案例中可以知道：
	 * 	1. 如果程序本身抛出了异常,那么就不会执行Junit的断言(参考testDevide()方法):
	 * 		1)程序会在该代码处中断执行,并抛出异常,那么之后的代码都不会执行(不考虑捕获的情况),那么JUnit的Assert根本就没有执行
	 * 		2)正是因为程序本身抛出了异常,所以Junit的测试结果是  Errors:1   Failures:0
	 * 	2. 如果程序本身没有抛出异常,那么会继续执行JUnit断言:
	 * 		1)如果Junit的断言通过,代码会向下继续执行,直到方法结束;
	 * 		2)如果JUnit的断言不通过,代码会在此处中断,并排除Junit自定义的异常,所以JUnit的执行结果是  Errors:0   Failures:1  (参考testAdd()方法)
	 */
	
	
	
	/**
	 * 下面是测试产生Error的常见情况(产生Error的情况一般与JUnit无关)：
	 * 	1.被测试的代码有bug
	 * 	2.测试的代码有bug
	 */
	@Test
	public void testError_1() {
		//1.被测试的代码有bug
		Calculate calcuate = new Calculate();
		int result = calcuate.divide(6, 0);
		assertEquals("除法有问题", 6, result);
		/**
		 * 测试结果产生了Error,这是因为在执行Calculate对象的divide()方法的时候,产生了异常,所以Junit测试结果为Error
		 */
	}
	@Test
	public void testError_2() {
		//2.测试的代码有bug
		int temp = 5 / 0;
		
		Calculate calcuate = new Calculate();
		int result = calcuate.divide(6, 0);
		assertEquals("除法有问题", 6, result);
		/**
		 * 测试结果产生了Error,这是因为在执行 "int temp = 5 / 0;" 这一行代码的时候产生了异常,所以Junit测试结果为Error
		 */
	}
	
	
	/**
	 * 下面是测试产生Failure的常见情况(产生Failure的情况一般就是因为测试结果与我们的期望不一致)
	 */
	@Test
	public void testFailure() {
		Calculate calcuate = new Calculate();
		int result = calcuate.add(6, 8);
		assertEquals("加法有问题", 20, result);
		/**
		 * 测试结果产生Failure,这是因为Junit断言的时候发现期望结果(20)与实际结果(14)不一致,所以Junit测试结果为Failure
		 */
	}
	
}
>>>>>>> 9a23723de0eac87773e4ba0adc56ee6ecbc22f3e
