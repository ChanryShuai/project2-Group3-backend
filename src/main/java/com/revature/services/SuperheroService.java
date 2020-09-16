package com.revature.services;

import com.revature.models.AddSuperheroDTO;
import com.revature.models.Superhero;
import com.revature.repositories.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SuperheroService {
	
	private static IUserDAO udao = new UserDAO();
	private static ISuperheroDAO sdao = new SuperheroDAO();
	private static final Logger log = LogManager.getLogger(SuperheroService.class);
	
	//I JUST MADE EVERYTHING A SET METHOD PULLING FROM THE DTO BECAUSE I AM NOT SURE HOW THE API WORKS WITH METHODS
	public boolean addSuperhero(AddSuperheroDTO asdto, int id) {
		//log.info("Adding a superhero");
		Superhero s = new Superhero();
		s.setId(asdto.id);
		s.setName(asdto.name);
		s.setPowerStats(asdto.powerstats);
		s.setAlignment(asdto.alignment);
		
		if(sdao.addSuperhero(s)) {
			return true;
		}
		return false;
	}

}
