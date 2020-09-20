package com.revature.controllers;

import java.util.Arrays;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.services.UserService;
import com.revature.models.User;

@Controller
@RequestMapping(value = "/user")
@ResponseBody
@CrossOrigin
public class UserController {

	private UserService uSer;

	@Autowired
	public UserController() {
		super();
		this.uSer = uSer;
	}

	// add new user
	@PostMapping
	public ResponseEntity<User> addUser(@RequestBody User u) {
		User u1 = uSer.insertUser(u);
		if (u == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // .build() builds an empty response body
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(u1);
	}

	// get one user by ID
//	@GetMapping("/{id}")
//	public ResponseEntity<User> getUserById(@PathVariable("id") int id) {
//		User u = uSer.selectByUserId(id);
//		if (u == null) {
//			return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // .build() builds an empty response body
//		}
//		return ResponseEntity.status(HttpStatus.ACCEPTED).body(u);
//	}

	// get one user
	@GetMapping("/{input}")
	public ResponseEntity<User> getUserByUsename(@PathVariable("input") String input) {
		// if input = username
		if (isNumeric(input)) {
			User u = uSer.findByUsername(input);
			if (u == null) {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // .build() builds an empty response body
			}
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(u);

			// if input = user_Id
		} else {
			User u = uSer.selectByUserId(Integer.parseInt(input));
			if (u == null) {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // .build() builds an empty response body
			}
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(u);
		}
	}
	
	// getting a list of all users (for the record controller)
	// did this RequestMapping method like Tim to simplify
	@RequestMapping(method=RequestMethod.GET)
	public List<User> findAllUsers() {
		return uSer.findAllUsers();
	}
	
	// update one user
	@PostMapping
	public ResponseEntity<User> updateUser(@RequestBody User u) {
		User u1 = uSer.updateUser(u);
		if (u1 == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // .build() builds an empty response body
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(u1);
	}

	public static boolean isNumeric(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
