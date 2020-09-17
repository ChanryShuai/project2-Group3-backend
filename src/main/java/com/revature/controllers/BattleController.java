package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.services.BattleService;

@Controller
@RequestMapping(value="/battle")
@ResponseBody
@CrossOrigin(origins="*", allowedHeaders="")
public class BattleController {
	
	private BattleService bSer;
	
	@Autowired
	public BattleController() {
		super();
		this.bSer=bSer;
	}
	
	//add new battle
	
	//get one battle by ID
	
	//get all battles
	
	//get battles by user

}
