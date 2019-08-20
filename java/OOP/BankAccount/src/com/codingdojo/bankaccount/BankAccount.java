package com.codingdojo.bankaccount;
import java.util.Random;

public class BankAccount {
	private String accountNum;
	private double checking;
	private double saving;
	private static int totalAccounts;
	
	public BankAccount() {
		this.checking = 0.00;
		this.saving = 0.00;
		this.accountNum =  getRandNum();
		totalAccounts++;
	}
	
	public String getAccountNum() {
		return accountNum;
	}

	public void displayChecking() {
		System.out.println(this.checking);
	}

	public void depositChecking(double checking) {
		this.checking += checking;
	}

	public void displaySaving() {
		System.out.println(this.saving);
	}

	public void depositSaving(double saving) {
		this.saving += saving;
	}
	
	public void withdraw(double amount) {
		if (amount > this.checking) {
			System.out.println("Insufficent funds to withdraw");
		} else {
			this.checking -= amount;
		}
	}

	private static String getRandNum() {
		String result = "";
		Random r = new Random();
		for (int i=0; i < 10; i++) {
			int rand = r.nextInt(10);
			result += Integer.toString(rand);
		}
		return result;
	}
	

	public void getTotalMoney() {
		System.out.println(this.checking + this.saving);
	}
	
	public static void getTotalAccount() {
		System.out.println(totalAccounts);
	}
	
}
