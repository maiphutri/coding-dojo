package com.codingdojo.bankaccount;

public class BankAccountTest {

	public static void main(String[] args) {
		BankAccount acc1 = new BankAccount();
		BankAccount acc2 = new BankAccount();
		acc2.depositChecking(200.00);
		acc1.depositChecking(100.00);
		acc2.withdraw(100.00);
		acc1.displayChecking();
		acc2.displayChecking();
		acc1.getTotalMoney();
		acc2.getTotalMoney();
		System.out.println(acc1.getAccountNum());
		System.out.println(acc2.getAccountNum());
	}

}
