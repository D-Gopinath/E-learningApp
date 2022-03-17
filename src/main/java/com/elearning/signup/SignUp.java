package com.elearning.signup;
import com.elearning.courses.*;
import java.util.*;
import com.elearning.dao.ElearningDAO;
import com.elearning.login.Login;
import com.elearning.registration.Registration;
import com.elearning.userinputs.UserInput;

public class SignUp { 
	
	ElearningDAO dao = new ElearningDAO();
	Scanner sc = new Scanner(System.in);
	Courses c = new Courses();
	Login l = new Login();
	
	public void signup() throws Exception {
		UserInput u =new UserInput();
		
		String name = u.getName();
		
		String phone = u.getPhone();
		
		String email = u.getEmail();
		
		String password =u.getPassword();
		
		Registration register = new Registration(name,phone,email,password);
		
		try {
			dao.Adduser(register);
			System.out.println("\n You are joined as New User \n\n Login To Expolre and Learn!!!");
			}
		catch(Exception e) {
				System.err.println("\n You are Existing USER!!!  \n Please Login!"); 
			}
		finally {
			l.login();
		}
		
		
		
		
		
	}

}
