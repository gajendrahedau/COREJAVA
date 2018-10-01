package com.cg.payroll.client;

import com.cg.payroll.beans.Associate;
import com.cg.payroll.beans.BankDetails;
import com.cg.payroll.beans.Salary;
import com.cg.payroll.exceptions.AssociateDetailsNotFoundException;
import com.cg.payroll.exceptions.PayrollServicesDownException;
import com.cg.payroll.services.PayrollServices;
import com.cg.payroll.services.PayrollServicesImpl;

public class MainClass {

	public static void main(String[] args) {
		
		
		PayrollServices payrollServices=new PayrollServicesImpl();
		try {
			payrollServices.acceptAssociateDetails(15000, "Gajendra", "Hedau", "ADM", "Sr. Analyst", "ADGMK5776G", "gaj@gmail.com", 15000, 1200, 1200, 1276834654l, "HDFC", "HDFC00076");
		} catch (PayrollServicesDownException e) {
			e.printStackTrace();
			System.out.println("Payroll Services has down");
		}
		try {
			System.out.println("Net Salary"+payrollServices.calculateNetSalary(101));
		} catch (AssociateDetailsNotFoundException
				| PayrollServicesDownException e) {
			e.printStackTrace();
			System.out.println("Associate Detail Not Found");

		}
		
		try {
			payrollServices.getAssociateDetails(101);
		} catch (PayrollServicesDownException e) {
			System.out.println("Payroll Services has down");
			e.printStackTrace();
		} catch (AssociateDetailsNotFoundException e) {
			System.out.println("Associate Detail Not Found");
			e.printStackTrace();
		}
		
		try {
			payrollServices.getAllAssociateDetails();
		} catch (PayrollServicesDownException e) {
			System.out.println("Payroll Services has down");
			e.printStackTrace();
		}
		
		/*int num=100;
		Associate associate=new Associate(101, 1500, "Gajendra", "Hedau", "ADM", "Sr. COn", "HAGFD23454", "gaj@gmail.com", new BankDetails(12345678906l, "SBI", "SBI00954"), new Salary(20000));		
		
		BankDetails bankDetails1=new BankDetails(7024556677l, "SBI", "SBI00786");
		BankDetails bankDetails2=new BankDetails(4033587343l, "HDFC", "HDFC8657");
		BankDetails bankDetails3=new BankDetails(9098657438l, "AXIS", "AXIS98712");
		System.out.println("accountNumber : "+bankDetails1.getAccountNumber()+"\n"+"bankName : "+bankDetails1.getBankName());
		
		Salary salary1=new Salary(15000, 2000, 5000, 3000, 1000, 600, 500, 500, 5000, 500000, 450000);
		System.out.println("basicSalary :"+salary1.getBasicSalary());
	
		
		associate.getSalary().setHra((30*associate.getSalary().getBasicSalary())/100);
		associate.getSalary().setOtherAllowance((20*associate.getSalary().getBasicSalary())/100);
		associate.getSalary().setPersonalAllowance((25*associate.getSalary().getBasicSalary())/100);
		associate.getSalary().setConveyenceAllowance((15*associate.getSalary().getBasicSalary())/100);
		associate.getSalary().setGrossSalary((associate.getSalary().getBasicSalary())+(associate.getSalary().getHra())+(associate.getSalary().getConveyenceAllowance())+(associate.getSalary().getPersonalAllowance())+(associate.getSalary().getOtherAllowance()));
		System.out.println("\n"+Associate.getASSOCIATE_COUNTER()+"\n");
		
		
		
		System.out.println("Basic Salary : "+associate.getSalary().getBasicSalary());
		System.out.println("Personal Allowance : "+associate.getSalary().getPersonalAllowance());
		System.out.println("HRA : "+associate.getSalary().getHra());
		System.out.println("OtherAllowance : "+associate.getSalary().getOtherAllowance());
		System.out.println("Conveyence Allowance : "+associate.getSalary().getConveyenceAllowance());
		System.out.println("Gross Salary : "+associate.getSalary().getGrossSalary());
	
		
		associate.getSalary().setNetSalary(associate.getSalary().getGrossSalary());
		
		int salaryPerAnnum=(associate.getSalary().getGrossSalary()*12);
		if(salaryPerAnnum<300000){
			associate.getSalary().setMonthlyTax(0);
		}
		else if(salaryPerAnnum>=30000 && salaryPerAnnum<500000){
			associate.getSalary().setMonthlyTax((10*(associate.getSalary().getGrossSalary()-300000))/100);
		}*/
	}
}


