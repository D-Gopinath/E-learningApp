package com.elearning.admin;

import java.sql.ResultSet;
import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.elearning.model.*;
import com.elearning.courses.Courses;
import com.elearning.dao.*;
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
	private static Logger log = LogManager.getLogger(AdminAccess.class);
	public void adminActions() throws Exception {
		
		try {
		
		int i=0;
		do {
		log.info("\nSelect any Action \n 1.Display Users \n 2.Display Course \n 3.Add New Course \n 4.Delete Course \n 5.Display User's Course \n 6.Exit");
		int action = sc.nextInt();
		if(action==1) {
			UsersList();
		}
<<<<<<< HEAD
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
			UsersCourse();
		}
		else if(action==6) {
			i=1;
			System.exit(0);
=======
		else if(action==2){
			c.displayAll();
		}
		else if(action==3){
			insertCourse();
		}
		else if(action==4){
			deleteCourse();
		}
		else if(action==5){
			i=1;
			System.exit(0);
		}
		else{
			System.err.println("Enter valid Option!!!");
>>>>>>> e844386c405e30739ebbf800f6a4d94e78b58165
		}
		else {
			log.warn("Enter valid Option!!!");
		}
		}while(i!=1);
		}
		catch(Exception e) {
			log.error(e.getMessage());
		}
	}
	
	public static void insertCourse()throws Exception{
		
		log.info("Enter Course Name");
		String name = sc.next();
		cd.setName(name);
		
		log.info("Enter Course Tutor");
		String tutor=sc.next();
		cd.setTutor(tutor);
		
		log.info("Enter Course Duration");
		String duration=sc.next();
		cd.setDuration(duration);
		
		log.info("Enter Course URL");
		String url = sc.next();
		cd.setURL(url);
		
		CourseData data = new CourseData(cd.getName(),cd.getTutor(),cd.getDuration(),cd.getURL());
		try {
		dao.addCourse(data);
		}
		catch(Exception e) {
			log.error("Course Already Exist!!!");
		}
		
	}
	
	public static void deleteCourse() throws Exception{
		log.info("Enter Course Name To Delete");
		String delete=sc.next();
		cd.setName(delete);
		dao.removeCourse(cd.getName());
	}
	
	public static void UsersList() {
		try {
			String query = "select Uid,Name,Phone,Email from Users_Details";
			ResultSet user = SQLDB.ConnectTable(query);
			
			System.out.println("\nUser_id\tName\t\tPhone\t\tEmail");
			
			while(user.next()) {
				int id = user.getInt("Uid");
				String name = user.getString("Name");
				String phone = user.getString("Phone");
				String email = user.getString("Email");
				
				System.out.format("%d\t %s\t\t%s\t\t %s \n",id,name,phone,email);
				}
		}
		catch(Exception e) {
			log.error(e.getMessage());
		}
	}
	public static void UsersCourse(){
		
		try {
			String query = "select Users_Details.name,Course.C_Name from Users_Details inner join Course on Users_Details.C_id=Course.C_id ";
			ResultSet user = SQLDB.ConnectTable(query);
			
			System.out.println("\nName\t\tCourse");
			
			while(user.next()) {
				
				String name = user.getString("Name");
				String course = user.getString("C_Name");
				
				
				System.out.format(" %s\t\t%s\n",name,course);
				}
		}
		catch(Exception e) {
			log.error(e.getMessage());
		}
		
	}

}
