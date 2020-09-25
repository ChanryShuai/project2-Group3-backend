package com.revature.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import com.revature.models.Battle;

import com.revature.models.User;
import com.revature.repositories.BattleDAO;
import com.revature.repositories.IBattleDAO;

public class BattleServiceTest {
	
	BattleDAO bdaoMock = (BattleDAO) mock(IBattleDAO.class);
	BattleService bSerMock = new BattleService(bdaoMock);
	
	@Test
	public void testFindOutcome() {
		Battle b = new Battle();
		b.setBattleId(10);
		
		User u = new User();
		b.setUserId(u);
		b.setOutcomes("win");
		assertEquals(b.getOutcomes(), bdaoMock.findOutcome(10));
	}
	
	@Test
	public void testUpdateBattleTrue() {
		
	}
	
	@Test
	public void testUpdateBattleFalse() {
		
	}
	
	@Test
	public void testFindAllBattles() {
		
	}
	
	@Test
	public void testFindBattlesByUser() {
		
	}

	@Test
	public void testAddBattle() {
		
	}
	
	@Test
	public void getBattleById() {
		
	}
}
