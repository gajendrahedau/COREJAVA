package com.cg.project.Account;

public class SavingAccount extends Account{
	private final double minimumBalance=500;
	
	public void withdraw(double balance){
		if(getBalance()>minimumBalance && (getBalance()-minimumBalance)>=balance)
			setBalance((getBalance()-balance));
	}
}
