package com.chenming.test1;

import java.beans.Transient;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 这是 持久化 类
 * @author Lenovo
 *
 */

@Table(name="jpa_customers")   //
@Entity   //使用 @Entity 注解表明这是一个 持久化 类
public class Customer
{
	
	@Column(name="ID")    //如果列名和属性名样, @Column 注解可以省略
	@GeneratedValue(strategy=GenerationType.AUTO)   //主键生成策略,之后不用再为id赋值了
	@Id   //主键
	private Integer id;
	
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	
	private String email;
	
	
	private int age;
	
	
	/* Setter And Getter */
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getLastName()
	{
		return lastName;
	}
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
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
	
	@Override
	public String toString()
	{
		return "Customer [id=" + id + ", lastName=" + lastName + ", email=" + email + ", age=" + age + "]";
	}
	
	/* ==================== BEGIN ================== */
	//测试 @Transient 注解
	public String method1()
	{
		return "hello";
	}
	@Transient
	public String getInfo()
	{
		return "email: "+email;
	}
	/**
	 * 这本来是想测试 @Entity 注解标注的类不能随便添加get方法
	 * 如果一定要添加get方法,该方法上要用 @Transient 注解标注
	 * 
	 * 但是不知为何,getInfo()方法上不论有没有 @Transient 注解标注,都能正常的创建数据表,
	 * 而不是像我们希望的那样：没有 @Transient 注解标注的get方法会报错
	 */
	/* ==================== END ==================== */
	
}
