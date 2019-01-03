package com.chenming.JPQL;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 部门表
 * @author Lenovo
 *
 */
@Table(name="department")
@Entity
public class Department
{
	private Integer id;
	private String name;
	
	private Set<Person> persons = new HashSet<Person>();

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

	@JoinColumn(name="department_id")
	@OneToMany
	public Set<Person> getPersons()
	{
		return persons;
	}

	public void setPersons(Set<Person> persons)
	{
		this.persons = persons;
	}

	@Override
	public String toString()
	{
		return "Department [id=" + id + ", name=" + name + ", persons=" + persons + "]";
	}		
			
	
}
