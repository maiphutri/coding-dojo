package com.codingdojo.objectmaster;

public class Wizard extends Human {
	public Wizard() {
		this.health = 80;
		this.iq = 8;
	}
	
	void heal(Human human) {
		human.health += this.iq;
	}
	
	void fireball(Human human) {
		human.health -= (3 * this.iq);
	}
}
