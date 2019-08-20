package com.codingdojo.phone;

public class Galaxy extends Phone implements Ringable {
	public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
		super(versionNumber, batteryPercentage, carrier, ringTone);
	}

	@Override
	public String ring() {
		return this.getRingtone();
	}

	@Override
	public String unlock() {
		return "Unlock via finger print";
	}

	@Override
	public void displayInfo() {
		System.out.println(String.format("Galaxy %s from %s", this.getVersionNumber(), this.getCarrier()));
		
	}
}
