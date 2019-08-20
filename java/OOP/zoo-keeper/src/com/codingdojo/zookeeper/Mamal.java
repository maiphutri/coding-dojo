package com.codingdojo.zookeeper;

public class Mamal {
	int energy = 100;

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public int displayEnergy() {
		System.out.println(this.energy);
		return this.energy;
	}

}
