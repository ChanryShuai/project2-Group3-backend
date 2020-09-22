//package com.revature.repositories;
//
//import org.hibernate.Session;
//
//import com.revature.models.PowerStats;
//import com.revature.utils.HibernateUtil;
//
//public class PowerStatsDAO implements IPowerStatsDAO {
//
//	@Override
//	public PowerStats selectByPowerStatsId(int powerStatsId) {
//		
//		Session ses = HibernateUtil.getSession();
//		
//		PowerStats p = ses.get(PowerStats.class, powerStatsId);
//		
//		return p;
//	}
//}
