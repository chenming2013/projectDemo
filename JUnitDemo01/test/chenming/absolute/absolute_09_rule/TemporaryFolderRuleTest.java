package chenming.absolute.absolute_09_rule;

import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

/**
 * 测试TemporaryFolder Rule
 * 	这个Rule可以创建一些临时目录或文件,在一个测试方法结束后,系统会自动清空他们
 * @author 陈明
 * @date   2018年10月25日
 */
public class TemporaryFolderRuleTest
{
	//创建TemporaryFolder Rule  
	//可以在构造方法上加入路径参数来指定临时目录，否则使用系统临时目录  
	@Rule  
	public TemporaryFolder tempFolder = new TemporaryFolder();  
	  
	@Test  
	public void testTempFolderRule() throws IOException {  
	    //在系统的临时目录下创建文件或者目录，当测试方法执行完毕自动删除  
	    tempFolder.newFile("test.txt");  
	    tempFolder.newFolder("test");  
	    
	    String absolutePath = tempFolder.getRoot().getAbsolutePath();
	}  
}
