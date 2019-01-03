package chenming.absolute.absolute_09_rule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

/**
 * 测试 ErrorCollector Rule
 * @author 陈明
 * @date   2018年10月25日
 */
public class ErrorCollectorRuleTest
{
	@Rule  
	public ErrorCollector errorCollector = new ErrorCollector();  
	  
	@Test  
	public void testErrorCollector() {  
	    errorCollector.addError(new Exception("Test Fail 1"));  
	    errorCollector.addError(new Throwable("fff"));  
	}  
}
