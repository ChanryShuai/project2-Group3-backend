package com.revature.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.LoginDTO;
import com.revature.repositories.ILoginDAO;
import com.revature.repositories.LoginDAO;
import com.revature.repositories.UserDAO;

@Service
public class LoginService {

	private static final Logger log = LogManager.getLogger(UserDAO.class);
	private static final Logger Log = LogManager.getLogger(LoginService.class);

//	private static UserDAO udao;
//	private static LoginDAO ldao;

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
	
	private ILoginDAO ldao;

	@Autowired
	public LoginService(ILoginDAO ldao) {
		super();
		this.ldao=ldao;
	}


	//adding a new user-login to DB
	public LoginDTO addLogin(LoginDTO l) {
		log.info("@login in LoginService");
		return ldao.addLogin(l);
	}
	
	public LoginDTO getByUsername(String username) {
		return ldao.getByUsername(username);
	}
	
//	public boolean login(LoginDTO l) {
//		log.info("@login in LoginService");
//
//		String providedPassword = l.password;
//
//		String securePassword = udao.findByUsername(l.username).getUsername();
//		String salt = udao.findByUsername(l.username).getSalt();
//
//		boolean passwordMatch = PasswordUtil.verifyUserPassword(providedPassword, securePassword, salt);
//
//		if (passwordMatch) {
//			System.out.println("Provided user password " + providedPassword + " is correct.");
//			return true;
//		} else {
//			System.out.println("Provided password is incorrect");
//			return false;
//		}
//	}
	
}