//package com.revature.controllers;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.revature.models.Superhero;
//import com.revature.services.SuperheroService;
//
//@Controller
//@RequestMapping(value = "/superhero")
//@ResponseBody
//@CrossOrigin
//public class SuperheroController {
//
//	private SuperheroService sSer;
//
//	@Autowired
//	public SuperheroController() {
//		super();
//	}
//
//	// adding a superhero to DB -- no return
//	@PostMapping
//	public void addSuperhero(@RequestBody Superhero s) {
//		sSer.addSuperhero(s);
//	}
//
//	// getting a superhero from DB
//	@GetMapping("/{id}")
//	public ResponseEntity<Superhero> getSuperhero(@PathVariable("id") int id) {
//		Superhero s = sSer.findById(id);
//		if (s == null) {
//			return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // .build() builds an empty response body
//		}
//		return ResponseEntity.status(HttpStatus.ACCEPTED).body(s);
//	}
//
//}
