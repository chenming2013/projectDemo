package basic.basic_06_3_aop_adviceBaseAspectJ.service;

/**
 * 业务 Service层
 * @author 陈明
 * @date 2018年11月29日
 */
public interface BusinessService {
	/**
	 * 业务操作1
	 */
	public abstract void doBusiness_1();
	/**
	 * 业务操作2
	 */
	public abstract void doBusiness_2(String str);
	/**
	 * 业务操作3
	 */
	public abstract String doBusiness_3(String str);
	/**
	 * 业务操作4
	 */
	public abstract Boolean doBusiness_4(String str);
	/**
	 * 业务操作5
	 */
	public abstract void doBusiness_5(Integer num);
}
