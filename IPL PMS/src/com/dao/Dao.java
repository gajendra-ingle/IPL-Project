package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.entity.Players;
import com.utility.DBConnection;

public class Dao {

	// 1 - Add new team
	public int addNewTeam(String teamName) {
		String sql = "insert into teams(team_name) values(?)";
		int rowAffected = 0;
		Connection con = DBConnection.getMySqlConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, teamName);

			try {
				rowAffected = ps.executeUpdate();
			} catch (SQLIntegrityConstraintViolationException e) {
				e.getMessage();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowAffected;
	}

	// 2 - Add player to a team

	public int addPlayer(String teamName, String playerName, String role, int age) {
		String sql = "insert into players(player_name, role, age, team_name) values(?,?,?,?);";
		int rowAffected = 0;

		Connection con = DBConnection.getMySqlConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, playerName);
			ps.setString(2, role);
			ps.setInt(3, age);
			ps.setString(4, teamName);

			try {
				rowAffected = ps.executeUpdate();
			} catch (SQLIntegrityConstraintViolationException e) {
				e.getLocalizedMessage();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rowAffected;
	}

	// 3 - Delete a player to a team
	public int deletePlayerToTeam(String playerName, String teamName) {
		String sql = "delete from players where player_name = ? and team_name = ?";
		int deleteOrNot = 0;
		Connection con = DBConnection.getMySqlConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, playerName);
			ps.setString(2, teamName);

			deleteOrNot = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return deleteOrNot;
	}

	// 4 - Update player details
	public int updatePlayerDetails(String role, int age, String playerName, String teamName) {

		String sql = "UPDATE players SET role = ?, age = ? WHERE player_name = ? and team_name = ?";
		int updateOrNot = 0;
		Connection con = DBConnection.getMySqlConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, role);
			ps.setInt(2, age);
			ps.setString(3, playerName);
			ps.setString(4, teamName);

			updateOrNot = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return updateOrNot;
	}

	// 5 - Fetch all players by team names
	public ArrayList<Players> getAllPlayerByTeam(String teamName) {
		ArrayList<Players> playerList = new ArrayList<Players>();

		String sql = "select player_name, role, age from players where team_name = " + "'" + teamName + "'";

		Connection con = DBConnection.getMySqlConnection();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			// ps.setString(1, teamName);
			ResultSet rs = ps.executeQuery(sql);

			while (rs.next()) {
				String playerName = rs.getString(1);
				String role = rs.getString(2);
				int age = rs.getInt(3);

				playerList.add(new Players(playerName, role, age));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return playerList;
	}

	// 6 - fetch player details from player name
	public Players getPlayerByName(String playerName) {
		String sql = "select team_name, role, age from players where player_name =" + "'" + playerName + "'";

		Connection con = DBConnection.getMySqlConnection();

		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery(sql);

			while (rs.next()) {
				String teamName = rs.getString(1);
				String role = rs.getString(2);
				int age = rs.getInt(3);

				return new Players(teamName, role, age);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	// 7 - display all teams and there team names
	public Map<String, ArrayList<Players>> getAllTeamsAndTherePlayers() {
		Map<String, ArrayList<Players>> allPlayers = new HashMap<String, ArrayList<Players>>();

		ArrayList<Players> miPlayers = new ArrayList<Players>();

		String sql = "select player_name, role, age from players";

		Connection con = DBConnection.getMySqlConnection();

		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				String playerName = rs.getString(1);
				String role = rs.getString(2);
				int age = rs.getInt(3);

				miPlayers.add(new Players(playerName, role, age));

			}
			allPlayers.put("All Players", miPlayers);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return allPlayers;
	}

}
