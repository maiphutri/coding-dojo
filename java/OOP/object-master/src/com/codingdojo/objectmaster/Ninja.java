package com.codingdojo.objectmaster;

public class Ninja extends Human {
	
	public Ninja() {
		this.stealth = 10;
	}
	
	void steal(Human human) {
		human.health -= this.stealth;
		this.health += this.stealth;
	}
	
	void runAway() {
		this.health -= 10;
	}
}
