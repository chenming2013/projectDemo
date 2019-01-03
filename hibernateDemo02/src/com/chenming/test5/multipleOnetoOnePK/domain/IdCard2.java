package com.chenming.test5.multipleOnetoOnePK.domain;

public class IdCard2
{
	private int id;
	
	private String cardNo;

	private Person2 person2;
	
	// ============ Setter And Getter(Start) =============
	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getCardNo()
	{
		return cardNo;
	}

	public void setCardNo(String cardNo)
	{
		this.cardNo = cardNo;
	}

	public Person2 getPerson2()
	{
		return person2;
	}

	public void setPerson2(Person2 person2)
	{
		this.person2 = person2;
	}
	
	// ============= Setter And Getter(End) =============
}
