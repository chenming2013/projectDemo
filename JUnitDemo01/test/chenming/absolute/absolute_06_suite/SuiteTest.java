package chenming.absolute.absolute_06_suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * 套件测试(也就是测试集测试)
 * 	套件测试就是按照业务逻辑对测试类进行分组,并以组为单位进行单元测试
 * @author 陈明
 * @date 2018年10月25日
 */
@RunWith(Suite.class)
@SuiteClasses({Test1.class,Test2.class})
public class SuiteTest {
	
	/**
	 * 直接在类上运行测试
	 * 输出结果:
	 * 	Test1...testMethod_1()...
	 *	Test1...testMethod_2()...
	 *	Test2...testMethod_1()...
	 *	Test2...testMethod_2()...
	 */
}
