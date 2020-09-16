package com.revature.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.*;

/*Battle model class: including all user battles, participants, and the userId associated to each battle*/

@Entity
@Table(name="battle")
public class Battle implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="battle_id")
	private static final long serialVersionUID = 1L;
	private int battleId;

	//TALK WITH CHANRY ABOUT IF WE NEED THIS TO HAVE A JOIN
	@Column(name="outcomes")
	private int outcomes;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="id", nullable=false)
	@Column(name="avatar_id", nullable=false, unique=true)
	private Superhero avatarId;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="id", nullable=false)
	@Column(name="opponent_id",nullable=false, unique=true)
	private Superhero opponentId;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="user_id", nullable=false)
	@Column(name="user_id",nullable=false, unique=true)
	private User userId;

	public Battle(int battleId, int outcomes, Superhero avatarId, Superhero opponentId, User userId) {
		super();
		this.battleId = battleId;
		this.outcomes = outcomes;
		this.avatarId = avatarId;
		this.opponentId = opponentId;
		this.userId = userId;
	}

	public Battle(int outcomes, Superhero avatarId, Superhero opponentId, User userId) {
		super();
		this.outcomes = outcomes;
		this.avatarId = avatarId;
		this.opponentId = opponentId;
		this.userId = userId;
	}

	public Battle() {
		super();
	}

	public int getbattleId() {
		return battleId;
	}

	public void setbattleId(int battleId) {
		this.battleId = battleId;
	}

	public int getOutcomes() {
		return outcomes;
	}

	public void setOutcomes(int outcomes) {
		this.outcomes = outcomes;
	}

	public Superhero getAvatarId() {
		return avatarId;
	}

	public void setAvatarId(Superhero avatarId) {
		this.avatarId = avatarId;
	}

	public Superhero getOpponentId() {
		return opponentId;
	}

	public void setOpponentId(Superhero opponentId) {
		this.opponentId = opponentId;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "battle [battleId=" + battleId + ", outcomes=" + outcomes + ", avatarId=" + avatarId + ", opponentId="
				+ opponentId + ", userId=" + userId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((avatarId == null) ? 0 : avatarId.hashCode());
		result = prime * result + battleId;
		result = prime * result + ((opponentId == null) ? 0 : opponentId.hashCode());
		result = prime * result + outcomes;
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
		if (avatarId == null) {
			if (other.avatarId != null)
				return false;
		} else if (!avatarId.equals(other.avatarId))
			return false;
		if (battleId != other.battleId)
			return false;
		if (opponentId == null) {
			if (other.opponentId != null)
				return false;
		} else if (!opponentId.equals(other.opponentId))
			return false;
		if (outcomes != other.outcomes)
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	
	
	
}
