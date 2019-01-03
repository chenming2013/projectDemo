package com.chenming.poi.POIOperate_04_template;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 我们是从数据库中读取读取UserScore的信息,但是user_score表中可能有一些我们 不需要导入到Excel中的数据,
 * 如createtime、updatetime、version等信息,注意,可能Id也不需要导出,因为Excel中的Id并不是我们数据库中唯一的ID标识
 * 所以我们专门定义一个UserDTO类用来装载需要保存到Excel中的数据
 * @author 陈明
 * @date   2018年8月12日
 */
public class UserScoreDTO
{
	//学生ID
	private String id;
	
	//姓名
	private String name;
	
	//年龄
	private Integer age;
	
	//省份
	private String province;
	
	//城市
	private String city;
	
	//入学时间
	private Date entryDate;
	
	//数学成绩
	private BigDecimal mathScore;
	
	//语文成绩
	private BigDecimal chineseScore;
	
	//英语成绩
	private BigDecimal englishScore;
	
	//理综成绩
	private BigDecimal integratedScienceScore;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Integer getAge()
	{
		return age;
	}

	public void setAge(Integer age)
	{
		this.age = age;
	}

	public String getProvince()
	{
		return province;
	}

	public void setProvince(String province)
	{
		this.province = province;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public Date getEntryDate()
	{
		return entryDate;
	}

	public void setEntryDate(Date entryDate)
	{
		this.entryDate = entryDate;
	}

	public BigDecimal getMathScore()
	{
		return mathScore;
	}

	public void setMathScore(BigDecimal mathScore)
	{
		this.mathScore = mathScore;
	}

	public BigDecimal getChineseScore()
	{
		return chineseScore;
	}

	public void setChineseScore(BigDecimal chineseScore)
	{
		this.chineseScore = chineseScore;
	}

	public BigDecimal getEnglishScore()
	{
		return englishScore;
	}

	public void setEnglishScore(BigDecimal englishScore)
	{
		this.englishScore = englishScore;
	}

	public BigDecimal getIntegratedScienceScore()
	{
		return integratedScienceScore;
	}

	public void setIntegratedScienceScore(BigDecimal integratedScienceScore)
	{
		this.integratedScienceScore = integratedScienceScore;
	}
}
