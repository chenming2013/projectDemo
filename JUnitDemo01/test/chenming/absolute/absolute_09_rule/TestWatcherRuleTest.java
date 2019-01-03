package chenming.absolute.absolute_09_rule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.internal.AssumptionViolatedException;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

/**
 * 测试 TestWatcher Rule
 * @author 陈明
 * @date   2018年10月25日
 */
public class TestWatcherRuleTest
{
	@Rule  
	public TestWatcher testWatcher = new TestWatcher() {  
	    @Override  
	    protected void succeeded(Description description) {  
	        System.out.println(description.getDisplayName() + " Succeed");  
	    }  
	  
	    @Override  
	    protected void failed(Throwable e, Description description) {  
	        System.out.println(description.getDisplayName() + " Fail");  
	    }  
	  
	    @Override  
	    protected void skipped(AssumptionViolatedException e, Description description) {  
	        System.out.println(description.getDisplayName() + " Skipped");  
	    }  
	  
	    @Override  
	    protected void starting(Description description) {  
	        System.out.println(description.getDisplayName() + " Started");  
	    }  
	  
	    @Override  
	    protected void finished(Description description) {  
	        System.out.println(description.getDisplayName() + " finished");  
	    }  
	};  
	  
	@Test  
	public void testTestWatcher() {  
	    /* 
	        测试执行后会有以下输出： 
	        testTestWatcher(org.haibin369.test.RulesTest) Started 
	        Test invoked 
	        testTestWatcher(org.haibin369.test.RulesTest) Succeed 
	        testTestWatcher(org.haibin369.test.RulesTest) finished 
	     */  
	    System.out.println("Test invoked");  
	}  
}
