package com.revature.controllers;

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

	// get one user by username or Id
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
	// I don't think we need the record controller -- this is already handled in the frontend by
	// the getAllUserRecords in battle.service.ts 
	// we need to make a new userRecord model if we are using the record controller approach 
	@GetMapping
	public ResponseEntity<List<User>> findAllUsers() {
		List<User> uList = uSer.findAllUsers();

		if (uList == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(uList);
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
