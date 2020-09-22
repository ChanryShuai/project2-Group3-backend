package com.revature.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.revature.models.Battle;

@Repository
public interface IBattleDAO {

	public String findOutcome(int battleId);

	public boolean updateBattle(List<Battle> b);

	public List<Battle> findAllBattles();

	public List<Battle> findBattlesByUser(String username);

	public Battle addBattle(Battle b);

	public List<Battle> getBattleById(int id);

}
