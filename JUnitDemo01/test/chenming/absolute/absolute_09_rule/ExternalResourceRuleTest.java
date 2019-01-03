package chenming.absolute.absolute_09_rule;

import java.io.File;
import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExternalResource;

/**
 * 测试ExternalResource Rule
 * @author 陈明
 * @date   2018年10月25日
 */
public class ExternalResourceRuleTest
{
	File tempFile;  
	  
	@Rule  
	public ExternalResource extResource = new ExternalResource() {  
	    //每个测试执行之前都会调用该方法创建一个临时文件  
	    @Override  
	    protected void before() throws Throwable {  
	        tempFile = File.createTempFile("test", ".txt");  
	    }  
	  
	    //每个测试执行之后都会调用该方法删除临时文件  
	    @Override  
	    protected void after() {  
	        tempFile.delete();  
	    }  
	};  
	  
	@Test  
	public void testExtResource() throws IOException {  
	    System.out.println(tempFile.getCanonicalPath());  
	}  
}
