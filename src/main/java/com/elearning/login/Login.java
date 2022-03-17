package com.elearning.login;
import java.util.*;
import com.elearning.courses.*;
import com.elearning.dao.ElearningDAO;
import com.elearning.userinputs.UserInput;
import com.elearning.validation.Validation;

public class Login {
	
	UserInput ui = new UserInput();
	Scanner sc = new Scanner(System.in);
	Courses c = new Courses();
	public void login() throws Exception {
		
		String validEmail =ui.getEmail(); 
		String validpass =ui.getPassword(); 
		int  i = 0;
		try {
			Validation.checkLogin(ElearningDAO.LoginData(validEmail), validpass);
		}
		catch(Exception e) {
			System.err.println(e.getMessage());
			i=1;
		}
		//error may occur
		if(i==1) {
			login();
		}
		
		System.out.println("\n Select Options \n 1.View Courses \n 2.Search \n 3.Enrolled Courses \n 4.Exit");
		int option = sc.nextInt();
		if(option == 1) {
			c.displayAll();
		}
		else if(option == 2) {
			c.SearchCourse();
		}
		else if(option==3) {
			                                               //yet to write
		}
		else if(option==4) {
			System.out.println("Logging out...");
			System.exit(0);
		}
		else {
			System.out.println("Invalid option");
		}
	}

}
