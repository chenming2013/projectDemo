<<<<<<< HEAD
package chenming.absolute.absolute_01_fixture;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 固件测试
 * 	所谓固件测试,就是每个测试方法执行前和执行后都执行的方法,用于自动初始化和回收资源等工作。
 * 	通过@Before注解标注测试方法执行前调用的固件测试,通过@After注解标注测试方法执行后调用的固件测试
 * @author 陈明
 * @date 2018年10月24日
 */
public class FixtureTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("this is setUpBeforeClass()...");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("this is tearDownAfterClass()...");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("this is setUp()...");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("this is tearDown()...");
	}
	
	@Test
	public void testFixture() {
		System.out.println("this is test()...");
		/**
		 * 输出结果：
		 *	this is setUpBeforeClass()...
		 *	this is setUp()...
		 *	this is test()...
		 *	this is tearDown()...
		 *	this is tearDownAfterClass()...
		 */
	}
	
	/**
	 * 总结:
	 * 	1) @BeforeClass修饰发方法会在所有方法被调用前执行,而且该方法是静态的,所以当测试类被加载后接着就会运行它,而且在内存中只会存在一份实例,
	 * 		它比较适合加载配置文件、进行初始化等等。
	 *  2) @AfterClass所修饰的方法会在所有方法被调用后执行,通常用来对资源的处理,如关闭数据库的链接
	 *  3) @Before和@After会在每个测试方法的前后各执行一次
	 */
	
}
=======
package chenming.absolute.absolute_01_fixture;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 固件测试
 * 	所谓固件测试,就是每个测试方法执行前和执行后都执行的方法,用于自动初始化和回收资源等工作。
 * 	通过@Before注解标注测试方法执行前调用的固件测试,通过@After注解标注测试方法执行后调用的固件测试
 * @author 陈明
 * @date 2018年10月24日
 */
public class FixtureTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("this is setUpBeforeClass()...");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("this is tearDownAfterClass()...");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("this is setUp()...");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("this is tearDown()...");
	}
	
	@Test
	public void testFixture() {
		System.out.println("this is test()...");
		/**
		 * 输出结果：
		 *	this is setUpBeforeClass()...
		 *	this is setUp()...
		 *	this is test()...
		 *	this is tearDown()...
		 *	this is tearDownAfterClass()...
		 */
	}
	
	/**
	 * 总结:
	 * 	1) @BeforeClass修饰发方法会在所有方法被调用前执行,而且该方法是静态的,所以当测试类被加载后接着就会运行它,而且在内存中只会存在一份实例,
	 * 		它比较适合加载配置文件、进行初始化等等。
	 *  2) @AfterClass所修饰的方法会在所有方法被调用后执行,通常用来对资源的处理,如关闭数据库的链接
	 *  3) @Before和@After会在每个测试方法的前后各执行一次
	 */
	
}
>>>>>>> 9a23723de0eac87773e4ba0adc56ee6ecbc22f3e
