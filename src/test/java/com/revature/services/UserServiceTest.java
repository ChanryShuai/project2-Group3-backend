package com.revature.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Before;
import org.junit.Test;

import com.revature.models.User;
import com.revature.repositories.IUserDAO;
import com.revature.repositories.UserDAO;

public class UserServiceTest {
	
	ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	IUserDAO udao = ac.getBean(IUserDAO.class);
	
	@Before
	public void before() {
		System.out.println("Testing User Service: ");
	}
	
//	UserDAO udaoMock = (UserDAO) mock(IUserDAO.class);
//	UserService uSerMock = new UserService(udaoMock);

	@Test
	public void testInsertUser(){
		User u = new User();
		u.setFirst("test");
		u.setLast("test2");
		u.setUsername("testusername");
		u.setPassword("testpassword");
		//u.getSalt();
		User x = udao.insert(u);
		assertNotNull(x);
	}
	
	@Test
	public void testSelectByUserId() {
		User u = udao.selectByUserId(3);
		assertNotNull(u);
		
		User x = udao.selectByUserId(10);
		assertNull(x);
	}

	@Test
	public void testUpdateUser() {
		User u = new User("vicky", "pass9502", "victoria", "doncell");
		User updated = udao.updateUser(u);
		assertNotNull(updated);
	}
	
	@Test
	public void testfindByUsername() {
		User u = udao.findByUsername("annabee");
		assertNotNull(u);
		
		User x = udao.findByUsername("xyz");
		assertNull(x);
	}
	
	@Test
	public void testValidUser() {
		User u = udao.validUser("annabee", "password");
		assertNotNull(u);
		
		User x = udao.validUser("xyz", "password");
		assertNull(x);
	}

	@Test
	public void testFindAllUsers() {
		User u1 = udao.findByUsername("annabee");
		assertNotNull(u1);
		
		User u2 = udao.findByUsername("cadie");
		assertNotNull(u2);
		
		User u3 = udao.findByUsername("chanry");
		assertNotNull(u3);
		
		List<User> uList = udao.findAllUsers();
		assertNotNull(uList);
	}
	
	@Test
	public void testCalculateRecord() {
		User u = udao.findByUsername("chanry");
		assertEquals(u.getUserRecord(), udao.calculateRecord(u), 0);
	}

}
