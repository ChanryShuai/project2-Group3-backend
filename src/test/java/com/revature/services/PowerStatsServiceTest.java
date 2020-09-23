//package com.revature.services;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertTrue;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//import org.junit.Test;
//
//import com.revature.models.PowerStats;
//import com.revature.repositories.IPowerStatsDAO;
//import com.revature.repositories.PowerStatsDAO;
//
//public class PowerStatsServiceTest {
//	
//	PowerStatsDAO psdaoMock = (PowerStatsDAO) mock(IPowerStatsDAO.class);
//	PowerStatsService pSerMock = new PowerStatsService(psdaoMock);
//	
//	@Test
//	public void testSelectByPowerStatsId() {
//		PowerStats p = new PowerStats();
//		p.setPowerstatsId(3);
//		when(psdaoMock.selectByPowerStatsId(3)).thenReturn(p);
//		assertEquals(p, pSerMock.selectByPowerStatsId(3));
//	}
//	
//	@Test
//	public void testSelectByPowerStatsIdNull() {
//		when(psdaoMock.selectByPowerStatsId(3)).thenReturn(null);
//		assertEquals(null, pSerMock.selectByPowerStatsId(3));
//	}
//}
