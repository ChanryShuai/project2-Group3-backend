package com.revature.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.repositories.IBattleDAO;
import com.revature.models.Battle;
import com.revature.repositories.BattleDAO;

public class BattleService {

	private static IBattleDAO bdao = new BattleDAO();
	private static final Logger log = LogManager.getLogger(BattleService.class);
	
	public void findOutcome(int battleId) {
		log.info("Finding the battle outcome");
		bdao.findOutcome(battleId);
	}
	
	public boolean updateBattle(Battle b) {
		log.info("Updating the user's battle info");
		return bdao.updateBattle(b);
	}
	
	public List<Battle> findAllBattles(){
		log.info("Finding all the battles");
		return bdao.findAllBattles();
	}
	
	public List<Battle> findBattlesByUser(int userId){
		log.info("Finding the user's battles");
		return bdao.findBattlesByUser(userId);
	}

	public Battle addBattle(Battle b) {
		log.info("Adding a new battle");
		return bdao.addBattle(b);
		
	}

	public Battle getBattleById(int id) {
		log.info("Finding battle with id: " + id);
		return bdao.getBattleById(id);
	}
}
