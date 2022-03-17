package com.elearning.sqlDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLDB {
	
	public static Connection DBconnect() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://101.53.133.59:3306/revature_training_db","rev_user","rev_user");
		System.out.println(connection);
		return connection;
	}

	public static void sqlConnect(String query) throws Exception {
		Connection connect=DBconnect();
		Statement run=connect.createStatement();
		run.executeUpdate(query);
		run.close();
		connect.close();
	} 
	
	public static ResultSet ConnectTable(String query) throws Exception{
		Connection connect=DBconnect();
		Statement run=connect.createStatement();
		ResultSet get=run.executeQuery(query);
		return get;
	}
}
