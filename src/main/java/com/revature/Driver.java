package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.models.User;

import com.revature.repositories.IUserDAO;
import com.revature.repositories.UserDAO;

public class Driver {
	
	
	
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

//	insertUser();
//		User u = uDao.findByUsername("Chanry");
//		
//		}
//
//
//	private static void insertUser() {
//		
//		User user1 = new User("Chanry", "12345", "Chanry", "Shuai", 1, 2);
//	}
	

}
}