package basic.basic_03_1_dependencyInjectTest.bean;

/**
 * 实例工厂
 * @author 陈明
 * @date   2018年9月17日
 */
public class HelloInstanceFactory
{
	/**
	 * 实例方法
	 * @param id
	 * @param name
	 * @param age
	 * @return
	 */
	public HelloImpl newInstance(int id,String name,int age) {
		return new HelloImpl(id,name,age);
	}
	
}
