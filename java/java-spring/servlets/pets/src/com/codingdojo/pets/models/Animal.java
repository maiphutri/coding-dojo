package com.codingdojo.pets.models;

public abstract class Animal implements Pet, java.io.Serializable {
	protected String name;
	protected String breed;
	protected double weight;
	
	abstract String getName();

	abstract void setName(String name);

	abstract String getBreed();

	abstract void setBreed(String breed);

	abstract double getWeight();

	abstract void setWeight(double weight);

	public Animal() {
		
	}

	public Animal(String name, String breed, double weight) {
		this.name = name;
		this.breed = breed;
		this.weight = weight;
	}
}
