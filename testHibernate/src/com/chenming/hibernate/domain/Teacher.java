package com.chenming.hibernate.domain;

import java.util.Set;

public class Teacher {

	private Integer id;
	
	private Set<Student> stuSet;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Set<Student> getStuSet() {
		return stuSet;
	}

	public void setStuSet(Set<Student> stuSet) {
		this.stuSet = stuSet;
	}
	
}
