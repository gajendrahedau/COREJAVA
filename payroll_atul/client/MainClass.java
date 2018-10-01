package com.cg.payroll.client;

import com.cg.payroll.beans.Associate;
import com.cg.payroll.beans.BankDetails;
import com.cg.payroll.beans.Salary;

public class MainClass {
	
	public static void main(String[] args) {
		Associate associate=new Associate(101, 1500000, "Atul", "Anand", "NFS", "Sr. Analyst", "ANX6711X", "atul@gmail.com", 
				new BankDetails(500161, "SBI", "SB0001"), new Salary(35000, 1000, 1000));
		associate.getSalary().setHra((30*associate.getSalary().getBasicSalary())/100);
		associate.getSalary().setConveyenceAllowance((5*associate.getSalary().getBasicSalary())/100);
		associate.getSalary().setOtherAllowance((20*associate.getSalary().getBasicSalary())/100);
		associate.getSalary().setPersonalAllowance((25*associate.getSalary().getBasicSalary())/100);
		associate.getSalary().setGrossSalary(associate.getSalary().getBasicSalary()+associate.getSalary().getHra()+associate.getSalary().getConveyenceAllowance()+associate.getSalary().getOtherAllowance()+associate.getSalary().getPersonalAllowance());
		associate.getSalary().setMonthlyTax(((20*((associate.getSalary().getGrossSalary())*12))/100)/12);
		associate.getSalary().setNetSalary(associate.getSalary().getGrossSalary()-associate.getSalary().getMonthlyTax());
		
		System.out.println(associate.getSalary());
	
	
	
	
	}
}
