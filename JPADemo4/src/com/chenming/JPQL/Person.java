package com.chenming.JPQL;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 专门为了测试EntityManager的实体
 * @author Lenovo
 *
 */
@Table(name="jpa_person")
@Entity
public class Person
{
	private Integer id;
	private String name;
	private Date birthday;
	private int age;
	
	private Department department;
	
	
	/* Constructor */
	public Person() {};
	public Person(String name,int age) 
	{
		this.name = name;
		this.age = age;
	}
	
	
	/* Setter And Getter */
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
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
	public int getAge()
	{
		return age;
	}
	public void setAge(int age)
	{
		this.age = age;
	}
	
	@JoinColumn(name="department_id")
	@ManyToOne
	public Department getDepartment()
	{
		return department;
	}
	public void setDepartment(Department department)
	{
		this.department = department;
	}
	
	@Override
	public String toString()
	{
		return "Person [id=" + id + ", name=" + name + ", birthday=" + birthday + ", age=" + age + "]";
	}
	
	
}
