package com.revature.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.services.UserService;
import com.revature.models.User;

@Controller
@RequestMapping(value="/user")
@ResponseBody
@CrossOrigin(origins="*", allowedHeaders="")
public class UserController {
	
	private UserService uSer;
	
	@Autowired
	public UserController() {
		super();
		this.uSer = uSer;
	}
	
	//add new user
	@PostMapping("/user")
	public ResponseEntity<User> addUser(@RequestBody User u){
		User u1 = uSer.insertUser(u);
		if(u == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // .build() builds an empty response body
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(u1);		
	}
	
	//get one user by ID
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") int id){
		User u= uSer.selectByUserId(id);
		if (u == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // .build() builds an empty response body
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(u);
	}
	
	//get one user by username
		@GetMapping("/user")
		public ResponseEntity<User> getUserByUsename(@RequestParam String username){
			User u= uSer.findByUsername(username);
			if (u == null) {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // .build() builds an empty response body
			}
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(u);
		}
	
	//update one user
	@PostMapping("/user")
	public ResponseEntity<User> updateUser(@RequestBody User u){
		User u1 = uSer.updateUser(u);
		if(u1 == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // .build() builds an empty response body
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(u1);		
	}
	
}
