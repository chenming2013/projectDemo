package com.chenming.testMapping.oneToManyOfOneway;

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
public class Order2
{
	private Integer id;
	private String orderName;
	
	
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
	
}
