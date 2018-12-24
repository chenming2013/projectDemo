package chenming.absolute.absolute_04_timeout;


import org.junit.Test;

/**
 * 超时测试
 * 	通过@Test(timeout=毫秒数)注解来标注期待执行测试方法的最大耗时,若超时则测试失败
 * @author 陈明
 * @date 2018年10月24日
 */
public class TimeoutTest {
	
	@Test(timeout=2000)
	public void testTimeout_1() {
		System.out.println("hello world");
	}
	
	@Test(timeout=2000)
	public void testTimeout_2() {
		for(int i=0;i<7000;i++) {
			System.out.print(i+",");
		}
	}
	
	@Test(timeout=2000)
	public void testTimeout_3() {
		try {
			Thread.sleep(3000);
			
			System.out.println("hello world");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		/**
		 * 运行测试方法,当前线程休眠3000毫秒,在时间达到2000毫秒的时候,JUnit因为超时而强制结束该方法,
		 * 这就触发了InterruptedException中断异常,所以运行结果 Errors:1   Failures:0
		 */
	}
	
}