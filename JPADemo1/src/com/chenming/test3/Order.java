package com.chenming.test3;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 这是 Order 实体
 * 
 * 这是为了测试 主键生成策略是 "TABLE"
 * 
 * @author Lenovo
 *
 */
@Table(name="jpa_orders")
@Entity
public class Order
{
	private Integer id;  //订单id
	
	private String name;  //订单的名字,如: 衣服、鞋子、外套等
	
	private Date orderTime;  //下单时间
	
	private double price;  //订单价钱

	
	/* Setter And Getter */
	/**
	 * name属性表示该注解生成策略的名称,它被引用在 @GeneratedValue 中设置的generator值中
	 * table属性表示表生成策略所持久化的表名
	 * pkColumnName属性值表示在持久化表中,该主键生成策略所对应键值的名称
	 * pkColumnValue属性值表示在持久化表中,该生成策略所对应的主键
	 * valueColumnName属性值表示在持久化表中,该主键当前所生成的值,它的值将会随着每次创建累加
	 * allocationSize属性值表示每次主键值增加的大小,默认值是50 
	 */
	@TableGenerator(name="ID_GENERATOR",table="jpa_id_generators",
					pkColumnName="pk_name",
					pkColumnValue="order_id",
					valueColumnName="pk_value",
					allocationSize=2)
	@GeneratedValue(strategy=GenerationType.TABLE,generator="ID_GENERATOR")   //主键是生成策略是 "TABLE"
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

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="order_time")
	public Date getOrderTime()
	{
		return orderTime;
	}

	public void setOrderTime(Date orderTime)
	{
		this.orderTime = orderTime;
	}

	public double getPrice()
	{
		return price;
	}

	public void setPrice(double price)
	{
		this.price = price;
	}
	
	

}
