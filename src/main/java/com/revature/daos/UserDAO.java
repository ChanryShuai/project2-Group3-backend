package com.revature.daos;

import org.hibernate.Session;

import com.revature.models.User;
import com.revature.utils.HibernateUtil;

public class UserDAO implements IUserDAO {
	
	@Override
	public User validUser(String username, String password) {
		Session ses = HibernateUtil.getSession();
		
		User u = findByUsername(username);
		User p = ses.createQuery("FROM User WHERE password = '" + password + "'", User.class).uniqueResult();
		
		if (u == p) {
			return u;
		} else {
			return null;
		}
		
	}

	@Override
	public User findByUsername(String username) {
		Session ses = HibernateUtil.getSession();
		User u = ses.createQuery("FROM User WHERE username = '" + username + "'", User.class).uniqueResult();
		return u;
	}

}
