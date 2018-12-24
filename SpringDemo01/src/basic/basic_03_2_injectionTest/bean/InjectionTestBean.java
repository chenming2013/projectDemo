package basic.basic_03_2_injectionTest.bean;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class InjectionTestBean
{
	
	/**
	 * 1、注入八种基本数据类型
	 */
	private byte bt;
	
	private short st;
	
	private int it;
	
	private long lg;
	
	private float ft;
	
	private double de;
	
	private char cr;
	
	private boolean bn;
	
	
	/**
	 * 2、注入Bean ID
	 */
	private String id;

	
	/**
	 * 3、引用数据类型
	 */
	/**
	 * 3.1 注入List(简单List)
	 */
	private List<String> list;
	
	/**
	 * 3.1 注入List(复杂List)
	 */
	private List<List<String>> list2;
	
	/**
	 * 3.2 注入Set(简单Set)
	 */
	private Set<String> set;
	
	/**
	 * 3.2 注入Set(复杂Set)
	 */
	private Set<Set<String>> set2;
	
	/**
	 * 3.3 注入Collection
	 */
	private Collection<String> collection;
	/**
	 * 3.4 注入数组(一维数组)
	 */
	private String[] array;
	/**
	 * 3.5 注入数组(二维数组)
	 */
	private String[][] array2;
	/**
	 * 3.6 注入Map(简单Map)
	 */
	private Map<Integer,String> map;
	/**
	 * 3.6 注入Map(复杂Map)
	 */
	private Map<String,List<String>> map2;
	
	/**
	 * 3.7 注入Properties
	 */
	private Properties properties;
	
	
	/*============== Constructor ===============*/
	public InjectionTestBean() {}

	public byte getBt()
	{
		return bt;
	}

	public void setBt(byte bt)
	{
		this.bt = bt;
	}

	public short getSt()
	{
		return st;
	}

	public void setSt(short st)
	{
		this.st = st;
	}

	public int getIt()
	{
		return it;
	}

	public void setIt(int it)
	{
		this.it = it;
	}

	public long getLg()
	{
		return lg;
	}

	public void setLg(long lg)
	{
		this.lg = lg;
	}

	public float getFt()
	{
		return ft;
	}

	public void setFt(float ft)
	{
		this.ft = ft;
	}

	public double getDe()
	{
		return de;
	}

	public void setDe(double de)
	{
		this.de = de;
	}

	public char getCr()
	{
		return cr;
	}

	public void setCr(char cr)
	{
		this.cr = cr;
	}

	public boolean isBn()
	{
		return bn;
	}

	public void setBn(boolean bn)
	{
		this.bn = bn;
	}

	public List<String> getList()
	{
		return list;
	}

	public void setList(List<String> list)
	{
		this.list = list;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public Set<String> getSet()
	{
		return set;
	}

	public void setSet(Set<String> set)
	{
		this.set = set;
	}

	public Collection<String> getCollection()
	{
		return collection;
	}

	public void setCollection(Collection<String> collection)
	{
		this.collection = collection;
	}

	public String[] getArray()
	{
		return array;
	}

	public void setArray(String[] array)
	{
		this.array = array;
	}

	public String[][] getArray2()
	{
		return array2;
	}

	public void setArray2(String[][] array2)
	{
		this.array2 = array2;
	}

	public Map<Integer, String> getMap()
	{
		return map;
	}

	public void setMap(Map<Integer, String> map)
	{
		this.map = map;
	}

	public Map<String, List<String>> getMap2()
	{
		return map2;
	}

	public void setMap2(Map<String, List<String>> map2)
	{
		this.map2 = map2;
	}

	public List<List<String>> getList2()
	{
		return list2;
	}

	public void setList2(List<List<String>> list2)
	{
		this.list2 = list2;
	}

	public Set<Set<String>> getSet2()
	{
		return set2;
	}

	public void setSet2(Set<Set<String>> set2)
	{
		this.set2 = set2;
	}

	public Properties getProperties()
	{
		return properties;
	}

	public void setProperties(Properties properties)
	{
		this.properties = properties;
	}
}
