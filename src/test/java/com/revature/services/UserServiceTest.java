package com.revature.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

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
	
	@Test
	public void testfindByUsernameNull() {
		when(udaoMock.findByUsername("test")).thenReturn(null);
		assertEquals(null, uSerMock.findByUsername("test"));
	}
	
	@Test
	public void testfindByUsername() {
		User u = new User();
		u.setUsername("test");
		when(udaoMock.findByUsername("test")).thenReturn(u);
		assertEquals(u, uSerMock.findByUsername("test"));
	}
	
	@Test
	public void testUpdateUser() {
		User u = new User();
		when(udaoMock.updateUser(u)).thenReturn(u);
		assertEquals(u, uSerMock.updateUser(u));
	}
	
	@Test
	public void testUpdateUserNull() {
		User u = null;
		when(udaoMock.updateUser(u)).thenReturn(null);
		assertEquals(null, uSerMock.updateUser(u));
	}
	
	@Test
	public void testSelectByUserId() {
		User u = new User();
		u.setUserId(3);
		when(udaoMock.selectByUserId(3)).thenReturn(u);
		assertEquals(u, uSerMock.selectByUserId(3));
	}
	
	public void testSelectByUserIdNull() {
		when(udaoMock.selectByUserId(3)).thenReturn(null);
		assertEquals(null, uSerMock.selectByUserId(3));
	}
	
	public void testFindAllUsers() {
		User u1 = new User();
		User u2 = new User();
		User u3 = new User();
		
		List<User> uList = new ArrayList<User>();
		uList.add(u1);
		uList.add(u2);
		uList.add(u3);
		
		when(udaoMock.findAllUsers()).thenReturn(uList);
		assertEquals(uList, uSerMock.findAllUsers());
	}
	
	public void testFindAllUsersEmpty() {
		when(udaoMock.findAllUsers()).thenReturn(null);
		assertEquals(null, uSerMock.findAllUsers());
	}
	
}
