package com.revature.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.models.PowerStats;
import com.revature.repositories.IPowerStatsDAO;

import com.revature.repositories.PowerStatsDAO;


public class PowerStatsService {
	
	private static IPowerStatsDAO pdao = new PowerStatsDAO();
	private static final Logger log = LogManager.getLogger(PowerStatsService.class);
	
	public PowerStats selectByPowerStatsId(int powerStatsId) {
		log.info("Selecting a powerStats object");
		return pdao.selectByPowerStatsId(powerStatsId);
	}
}
