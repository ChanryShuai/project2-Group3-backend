package com.revature.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Battle;
import com.revature.models.BattleDTO;
import com.revature.models.User;

@Repository
@Transactional
public class BattleDAO implements IBattleDAO {

	@Autowired
	private SessionFactory sf;

	@Autowired
	private IUserDAO uDao;

	@Override
	public String findOutcome(int battleId) {

		Session s = sf.getCurrentSession();

		BattleDTO b = s.get(BattleDTO.class, battleId);
		if (b != null) {

			String outcomes = b.getOutcomes();
			return outcomes;
		}

		return null;
	}

	@Override
	public boolean updateBattle(List<Battle> b) {
		Session s = sf.getCurrentSession();
		s.update(b);

//		Transaction tx = s.beginTransaction();
//		s.merge(b);
//		tx.commit();
		return true;
	}

	@Override
	public List<Battle> findAllBattles() {

		Session s = sf.getCurrentSession();
		CriteriaQuery<Battle> cq = s.getCriteriaBuilder().createQuery(Battle.class);
		cq.from(Battle.class);
		// List<Battle> bList = s.createQuery("FROM battle").list();
		return s.createQuery(cq).getResultList();
	}

	@Override
	public List<Battle> findBattlesByUser(String username) {
//		Session s = sf.getCurrentSession();
//		CriteriaQuery<Battle> cq = s.getCriteriaBuilder().createQuery(Battle.class);
//		Root<Battle> = cq.from(Battle.class);
//		cq.select(userId);
//	

		// int userId = uDao.findByUsername(username).getUserId();
		Session s = sf.getCurrentSession();
		User u = uDao.findByUsername(username);
		if (u == null) {
			return new ArrayList<Battle>();
		} else {
			int userId = u.getUserId();
//			Query<Battle> q = s.createQuery("FROM battle WHERE userId = :userId");
//			q.setParameter("userId", userId);
			List<Battle> bList = s.createQuery("FROM battle WHERE userId=" + userId, Battle.class).list();
			// track null username

//		List<Battle> allBattles = findAllBattles();
//		List<Battle> userBattles = new ArrayList<Battle>();
//		for(Battle b: allBattles) {
//			if(b.getUserId().getUsername().equals(username)) {
//				userBattles.add(b);
//			} 
//		}

			return bList;
		}

		// return
		// sf.getCurrentSession().createCriteria(Battle.class).add(Restrictions.eq("battle.user_id",
		// userId)).list();
	}

	@Override
	public Battle addBattle(Battle b) {

		Session s = sf.getCurrentSession();
//		Transaction tr = s.beginTransaction();
//		s.save(b);
//		tr.commit();
		s.saveOrUpdate(b);
		User u = b.getUserId();
		if (b.getOutcomes().equals("win")) {
			u.setUserWins(u.getUserWins()+1);
			uDao.calculateRecord(u);
		} else if (b.getOutcomes().equals("loss")) {
			u.setUserLosses(u.getUserLosses()+1);
			uDao.calculateRecord(u);
		}
		return b;
	}

	@Override
	public List<Battle> getBattleById(int id) {
		Session s = sf.getCurrentSession();
		List<Battle> bList = new ArrayList<Battle>();
		Battle b = s.get(Battle.class, id);
		bList.add(b);
		// List<Battle> bList = s.createQuery("From battle WHERE battle_id=" +
		// id).list();
		return bList;
	}

}