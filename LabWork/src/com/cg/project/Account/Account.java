package com.cg.project.Account;
public class Account {
	private static long accountNumber=4387437384l;
	private long accNum;
	private  double balance=500;
	Person accHolder;
	public Account() {}
	public Account(double balance, Person accHolder) {
		super();
		this.accNum = accountNumber++;
		this.balance = balance;
		this.accHolder = accHolder;
	}
	public void deposit(double balance){
		this.balance+=balance;
	}
	public void withdraw(double balance){
		if(this.balance<balance) System.out.println("Your balance is not enough");
		this.balance-=balance;
	}
	public double getBalance() {
		return balance;
	}
	@Override
	public String toString() {
		return "Account [accNum=" + accNum + ", balance=" + balance
				+ ", accHolder=" + accHolder + "]";
	}
	public long getAccNum() {
		return accNum;
	}
	public void setAccNum(long accNum) {
		this.accNum = accNum;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Person getAccHolder() {
		return accHolder;
	}
	public void setAccHolder(Person accHolder) {
		this.accHolder = accHolder;
	}
	
}
