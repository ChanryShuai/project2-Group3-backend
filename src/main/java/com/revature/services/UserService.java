package com.revature.services;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.revature.models.User;
import com.revature.repositories.*;

@Service
public class UserService {

	private static IUserDAO udao;
	private static final Logger log = LogManager.getLogger(UserService.class);
	
	public User insertUser(User u) {
		log.info("Adding user");
		return udao.insert(u);
	}
	
	public User selectByUserId(int userId) {
		log.info("Finding user by the user id");
		return udao.selectByUserId(userId);
	}
	
	public User updateUser(User u) {
		log.info("Updating a user");
		return udao.updateUser(u);
	}
	
	public User findByUsername(String username) {
		log.info("Finding user by the username");
		return udao.findByUsername(username);
	}
	
	public User validUser(String username, String password) {
		log.info("Validating the user by login credentials");
		return udao.validUser(username, password);
	}
}
