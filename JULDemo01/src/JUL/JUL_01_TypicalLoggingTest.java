<<<<<<< HEAD
package JUL;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;

/**
 * 测试java.util.logging的经典用法
 * @author 陈明
 */
public class JUL_01_TypicalLoggingTest {

	private static final Logger logger = Logger.getLogger(JUL_01_TypicalLoggingTest.class.getName());
	
	/**
	 * 测试logging
	 */
	@Test
	public void testLogging() {
		logger.log(Level.INFO,"方法开始");
		try {
			int num = 2/0;
		}catch(Exception e) {
			logger.log(Level.SEVERE, "除0异常");
		}
		logger.log(Level.INFO, "方法结束");
	}
	
}
=======
package JUL;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;

/**
 * 测试java.util.logging的经典用法
 * @author 陈明
 */
public class JUL_01_TypicalLoggingTest {

	private static final Logger logger = Logger.getLogger(JUL_01_TypicalLoggingTest.class.getName());
	
	/**
	 * 测试logging
	 */
	@Test
	public void testLogging() {
		logger.log(Level.INFO,"方法开始");
		try {
			int num = 2/0;
		}catch(Exception e) {
			logger.log(Level.SEVERE, "除0异常");
		}
		logger.log(Level.INFO, "方法结束");
	}
	
}
>>>>>>> 9a23723de0eac87773e4ba0adc56ee6ecbc22f3e
