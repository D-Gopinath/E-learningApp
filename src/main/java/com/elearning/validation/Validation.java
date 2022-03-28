package com.elearning.validation;
import java.sql.ResultSet;
import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.elearning.courses.Courses;
interface Validate{
	String checkname(String name);
	String checkphone(String phone);
	String checkemail(String email);
	String checkPassword(String password);
}
public class Validation implements Validate { 
	
	Scanner sc = new Scanner(System.in); 
	private static Logger log = LogManager.getLogger(Validation.class);
	
	public String checkname(String name) {
		while(name.isBlank() || name.isEmpty()) {
			log.warn("Invalid name");
			log.info("Enter Valid Name");
			name=sc.nextLine();
		}
		return name;
	}
	
	public String checkphone(String phone) {
		while(phone.length()>10 || phone.length()<10) {
			log.warn("Invalid Number");
			log.info("Enter Valid Number");
			phone=sc.nextLine();
		}
		for(int i=0;i<phone.length();i++) {
				char ch=phone.charAt(i);
				if(!Character.isDigit(ch)) {
					log.error("Invalid number!!! Only numbers are allowed");
					log.info("Enter mobile number:");
					phone=sc.nextLine();
					checkphone(phone);
				break;
				}
		}
		return phone;
	}
	
	public String checkemail(String email) { 
		while((!email.contains("@")) || (!email.endsWith(".com"))) {
			log.warn("Invalid Email");
			log.info("Enter Valid Email");
			email=sc.nextLine();
		}
		return email;
	} 
	
	public String checkPassword(String password) { 
		while(password.length()<8 || password.length()>16) {
			log.warn("Password Must contain 8-16 Characters");
			log.info("Enter Valid Password");
			password=sc.nextLine();
		}
		return password;
		
	}

	public static int checkLogin(ResultSet check,String password) throws Exception {
		
		String email=null;
		String key=null;
		int uid=0;
		ResultSet data=check;
		log.info("checking");
		while(data.next()) {
			uid=data.getInt("Uid");
			email=data.getString("Email");
			key=data.getString("password");
			
		}
		if(email==null) {
			throw new Exception("You are not Registered Yet!!!");
		}
		else if(key.equals(password)) {
			log.info("Loging in...  \n Welcome Back!");
		}
		else {
			throw new Exception("Email /Password is incorrect");
		}
		return uid;
		
	}

	public static void adminCheck(ResultSet check,String email,String password) throws Exception {
		
		String mailId=null;
		String key=null;
		ResultSet data = check;
		while(data.next()) {
			mailId=data.getNString("Email");
			key=data.getString("password");
		}
		if(mailId.equals(email) && key.equals(password)) {
			log.info("Access Granted....");
		}
		else {
			log.error("Access Denied");
			throw new Exception("Invaild Email/Password");
		}
		
	}
}
