package chenming;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class Log4j2_1_HelloworldTest {

	private static Logger logger = LogManager.getLogger(Log4j2_1_HelloworldTest.class);
	
	@Test
	public void testHelloworld() {
		logger.error("error...message..."); 
		logger.info("info...message");
	}
	
}
