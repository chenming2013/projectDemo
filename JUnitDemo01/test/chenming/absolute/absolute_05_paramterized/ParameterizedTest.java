<<<<<<< HEAD
package chenming.absolute.absolute_05_paramterized;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.JUnitCore;
import org.junit.runner.Request;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

/**
 * 参数化测试
 * 	用于模拟不同的数据集来对方法进行多次测试。若不使用参数化测试,该方法有N个不同的数据集,则需要写N个测试方法来测试
 * 
 * 获取数据集有两种方式:
 * 	1.使用带参构造函数获取数据集
 * 	2.使用@parameter(n)获取数据集
 * 
 * 本测试使用第一种获取数据集的方式
 * 
 * @author 陈明
 * @date 2018年10月24日
 */
//需要使用Parameterized测试运行器才可以
@RunWith(Parameterized.class)
public class ParameterizedTest {

	// 成员变量，用于存放测试用数据和测试期望值
	public int orig;
	public int expected;
	
	public ParameterizedTest(int orig, int expected) {
		this.orig = orig;
		this.expected = expected;
	}
	
	@Test
	public void testMyMethod() {
		System.out.println(orig+","+expected);
		assertEquals(expected, orig + 1);
	}

	/**
	 * 测试数据和测试期望值的提供方法,该方法需要满足一定的要求： 
     *    1)该方法必须由Parameters注解修饰 
     *    2)该方法必须为public static的 
     *    3)该方法必须返回Collection类型 
     *    4)该方法的名字不做要求 
     *    5)该方法没有参数 
     *    
     * @parameters指定数据集,该注解下有个name成员,可以标注每个数据集成员的信息,index所在数据集索引,{n}每个数据集元素{...}的第n+1的值
	 */
	@Parameters(name="{index}:{0} + 1 = {1}")
	public static Collection dataFeed() {
		return Arrays.asList(new Object[][] { { 1, 3 }, { 2, 3 }, { 3, 4 } });
	}
}
=======
package chenming.absolute.absolute_05_paramterized;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * 参数化测试
 * 	用于模拟不同的数据集来对方法进行多次测试。若不使用参数化测试,该方法有N个不同的数据集,则需要写N个测试方法来测试
 * 
 * 获取数据集有两种方式:
 * 	1.使用带参构造函数获取数据集
 * 	2.使用@parameter(n)获取数据集
 * 
 * 本测试使用第一种获取数据集的方式
 * 
 * @author 陈明
 * @date 2018年10月24日
 */
//需要使用Parameterized测试运行器才可以
@RunWith(Parameterized.class)
public class ParameterizedTest {

	// 成员变量，用于存放测试用数据和测试期望值
	public int orig;
	public int expected;
	
	public ParameterizedTest(int orig, int expected) {
		this.orig = orig;
		this.expected = expected;
	}
	
	@Test
	public void testMyMethod() {
		System.out.println(orig+","+expected);
		assertEquals(expected, orig + 1);
	}

	/**
	 * 测试数据和测试期望值的提供方法,该方法需要满足一定的要求： 
     *    1)该方法必须由Parameters注解修饰 
     *    2)该方法必须为public static的 
     *    3)该方法必须返回Collection类型 
     *    4)该方法的名字不做要求 
     *    5)该方法没有参数 
     *    
     * @parameters指定数据集,该注解下有个name成员,可以标注每个数据集成员的信息,index所在数据集索引,{n}每个数据集元素{...}的第n+1的值
	 */
	@Parameters(name="{index}:{0} + 1 = {1}")
	public static Collection dataFeed() {
		return Arrays.asList(new Object[][] { { 1, 2 }, { 2, 3 }, { 3, 5 } });
	}
}
>>>>>>> 9a23723de0eac87773e4ba0adc56ee6ecbc22f3e
