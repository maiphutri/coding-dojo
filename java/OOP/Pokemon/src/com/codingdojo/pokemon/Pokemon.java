package com.codingdojo.pokemon;

public class Pokemon {
	private String name;
	private int health;
	private String type;
	private static int count;
	
	public Pokemon(String name, int health, String type) {
		this.name = name;
		this.health = health;
		this.type = type;
		Poke
		count++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	void attackPokemon(Pokemon pokemon) {
		pokemon.health -= 10;
	}
	
	static int getTotalPokemon() {
		System.out.println(count);
		return count;
	}
	
}
