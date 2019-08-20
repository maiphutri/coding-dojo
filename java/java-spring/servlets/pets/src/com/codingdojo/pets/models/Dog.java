package com.codingdojo.pets.models;

public class Dog extends Animal {
	public Dog() {
	}
	
	public Dog(String name, String breed, double weight) {
		super(name, breed, weight);
	}
	

	@Override
	public String showAffection() {
		if (this.weight < 30) {
			return " hopped into your lap and cuddled you!";
		} else {
			return " curled up next to you!";
		}
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getBreed() {
		return this.breed;
	}

	@Override
	public void setBreed(String breed) {
		this.breed = breed;
	}

	@Override
	public double getWeight() {
		return this.weight;
	}

	@Override
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
}
