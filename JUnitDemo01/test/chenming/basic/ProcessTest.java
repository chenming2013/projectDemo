package chenming.basic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 测试JUnit的运行流程
 * @author 陈明
 * @date 2018年10月24日
 */
public class ProcessTest {

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
	public void testProcess() {
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
