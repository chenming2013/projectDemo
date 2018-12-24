package JUL;


import java.io.IOException;
import java.util.Enumeration;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.junit.Test;

/**
 * 测试输出内容到指定文件
 * @author 陈明
 */
public class JUL_04_FileHandlerTest {
	
	private static final Logger logger = Logger.getLogger(JUL_04_FileHandlerTest.class.getName());
	
	/**
	 * 测试输出日志到指定文件
	 * @throws IOException 
	 * @throws SecurityException 
	 */
	@Test
	public void testFileHandler() throws SecurityException, IOException {
		
		//创建一个FileHandler
		FileHandler fileHandler = new FileHandler("F:\\tempDirectory\\logger\\JUL\\JUL.log.txt",true);
		
		//设置输出格式为一般的文本格式
		fileHandler.setFormatter(new SimpleFormatter());
		
		logger.addHandler(fileHandler);
		
		logger.setLevel(Level.WARNING);
		logger.severe("SERVER...message");
		logger.warning("WARNNING...message");
		logger.info("INFO...message");
		logger.config("config...message");
		logger.fine("FINE...message");
		logger.finer("FINER...message");
		logger.finest("FINEST...message");
		
		Enumeration<String> loggerNames = LogManager.getLogManager().getLoggerNames();
		while(loggerNames.hasMoreElements()) {
			String loggerName = loggerNames.nextElement();
			Logger logger2 = LogManager.getLogManager().getLogger(loggerName);
			System.out.println("loggerName:"+loggerName+" , handlers:"+logger2.getHandlers().length);
			/**
			 *  loggerName:global , handlers:0
			 *	loggerName:JUL.JUL_03_FileHandlerTest , handlers:1
			 *	loggerName: , handlers:1
			 */
		}
		
	}
}
