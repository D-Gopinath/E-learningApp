package com.elearning.users;

//import com.eLearning.Elearning;
import com.elearning.courses.*;
import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.elearning.dao.ElearningDAO;
import com.elearning.model.*;

public class SignUp { 
	
	ElearningDAO dao = new ElearningDAO();
	Scanner sc = new Scanner(System.in);
	Courses c = new Courses();
	Login l = new Login();
	
	private static Logger log = LogManager.getLogger(SignUp.class);
	
	public void signup() throws Exception {
		UserInput u =new UserInput();
		
		String name = u.getName();
		
		String phone = u.getPhone();
		
		String email = u.getEmail();
		
		String password =u.getPassword();
		
		Registration register = new Registration(name,phone,email,password);
		
		try {
			dao.addUser(register);
			log.info("\n You are joined as New User \n\n Login To Expolre and Learn!!!");
			}
		catch(Exception e) {
				log.error("\n You are Existing USER!!!  \n Please Login!"); 
			}
		finally {
			l.login();
		}
		
		
		
		
		
	}

}
