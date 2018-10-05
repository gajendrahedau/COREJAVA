package com.cg.project.Account;
public class MainClass {
	public static void main(String[] args) {
		Account account1=new Account(2000, new Person("Smith", 30));
		Account account2=new Account(3000, new Person("Kathy", 35));
		System.out.println(account1);
		System.out.println(account2);
		account1.deposit(2000);
		account2.withdraw(2000);
		System.out.println("Updated Account-");
		System.out.println(account1);
		System.out.println(account2);
		
	}
}
