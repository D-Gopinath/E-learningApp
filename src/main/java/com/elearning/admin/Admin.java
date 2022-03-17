package com.elearning.admin;
import com.elearning.userinputs.*;
import com.elearning.validation.Validation;
import java.util.Scanner;
import com.elearning.courses.Courses;
import com.elearning.dao.*;

public class Admin{
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
			System.err.println(e.getMessage());
		    i=1;
		}
		if(i==1) {
			adminIn();
		}
		
		AdminAccess aa = new AdminAccess();
		aa.adminActions();
		
		
	}
	
}
