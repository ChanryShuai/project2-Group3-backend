package com.revature.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.revature.models.LoginDTO;
import com.revature.models.User;
import com.revature.services.LoginService;

@RestController
@RequestMapping

@CrossOrigin(origins = "*")
//@SessionAttributes("log")
public class LoginController {

	private LoginService lSer;

	@Autowired
	public LoginController() {
		super();
		this.lSer = lSer;
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
		public ResponseEntity<LoginDTO> getUserLogin(@RequestBody LoginDTO l) {
			try {
			LoginDTO result = lSer.getByUsername(l.getUsername());
			if (result.getPassword().equals(l.getPassword())) {
				System.out.println(l);
				return new ResponseEntity<LoginDTO>(l, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<LoginDTO>(HttpStatus.NOT_FOUND);
			}
			} catch (NullPointerException e) {
				return null;
			}
		}
}
