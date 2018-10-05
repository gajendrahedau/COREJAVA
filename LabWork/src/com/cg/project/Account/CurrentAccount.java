package com.cg.project.Account;

public class CurrentAccount extends Account{
	private double overdraftLimit=30000;
	public void withdraw(double d){
		if(overdraftLimit<d)
			System.out.println("Overdraft Limit");
	}
}
