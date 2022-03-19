package com.elearning.dao;
import java.util.*;
import java.sql.ResultSet;

import com.elearning.courseData.CourseData;
import com.elearning.registration.*;
import com.elearning.sqlDB.*;

public class ElearningDAO {
	static Scanner sc= new Scanner(System.in);
	
	public void Adduser(Registration add) throws Exception {
		
		String query = "insert into Users_Details(name,phone,email,password) values('"+add.name+"','"+add.phone+"','"+add.email+"','"+add.password+"')";
		SQLDB.sqlConnect(query);
	}
	
	public static  ResultSet LoginData(String email) throws Exception{
		String query="SELECT Uid,Email,password FROM Users_Details WHERE Email='"+email+"'";
		ResultSet check=SQLDB.ConnectTable(query);
		return check;	
	}
	
	public static ResultSet AdminLogin() throws Exception {
		String query = "select Email,Password from Users_Details WHERE Role ='Admin'";
		ResultSet check =SQLDB.ConnectTable(query);
		return check;
		
	}

	public void addCourse(CourseData insert)throws Exception {
		
		String query = "insert into Course(C_Name,Tutor,Duration,URL) values('"+insert.cName+"','"+insert.cTutor+"','"+insert.cDuration+"','"+insert.cURL+"')";
		SQLDB.sqlConnect(query);
		System.out.println("New Course "+insert.cName+" is Added...");
	}

	public void removeCourse(String name) throws Exception{
		
		String query = "delete from Course where C_Name='"+name+"' ";
		SQLDB.sqlConnect(query);
		System.out.println(name+" is deleted");
	}
	//Return the course id to the enrolledCourse method
	public static int enrollCourse(char o,int uid) {
		int i=0;
		if(o=='Y' || o=='y') {
			try {
				System.out.println("Enter Course id to Enroll...");
				i=sc.nextInt();
				String q="select * from Course where C_id='"+i+"'";
				ResultSet c = SQLDB.ConnectTable(q);
				String cname=null;
				String ctutor=null;
				String cduration=null;
				String url=null;
				while(c.next()) {
					cname=c.getString("C_NAME");
					ctutor=c.getString("Tutor");
					cduration=c.getString("Duration");
					url=c.getString("URL");
				}
				String query ="update Users_Details set Course_Enrolled='"+cname+"',C_id='"+i+"',C_Tutor='"+ctutor+"',C_Duration='"+cduration+"',URL='"+url+"' where Uid='"+uid+"' ";
				SQLDB.sqlConnect(query);
				System.out.println(cname+" Successfully Enrolled!!!");
			}
			catch(Exception e){
				  System.out.println(e.getMessage());  
			}
		}
		else if(o=='N' || o=='n') {
			
		}
		else {
			System.out.println("Invalid Option");
		}
		return i;
	}
}


