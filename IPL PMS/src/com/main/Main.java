package com.main;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import com.controller.Controller;
import com.entity.Players;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		boolean exit = true;

		while (exit) {

			System.out.println("\n---------- IPL Player Management System ----------\n");
			System.out.println("1 - Add new team");
			System.out.println("2 - Add player to a team");
			System.out.println("3 - Delete a player to a team");
			System.out.println("4 - Update player details");
			System.out.println("5 - Fetch all players by team names");
			System.out.println("6 - Fetch player details from player name");
			System.out.println("7 - Display all teams and there players");
			System.out.println("8 - Exit");

			System.out.println("\n----------------------------------------------------\n");

			System.out.print("Enter your choice : ");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.print("Enter Team Name : ");
				String teanName = sc.next();
				int rowAffected = new Controller().addNewTeam(teanName);
				if (rowAffected > 0) {
					System.out.println("Team Added Successfully");
				} else {
					System.out.println("Team is already exist ");
				}

				break;
			case 2:
				System.out.print("Enter Team Name : ");
				String playerTeamName = sc.nextLine();
				sc.nextLine();
				System.out.print("Enter Player Name : ");
				String playerName = sc.nextLine();

				System.out.print("Enter Player Role : ");
				String role = sc.nextLine();
				System.out.print("Enter Player Age : ");
				int age = sc.nextInt();

				int result = new Controller().addPlayer(playerTeamName, playerName, role, age);

				if (result > 0) {
					System.out.println("Player Added Successfully....");
				} else {
					System.out.println("Player already exist....");
				}

				break;

			case 3:
				System.out.print("Enter Player Name : ");
				String pname = sc.nextLine();
				sc.nextLine();

				System.out.print("Enter Player Team Name : ");
				String tname = sc.nextLine();

				int deleteOrNot = new Controller().deletePlayerToTeam(pname, tname);
				if (deleteOrNot > 0) {
					System.out.println("Player Delete Successfully....");
				} else {
					System.out.println("Player not deleted....");
				}

				break;

			case 4:

				System.out.print("Which Team Player you want to update : ");
				String team = sc.nextLine();
				sc.nextLine();

				System.out.print("Enter the Name of that player : ");
				String name = sc.nextLine();

				System.out.print("Enter the updated role : ");
				String updatedRole = sc.nextLine();

				System.out.print("Enter the updated age :");
				int updatedAge = sc.nextInt();

				int updateOrNot = new Controller().updatePlayerDetails(updatedRole, updatedAge, name, team);
				if (updateOrNot > 0) {
					System.out.println("Successfully updated....");
				} else {
					System.out.println("Not updated");
				}

				break;
			case 5:
				System.out.println("Enter the team Name which player you want to see : ");
				String playerTeam = sc.next();

				ArrayList<Players> playerList = new Controller().getAllPlayerByTeam(playerTeam);

				for (Players player : playerList) {
					System.out.println(player);
				}
				break;
			case 6:
				System.out.println("Which player details you want to see : ");
				String pName = sc.nextLine();

				Players player = new Controller().getPlayerByName(pName);
				if (player != null) {
					System.out.println("Team : " + player.getName());
					System.out.println("Role : " + player.getRole());
					System.out.println("Age  : " + player.getAge());
				} else {
					System.out.println("Player not found");
				}

				break;
			case 7:
				System.out.println("\nAll teams & there players");

				Map<String, ArrayList<Players>> allPLayers = new Controller().getAllTeamsAndTherePlayers();

				allPLayers.forEach((k, v) -> {
					System.out.println(v);

				});

				break;
			case 8:
				sc.close();
				exit = false;
				System.out.println("Exit Successfully");
				break;

			default:
				System.out.println("Invalid Choice.....");
				break;
			}

		}

	}
}
