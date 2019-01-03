package chenming;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class Log4j2_2_TypicalTest {

	private static Logger logger = LogManager.getLogger(Log4j2_2_TypicalTest.class);
	
	/**
	 * 注:这个类中的所有测试案例是需要配合   "006-log4j2_所有示例.doc" 这个文档来看的
	 */
	
	/**
	 * 测试实例一
	 * 	【本Demo的配置:
	 * 		只有一个RootLogger,RootLogger的Level为DEBUG,而且有一个Appender】
	 */
	@Test
	public void testExample_1() {
		logger.fatal("fatal...message...");
		logger.error("error...message...");
		logger.warn("warn...message...");
		logger.info("info...message...");
		logger.debug("debug...message...");
		logger.trace("trace...message...");
		
		/**
		 * 输出结果：
		 * 	FATAL chenming.Log4j2_2_TypicalTest - fatal...message...
		 *	ERROR chenming.Log4j2_2_TypicalTest - error...message...
		 *	WARN chenming.Log4j2_2_TypicalTest - warn...message...
		 *	INFO chenming.Log4j2_2_TypicalTest - info...message...
		 *	DEBUG chenming.Log4j2_2_TypicalTest - debug...message...
		 */
	}
	
	/**
	 * 测试实例二
	 * 	【本Demo的配置:
	 * 		只有一个RootLogger,RootLogger的Level为DEBUG,但是RootLogger并没有配置Appender】
	 */
	@Test
	public void testExample_2() {
		logger.fatal("fatal...message...");
		logger.error("error...message...");
		logger.warn("warn...message...");
		logger.info("info...message...");
		logger.debug("debug...message...");
		logger.trace("trace...message...");
		
		/**
		 * 输出结果：
		 * 	什么都不输出
		 */
	}
	
	
	/**
	 * 测试实例三
	 * 	【本Demo的配置:
	 * 		有多个logger,但是都没有Appender】
	 */
	@Test
	public void testExample_3() {
		logger.fatal("fatal...message...");
		logger.error("error...message...");
		logger.warn("warn...message...");
		logger.info("info...message...");
		logger.debug("debug...message...");
		logger.trace("trace...message...");
		
		/**
		 * 输出结果：
		 * 	什么都不输出
		 */
	}
	
	
	/**
	 * 测试实例四
	 * 	【本Demo的配置:
	 * 		有两个Logger,一个RootLogger,一个当前类的logger,RootLogger有Appender,并且RootLogger的Level为debug,当前类的Logger没有Appender】
	 */
	@Test
	public void testExample_4() {
		logger.fatal("fatal...message...");
		logger.error("error...message...");
		logger.warn("warn...message...");
		logger.info("info...message...");
		logger.debug("debug...message...");
		logger.trace("trace...message...");
		
		/**
		 * 输出结果：
		 * 	FATAL chenming.Log4j2_2_TypicalTest - fatal...message...
		 *	ERROR chenming.Log4j2_2_TypicalTest - error...message...
		 */
	}
	
	
	/**
	 * 测试实例五
	 * 	【本Demo的配置:
	 * 		有两个Logger,一个RootLogger,一个当前类的logger,RootLogger没有Appender,当前类的Logger有Appender,并且Level为ERROR】
	 */
	@Test
	public void testExample_5() {
		logger.fatal("fatal...message...");
		logger.error("error...message...");
		logger.warn("warn...message...");
		logger.info("info...message...");
		logger.debug("debug...message...");
		logger.trace("trace...message...");
		
		/**
		 * 输出结果：
		 * 	FATAL chenming.Log4j2_2_TypicalTest - fatal...message...
		 *	ERROR chenming.Log4j2_2_TypicalTest - error...message...
		 *
		 */
	}
	
	
	/**
	 * 测试实例六
	 * 	【本Demo的配置:
	 * 		有两个Logger,一个RootLogger,一个当前类的logger,RootLogger有Appender,并且Level为DEBUG,当前类的Logger有Appender,并且Level为ERROR】
	 */
	@Test
	public void testExample_6() {
		logger.fatal("fatal...message...");
		logger.error("error...message...");
		logger.warn("warn...message...");
		logger.info("info...message...");
		logger.debug("debug...message...");
		logger.trace("trace...message...");
		
		/**
		 * 输出结果：
		 * 	FATAL chenming.Log4j2_2_TypicalTest - fatal...message...
		 *	FATAL chenming.Log4j2_2_TypicalTest - fatal...message...
		 *	ERROR chenming.Log4j2_2_TypicalTest - error...message...
		 *	ERROR chenming.Log4j2_2_TypicalTest - error...message...
		 */
	}
	
	
	/**
	 * 测试实例七
	 * 	【本Demo的配置:
	 * 		有两个Logger,一个RootLogger,一个当前类的logger,RootLogger有Appender,并且Level为DEBUG,
	 * 		当前类的Logger有Appender,Level为ERROR,并且additivity="false"】
	 */
	@Test
	public void testExample_7() {
		logger.fatal("fatal...message...");
		logger.error("error...message...");
		logger.warn("warn...message...");
		logger.info("info...message...");
		logger.debug("debug...message...");
		logger.trace("trace...message...");
		
		/**
		 * 输出结果：
		 * 	FATAL chenming.Log4j2_2_TypicalTest - fatal...message...
		 *	ERROR chenming.Log4j2_2_TypicalTest - error...message...
		 */
	}
	
	
	/**
	 * 测试实例八
	 * 	【本Demo的配置:
	 * 		有三个Logger】
	 */
	@Test
	public void testExample_8() {
		logger.fatal("fatal...message...");
		logger.error("error...message...");
		logger.warn("warn...message...");
		logger.info("info...message...");
		logger.debug("debug...message...");
		logger.trace("trace...message...");
		
		/**
		 * 输出结果：
		 * 	FATAL chenming.Log4j2_2_TypicalTest - fatal...message...
		 *	FATAL chenming.Log4j2_2_TypicalTest - fatal...message...
		 *	ERROR chenming.Log4j2_2_TypicalTest - error...message...
		 *	ERROR chenming.Log4j2_2_TypicalTest - error...message...
		 */
	}
	
	
	/**
	 * 测试实例九
	 * 	【本Demo的配置:
	 * 		有三个Logger】
	 */
	@Test
	public void testExample_9() {
		logger.fatal("fatal...message...");
		logger.error("error...message...");
		logger.warn("warn...message...");
		logger.info("info...message...");
		logger.debug("debug...message...");
		logger.trace("trace...message...");
		
		/**
		 * 输出结果：
		 *	FATAL chenming.Log4j2_2_TypicalTest - fatal...message...
		 *	FATAL chenming.Log4j2_2_TypicalTest - fatal...message...
		 *	FATAL chenming.Log4j2_2_TypicalTest - fatal...message...
		 *	ERROR chenming.Log4j2_2_TypicalTest - error...message...
		 *	ERROR chenming.Log4j2_2_TypicalTest - error...message...
		 *	ERROR chenming.Log4j2_2_TypicalTest - error...message...
		 */
	}
	
	
	/**
	 * 测试实例十
	 * 	【本Demo的配置:
	 * 		有三个Logger】
	 */
	@Test
	public void testExample_10() {
		logger.fatal("fatal...message...");
		logger.error("error...message...");
		logger.warn("warn...message...");
		logger.info("info...message...");
		logger.debug("debug...message...");
		logger.trace("trace...message...");
		
		/**
		 * 输出结果：
		 *	FATAL chenming.Log4j2_2_TypicalTest - fatal...message...
		 *	FATAL chenming.Log4j2_2_TypicalTest - fatal...message...
		 *	FATAL chenming.Log4j2_2_TypicalTest - fatal...message...
		 *	ERROR chenming.Log4j2_2_TypicalTest - error...message...
		 *	ERROR chenming.Log4j2_2_TypicalTest - error...message...
		 *	ERROR chenming.Log4j2_2_TypicalTest - error...message...
		 */
	}
	
	
	
	
	/**
	 * 总结：
	 *	1) 能够通过Logger的日志(LoggerRecord),需要由Appender推送到指定的输出地点,所以如果Logger中没有配置Appender,那么通过该Logger的日志也不会输出
	 *		如: 测试实例二、测试实例三
	 *			【1】在测试实例二中,RootLogger的Level是DEBUG,所以能够通过该级别的日志有DEBUG、INFO、WARN、ERROR、FATAL这五种级别,
	 *			          但是因为RootLogger没有配置Appender,所以什么也不会输出。
	 *			【2】在测试实例三种,name="chenming"的Logger和RootLogger都能够匹配上当前测试类,所以当前测试类输出的日志要经过这两个Logger,
	 *				但是因为这两个Logger都没有Appender,所以任何日志都不会输出
	 *	2) 如果配置中有命名的Logger能够准确的匹配日志,那么就会以该Logger的配置为准,并且也会覆盖RootLogger的配置
	 *		如: 实例测试六
	 *			【1】在实例测试六中,当前测试类(chenming.Log4j2_2_TypicalTest)能够准确匹配到 <Logger name="chenming" level="ERROR">这个Logger,
	 *				那么只有ERROR、FATAL这两个Level的日志能够通过该Logger,那么不论RootLogger的Level是什么级别(不论是TARCE,还是FATAL),
	 *				ERROR和FATAL这两种级别的日志都能够输出到Appender.
	 *	3) 如果能够陪陪指定名称的Logger,那么就一定能够匹配其祖先Logger及RootLogger,不论祖先Logger和RootLogger设置的Level是什么级别
	 * 		如: 测试实例九
	 * 			【1】在实例测试九中,当前类(chenming.Log4j2_2_TypicalTest)能够准确匹配到 <Logger name="chenming.Log4j2_2_TypicalTest" level="ERROR">这个Logger,
	 * 				那么只有ERROR、FATAL这两个Level的日志能够通过该Logger,并且这两种类型的Logger也能够匹配其祖先Logger(name="chenming")以及RootLogger,
	 * 			    FATAL chenming.Log4j2_2_TypicalTest - fatal...message...
	 *				FATAL chenming.Log4j2_2_TypicalTest - fatal...message...
	 *				FATAL chenming.Log4j2_2_TypicalTest - fatal...message...
	 *				ERROR chenming.Log4j2_2_TypicalTest - error...message...
	 *				ERROR chenming.Log4j2_2_TypicalTest - error...message...
	 *				ERROR chenming.Log4j2_2_TypicalTest - error...message...
	 */
	
}
