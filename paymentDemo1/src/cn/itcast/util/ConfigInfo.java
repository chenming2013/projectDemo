package cn.itcast.util;

import java.util.Properties;
import java.util.ResourceBundle;

/**
 *	读取properties配置文件的信息 
 *	这里使用两种方法：
 *		1.使用Properties对象
 *		2.使用ResourceBundle对象
 */
public class ConfigInfo {

/**  //这是读取属性文件的一种方法
	private static ResourceBundle cache = null;
	static 
	{
		try 
		{
			cache = ResourceBundle.getBundle("merchantInfo");
		}catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public static String getValue(String key)
	{
		cache.getString(key);
	}
*/
	
	private static Properties cache = new Properties();
	static{
		try {
			cache.load(ConfigInfo.class.getClassLoader().getResourceAsStream("merchantInfo.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 传入Properties文件中要读取的key,就能获取值
	 * @param key
	 * @return
	 */
	public static String getValue(String key){
		return cache.getProperty(key);
	}
}
