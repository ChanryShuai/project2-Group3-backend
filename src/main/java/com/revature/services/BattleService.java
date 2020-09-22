package com.revature.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.revature.repositories.IBattleDAO;
import com.revature.models.Battle;
import com.revature.models.BattleDTO;
import com.revature.models.User;
import com.revature.repositories.BattleDAO;

@Service
public class BattleService {

	private static IBattleDAO bdao = new BattleDAO();
	private static final Logger log = LogManager.getLogger(BattleService.class);
	
	public BattleService(BattleDAO bdao) {
		super();
		BattleService.bdao = bdao;
	}

	public void findOutcome(int battleId) {
		log.info("Finding the battle outcome");
		bdao.findOutcome(battleId);
	}
	
	public boolean updateBattle(BattleDTO bdto) {
		log.info("Updating the user's battle info");
		
		List<Battle> b = bdao.getBattleById(bdto.battleId);
		String outcomes = bdao.findOutcome(bdto.battleId);
		bdto.setOutcomes(outcomes);
		return bdao.updateBattle(b);
	}
	
	public List<Battle> findAllBattles(){
		log.info("Finding all the battles");
		return bdao.findAllBattles();
	}
	
	public List<Battle> findBattlesByUser(String username){
		log.info("Finding the user's battles");
		return bdao.findBattlesByUser(username);
	}

	public Battle addBattle(BattleDTO bdto) {
		log.info("Adding a new battle");
		Battle b = new Battle();
		//int battleId = bdto.battleId;
		//String outcomes = bdto.outcomes;
		String avatar = bdto.avatar;
		String opponent = bdto.opponent;
		User userId = bdto.userId;
		
		b.setOutcomes(bdao.findOutcome(bdto.battleId));
		b.setAvatar(avatar);
		b.setOpponent(opponent);
		b.setUserId(userId);
		
		return bdao.addBattle(b);
		
	}
	

	public List<Battle> getBattleById(int id) {
		log.info("Finding battle with id: " + id);
		return bdao.getBattleById(id);
	}
}
