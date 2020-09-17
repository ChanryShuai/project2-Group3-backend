package com.revature.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.revature.models.Battle;

@Repository
public interface IBattleDAO {

	public void findOutcome(int battleId);

	public boolean updateBattle(Battle b);

	public List<Battle> findAllBattles();

	public List<Battle> findBattlesByUser(int userId);

	public Battle addBattle(Battle b);

	public Battle getBattleById(int id);

}
