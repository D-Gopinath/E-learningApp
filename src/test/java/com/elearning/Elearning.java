package com.elearning;
import java.util.Scanner;
import com.elearning.admin.*;
import com.elearning.login.Login;
import com.elearning.signup.*;
public class Elearning {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		SignUp su = new SignUp();
		Login l = new Login();
		Admin a = new Admin();
		
		
		int i=0;
		do {
			System.out.println("Welcome To E-Learning App \n");
			System.out.println("1.New User?...SignUp and Start Learning!!!");
			System.out.println("2.Existing User?...Login now");
			System.out.println("3.Admin only... ");
			System.out.println("4.Exit");
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
				System.err.println("Invalid Option");
				i=1;
			}
		}while(i==1);
		
	}
}
