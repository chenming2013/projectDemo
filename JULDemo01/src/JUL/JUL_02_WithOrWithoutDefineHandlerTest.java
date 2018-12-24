package JUL;

import java.util.Enumeration;
import java.util.logging.ConsoleHandler;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.junit.Test;

/**
 * 测试 自定义handler与不自定义handler到控制台
 * @author 陈明
 */
public class JUL_02_WithOrWithoutDefineHandlerTest {

	private static Logger logger = Logger.getLogger(JUL_02_WithOrWithoutDefineHandlerTest.class.getName());
	
	/**
	 * 测试不自定义Handler
	 */
	@Test
	public void testWithoutDefineHandler() {
		
		logger.severe("SERVER...message");
		logger.warning("WARNNING...message");
		logger.info("INFO...message");
		logger.config("config...message");
		logger.fine("FINE...message");
		logger.finer("FINER...message");
		logger.finest("FINEST...message");
		
		//求出当前类中有几个logger
		Enumeration<String> loggerNames = LogManager.getLogManager().getLoggerNames();
		while(loggerNames.hasMoreElements()) {
			String loggerName = loggerNames.nextElement();
			Logger logger2 = LogManager.getLogManager().getLogger(loggerName);
			System.out.println("loggerName:"+loggerName+" , handlers:"+logger2.getHandlers().length);
			/**
			 *  loggerName:JUL.JUL_02_WithOrWithoutDefineHandlerTest , handlers:0
			 *	loggerName:global , handlers:0
			 *	loggerName: , handlers:1
			 */
		}
		
		
		/**
		 * 输出结果:
		 * 	九月 17, 2018 6:30:14 下午 JUL.JUL_02_WithOrWithoutDefineHandlerTest testWithoutDefineHandler
		 *	严重: SERVER...message
		 *	九月 17, 2018 6:30:14 下午 JUL.JUL_02_WithOrWithoutDefineHandlerTest testWithoutDefineHandler
		 *	警告: WARNNING...message
		 *	九月 17, 2018 6:30:14 下午 JUL.JUL_02_WithOrWithoutDefineHandlerTest testWithoutDefineHandler
		 *	信息: INFO...message
		 *
		 *
		 *	从输出的结果以及logger的Handler中可以知道:
		 *		1.没有设置Handler的logger,即使记录了日志信息,但是也不会输出
		 *		2.任何一个logger(不论有没有名字),都会继承自Root logger,没有设置Handler的logger不会输出日志信息,但是Root logger会输出日志信息,
		 *			而且如果该logger还有父logger,那么还需要判断父logger是否需要进行输出
		 *		
		 */
	}
	
	
	/**
	 * 测试自定义Handler
	 */
	@Test
	public void testWithDefineHandler() {
		logger.addHandler(new ConsoleHandler());
		
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
			 *  loggerName:JUL.JUL_02_WithOrWithoutDefineHandlerTest , handlers:1
			 *	loggerName:global , handlers:0
			 *	loggerName: , handlers:1
			 */
		}
		
		
		/**
		 *  九月 18, 2018 2:36:05 下午 JUL.JUL_02_WithOrWithoutDefineHandlerTest testWithDefineHandler
		 *	严重: SERVER...message
		 *	九月 18, 2018 2:36:05 下午 JUL.JUL_02_WithOrWithoutDefineHandlerTest testWithDefineHandler
		 *	严重: SERVER...message
		 *	九月 18, 2018 2:36:05 下午 JUL.JUL_02_WithOrWithoutDefineHandlerTest testWithDefineHandler
		 *	警告: WARNNING...message
		 *	九月 18, 2018 2:36:05 下午 JUL.JUL_02_WithOrWithoutDefineHandlerTest testWithDefineHandler
		 *	警告: WARNNING...message
		 *	九月 18, 2018 2:36:05 下午 JUL.JUL_02_WithOrWithoutDefineHandlerTest testWithDefineHandler
		 *	信息: INFO...message
		 *	九月 18, 2018 2:36:05 下午 JUL.JUL_02_WithOrWithoutDefineHandlerTest testWithDefineHandler
		 *	信息: INFO...message
		 *
		 *
		 *	从输出结果可以知道：
		 *		1.INFO及其以上级别的日志输出了两次,一次是当前logger输出的,一次是Root logger输出的
		 *		2.默认的Handler的日志级别是INFO,这是在logging.properties文件中定义的
		 */
		
	}
}
