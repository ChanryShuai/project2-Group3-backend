package com.revature.repositories;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.models.LoginDTO;

@Transactional
@Repository
public class LoginDAO implements ILoginDAO {

	
	@Autowired
	SessionFactory sf;
	
	@Override
	public LoginDTO addLogin(LoginDTO l) {
		String username = (String) sf.getCurrentSession().save(l);
		l.setUsername(username);
		return l;
	}

	@Override
	public LoginDTO getByUsername(String username) {
		LoginDTO result = (LoginDTO) sf.getCurrentSession().get(LoginDTO.class, username);
		return result;
	}

}
