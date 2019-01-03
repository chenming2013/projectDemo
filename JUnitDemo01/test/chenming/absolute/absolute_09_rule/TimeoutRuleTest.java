package chenming.absolute.absolute_09_rule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

/**
 * 测试TimeoutRule
 * @author 陈明
 * @date 2018年10月24日
 */
public class TimeoutRuleTest {

	/**
	 * 使用timeout这个Rule
	 */
	@Rule
	public Timeout timeout = new Timeout(2000);
	
	@Test
	public void testMethod_1() {
		System.out.println("testMethod_1()...");
	}
	
	@Test
	public void testMethod_2() {
		try{
			Thread.sleep(3000);
			
			System.out.println("testMethod_2()...");
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * 对于本类中的测试方法,每一个运行时间不能超过2000毫秒,否则测试失败,
	 * 原理与@Tets(timeout=2000)一样,只不过不需要在每个测试方法上声明一次
	 */
}
