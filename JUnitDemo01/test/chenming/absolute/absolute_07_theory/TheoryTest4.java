<<<<<<< HEAD
package chenming.absolute.absolute_07_theory;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;


/**
 * 测试@Theory理论机制
 * 	使用注解@Theory取代@Test标记测试方法，可以支持带形参的测试方法签名，并使用指定的数据集(@DataPoint是单个,@DataPonints是多个)自动代入进行连续多次测试
 * @author 陈明
 * @date 2018年10月25日
 */
@RunWith(Theories.class)
public class TheoryTest4 {

	@DataPoints
	public static String[] getData() {
		return new String[] {"hello","world","chenming"};
	}
	
	@Theory
	public void testTheory(String str) {
		System.out.println(str);
	}
	
	/**
	 * 输出结果:
	 * 	hello
	 *	world
	 *	chenming
	 *
	 *
	 * 流程:
	 *	运行该测试类的时候,JUnit会依次将@DataPoints注解得到的测试数据传入到@Theory注解的方法中	
	 *
	 * 注意点:
	 *	1)数据必须是public static修饰的,不能是private
	 *	2)测试类必须写成@RunWith(Theories.class)
	 *	3)测试方法必须用@Theory注解
	 */
}
=======
package chenming.absolute.absolute_07_theory;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;


/**
 * 测试@Theory理论机制
 * 	使用注解@Theory取代@Test标记测试方法，可以支持带形参的测试方法签名，并使用指定的数据集(@DataPoint是单个,@DataPonints是多个)自动代入进行连续多次测试
 * @author 陈明
 * @date 2018年10月25日
 */
@RunWith(Theories.class)
public class TheoryTest4 {

	@DataPoints
	public static String[] getData() {
		return new String[] {"hello","world","chenming"};
	}
	
	@Theory
	public void testTheory(String str) {
		System.out.println(str);
	}
	
	/**
	 * 输出结果:
	 * 	hello
	 *	world
	 *	chenming
	 *
	 *
	 * 流程:
	 *	运行该测试类的时候,JUnit会依次将@DataPoints注解得到的测试数据传入到@Theory注解的方法中	
	 *
	 * 注意点:
	 *	1)数据必须是public static修饰的,不能是private
	 *	2)测试类必须写成@RunWith(Theories.class)
	 *	3)测试方法必须用@Theory注解
	 */
}
>>>>>>> 9a23723de0eac87773e4ba0adc56ee6ecbc22f3e
