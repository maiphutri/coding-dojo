package com.codingdojo.zookeeper;

public class Bat extends Mamal{
	private int energy = 300;
	
	public void fly() {
		this.energy -= 50;
	}
	
	public void eatHumans() {
		this.energy += 25;
	}
	
	public void attackTown() {
		this.energy -= 100;
	}
	
	public int displayEnergy() {
		System.out.println(this.energy);
		return this.energy;
	}
}
