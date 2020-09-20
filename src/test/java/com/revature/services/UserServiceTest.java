package com.revature.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import com.revature.models.User;
import com.revature.repositories.IUserDAO;
import com.revature.repositories.UserDAO;

public class UserServiceTest {
	UserDAO udaoMock = (UserDAO) mock(IUserDAO.class);
	UserService uSerMock = new UserService(udaoMock);
	
	@Test
	public void testValidUserNull() {
		when(udaoMock.findByUsername("test")).thenReturn(null);
		assertEquals(null, uSerMock.validUser("test", "password"));
	}

	@Test
	public void testValidUser() {
		User u = new User();
		u.setPassword("password");
		when(udaoMock.findByUsername("test")).thenReturn(u);
		assertEquals(u, uSerMock.validUser("test", "password"));
	}
	
	//test to see only if the password is incorrect
	@Test
	public void testValidUserWrongPassword() {
		User u = new User();
		u.setPassword("wrong");
		when(udaoMock.findByUsername("test")).thenReturn(u);
		assertEquals(null, uSerMock.validUser("test", "password"));
	}
	
	//testing a new inserted user
	@Test
	public void testInsert(){
		User u = new User();
		u.setFirst("ttest");
		u.setLast("ttest2");
		u.setUsername("testusername");
		u.setPassword("password");
		//u.getSalt();
		u.setUserWins(1);
		u.setUserLosses(3);
		u.setUserRecord(0.25);
		
		when(udaoMock.insert(u)).thenReturn(u);
		assertEquals(u, uSerMock.insertUser(u));

	}
	
	
	
}
