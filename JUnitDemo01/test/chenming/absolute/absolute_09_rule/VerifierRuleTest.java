package chenming.absolute.absolute_09_rule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Verifier;

/**
 * 测试Verifier Rule
 * @author 陈明
 * @date   2018年10月25日
 */
public class VerifierRuleTest
{

	String result;  
	  
	@Rule  
	public Verifier verifier = new Verifier() {  
	    //当测试执行完之后会调用verify方法验证结果，抛出异常表明测试失败  
	    @Override  
	    protected void verify() throws Throwable {  
	        if (!"Success".equals(result)) {  
	            System.out.println("hello");
	        	throw new Exception("Test Fail.");  
	        }  
	    }  
	};  
	  
	@Test  
	public void testVerifier() {  
		result = "Failure";  
	}  
	
}
