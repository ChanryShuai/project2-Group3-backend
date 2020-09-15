package com.revature.models;

import javax.persistence.*;

/*Powerstats model class: including powers of one superhero, and a standard(averaged) power level*/

@Entity
@Table(name="powerstats")
public class PowerStats {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="powerstats_id")
	private int powerstatsId;
	
	@Column(name="intelligence")
	private int intelligence;
	
	@Column(name="strength")
	private int strength;
	
	@Column(name="speed")
	private int speed;
	
	@Column(name="durability")
	private int durability;
	
	@Column(name="power")
	private int power;
	
	@Column(name="combat")
	private int combat;
	
	@Column(name="average")
	private int average;

	public PowerStats(int powerstatsId, int intelligence, int strength, int speed, int durability, int power,
			int combat, int average) {
		super();
		this.powerstatsId = powerstatsId;
		this.intelligence = intelligence;
		this.strength = strength;
		this.speed = speed;
		this.durability = durability;
		this.power = power;
		this.combat = combat;
		this.average = average;
	}

	public PowerStats(int intelligence, int strength, int speed, int durability, int power, int combat, int average) {
		super();
		this.intelligence = intelligence;
		this.strength = strength;
		this.speed = speed;
		this.durability = durability;
		this.power = power;
		this.combat = combat;
		this.average = average;
	}

	public PowerStats() {
		super();
	}

	public int getPowerstatsId() {
		return powerstatsId;
	}

	public void setPowerstatsId(int powerstatsId) {
		this.powerstatsId = powerstatsId;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getDurability() {
		return durability;
	}

	public void setDurability(int durability) {
		this.durability = durability;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getCombat() {
		return combat;
	}

	public void setCombat(int combat) {
		this.combat = combat;
	}

	public int getAverage() {
		return average;
	}

	public void setAverage(int average) {
		this.average = average;
	}

	@Override
	public String toString() {
		return "PowerStats [powerstatsId=" + powerstatsId + ", intelligence=" + intelligence + ", strength=" + strength
				+ ", speed=" + speed + ", durability=" + durability + ", power=" + power + ", combat=" + combat
				+ ", average=" + average + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + average;
		result = prime * result + combat;
		result = prime * result + durability;
		result = prime * result + intelligence;
		result = prime * result + power;
		result = prime * result + powerstatsId;
		result = prime * result + speed;
		result = prime * result + strength;
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
		PowerStats other = (PowerStats) obj;
		if (average != other.average)
			return false;
		if (combat != other.combat)
			return false;
		if (durability != other.durability)
			return false;
		if (intelligence != other.intelligence)
			return false;
		if (power != other.power)
			return false;
		if (powerstatsId != other.powerstatsId)
			return false;
		if (speed != other.speed)
			return false;
		if (strength != other.strength)
			return false;
		return true;
	}
	
	

}
