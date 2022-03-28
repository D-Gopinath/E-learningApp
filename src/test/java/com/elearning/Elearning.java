package com.elearning;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.elearning.admin.*;
import com.elearning.users.*;
public class Elearning {
	
	private static Logger log = LogManager.getLogger(Elearning.class);

	public static void main(String[] args) throws Exception {		
		Scanner sc = new Scanner(System.in);
		
		SignUp su = new SignUp();
		Login l = new Login();
		Admin a = new Admin();
		
		
		int i=0;
		do {
			log.info("Welcome To E-Learning App \n");
			log.info("1.New User?...SignUp and Start Learning!!!");
			log.info("2.Existing User?...Login now");
			log.info("3.Admin only... ");
			log.info("4.Exit");
			int n = sc.nextInt();
			
			if(n==1) {
				su.signup();
			}
			else if(n==2) {
				l.login();
			}
			else if(n==3) {
				a.adminIn();
			}
			else if(n==4) {
				System.exit(0);
			}
			else {
				log.warn("Invalid Option");
				i=1;
			}
		}while(i==1);
		
	}
}
