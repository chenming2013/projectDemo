package com.chenming.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection
{
	private static final String DBDRIVER = "com.mysql.jdbc.Driver";
	private static final String DBURL = "jdbc:mysql:/localhost:3306/ajax";
	private static final String USER = "root";
	private static final String PASSWORD = "chenming";
	
	private Connection connenction;
	
	private DataBaseConnection()
	{
		try {
			Class.forName(DBDRIVER);
			this.connenction = DriverManager.getConnection(DBURL, USER, PASSWORD);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
