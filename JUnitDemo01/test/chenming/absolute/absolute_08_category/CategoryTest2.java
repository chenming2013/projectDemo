package chenming.absolute.absolute_08_category;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.ExcludeCategory;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

/**
 * 分类测试
 * 	指定运行测试集(@SuiteClasses指定的测试类)带有指定标记的(@IncludeCategory指定的标记)的方法,并且不执行带有指定标记(@ExcludeCategory指定的标记)的方法
 * 	其中FastTests.java与SlowTests.java相当于两个标记	
 * 	
 * 	@IncludeCategory: 要执行的分类方法
 *  @ExcludeCategory: 不执行的分类方法
 * 
 * @author 陈明
 * @date 2018年10月25日
 */
@RunWith(Categories.class)
@SuiteClasses(CalculateTest.class)
@IncludeCategory(SlowTests.class)
@ExcludeCategory(FastTests.class)
public class CategoryTest2 {

	/**
	 * 输出结果:
	 * 	this is setUpBeforeClass()...
	 *	this is setUp()...
	 *	this is testMethod_2()...
	 *	this is tearDown()...
	 *	this is tearDownAfterClass()...
	 *
	 *	本实例中指定运行CalculateTest类中  "带有SlowTests.class标记,并且不能带有FastTests.class标记"  的方法,
	 *	因为在CalculateTest类中 testMethod_1()、testMehod_3()方法都带有ShowTests.class标记,所以这两个方法满足@IncludeCategory的条件,
	 *	然后再进行@ExcludeCategory的条件过滤,发现testMethod_3()方法不满足,所以最后只会运行testMethod_1()方法
	 */
	
}
