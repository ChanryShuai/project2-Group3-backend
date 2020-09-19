package com.revature.repositories;

import com.revature.models.LoginDTO;

public interface ILoginDAO {
	
	public LoginDTO addLogin(LoginDTO l);

	public LoginDTO getByUsername(String username);
	
	//public List<UserLogin> getAll();

}
