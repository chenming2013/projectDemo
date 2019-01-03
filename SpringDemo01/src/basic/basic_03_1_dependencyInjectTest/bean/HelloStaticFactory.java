package basic.basic_03_1_dependencyInjectTest.bean;
/**
 * 静态工厂
 * @author 陈明
 * @date   2018年9月17日
 */
public class HelloStaticFactory
{
	/**
	 * 静态工厂方法
	 * @param id
	 * @param name
	 * @param age
	 * @return
	 */
	public static Hello newInstance(int id,String name,int age) {
		return new HelloImpl(id,name,age);
	}
}
