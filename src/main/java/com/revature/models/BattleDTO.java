package com.revature.models;


public class BattleDTO {

	public int battleId;
	public String outcomes;
	public String avatar;
	public String opponent;
	public int userId;
	
	public BattleDTO( ) {
		super();
	}

	public BattleDTO(int battleId,String outcomes, String avatar, String opponent, int userId) {
		super();
		this.battleId = battleId;
		this.outcomes = outcomes;
		this.avatar = avatar;
		this.opponent = opponent;
		this.userId = userId;
	}

	
	public int getBattleId() {
		return battleId;
	}

	public void setBattleId(int battleId) {
		this.battleId = battleId;
	}

	public String getOutcomes() {
		return outcomes;
	}

	public void setOutcomes(String outcomes) {
		this.outcomes = outcomes;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getOpponent() {
		return opponent;
	}

	public void setOpponent(String opponent) {
		this.opponent = opponent;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "BattleDTO [battleId=" + battleId + ", outcomes=" + outcomes + ", avatar=" + avatar + ", opponent="
				+ opponent + ", userId=" + userId + "]";
	}

	
}
