package com.codingdojo.pets.models;

public class Cat extends Animal {
	public Cat() {
		
	}
	
	public Cat(String name, String breed, double weight) {
		super(name, breed, weight);
	}

	@Override
	public String showAffection() {
		return " looked at you with some affection. You think.";
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
