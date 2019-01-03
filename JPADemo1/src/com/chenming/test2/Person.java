package com.chenming.test2;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Person 实体类
 * @author Lenovo
 *
 */
@Table(name="jpa_persons")
@Entity
public class Person
{
	private Integer id;
	
	private String name;
	
	private Date birthday;  //出生时间
	
	private Date registerTime;  //在公安局等级的时间
	
	private int age;   //年龄

	
	/* Setter And Getter */
	@Id
	@GeneratedValue
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
	
	@Temporal(TemporalType.DATE)
	public Date getBirthday()
	{
		return birthday;
	}

	public void setBirthday(Date birthday)
	{
		this.birthday = birthday;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getRegisterTime()
	{
		return registerTime;
	}

	public void setRegisterTime(Date registerTime)
	{
		this.registerTime = registerTime;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}
	
	/**
	 * 问题一:
	 * 	我们执行了 Test.java 类之后,就在 jpa 数据库下自动创建了一张名为 "jpa_person"的表,并且添加了一条数据,
	 *  但是我们发现 birthday 的时间是 "2017-09-23 21:00:38",而一般能够准确到出生日期 "2017-09-23",后面的时间 "21:00:38"就很少去算了
	 *  所以,我们要求只保存日期,不要时间
	 *  这时就可以使用 @Temporal 注解来控制时间
	 *  
	 *  而加了 @temporal 注解之后,数据表中新创建的Person数据的time字段值就是 "2017-09-23",只有日期,而没有时间,这正是我们所希望的!
	 */
	
}
