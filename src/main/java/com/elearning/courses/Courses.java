package com.elearning.courses;
import java.sql.ResultSet;
import java.util.*; 
import com.elearning.sqlDB.*;

public class Courses {
	
	Scanner sc = new Scanner(System.in);
	public void displayAll() throws Exception {
		
		try {
		String query ="select * from Course";
		ResultSet course = SQLDB.ConnectTable(query);
		System.out.println("\nID \t\t Name \t\t Tutor \t\t Duration");
		while(course.next()) {
			int id = course.getInt("ID");
			String name = course.getString("Name");
			String tutor = course.getString("Tutor");
			String duration = course.getString("Duration");
			
			System.out.format("%d \t\t %s \t\t %s \t\t %s \n",id,name,tutor,duration);
			}
		
		}
		catch(Exception e) {
			e.getMessage();
		}
	}

	public void SearchCourse() throws Exception {
		System.out.println("Enter Course to Search...");
		String cname = sc.nextLine();
		
		try {
			String query = "select * from Course WHERE name='"+cname+"'";
			ResultSet course = SQLDB.ConnectTable(query);
			System.out.println("\nName \t\t Tutor \t\t Duration");
			while(course.next()) {
				String name = course.getString("Name");
				String tutor = course.getString("Tutor");
				String duration = course.getString("Duration");
				
				System.out.format("%s \t\t %s \t\t %s %s \n",name,tutor,duration);
				}
		}
		catch(Exception e) {
			e.getMessage();
		}
		
	}

	
}
