package com.revature.repositories;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.revature.models.Battle;
import com.revature.models.Superhero;
import com.revature.utils.HibernateUtil;

@Repository
public class BattleDAO implements IBattleDAO {
	
	@Override
	public void findOutcome(int battleId) {
		
		Session ses = HibernateUtil.getSession();
		
			Battle b = ses.get(Battle.class, battleId);
			if(b != null) {
			int avatarId = b.getAvatarId().getId();
			Superhero avatar = ses.get(Superhero.class, avatarId );
			
			int opponentId = b.getOpponentId().getId();
			Superhero opponent = ses.get(Superhero.class, opponentId );
			
			if(avatar.getPowerStats().getAverage() >= opponent.getPowerStats().getAverage()) {
				b.setOutcomes("win");
				System.out.println("You won!");
			} else {
				b.setOutcomes("loss");
				System.out.println("You lost!");
			}
			updateBattle(b);
		}
		
	}
	@Override
	public boolean updateBattle(Battle b) {
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
	public List<Battle> findBattlesByUser(int userId) {
	
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
	public Battle getBattleById(int id) {
		Session ses = HibernateUtil.getSession();
		Battle b = ses.get(Battle.class, id);
		return b;
	}	
	
	
}