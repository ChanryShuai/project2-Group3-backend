package com.revature.repositories;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.User;

@Repository
@Transactional
public class UserDAO implements IUserDAO {
	

	@Autowired
	private SessionFactory sf;
	
	@Override
	public User validUser(String username, String password) {
		Session s = sf.getCurrentSession();
		

		User u = findByUsername(username);

		if (u != null) {
			User p = s.createQuery("FROM User WHERE password = '" + password + "'", User.class).uniqueResult();

			if (u == p) {
				return u;
			} else {
				return null;
			}
		} else {
			return null;
		}

	}

	@Override
	public User findByUsername(String username) {
		Session s = sf.getCurrentSession();
		User u = s.createQuery("FROM User WHERE username = '" + username + "'", User.class).uniqueResult();
		return u;
	}

	@Override
	public User insert(User u) {
		Session s = sf.getCurrentSession();
//		Transaction tr = s.beginTransaction();
//		s.save(u);
//		tr.commit();
		s.saveOrUpdate(u);
		return u;
	}

	@Override
	public User updateUser(User u) {

		Session s = sf.getCurrentSession();

//		try {
//			s.merge(u);
//			return selectByUserId(u.getUserId());
//
//		} catch (HibernateException e) {
//			e.printStackTrace();
//			return null;
//		}
		s.update(u);
		return u;
	}

	@Override
	public User selectByUserId(int userId) {

		Session s = sf.getCurrentSession();

		User u = s.get(User.class, userId);

		return u;
	}

	@Override
	public List<User> findAllUsers() {
		
		Session s = sf.getCurrentSession();
		
//		List<User> uList = ses.createQuery("FROM User").list();
		
		CriteriaQuery<User> cq = s.getCriteriaBuilder().createQuery(User.class);
		cq.from(User.class);
		return s.createQuery(cq).getResultList();
	}
	
	

}
