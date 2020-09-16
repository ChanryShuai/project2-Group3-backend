package com.revature.services;

import com.revature.models.AddSuperheroDTO;
import com.revature.models.Superhero;
import com.revature.repositories.*;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SuperheroService {
	
	private static IUserDAO udao = new UserDAO();
	private static ISuperheroDAO sdao = new SuperheroDAO();
	private static final Logger log = LogManager.getLogger(SuperheroService.class);
	
	//I JUST MADE EVERYTHING A SET METHOD PULLING FROM THE DTO BECAUSE I AM NOT SURE HOW THE API WORKS WITH METHODS
//	public boolean addSuperhero(AddSuperheroDTO asdto, int id) {
//		//log.info("Adding a superhero");
//		Superhero s = new Superhero();
//		s.setId(asdto.id);
//		s.setName(asdto.name);
//		s.setPowerStats(asdto.powerstats);
//		s.setAlignment(asdto.alignment);
//		
//		if(sdao.addSuperhero(s)) {
//			return true;
//		}
//		return false;
//	}

	public boolean addSuperhero (Superhero s) {
		log.info("Adding a Superhero from the API");
		return sdao.addSuperhero(s);
	}
	
	public List<Superhero> findAllSuperheros(){
		log.info("Finding all the superheros");
		return sdao.findAllSuperheros();
	}
	
	public Superhero findById(int id) {
		log.info("Finding a superhero from the id");
		return sdao.findById(id);
	}
	
	public List<Superhero> findByAlignment(String alignment){
		log.info("Find all the superheros by alignment");
		return sdao.findByAlignment(alignment);
	}
	
	public List<Superhero> random5(String alignment){
		log.info("Giving the user a set of 5 superheros");
		return sdao.random5(alignment);
	}
	
	public Superhero randomOpponent(String alignment) {
		log.info("Giving the user an opponent");
		return sdao.randomOpponent(alignment);
	}
}
