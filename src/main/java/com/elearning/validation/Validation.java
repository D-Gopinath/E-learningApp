package com.elearning.validation;
import java.sql.ResultSet;
import java.util.*;
interface Validate{
	String checkname(String name);
	String checkphone(String phone);
	String checkemail(String email);
	String checkPassword(String password);
}
public class Validation implements Validate { 
	
	Scanner sc = new Scanner(System.in); 
	
	public String checkname(String name) {
		while(name.isBlank() || name.isEmpty()) {
			System.err.println("Invalid name");
			System.out.println("Enter Valid Name");
			name=sc.nextLine();
		}
		return name;
	}
	
	public String checkphone(String phone) {
		while(phone.length()>10 || phone.length()<10) {
			System.err.println("Invalid Number");
			System.out.println("Enter Valid Number");
			phone=sc.nextLine();
		}
		for(int i=0;i<phone.length();i++) {
				char ch=phone.charAt(i);
				if(!Character.isDigit(ch)) {
					System.err.println("Invalid number!!! Only numbers are allowed");
					System.out.println("Enter mobile number:");
					phone=sc.nextLine();
					checkphone(phone);
				break;
				}
		}
		return phone;
	}
	
	public String checkemail(String email) { 
		while((!email.contains("@")) || (!email.endsWith(".com"))) {
			System.err.println("Invalid Email");
			System.out.println("Enter Valid Email");
			email=sc.nextLine();
		}
		return email;
	} 
	
	public String checkPassword(String password) { 
		while(password.length()<8 || password.length()>16) {
			System.err.println("Password Must contain 8-16 Characters");
			System.out.println("Enter Valid Password");
			password=sc.nextLine();
		}
		return password;
		
	}

	public static void checkLogin(ResultSet check,String password) throws Exception {
		
		String email=null;
		String key=null;
		ResultSet data=check;
		System.out.println("checking");
		while(data.next()) {
			email=data.getString("Email");
			key=data.getString("password");
		}
		if(email==null) {
			throw new Exception("You are not Registered Yet!!!");
		}
		else if(key.equals(password)) {
			System.out.println("Loging in...  \n Welcome Back!");
		}
		else {
			throw new Exception("Email /Password is incorrect");
		}
		
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
			System.out.println("Access Granted....");
		}
		else {
			throw new Exception("Invaild Email/Password");
		}
		
	}
}
