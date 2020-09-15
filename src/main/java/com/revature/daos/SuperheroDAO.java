package com.revature.daos;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Superhero;
import com.revature.utils.HibernateUtil;

public class SuperheroDAO implements ISuperheroDAO {
	
	@Override
	public boolean addSuperhero(Superhero s) {
		
			Session ses = HibernateUtil.getSession();
			try {
			Transaction tx= ses.beginTransaction();
			ses.save(s);
			tx.commit();
			return true;
			
			}catch (HibernateException e) {
				e.printStackTrace();
				return false;
			}
		}

}
