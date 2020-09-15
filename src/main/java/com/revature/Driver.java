package com.revature;

import java.util.List;

import com.revature.daos.IUserDAO;
import com.revature.daos.UserDAO;
import com.revature.models.User;
import com.revature.services.*;

public class Driver {
	
	public static IUserDAO uDao = new UserDAO();
	
	
	public static void main(String[] args) {
		
		insertUser();
		User u = uDao.findByUsername("Chanry");
		
		}


	private static void insertUser() {
		
		User user1 = new User("Chanry", "12345", "Chanry", "Shuai", 1, 2);
	}
	

}
