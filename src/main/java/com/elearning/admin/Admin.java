package com.elearning.admin;
import com.elearning.users.*;
import com.elearning.validation.Validation;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.elearning.courses.Courses;
import com.elearning.dao.*;

public class Admin{
	
	private static Logger log = LogManager.getLogger(Admin.class);
	
	UserInput ui = new UserInput();
	Courses c = new Courses();
	Scanner sc = new Scanner(System.in);
	public void adminIn() throws Exception {
		
		String validEmail=ui.getEmail();
		String validPass =ui.getPassword();
		int i =0;
		
		try {
			Validation.adminCheck(ElearningDAO.AdminLogin(),validEmail, validPass);
		}
		catch(Exception e) {
			log.error(e.getMessage());
		    i=1;
		}
		if(i==1) {
			adminIn();
		}
		
		AdminAccess aa = new AdminAccess();
		aa.adminActions();
		
		
	}
	
}
