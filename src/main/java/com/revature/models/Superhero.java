package com.revature.models;

/*Superhero model class: including superhero info, superhero power statics, and super hero good/bad alignment*/

import javax.persistence.*;

@Entity
@Table(name="superheros")
public class Superhero {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name",nullable=false, unique=true)
	private String name;
	
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="powerstats_id", nullable=false, unique=true)
	private PowerStats powerStats;
	
	@Column(name="alignment",nullable=false)
	private String alignment;
	
	

	public Superhero(int id, String name, PowerStats powerStats, String alignment) {
		super();
		this.id = id;
		this.name = name;
		this.powerStats = powerStats;
		this.alignment = alignment;
	}
	
	

	public Superhero(String name, PowerStats powerStats, String alignment) {
		super();
		this.name = name;
		this.powerStats = powerStats;
		this.alignment = alignment;
	}

	public Superhero() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PowerStats getPowerStats() {
		return powerStats;
	}

	public void setPowerStats(PowerStats powerStats) {
		this.powerStats = powerStats;
	}

	public String getAlignment() {
		return alignment;
	}

	public void setAlignment(String alignment) {
		this.alignment = alignment;
	}



	@Override
	public String toString() {
		return "Superhero [id=" + id + ", name=" + name + ", powerStats=" + powerStats + ", alignment=" + alignment
				+ "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alignment == null) ? 0 : alignment.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((powerStats == null) ? 0 : powerStats.hashCode());
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
		Superhero other = (Superhero) obj;
		if (alignment == null) {
			if (other.alignment != null)
				return false;
		} else if (!alignment.equals(other.alignment))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (powerStats == null) {
			if (other.powerStats != null)
				return false;
		} else if (!powerStats.equals(other.powerStats))
			return false;
		return true;
	}
	
	

}
