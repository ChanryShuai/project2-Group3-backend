package com.revature.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.revature.models.LoginDTO;
import com.revature.models.User;
import com.revature.repositories.UserDAO;
import com.revature.utils.PasswordUtil;

@Service
public class LoginService {

	private static final Logger log = LogManager.getLogger(UserDAO.class);
	private static final Logger Log = LogManager.getLogger(LoginService.class);

	private static UserDAO udao;

//	public boolean login(LoginDTO l) {
//		log.info("@login in LoginService");
//		User u = udao.findByUsername(l.username);
//		StringBuilder tempPassword = new StringBuilder();
//		tempPassword.append(l.password.hashCode());
//		String hashPassword = tempPassword.toString();
//
//		if ((u != null) && hashPassword.equals(u.getPassword())) {
//			return true;
//
//		} else {
//			return false;
//		}
//	}
//}

	public boolean login(LoginDTO l) {
		log.info("@login in LoginService");

		String providedPassword = l.password;

		String securePassword = udao.findByUsername(l.username).getUsername();
		String salt = udao.findByUsername(l.username).getSalt();

		boolean passwordMatch = PasswordUtil.verifyUserPassword(providedPassword, securePassword, salt);

		if (passwordMatch) {
			System.out.println("Provided user password " + providedPassword + " is correct.");
			return true;
		} else {
			System.out.println("Provided password is incorrect");
			return false;
		}
	}
	
	public boolean logout() {
		log.info("@logout in LoginService");
		
	}
}