package com.revature.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.revature.models.Superhero;

@Repository
public interface ISuperheroDAO {
	
	public boolean addSuperhero(Superhero s);

	public List<Superhero> findAllSuperheros();

	public Superhero findById(int id);

}
