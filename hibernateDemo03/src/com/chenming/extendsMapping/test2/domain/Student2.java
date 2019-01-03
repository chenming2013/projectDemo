package com.chenming.extendsMapping.test2.domain;

public class Student2 extends People2
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
