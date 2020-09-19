package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.revature.models.User;
import com.revature.repositories.UserDAO;
import com.revature.services.UserService;

import antlr.collections.List;

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
	@GetMapping
	public ResponseEntity<List<User>> getRecords(){
		
	}

}
