package com.revature.repositories;

import org.springframework.stereotype.Repository;

import com.revature.models.User;

@Repository
public interface IUserDAO {

	public User validUser(String username, String password);
	
	public User findByUsername(String username);
	
	public User insert(User u);

	public User selectByUserId(int userId);

	public User updateUser(User u);

}
