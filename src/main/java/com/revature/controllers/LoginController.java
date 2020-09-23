package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.revature.models.LoginDTO;
import com.revature.models.User;
import com.revature.services.LoginService;
import com.revature.services.UserService;


@CrossOrigin 
@RestController
@RequestMapping(value="/login")

public class LoginController {

	private LoginService lSer;
	private UserService uSer;

	@Autowired
	public LoginController(LoginService lSer, UserService uSer) {
		super();
		this.lSer = lSer;
		this.uSer = uSer;
	}

	@GetMapping("/")
	public String index() {
		return "index";
	}

	//for registering a new user
		@PostMapping(value="/register",
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<LoginDTO> addUserLogin(@RequestBody LoginDTO l) {
			try {
				l = lSer.addLogin(l);
				if(l == null) {
					return new ResponseEntity<LoginDTO>(HttpStatus.CONFLICT);
				}
				else {
					return new ResponseEntity<LoginDTO>(l, HttpStatus.CREATED);
				}
			} catch (NullPointerException e) {
				return null;
			}
		}
		
		// Takes in a LoginDTO object: returns it if found and null if not found
		@PostMapping(value="/validate",
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<User> getUserLogin(@RequestBody LoginDTO l) {
			try {
			LoginDTO result = lSer.getByUsername(l.getUsername());
			if (result.getPassword().equals(l.getPassword())) {
				System.out.println(l);
				User loggedInUser = uSer.findByUsername(l.getUsername());
				return new ResponseEntity<User>(loggedInUser, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
			}
			} catch (NullPointerException e) {
				return null;
			}
		}

		public LoginService getlSer() {
			return lSer;
		}

		public void setlSer(LoginService lSer) {
			this.lSer = lSer;
		}

		public UserService getuSer() {
			return uSer;
		}

		public void setuSer(UserService uSer) {
			this.uSer = uSer;
		}
		
		
}
