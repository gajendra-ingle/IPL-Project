package com.controller;

import java.util.ArrayList;
import java.util.Map;

import com.entity.Players;
import com.service.Service;

public class Controller {

	public int addNewTeam(String teamName) {
		return new Service().addNewTeam(teamName);
	}

	public int addPlayer(String teamName, String playerName, String role, int age) {
		return new Service().addPlayer(teamName, playerName, role, age);
	}

	public int deletePlayerToTeam(String playerName, String teamName) {
		return new Service().deletePlayerToTeam(playerName, teamName);
	}

	public int updatePlayerDetails(String role, int age, String playerName, String teamName) {
		return new Service().updatePlayerDetails(role, age, playerName, teamName);
	}

	public ArrayList<Players> getAllPlayerByTeam(String teamName) {
		return new Service().getAllPlayerByTeam(teamName);
	}

	public Players getPlayerByName(String playerName) {
		return new Service().getPlayerByName(playerName);
	}

	public Map<String, ArrayList<Players>> getAllTeamsAndTherePlayers() {
		return new Service().getAllTeamsAndTherePlayers();
	}
}
