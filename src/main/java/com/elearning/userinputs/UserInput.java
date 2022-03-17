package com.elearning.userinputs;
import com.elearning.validation.*;
import java.util.*;
public class UserInput {
	
	Scanner sc = new Scanner(System.in);
	Validation v = new Validation();
	
	public String getName() {
		System.out.println("Enter Your FullName"); 
		String fullname = sc.nextLine();
		String validName = v.checkname(fullname);
		return validName;
		
	}
	
	public String getPhone() {
		System.out.println("Enter Your Phone");
		String phone = sc.nextLine(); 
		String validPhone= v.checkphone(phone);
		return validPhone;
	}
	
	public String getEmail() {
		System.out.println("Enter Your Email");
		String email =sc.nextLine();
		String validEmail=v.checkemail(email);
		return validEmail;
		
	}
	
	public String getPassword() {
		System.out.println("Enter Password");
		String password = sc.nextLine();
		String validPass = v.checkPassword(password); 
		return validPass;
	}


}
