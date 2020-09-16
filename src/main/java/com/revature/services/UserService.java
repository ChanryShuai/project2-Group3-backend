package com.revature.services;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.models.User;
import com.revature.repositories.*;

public class UserService {

	private static IUserDAO udao = new UserDAO();
	private static final Logger log = LogManager.getLogger(UserService.class);
	
	public User insertUser(User u) {
		log.info("Add user");
		return udao.insert(u);
	}
}
