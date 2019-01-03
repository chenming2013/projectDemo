package chenming.absolute.absolute_08_category;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;


public class CalculateTest {
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("this is setUpBeforeClass()...");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("this is tearDownAfterClass()...");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("this is setUp()...");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("this is tearDown()...");
	}
	
	@Category(FastTests.class)
	@Test
	public void testMethod_1() {
		System.out.println("this is testMethod_1()...");
	}
	
	@Category(SlowTests.class)
	@Test
	public void testMethod_2() {
		System.out.println("this is testMethod_2()...");
	}
	
	@Category({FastTests.class,SlowTests.class})
	@Test
	public void testMethod_3() {
		System.out.println("this is testMethod_3()...");
	}
	
}
