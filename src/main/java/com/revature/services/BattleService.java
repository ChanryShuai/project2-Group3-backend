package com.revature.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.repositories.IBattleDAO;
import com.revature.repositories.IUserDAO;
import com.revature.models.Battle;
import com.revature.models.BattleDTO;
import com.revature.models.User;
import com.revature.repositories.BattleDAO;

@Service
public class BattleService {

	private static IBattleDAO bdao;
	private static IUserDAO udao;
	private static final Logger log = LogManager.getLogger(BattleService.class);
	
	@Autowired
	public BattleService(IBattleDAO bdao, IUserDAO udao) {
		super();
		this.bdao=bdao;
		this.udao =udao;
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
		User user= udao.selectByUserId(bdto.userId);
		
		b.setOutcomes(bdao.findOutcome(bdto.battleId));
		b.setAvatar(avatar);
		b.setOpponent(opponent);
		b.setUserId(user);
		
		return bdao.addBattle(b);
		
	}
	

	public List<Battle> getBattleById(int id) {
		log.info("Finding battle with id: " + id);
		return bdao.getBattleById(id);
	}

	public static IBattleDAO getBdao() {
		return bdao;
	}

	public static void setBdao(IBattleDAO bdao) {
		BattleService.bdao = bdao;
	}

	public static IUserDAO getUdao() {
		return udao;
	}

	public static void setUdao(IUserDAO udao) {
		BattleService.udao = udao;
	}
	
	
}
