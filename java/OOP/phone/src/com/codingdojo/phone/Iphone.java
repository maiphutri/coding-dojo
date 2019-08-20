package com.codingdojo.phone;

public class Iphone extends Phone implements Ringable {
	public Iphone (String versionNumber, int batteryPercentage, String carrier, String ringTone) {
		super(versionNumber, batteryPercentage, carrier, ringTone);
	}

	@Override
	public String ring() {
		return this.getRingtone();
	}

	@Override
	public String unlock() {
		return "Unlocking via facial recognition";
	}

	@Override
	public void displayInfo() {
		System.out.println(String.format("Iphone %s from %s", this.getVersionNumber(), this.getCarrier()));
		
	}
}
