package com.chenming.selfMapping.test1.domain;

import java.io.Serializable;
import java.util.Set;

/**
 * 这是一个地区类,用来测试自身一对多关联映射
 * @author 陈明
 * @date   2018年7月15日
 */
public class Region implements Serializable
{
	private Integer id;
	
	private String name;
	
	// 一个地区只属于一个上一级地区(就像一个省份只属于一个国家)
	private Region parentRegion;
	
	// 一个地区包含许多下一级地区(就像一个省份有许多城市)
	private Set<Region> childRegions;

	
	// ============ Setter And Getter(Start) =============
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

	public Region getParentRegion()
	{
		return parentRegion;
	}

	public void setParentRegion(Region parentRegion)
	{
		this.parentRegion = parentRegion;
	}

	public Set<Region> getChildRegions()
	{
		return childRegions;
	}

	public void setChildRegions(Set<Region> childRegions)
	{
		this.childRegions = childRegions;
	}
	// ============= Setter And Getter(End) ===============
}
