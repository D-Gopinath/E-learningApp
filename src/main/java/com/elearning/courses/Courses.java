package com.elearning.courses;
import java.sql.ResultSet;
import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.elearning.dao.*;
import com.elearning.users.Login;

public class Courses {
	
	ElearningDAO dao= new ElearningDAO();
	
	static Scanner sc = new Scanner(System.in);
	int b=0;
	
	private static Logger log = LogManager.getLogger(Courses.class);
	
	public void displayAll(int uid) throws Exception {
		
		try {
		String query ="select C_ID,C_NAME,Tutor,Duration from Course";
		ResultSet course = SQLDB.ConnectTable(query);
		System.out.println("\nID \t\t Name \t\t Tutor \t\t Duration");
		while(course.next()) {
			int id = course.getInt("C_ID");
			String name = course.getString("C_NAME");
			String tutor = course.getString("Tutor");
			String duration = course.getString("Duration");
			
			System.out.format("%d \t\t %s \t\t %s \t\t %s \n",id,name,tutor,duration);
			}
		
		}
		catch(Exception e) {
			log.error(e.getMessage());
		}
		log.info("Want To Enroll a Course?  Y/N ");
		char o = sc.next().charAt(0);
		b=ElearningDAO.enrollCourse(o,uid);
		
	}

	 //there is glitch here
	public void searchCourse(int uid) throws Exception {               
		log.info("Enter Course to Search...");
		String cname = sc.next();
		try {                                                                            
			String query = "select C_ID,C_NAME,Tutor,Duration from Course WHERE C_NAME ='"+cname+"' ";
			ResultSet course = SQLDB.ConnectTable(query);
			System.out.println("\nID \t\t Name \t\t Tutor \t\t Duration");
			if(course.next()) {
				int id = course.getInt("C_ID");
				String name = course.getString("C_NAME");
				String tutor = course.getString("Tutor");
				String duration = course.getString("Duration");
				
				System.out.format("%d \t\t %s \t\t %s \t\t %s \n",id,name,tutor,duration);
				}
			else {
				log.error("Course Not found");
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());      //try it in sysout
		}
		log.info("Want To Enroll a Course?  Y/N ");
		char o = sc.next().charAt(0);
		b=ElearningDAO.enrollCourse(o,uid);
		
	}


	public void enrolledCourse(int uid) {
		try {
			String query="select Course_Enrolled,C_Tutor,C_Duration,URL from Users_Details where Uid='"+uid+"' ";
			ResultSet ec = SQLDB.ConnectTable(query);
			System.out.println("\n Name \t\t Tutor \t\t Duration \t\t URL");
			while(ec.next()) {
				String name = ec.getString("Course_Enrolled");
				String tutor = ec.getString("C_Tutor");
				String duration = ec.getString("C_Duration");
				String url = ec.getString("URL");
				
				System.out.format("%s \t\t %s \t %s \t\t %s \n",name,tutor,duration,url);
				}
			
		}
		catch(Exception e) {
			log.error(e.getMessage());
		}
		
		
		
	}
}
