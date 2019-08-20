package com.codingdojo.objectmaster;

public class Human {
	protected int strength = 3;
	protected int iq = 3;
	protected int stealth = 3;
	protected int health = 100;
	
	public void attack(Human human) {
		human.health -= this.strength;
	}

	public int getHealth() {
		System.out.println(this.health);
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
}
