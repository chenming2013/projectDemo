package com.chenming.test5.multipleOnetoOneFK.domain;


public class IdCard4
{
	private int id;
	
	private String cardNo;
	
	private Person4 person4;

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

	public Person4 getPerson4()
	{
		return person4;
	}

	public void setPerson4(Person4 person4)
	{
		this.person4 = person4;
	}
	
}
