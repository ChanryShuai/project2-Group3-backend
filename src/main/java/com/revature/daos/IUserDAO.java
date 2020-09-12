package com.revature.daos;

import com.revature.models.User;

public interface IUserDAO {

	public User validUser(String username, String password);
	
	public User findByUsername(String username);

}
