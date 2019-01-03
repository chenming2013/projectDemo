package com.chenming.poi.domain;

import java.util.Date;

public class Student
{
	/**
	 * ID 
	 */
	private Integer id;
	
	/**
	 * 姓名
	 */
	private String name;
	
	/**
	 * 学号
	 */
	private String no;
	
	/**
	 * 籍贯
	 */
	private String nativePlace;
	
	/**
	 * 学院
	 */
	private String edu;
	
	/**
	 * 入学年份
	 */
	private Integer year;
	
	/**
	 * 数学成绩
	 */
	private Integer math;
	
	/**
	 * 英文成绩
	 */
	private Integer chinese;
	
	/**
	 * 英语成绩
	 */
	private Integer english;
	
	/**
	 * 理综成绩
	 */
	private Integer science;
	
	/**
	 * 总成绩
	 */
	private Integer scores;
	
	/**
	 * 平均分
	 */
	private Integer avg;
	
	/**
	 * 是否城镇户口
	 */
	private Boolean isCity;
	
	/**
	 * 入学时间
	 */
	private Date schoolDate;
	
	/**
	 * 出生年月
	 */
	private Date birth;
	

	// ========== Constructor ===========
	public Student() {}
	
	public Student(Integer id, String name, String no, String nativePlace, String edu, Integer year, Integer math,
			Integer chinese, Integer english, Integer science, Integer scores, Integer avg, Boolean isCity,
			Date schoolDate, Date birth)
	{
		super();
		this.id = id;
		this.name = name;
		this.no = no;
		this.nativePlace = nativePlace;
		this.edu = edu;
		this.year = year;
		this.math = math;
		this.chinese = chinese;
		this.english = english;
		this.science = science;
		this.scores = scores;
		this.avg = avg;
		this.isCity = isCity;
		this.schoolDate = schoolDate;
		this.birth = birth;
	}

	
	// ============= Setter And Getter =============
	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
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

	public String getNo()
	{
		return no;
	}

	public void setNo(String no)
	{
		this.no = no;
	}

	public String getNativePlace()
	{
		return nativePlace;
	}

	public void setNativePlace(String nativePlace)
	{
		this.nativePlace = nativePlace;
	}

	public String getEdu()
	{
		return edu;
	}

	public void setEdu(String edu)
	{
		this.edu = edu;
	}

	public Integer getYear()
	{
		return year;
	}

	public void setYear(Integer year)
	{
		this.year = year;
	}

	public Integer getMath()
	{
		return math;
	}

	public void setMath(Integer math)
	{
		this.math = math;
	}

	public Integer getChinese()
	{
		return chinese;
	}

	public void setChinese(Integer chinese)
	{
		this.chinese = chinese;
	}

	public Integer getEnglish()
	{
		return english;
	}

	public void setEnglish(Integer english)
	{
		this.english = english;
	}

	public Integer getScience()
	{
		return science;
	}

	public void setScience(Integer science)
	{
		this.science = science;
	}

	public Integer getScores()
	{
		return scores;
	}

	public void setScores(Integer scores)
	{
		this.scores = scores;
	}

	public Integer getAvg()
	{
		return avg;
	}

	public void setAvg(Integer avg)
	{
		this.avg = avg;
	}

	public Boolean getIsCity()
	{
		return isCity;
	}

	public void setIsCity(Boolean isCity)
	{
		this.isCity = isCity;
	}

	public Date getSchoolDate()
	{
		return schoolDate;
	}

	public void setSchoolDate(Date schoolDate)
	{
		this.schoolDate = schoolDate;
	}

	public Date getBirth()
	{
		return birth;
	}

	public void setBirth(Date birth)
	{
		this.birth = birth;
	}
	
}
