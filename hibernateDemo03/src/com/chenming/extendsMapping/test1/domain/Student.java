package com.chenming.extendsMapping.test1.domain;

public class Student extends People
{
	// 学生独有的属性
	private String cardId;

	
	// =========== Setter And Getter(Start) ==========
	public String getCardId()
	{
		return cardId;
	}

	public void setCardId(String cardId)
	{
		this.cardId = cardId;
	}
	// =========== Setter And Getter(End) ============
	
}
