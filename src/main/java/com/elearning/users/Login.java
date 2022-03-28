package com.elearning.users;
import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.elearning.courses.*;
import com.elearning.dao.ElearningDAO;
import com.elearning.validation.Validation;

public class Login {
	
	UserInput ui = new UserInput();
	Scanner sc = new Scanner(System.in);
	Courses c = new Courses();
	
	private static Logger log = LogManager.getLogger(Login.class);
	
	public void login() throws Exception {
		
		String validEmail =ui.getEmail(); 
		String validpass =ui.getPassword(); 
		int  i = 0;
		int uid=0;
		try {
			uid=Validation.checkLogin(ElearningDAO.LoginData(validEmail), validpass);
			log.info("Your User ID is : "+uid);
		}
		catch(Exception e) {
			log.error(e.getMessage());
			i=1;
		}
		//error may occur
		if(i==1) {
			login();
		}
		
		int j=0;
		do {
		log.info("\n Select Options \n 1.View Courses \n 2.Search \n 3.Enrolled Courses \n 4.Exit");
		int option = sc.nextInt();
		if(option == 1) {
			c.displayAll(uid);
		}
		else if(option == 2) {
			c.searchCourse(uid);
		}
		else if(option==3) {
			
			c.enrolledCourse(uid);
			                                               
		}
		else if(option==4) {
			j=1;
			log.info("Logging out...");
			System.exit(0);
		}
		else {
			log.error("Invalid option");
		}
		}while(j!=1);
	}

}
