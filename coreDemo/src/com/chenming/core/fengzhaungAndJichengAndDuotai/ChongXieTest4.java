package com.chenming.core.fengzhaungAndJichengAndDuotai;

import java.io.IOException;

public class ChongXieTest4
{
	public static void main(String[] args)
	{
		
	}
}

class RangeTestA
{
	public void test1() throws IOException,ClassNotFoundException
	{
		
	}
}
class RangeTestB extends RangeTestA
{

	//��дtest1()����
	@Override
	public void test1() throws IOException, ClassNotFoundException,ClassCastException  //�����ClassCastException��RunTimeException,���Կ����׳�
	{

	}
	
}
