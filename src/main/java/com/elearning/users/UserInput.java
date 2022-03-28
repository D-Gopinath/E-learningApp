package com.elearning.users;
import com.elearning.courses.Courses;
import com.elearning.validation.*;
import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class UserInput {
	
	Scanner sc = new Scanner(System.in);
	Validation v = new Validation();
	
	private static Logger log = LogManager.getLogger(UserInput.class);
	
	public String getName() {
		log.info("Enter Your FullName"); 
		String fullname = sc.nextLine();
		String validName = v.checkname(fullname);
		return validName;
		
	}
	
	public String getPhone() {
		log.info("Enter Your Phone");
		String phone = sc.nextLine(); 
		String validPhone= v.checkphone(phone);
		return validPhone;
	}
	
	public String getEmail() {
		log.info("Enter Your Email");
		String email =sc.nextLine();
		String validEmail=v.checkemail(email);
		return validEmail;
		
	}
	
	public String getPassword() {
		log.info("Enter Password");
		String password = sc.nextLine();
		String validPass = v.checkPassword(password); 
		return validPass;
	}


}
