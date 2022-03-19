package com.elearning.admin;

import java.sql.ResultSet;
import java.util.*;

import com.elearning.courseData.CourseData;
import com.elearning.courses.Courses;
import com.elearning.dao.ElearningDAO;
import com.elearning.sqlDB.SQLDB;
class CourseDetails{           //Encapsulation is Used here...
	
	private String name;
	private String tutor;
	private String duration;
	private String url;
	
	//Setter Method to set the values to Private variable
	public void setName(String name){ 
		this.name = name;
		}
	public void setTutor(String tutor){ 
		this.tutor = tutor;
		}
	public void setDuration(String duration){ 
		this.duration = duration;
		}
	public void setURL(String url){ 
		this.url = url;
		}

	//Getter method to get the value
	public String getName(){
		return name;
		}
	public String getTutor(){
		return tutor;
		}
	public String getDuration(){
		return duration;
		}
	public String getURL(){
		return url;
		}
	
}
public class AdminAccess {
	static ElearningDAO dao = new ElearningDAO();
	Courses c = new Courses();
	static Scanner sc = new Scanner(System.in);
	static CourseDetails cd = new CourseDetails();
	public void adminActions() throws Exception {
		
		int i=0;
		do {
		System.out.println("\nSelect any Action \n 1.Display Users \n 2.Display Course \n 3.Add New Course \n 4.Delete Course \n 5.Exit");
		int action = sc.nextInt();
		if(action==1) {
			UsersList();
		}
		else if(action==2) {
			c.displayAll(1);
		}
		else  if(action== 3) {
			insertCourse();
		}
		else if(action==4) {
			deleteCourse();
		}
		else if(action==5) {
			i=1;
			System.exit(0);
		}
		else {
			System.err.println("Enter valid Option!!!");
		}
		}while(i!=1);
	}
	
	public static void insertCourse()throws Exception{
		
		System.out.println("Enter Course Name");
		String name = sc.next();
		cd.setName(name);
		
		System.out.println("Enter Course Tutor");
		String tutor=sc.next();
		cd.setTutor(tutor);
		
		System.out.println("Enter Course Duration");
		String duration=sc.next();
		cd.setDuration(duration);
		
		System.out.println("Enter Course URL");
		String url = sc.next();
		cd.setURL(url);
		
		CourseData data = new CourseData(cd.getName(),cd.getTutor(),cd.getDuration(),cd.getURL());
		
		dao.addCourse(data);
		
	}
	
	public static void deleteCourse() throws Exception{
		System.out.println("Enter Course Name To Delete");
		String delete=sc.next();
		cd.setName(delete);
		dao.removeCourse(cd.getName());
	}
	
	public static void UsersList() {
		try {
			String query = "select User_id,Name,Phone,Email from Users_Details";
			ResultSet user = SQLDB.ConnectTable(query);
			
			System.out.println("\nUser_id\tName\t\tPhone\t\tEmail");
			
			while(user.next()) {
				int id = user.getInt("User_id");
				String name = user.getString("Name");
				String phone = user.getString("Phone");
				String email = user.getString("Email");
				
				System.out.format("%d\t %s\t\t%s\t\t %s \n",id,name,phone,email);
				}
		}
		catch(Exception e) {
			e.getMessage();
		}
	}

}
