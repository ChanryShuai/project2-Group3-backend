package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.revature.models.User;
import com.revature.repositories.UserDAO;
import com.revature.services.UserService;


@Controller
@RequestMapping(value = "/user/record")
@ResponseBody
@CrossOrigin
public class RecordController {
	
	private UserService uSer;
	public UserDAO udao;
	
	@Autowired
	public RecordController() {
		super();
		this.uSer = uSer;
	}
	
	//get all user records
	// THIS NEEDS TO BE LOOKED OVER BECAUSE I DON"T THINK IT IS CORRECT
	@GetMapping
	public ResponseEntity<List<User>> getUserRecords(){
		
		List<User> uList = uSer.findAllUsers();
		
		if(uList == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
			for(User u: uList) {
		    	u.setFirst(u.getFirst());
		    	u.setLast(u.getLast());
		    	u.setUserRecord(u.getUserRecord());
		    	
			}
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(uList);
	}	
}

	