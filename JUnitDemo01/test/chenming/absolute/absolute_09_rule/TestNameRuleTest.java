package chenming.absolute.absolute_09_rule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

/**
 * 测试 TestName Rule
 * @author 陈明
 * @date   2018年10月25日
 */
public class TestNameRuleTest
{
	@Rule  
	public TestName testName = new TestName();  
	  
	@Test  
	public void testTestName() {  
	    //打印出测试方法的名字testTestName  
	    System.out.println(testName.getMethodName());  
	} 
}
