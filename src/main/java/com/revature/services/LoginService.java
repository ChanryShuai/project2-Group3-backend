package com.revature.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.models.LoginDTO;
import com.revature.models.User;
import com.revature.repositories.UserDAO;

public class LoginService {

private static final Logger log = LogManager.getLogger(UserDAO.class);
private static final Logger Log = LogManager.getLogger(LoginService.class);

UserDAO udao = new UserDAO();

public boolean login(LoginDTO l) { 
	log.info("@login in LoginService");
	User u = udao.findByUsername(l.username);
	StringBuilder tempPassword = new StringBuilder();
	tempPassword.append(l.password.hashCode());
	String hashPassword = tempPassword.toString();
	
	if((u!=null) && hashPassword.equals(u.getPassword())) {
		return true;
	
	}else {
	return false; 
	}
}
}