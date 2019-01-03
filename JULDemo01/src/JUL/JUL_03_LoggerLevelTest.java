<<<<<<< HEAD
package JUL;

import java.util.Enumeration;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.junit.Test;

/**
 * 测试logger级别的问题
 * 	1)低级别的logger能显示高级别的信息吗？
 * 	2)高级别的logger能显示低级别的信息吗？
 * @author 陈明
 */
public class JUL_03_LoggerLevelTest {

	private static final Logger logger = Logger.getLogger(JUL_03_LoggerLevelTest.class.getName());
	
	/**
	 * 测试低级别的Logger
	 * 	如果我们为logger设置了级别,那么就会覆盖JDK默认的级别
	 */
	@Test
	public void testLowerLevelLogger() {

		logger.setLevel(Level.FINER);
		logger.severe("SERVER...message");
		logger.warning("WARNNING...message");
		logger.info("INFO...message");
		logger.config("config...message");
		logger.fine("FINE...message");
		logger.finer("FINER...message");
		logger.finest("FINEST...message");
		
		/**
		 * 输出结果：只输出了INFO及其以上的级别
		 *	九月 17, 2018 2:37:19 下午 JUL.JUL_02_LoggerLevelTest testLogger
		 *	严重: SERVER...message
		 *	九月 17, 2018 2:37:19 下午 JUL.JUL_02_LoggerLevelTest testLogger
		 *	警告: WARNNING...message
		 *	九月 17, 2018 2:37:19 下午 JUL.JUL_02_LoggerLevelTest testLogger
		 *	信息: INFO...message
		 */
	}
	
	
	/**
	 * 测试高级别的Logger
	 * 	如果我们为logger设置了级别,那么就会覆盖JDK默认的级别
	 */
	@Test
	public void testHigherLevelLogger() {
		logger.setLevel(Level.WARNING);
		logger.severe("SERVER...message");
		logger.warning("WARNNING...message");
		logger.info("INFO...message");
		logger.config("config...message");
		logger.fine("FINE...message");
		logger.finer("FINER...message");
		logger.finest("FINEST...message");
		/**
		 * 输出结果：只输出了WARNING及其以上的级别
		 *	九月 17, 2018 2:37:19 下午 JUL.JUL_02_LoggerLevelTest testLogger
		 *	严重: SERVER...message
		 *	九月 17, 2018 2:37:19 下午 JUL.JUL_02_LoggerLevelTest testLogger
		 *	警告: WARNNING...message
		 *
		 *	从这里的输出结果可以知道：
		 *		1.我们设置的级别WARNING的确覆盖了JDK默认的INFO,因为只输出WARNING及其以上的级别
		 */
	}
	
	
	@Test
	public void testConsoleHandlerTest_1() {
		logger.setLevel(Level.FINER);
		
		ConsoleHandler consoleHandler = new ConsoleHandler();
		//设置consoleHandler的级别为FINE
		consoleHandler.setLevel(Level.FINE);
		
		logger.addHandler(consoleHandler);
		/**
		 * 如果将这一句注释起来,那么就只会输出Root Logger记录的日志,因为这个自己定义的logger没有定义Handler,也就是没有定义日志输出目的地,所以这一个logger记录的日志不输出
		 */
		
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
			 * loggerName:JUL.JUL_02_LoggerLevelTest,handlers:1
			 *	loggerName:global,handlers:0
			 *	loggerName:,handlers:1   (这个是Root Logger)
			 */
		}
		
		/**
		 * 输出结果:
		 *	九月 17, 2018 5:19:02 下午 JUL.JUL_02_LoggerLevelTest testConsoleHandlerTest_1
		 *	严重: SERVER...message
		 *	九月 17, 2018 5:19:02 下午 JUL.JUL_02_LoggerLevelTest testConsoleHandlerTest_1
		 *	严重: SERVER...message
		 *	九月 17, 2018 5:19:02 下午 JUL.JUL_02_LoggerLevelTest testConsoleHandlerTest_1
		 *	警告: WARNNING...message
		 *	九月 17, 2018 5:19:02 下午 JUL.JUL_02_LoggerLevelTest testConsoleHandlerTest_1
		 *	警告: WARNNING...message
		 * 	九月 17, 2018 5:19:02 下午 JUL.JUL_02_LoggerLevelTest testConsoleHandlerTest_1
		 *	信息: INFO...message
		 *	九月 17, 2018 5:19:02 下午 JUL.JUL_02_LoggerLevelTest testConsoleHandlerTest_1
		 *	信息: INFO...message
		 *	九月 17, 2018 5:19:02 下午 JUL.JUL_02_LoggerLevelTest testConsoleHandlerTest_1
		 *	配置: config...message
		 *	九月 17, 2018 5:19:02 下午 JUL.JUL_02_LoggerLevelTest testConsoleHandlerTest_1
		 *	详细: FINE...message
		 *
		 *	从这里可以看出:
		 *		1.INFO以上级别的信息输出了两次,这是因为这里我们有两个Handler,一个是我们自定义的Handler,一个是根节点的Handler,所以输出了两次,
		 *			而且因为global这个logger没有handler,所以不输出信息
		 *		2.如果一个logger没有配置Handler,那么这个logger记录的日志也不会输出
		 */
	}
	
	
	
	/**
	 * 测试ConsoleHandler
	 */
	@Test
	public void testConsoleHandlerTest_2() {
		logger.setLevel(Level.FINER);
		
		ConsoleHandler consoleHandler = new ConsoleHandler();
		//设置consoleHandler的级别为FINE
		consoleHandler.setLevel(Level.FINE);
		
		//设置不输出Root Logger记录的日志
		logger.setUseParentHandlers(false);
		logger.addHandler(consoleHandler);
		
		logger.severe("SERVER...message");
		logger.warning("WARNNING...message");
		logger.info("INFO...message");
		logger.config("config...message");
		logger.fine("FINE...message");
		logger.finer("FINER...message");
		logger.finest("FINEST...message");
		/**
		 * 输出结果:
		 * 	九月 17, 2018 5:14:23 下午 JUL.JUL_02_LoggerLevelTest testConsoleHandlerTest
		 *	严重: SERVER...message
		 *	九月 17, 2018 5:14:23 下午 JUL.JUL_02_LoggerLevelTest testConsoleHandlerTest
		 *	警告: WARNNING...message
		 *	九月 17, 2018 5:14:23 下午 JUL.JUL_02_LoggerLevelTest testConsoleHandlerTest
		 *	信息: INFO...message
		 *	九月 17, 2018 5:14:23 下午 JUL.JUL_02_LoggerLevelTest testConsoleHandlerTest
		 *	配置: config...message
		 *	九月 17, 2018 5:14:23 下午 JUL.JUL_02_LoggerLevelTest testConsoleHandlerTest
		 *	详细: FINE...message
		 *
		 *	从这里的输出结果可以知道:
		 *		1.一条日志要想输出,首先要比较日志设置的级别与logger对象设置的需要记录的日志的级别,
		 *			如我们设置的logger的级别为logger.setLevel(Level.FINER),
		 *			那么logger.server()、logger.warning()、logger.info()、logger.config()、logger.fine()、logger.finer()都通过了第一重筛选,
		 *			而logger.finest()没有通过筛选
		 *		2.对通过筛选的日志信息再进行Handler的Level级别的比较
		 *			如我们设置的handler的级别为consoleHandler.setLevel(Level.fine),
		 *			那么logger.server()、logger.warning()、logger.info()、logger.config()、logger.fine()通过谁选
		 *			而logger.finer()没有通过筛选
		 *		3.如果我们设置了继承父logger,那么父logger也会重复执行1、2两个步骤
		 *		4.将通过筛选的日志信息输出到各自的目的地
		 */
	}
	
}
=======
package JUL;

import java.util.Enumeration;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.junit.Test;

/**
 * 测试logger级别的问题
 * 	1)低级别的logger能显示高级别的信息吗？
 * 	2)高级别的logger能显示低级别的信息吗？
 * @author 陈明
 */
public class JUL_03_LoggerLevelTest {

	private static final Logger logger = Logger.getLogger(JUL_03_LoggerLevelTest.class.getName());
	
	/**
	 * 测试低级别的Logger
	 * 	如果我们为logger设置了级别,那么就会覆盖JDK默认的级别
	 */
	@Test
	public void testLowerLevelLogger() {

		logger.setLevel(Level.FINER);
		logger.severe("SERVER...message");
		logger.warning("WARNNING...message");
		logger.info("INFO...message");
		logger.config("config...message");
		logger.fine("FINE...message");
		logger.finer("FINER...message");
		logger.finest("FINEST...message");
		
		/**
		 * 输出结果：只输出了INFO及其以上的级别
		 *	九月 17, 2018 2:37:19 下午 JUL.JUL_02_LoggerLevelTest testLogger
		 *	严重: SERVER...message
		 *	九月 17, 2018 2:37:19 下午 JUL.JUL_02_LoggerLevelTest testLogger
		 *	警告: WARNNING...message
		 *	九月 17, 2018 2:37:19 下午 JUL.JUL_02_LoggerLevelTest testLogger
		 *	信息: INFO...message
		 */
	}
	
	
	/**
	 * 测试高级别的Logger
	 * 	如果我们为logger设置了级别,那么就会覆盖JDK默认的级别
	 */
	@Test
	public void testHigherLevelLogger() {
		logger.setLevel(Level.WARNING);
		logger.severe("SERVER...message");
		logger.warning("WARNNING...message");
		logger.info("INFO...message");
		logger.config("config...message");
		logger.fine("FINE...message");
		logger.finer("FINER...message");
		logger.finest("FINEST...message");
		/**
		 * 输出结果：只输出了WARNING及其以上的级别
		 *	九月 17, 2018 2:37:19 下午 JUL.JUL_02_LoggerLevelTest testLogger
		 *	严重: SERVER...message
		 *	九月 17, 2018 2:37:19 下午 JUL.JUL_02_LoggerLevelTest testLogger
		 *	警告: WARNNING...message
		 *
		 *	从这里的输出结果可以知道：
		 *		1.我们设置的级别WARNING的确覆盖了JDK默认的INFO,因为只输出WARNING及其以上的级别
		 */
	}
	
	
	@Test
	public void testConsoleHandlerTest_1() {
		logger.setLevel(Level.FINER);
		
		ConsoleHandler consoleHandler = new ConsoleHandler();
		//设置consoleHandler的级别为FINE
		consoleHandler.setLevel(Level.FINE);
		
		logger.addHandler(consoleHandler);
		/**
		 * 如果将这一句注释起来,那么就只会输出Root Logger记录的日志,因为这个自己定义的logger没有定义Handler,也就是没有定义日志输出目的地,所以这一个logger记录的日志不输出
		 */
		
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
			 * loggerName:JUL.JUL_02_LoggerLevelTest,handlers:1
			 *	loggerName:global,handlers:0
			 *	loggerName:,handlers:1   (这个是Root Logger)
			 */
		}
		
		/**
		 * 输出结果:
		 *	九月 17, 2018 5:19:02 下午 JUL.JUL_02_LoggerLevelTest testConsoleHandlerTest_1
		 *	严重: SERVER...message
		 *	九月 17, 2018 5:19:02 下午 JUL.JUL_02_LoggerLevelTest testConsoleHandlerTest_1
		 *	严重: SERVER...message
		 *	九月 17, 2018 5:19:02 下午 JUL.JUL_02_LoggerLevelTest testConsoleHandlerTest_1
		 *	警告: WARNNING...message
		 *	九月 17, 2018 5:19:02 下午 JUL.JUL_02_LoggerLevelTest testConsoleHandlerTest_1
		 *	警告: WARNNING...message
		 * 	九月 17, 2018 5:19:02 下午 JUL.JUL_02_LoggerLevelTest testConsoleHandlerTest_1
		 *	信息: INFO...message
		 *	九月 17, 2018 5:19:02 下午 JUL.JUL_02_LoggerLevelTest testConsoleHandlerTest_1
		 *	信息: INFO...message
		 *	九月 17, 2018 5:19:02 下午 JUL.JUL_02_LoggerLevelTest testConsoleHandlerTest_1
		 *	配置: config...message
		 *	九月 17, 2018 5:19:02 下午 JUL.JUL_02_LoggerLevelTest testConsoleHandlerTest_1
		 *	详细: FINE...message
		 *
		 *	从这里可以看出:
		 *		1.INFO以上级别的信息输出了两次,这是因为这里我们有两个Handler,一个是我们自定义的Handler,一个是根节点的Handler,所以输出了两次,
		 *			而且因为global这个logger没有handler,所以不输出信息
		 *		2.如果一个logger没有配置Handler,那么这个logger记录的日志也不会输出
		 */
	}
	
	
	
	/**
	 * 测试ConsoleHandler
	 */
	@Test
	public void testConsoleHandlerTest_2() {
		logger.setLevel(Level.FINER);
		
		ConsoleHandler consoleHandler = new ConsoleHandler();
		//设置consoleHandler的级别为FINE
		consoleHandler.setLevel(Level.FINE);
		
		//设置不输出Root Logger记录的日志
		logger.setUseParentHandlers(false);
		logger.addHandler(consoleHandler);
		
		logger.severe("SERVER...message");
		logger.warning("WARNNING...message");
		logger.info("INFO...message");
		logger.config("config...message");
		logger.fine("FINE...message");
		logger.finer("FINER...message");
		logger.finest("FINEST...message");
		/**
		 * 输出结果:
		 * 	九月 17, 2018 5:14:23 下午 JUL.JUL_02_LoggerLevelTest testConsoleHandlerTest
		 *	严重: SERVER...message
		 *	九月 17, 2018 5:14:23 下午 JUL.JUL_02_LoggerLevelTest testConsoleHandlerTest
		 *	警告: WARNNING...message
		 *	九月 17, 2018 5:14:23 下午 JUL.JUL_02_LoggerLevelTest testConsoleHandlerTest
		 *	信息: INFO...message
		 *	九月 17, 2018 5:14:23 下午 JUL.JUL_02_LoggerLevelTest testConsoleHandlerTest
		 *	配置: config...message
		 *	九月 17, 2018 5:14:23 下午 JUL.JUL_02_LoggerLevelTest testConsoleHandlerTest
		 *	详细: FINE...message
		 *
		 *	从这里的输出结果可以知道:
		 *		1.一条日志要想输出,首先要比较日志设置的级别与logger对象设置的需要记录的日志的级别,
		 *			如我们设置的logger的级别为logger.setLevel(Level.FINER),
		 *			那么logger.server()、logger.warning()、logger.info()、logger.config()、logger.fine()、logger.finer()都通过了第一重筛选,
		 *			而logger.finest()没有通过筛选
		 *		2.对通过筛选的日志信息再进行Handler的Level级别的比较
		 *			如我们设置的handler的级别为consoleHandler.setLevel(Level.fine),
		 *			那么logger.server()、logger.warning()、logger.info()、logger.config()、logger.fine()通过谁选
		 *			而logger.finer()没有通过筛选
		 *		3.如果我们设置了继承父logger,那么父logger也会重复执行1、2两个步骤
		 *		4.将通过筛选的日志信息输出到各自的目的地
		 */
	}
	
}
>>>>>>> 9a23723de0eac87773e4ba0adc56ee6ecbc22f3e
