//package com.revature.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.revature.models.Battle;
import com.revature.models.BattleDTO;
import com.revature.utils.HibernateUtil;

@Repository
public class BattleDAO implements IBattleDAO {
	
	private IUserDAO uDao;
	
	@Override
	public String findOutcome(int battleId) {
		
		Session ses = HibernateUtil.getSession();
		
			BattleDTO b = ses.get(BattleDTO.class, battleId);
			if(b != null) {
			
			String outcomes = b.getOutcomes();
			return outcomes;
			}
			
			return null;
		}
		
	
	@Override
	public boolean updateBattle(List<Battle> b) {
		Session ses = HibernateUtil.getSession();
		
		Transaction tx = ses.beginTransaction();
		ses.merge(b);
		tx.commit();
		return true;
	}


	@Override
	public List<Battle> findAllBattles() {
	
	Session ses = HibernateUtil.getSession();
	List<Battle> bList = ses.createQuery("FROM battle").list();
	return bList;
	}

	@Override
	public List<Battle> findBattlesByUser(String username) {
	int userId = uDao.findByUsername(username).getUserId();
	Session ses = HibernateUtil.getSession();
	List<Battle> bList = ses.createQuery("From battle WHERE user_id=" + userId).list();
	return bList;
	}
	
	@Override
	public Battle addBattle(Battle b) {
		
		Session ses = HibernateUtil.getSession();
		Transaction tr = ses.beginTransaction();
		ses.save(b);
		tr.commit();
		return b;
	}
	
	@Override
	public List<Battle> getBattleById(int id) {
		Session ses = HibernateUtil.getSession();
		List<Battle> bList = ses.createQuery("From battle WHERE battle_id=" + id).list();
		return bList;
	}	
	
	
}