package com.revature.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.*;

/*Battle model class: including all user battles, participants, and the userId associated to each battle*/

@Entity
@Table(name="battle")
public class Battle implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="battle_id")
	private int battleId;

	@Column(name="outcomes")
	private String outcomes;
	
//	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
//	@JoinColumn(name="avatar_id", nullable=false)
	
	@Column(name="avatar", nullable=false)
	private String avatar;
	
//	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
//	@JoinColumn(name="opponent_id", nullable=false)
	@Column(name="opponent",nullable=false)
	private String opponent;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="user_id", nullable=false)
	//@Column(name="user_id",nullable=false, unique=true)
	private User userId;

	public Battle() {
		super();
	}

	public Battle(int battleId, String outcomes, String avatar, String opponent, User userId) {
		super();
		this.battleId = battleId;
		this.outcomes = outcomes;
		this.avatar = avatar;
		this.opponent = opponent;
		this.userId = userId;
	}

	public Battle(String outcomes, String avatar, String opponent, User userId) {
		super();
		this.outcomes = outcomes;
		this.avatar = avatar;
		this.opponent = opponent;
		this.userId = userId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((avatar == null) ? 0 : avatar.hashCode());
		result = prime * result + battleId;
		result = prime * result + ((opponent == null) ? 0 : opponent.hashCode());
		result = prime * result + ((outcomes == null) ? 0 : outcomes.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Battle other = (Battle) obj;
		if (avatar == null) {
			if (other.avatar != null)
				return false;
		} else if (!avatar.equals(other.avatar))
			return false;
		if (battleId != other.battleId)
			return false;
		if (opponent == null) {
			if (other.opponent != null)
				return false;
		} else if (!opponent.equals(other.opponent))
			return false;
		if (outcomes == null) {
			if (other.outcomes != null)
				return false;
		} else if (!outcomes.equals(other.outcomes))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Battle [battleId=" + battleId + ", outcomes=" + outcomes + ", avatar=" + avatar + ", opponent="
				+ opponent + ", userId=" + userId + "]";
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

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}