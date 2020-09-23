package com.revature.repositories;

//package com.revature.repositories;
//
//import java.util.List;
//
//import org.hibernate.HibernateException;
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//import org.springframework.stereotype.Repository;
//
//import com.revature.models.Superhero;
//import com.revature.utils.HibernateUtil;
//
//@Repository
//public class SuperheroDAO implements ISuperheroDAO {
//	
//	@Override
//	public boolean addSuperhero(Superhero s) {
//		
//			Session ses = HibernateUtil.getSession();
//			try {
//			Transaction tx= ses.beginTransaction();
//			ses.save(s);
//			tx.commit();
//			return true;
//			
//			}catch (HibernateException e) {
//				e.printStackTrace();
//				return false;
//			}
//		}
//	
//	@Override
//	public List<Superhero> findAllSuperheros() {
//		
//		Session ses = HibernateUtil.getSession();
//		List<Superhero> sList = ses.createQuery("SELECT intelligence, strength, speed, durability, power, combat FROM powerstats " 
//		+ "FROM superheros LEFT JOIN superheros.name, superheros.alignment" 
//		+ "order by alignment").list();
//		return sList;
//	}
//
//	@Override
//	public Superhero findById(int id) {
//		
//		Session ses = HibernateUtil.getSession();
//		
//		Superhero s = ses.get(Superhero.class, id);
//		
//		return s;
//	}
//	


//	@Override
//	public List<Superhero> findByAlignment(String alignment) {
//		
//		Session ses = HibernateUtil.getSession();
//		List<Superhero> sList = ses.createQuery("FROM superheros WHERE alignment='" + alignment +"'").list();
//		return sList;
//		
//	}

//	

	

//	@Override
//	public List<Superhero> random5(String alignment){
//		Session ses = HibernateUtil.getSession();
//		List<Superhero> sList = ses.createQuery("FROM superheros WHERE alignment='" + alignment 
//				+ "'ORDER BY rand()").setMaxResults(5).list();
//		return sList;
//	}
//	
//	
//	@Override
//	public Superhero randomOpponent(String alignment){
//		Session ses = HibernateUtil.getSession();
//		Superhero s = (Superhero) ses.createQuery("FROM superheros WHERE alignment='" + alignment 
//				+ "'ORDER BY rand()").setMaxResults(1);
//		return s;
//	}

//	
//	
//}

	
	

