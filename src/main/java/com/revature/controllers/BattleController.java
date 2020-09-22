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

import com.revature.models.Battle;
import com.revature.models.BattleDTO;
import com.revature.services.BattleService;

@Controller
@RequestMapping(value = "/battle")
@ResponseBody
@CrossOrigin
public class BattleController {

	private BattleService bSer;

	@Autowired
	public BattleController() {
		super();
	}

	// add new battle
	@PostMapping
	public void addBattle(@RequestBody BattleDTO bdto) {
		bSer.addBattle(bdto);
	}

//	//get one battle by ID
//	@GetMapping(value="/{battle_id}")
//	public ResponseEntity<Battle> getBattleById(@PathVariable("battle_id") int id) {
//		Battle b = bSer.getBattleById(id);
//		if (b == null) {
//			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//		}
//		return ResponseEntity.status(HttpStatus.ACCEPTED).body(b);
//	}
//	
	
	// get all battles
	@GetMapping
	public ResponseEntity<List<Battle>> findAllBattles() {
		List<Battle> bList = bSer.findAllBattles();
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(bList);
	}

	@GetMapping(value = "/{input}")
	// get battles by user
	public ResponseEntity<List<Battle>> getBattleByUser(@PathVariable("input") String input) {
		//if input = username
		if (isNumeric(input)) {
			List<Battle> bList = bSer.findBattlesByUser(input);
			if (bList == null) {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			}
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(bList);
		//if input = battle_Id
		} else {
			List<Battle> bFake= bSer.getBattleById(Integer.parseInt(input));
			if (bFake == null) {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			}
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(bFake);
		}
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
