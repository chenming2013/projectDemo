package com.chenming.testMapping.oneToManyOfTwoway;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name="jpa_orders3")
@Entity
public class Order3
{
	private Integer id;
	private String orderName;
	
	private Customer3 customer;
	
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
	
	/**
	 * 映射双向多对一关联关系
	 * 使用 @ManyToOne 来映射n-1的关联关系
	 * 使用 @JoinColumn 来映射外键列的名称
	 * @return
	 */
	@JoinColumn(name="customer3_id")
	@ManyToOne(fetch=FetchType.LAZY)
	public Customer3 getCustomer()
	{
		return customer;
	}
	public void setCustomer(Customer3 customer)
	{
		this.customer = customer;
	}
	
}
