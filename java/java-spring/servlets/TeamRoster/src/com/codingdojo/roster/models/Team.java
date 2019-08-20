package com.codingdojo.roster.models;

import java.util.ArrayList;

public class Team implements java.io.Serializable {
	private String teamName;
	private ArrayList<Player> players;
	
	public Team() {
	}

	public Team(String name) {
		this.teamName = name;
	}

	public String getName() {
		return teamName;
	}

	public void setName(String name) {
		this.teamName = name;
	}

	public ArrayList<Player> getPlayers() {
		return players;
		System.out.
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}
	
	public void addPlayer(Player player) {
		this.players.add(player);
	}
	
	
}
