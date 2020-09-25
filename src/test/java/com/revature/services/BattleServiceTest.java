package com.revature.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.models.Battle;
import com.revature.models.BattleDTO;
import com.revature.models.User;
import com.revature.repositories.BattleDAO;
import com.revature.repositories.IBattleDAO;
import com.revature.repositories.IUserDAO;

public class BattleServiceTest {
	
	ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	IBattleDAO bdao = ac.getBean(IBattleDAO.class);
	IUserDAO udao = ac.getBean(IUserDAO.class);
	BattleDTO bdto = ac.getBean(BattleDTO.class);
	
	@Before
	public void before() {
		System.out.println("Testing Battle Service: ");
	}
//	BattleDAO bdaoMock = (BattleDAO) mock(IBattleDAO.class);
//	BattleService bSerMock = new BattleService(bdaoMock);
	
	
	@Test
	public void testFindOutcome() {
		String s = bdao.findOutcome(1);
		assertNotNull(s);
		
		String x = bdao.findOutcome(100);
		assertNull(x);
	}
	
	@Test
	public void testUpdateBattle() {
		List<Battle> b = bdao.getBattleById(1);
		String s = bdao.findOutcome(bdto.battleId);
		bdto.setOutcomes(s);
		assertTrue(bdao.updateBattle(b));
	}
	
	@Test
	public void testFindAllBattles() {
		List<Battle> b1 = bdao.getBattleById(1);
		assertNotNull(b1);
		
		List<Battle> b2 = bdao.getBattleById(2);
		assertNotNull(b2);
		
		List<Battle> b3 = bdao.getBattleById(3);
		assertNotNull(b3);
		
		List<Battle> bList = bdao.findAllBattles();
		assertNotNull(bList);
	}
	
	@Test
	public void testFindBattlesByUser() {
		List<Battle> notNull = bdao.findBattlesByUser("chanry");
		assertNotNull(notNull);
		
		List<Battle> nullList = bdao.findBattlesByUser("xyz");
		assertNull(nullList);
	}

	@Test
	public void testAddBattle() {
		Battle b = new Battle();
		b.setAvatar("1");
		b.setOpponent("2");
		b.setOutcomes("win");
		User u = udao.findByUsername("cadie");
		b.setUserId(u);
		
		Battle x = bdao.addBattle(b);
		assertNotNull(x);
	}
	
	@Test
	public void testGetBattleById() {
		List<Battle> notNull = bdao.getBattleById(1);
		assertNotNull(notNull);
		
		List<Battle> nullBattle = bdao.getBattleById(100);
		assertNull(nullBattle);
	}
}
