package JUL;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.junit.Test;

/**
 * 测试自定义logging.properties文件覆盖默认的配置文件
 * @author 陈明
 */
public class JUL_05_DefinePropertiesFileTest {

	private static Logger logger = Logger.getLogger(JUL_05_DefinePropertiesFileTest.class.getName());
	
	/**
	 * 测试自定配置文件覆盖默认的配置文件
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws SecurityException 
	 */
	@Test
	public void testOwnPropertiesFile() throws SecurityException, FileNotFoundException, IOException {
		
		//读取自定义的配置文件
		LogManager logManager = LogManager.getLogManager();
		logManager.readConfiguration(JUL_05_DefinePropertiesFileTest.class.getResourceAsStream("/logging.properties"));
		logManager.addLogger(logger);
		
		logger.severe("SERVER...message");
		logger.warning("WARNNING...message");
		logger.info("INFO...message");
		logger.config("config...message");
		logger.fine("FINE...message");
		logger.finer("FINER...message");
		logger.finest("FINEST...message");
		
		
	}
	
}
