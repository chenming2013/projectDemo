package basic.basic_06_4_aop_adviceOrder.service;

import static org.hamcrest.CoreMatchers.nullValue;

/**
 * 业务实现接口
 * @author 陈明
 * @date 2018年11月29日
 */
public class BusinessServiceImpl implements BusinessService{

	/**
	 * 业务操作1
	 */
	@Override
	public void doBusiness_1() {
		System.out.println("======业务操作1");
	}
	@Override
	/**
	 * 业务操作2
	 */
	public void doBusiness_2(String str) {
		System.out.println("======业务操作2,str: "+str);
	}
	/**
	 * 业务操作3
	 */
	@Override
	public String doBusiness_3(String str) {
		System.out.println("======业务操作3,str: "+str);
		if(str==null || str.trim()=="") {
			return "default";
		}
		return str;
	}
	/**
	 * 业务操作4
	 */
	@Override
	public Boolean doBusiness_4(String str) {
		System.out.println("======业务操作4,str: "+str);
		if(str==null || str.trim()=="") {
			throw new RuntimeException("参数为null或者参数为空字符串");
		}
		return true;
	}
	/**
	 * 业务操作5
	 */
	@Override
	public void doBusiness_5(Integer num) {
		System.out.println("======业务操作5,Integer: "+num);
	}
}
