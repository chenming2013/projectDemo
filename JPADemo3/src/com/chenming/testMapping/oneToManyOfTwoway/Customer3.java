package com.chenming.testMapping.oneToManyOfTwoway;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="jpa_customers3")
public class Customer3
{
	private Integer id;
	private String name;
	private Date birthday;
	private String email;
	private int age;
	
	private Set<Order3> orders = new HashSet<Order3>();
	
	/* Setter And Getter */
	@GeneratedValue
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
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
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
	 * 映射双向一对多的关联关系
	 * 使用 @OneToMany 来映射1-n的关联关系
	 * 使用 @JoinColumn 来映射外键列的名称
	 * @return
	 */
	@JoinColumn(name="customer3_id")
	@OneToMany(fetch=FetchType.LAZY)    //一个Customer对应多个Order
	public Set<Order3> getOrders()
	{
		return orders;
	}
	public void setOrders(Set<Order3> orders)
	{
		this.orders = orders;
	}
	
}
