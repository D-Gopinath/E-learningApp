package com.elearning.dao;
import java.sql.ResultSet;

import com.elearning.courseData.CourseData;
import com.elearning.registration.*;
import com.elearning.sqlDB.*;

public class ElearningDAO {
	
	public void Adduser(Registration add) throws Exception {
		
		String query = "insert into User_Registration(name,phone,email,password) values('"+add.name+"','"+add.phone+"','"+add.email+"','"+add.password+"')";
		SQLDB.sqlConnect(query);
	}
	
	public static  ResultSet LoginData(String email) throws Exception{
		String query="SELECT Email,password FROM User_Registration WHERE Email='"+email+"'";
		ResultSet check=SQLDB.ConnectTable(query);
		return check;	
	}
	
	public static ResultSet AdminLogin() throws Exception {
		String query = "select Email,Password from User_Registration WHERE Role ='Admin'";
		ResultSet check =SQLDB.ConnectTable(query);
		return check;
		
	}

	public void addCourse(CourseData insert)throws Exception {
		
		String query = "insert into Course(Name,Tutor,Duration,URL) values('"+insert.cName+"','"+insert.cTutor+"','"+insert.cDuration+"','"+insert.cURL+"')";
		SQLDB.sqlConnect(query);
		System.out.println("New Course"+insert.cName+"is Added...");
	}
	public void removeCourse(String name) throws Exception{
		
		String query = "delete from Course where Name='"+name+"' ";
		SQLDB.sqlConnect(query);
		System.out.println(name+"is deleted");
	}
}
