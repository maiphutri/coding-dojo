package com.codingdojo.objectmaster;

public class Samurai extends Human {
	private static int counter;
	
	public Samurai() {
		this.health = 200;
		counter++;
	}
	
	void deathBlow(Human human) {
		human.health = 0;
		this.health /= 2;
	}
	
	void meditate() {
		this.health = 200;
	}
	
	int howMany() {
		System.out.println(this.counter);
		return this.counter;
	}
}
