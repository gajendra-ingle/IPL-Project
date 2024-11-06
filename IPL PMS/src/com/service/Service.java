package com.service;

import java.util.ArrayList;
import java.util.Map;

import com.dao.Dao;
import com.entity.Players;

public class Service {

	public int addNewTeam(String teamName) {
		return new Dao().addNewTeam(teamName);
	}

	public int addPlayer(String teamName, String playerName, String role, int age) {
		return new Dao().addPlayer(teamName, playerName, role, age);
	}

	public int deletePlayerToTeam(String playerName, String teamName) {
		return new Dao().deletePlayerToTeam(playerName, teamName);
	}

	public int updatePlayerDetails(String role, int age, String playerName, String teamName){
		return new Dao().updatePlayerDetails(role, age, playerName, teamName);
	}

	public ArrayList<Players> getAllPlayerByTeam(String teamName) {
		return new Dao().getAllPlayerByTeam(teamName);
	}

	public Players getPlayerByName(String playerName) {
		return new Dao().getPlayerByName(playerName);
	}

	public Map<String, ArrayList<Players>> getAllTeamsAndTherePlayers() {
		return new Dao().getAllTeamsAndTherePlayers();
	}
}
