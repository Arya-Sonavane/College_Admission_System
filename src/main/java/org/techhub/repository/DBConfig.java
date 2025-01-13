package org.techhub.repository;

import java.sql.*;
import java.util.Properties;
import java.io.*;

public class DBConfig {

	protected static Connection conn;
	protected static PreparedStatement stmt;
	protected static ResultSet rs;
	protected static CallableStatement csmt;
	private static DBConfig db = null;
	

	protected DBConfig() {
		try {
			File f = new File("");
			String path = f.getAbsolutePath();
			FileInputStream inputStream = new FileInputStream(path + "\\src\\main\\resources\\dbconfig.properties");
			Properties p = new Properties();
			p.load(inputStream);
			String driverClassName = p.getProperty("driver");
			String username = p.getProperty("username");
			String password = p.getProperty("password"); 
			String url = p.getProperty("url");
			Class.forName(driverClassName);
			System.out.println(driverClassName+"\t"+username+"\t"+password+"\t"+url);
		
			
			 //get actual connection
			 conn = DriverManager.getConnection(url, username, password);

		} catch (Exception ex) {
			System.out.println("error is" + ex);
		}
	}

	public static DBConfig getInstance() 
	{
		
		if (db == null) {
			db = new DBConfig();
			System.out.println("I am DB Config");
		}
		return db;
	}

	public static Connection getConn() {
		return conn;
	}

	public static PreparedStatement getStatement() {
		return stmt;
	}
	public static ResultSet getResult()
	{
		return rs;
	}
	public static CallableStatement getCallStatement()
	{
		return csmt;
    }
}
