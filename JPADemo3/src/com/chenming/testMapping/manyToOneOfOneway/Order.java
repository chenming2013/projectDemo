package com.chenming.testMapping.manyToOneOfOneway;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name="jpa_orders2")
@Entity
public class Order
{
	private Integer id;
	private String orderName;
	private Customer customer;
	
	
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
	@Column(name="order_name")
	public String getOrderName()
	{
		return orderName;
	}
	public void setOrderName(String orderName)
	{
		this.orderName = orderName;
	}
	
	//映射单向n-1的关联关系
	//使用 @ManyToOne 来映射多对一的关联关系
	//使用 @JoinColumn 来映射外键
	@JoinColumn(name="customer2_id")
	@ManyToOne(fetch=FetchType.LAZY)    //许多的Order对应一个Customer
	public Customer getCustomer()
	{
		return customer;
	}
	public void setCustomer(Customer customer)
	{
		this.customer = customer;
	}
	
}
