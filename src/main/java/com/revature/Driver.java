package com.revature;

import com.revature.repositories.IUserDAO;
import com.revature.repositories.UserDAO;
import com.revature.services.*;

public class Driver {
	
	public static IUserDAO udao = new UserDAO();
	
	
	public static void main(String[] args) {
		
		insertUser();
		
		}


	private static void insertUser() {
		// TODO Auto-generated method stub
		
	}
	

}
