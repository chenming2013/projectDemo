package com.chenming.dao.impl;

import java.sql.PreparedStatement;

import com.chenming.dao.IMemberDao;
import com.chenming.entity.Member;
import com.sun.corba.se.pept.transport.Connection;

public class MemberDaoImpl implements IMemberDao
{

	private Connection connection;
	private PreparedStatement preparedStatement;
	
	public MemberDaoImpl(Connection connection)
	{
		this.connection = connection;
	}
	
	@Override
	public Member findById(String id) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean doCreate(Member member) throws Exception
	{
		// TODO Auto-generated method stub
		return false;
	}

}
