package com.codingdojo.objectmaster;

public class HumanTest {

	public static void main(String[] args) {
		Ninja ninja = new Ninja();
		Wizard wizard = new Wizard();
		Samurai s1 = new Samurai();
		Samurai s2 = new Samurai();
		Samurai s3 = new Samurai();
		s1.getHealth();
		s2.getHealth();
		wizard.getHealth();
		ninja.getHealth();
		wizard.fireball(s1);
		s1.getHealth();
		wizard.heal(s1);
		s1.getHealth();
		s1.howMany();
		s1.deathBlow(s2);
		s2.getHealth();
		s2.meditate();
		s2.getHealth();
	}

}
