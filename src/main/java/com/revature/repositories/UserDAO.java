package com.revature.repositories;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.revature.models.User;
import com.revature.utils.HibernateUtil;

@Repository
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

	
	@Override
	public User insert(User u) {
		Session ses = HibernateUtil.getSession();
		Transaction tr = ses.beginTransaction();
		ses.save(u);
		tr.commit();
		return u;
	}
	
	@Override
	public boolean updateUser(User u) {
	
		Session ses = HibernateUtil.getSession();
		
		try {
		ses.merge(u);
		return true;
		
	}catch(HibernateException e) {
		e.printStackTrace();
		return false;
	}
	}
	
	@Override
	public User selectByUserId(int userId) {
		
		Session ses = HibernateUtil.getSession();
		
		User u = ses.get(User.class, userId);
		
		return u;
	}
	
}
