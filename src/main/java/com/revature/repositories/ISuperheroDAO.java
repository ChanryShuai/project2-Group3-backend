<<<<<<< HEAD
//package com.revature.repositories;
//
//import java.util.List;
//
//import org.springframework.stereotype.Repository;
//
//import com.revature.models.Superhero;
//
//@Repository
//public interface ISuperheroDAO {
//	
//	public boolean addSuperhero(Superhero s);
//
//	public List<Superhero> findAllSuperheros();
//
//	public Superhero findById(int id);
//
//	public List<Superhero> findByAlignment(String alignment);
//
//	public List<Superhero> random5(String alignment);
//
//	public Superhero randomOpponent(String alignment);
//
//}
=======
package com.revature.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.revature.models.Superhero;

@Repository
public interface ISuperheroDAO {
	
	public boolean addSuperhero(Superhero s);

	public List<Superhero> findAllSuperheros();

	public Superhero findById(int id);

//	public List<Superhero> findByAlignment(String alignment);

//	public List<Superhero> random5(String alignment);

//	public Superhero randomOpponent(String alignment);

}
>>>>>>> 4189204e5076959a0b24cf4a7b7af7cda629738a
