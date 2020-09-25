package com.revature.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.models.LoginDTO;
import com.revature.repositories.ILoginDAO;

public class LoginServiceTest {

	ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	ILoginDAO ldao = ac.getBean(ILoginDAO.class);
	LoginDTO ldto = ac.getBean(LoginDTO.class);
	
	@Before
	public void before() {
		System.out.println("Testing Login Service: ");
	}
	
	@Test
	public void testAddLogin() {
		LoginDTO l = new LoginDTO();
		
		LoginDTO x = ldao.addLogin(l);
		assertNull(x);
		
		l.setUsername("vicky");
		LoginDTO z = ldao.addLogin(l);
		assertNotNull(z);
	}
	
	@Test
	public void testGetByUsername() {
		LoginDTO l = ldao.getByUsername("cadie");
		assertNotNull(l);
		
		LoginDTO x = ldao.getByUsername("xyz");
		assertNull(x);
	}
	
}
