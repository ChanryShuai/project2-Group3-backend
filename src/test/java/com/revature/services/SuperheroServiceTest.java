//package com.revature.services;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertTrue;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Test;
//
//import com.revature.models.PowerStats;
//import com.revature.models.Superhero;
//import com.revature.repositories.ISuperheroDAO;
//import com.revature.repositories.SuperheroDAO;
//
//public class SuperheroServiceTest {
//
//	SuperheroDAO sdaoMock = (SuperheroDAO) mock(ISuperheroDAO.class);
//	SuperheroService sSerMock = new SuperheroService(sdaoMock);
//	
//	@Test
//	public void testAddSuperheroTrue() {
//		Superhero s = new Superhero();
//		PowerStats p = new PowerStats();
//		s.setName("test");
//		s.setAlignment("good");
//		s.setPowerStats(p);
//		
//		when(sdaoMock.addSuperhero(s)).thenReturn(true);
//		assertTrue(sSerMock.addSuperhero(s));
//	}
//	
//	@Test
//	public void testAddSuperheroFalse() {
//		Superhero s = null;
//		when(sdaoMock.addSuperhero(s)).thenReturn(false);
//		assertFalse(sSerMock.addSuperhero(s));
//	}
//	
//	@Test
//	public void testFindAllSuperheros() {
//		Superhero s1 = new Superhero();
//		Superhero s2 = new Superhero();
//		Superhero s3 = new Superhero();
//		
//		List<Superhero> sList = new ArrayList<Superhero>();
//		sList.add(s1);
//		sList.add(s2);
//		sList.add(s3);
//		
//		when(sdaoMock.findAllSuperheros()).thenReturn(sList);
//		assertEquals(sList, sSerMock.findAllSuperheros());
//	}
//	
//	@Test
//	public void testFindAllSuperherosEmpty() {
//		when(sdaoMock.findAllSuperheros()).thenReturn(null);
//		assertEquals(null, sSerMock.findAllSuperheros());
//	}
//	
//	@Test
//	public void testFindById() {
//		Superhero s = new Superhero();
//		s.setId(3);
//		when(sdaoMock.findById(3)).thenReturn(s);
//		assertEquals(s, sSerMock.findById(3));
//	}
//	
//	@Test
//	public void testFindByIdNull() {
//		when(sdaoMock.findById(3)).thenReturn(null);
//		assertEquals(null, sSerMock.findById(3));
//	}
//	
//}
