package com.cg.payroll.services;

import com.cg.payroll.beans.Associate;
import com.cg.payroll.beans.BankDetails;
import com.cg.payroll.beans.Salary;
import com.cg.payroll.daoservices.AssociateDAO;
import com.cg.payroll.daoservices.AssociateDAOImpl;
import com.cg.payroll.exceptions.AssociateDetailsNotFoundException;
import com.cg.payroll.exceptions.PayrollServicesDownException;

public class PayrollServicesImpl implements PayrollServices{
	
	
	private AssociateDAO associateDAO=new AssociateDAOImpl();
	
	@Override
	public int acceptAssociateDetails(int yearlyInvestmentUnder80C,
			String firstName, String lastName, String department,
			String designation, String pancard, String emailId,
			int basicSalary, int epf, int companyPf, long accountNumber,
			String bankName, String ifscCode)
			throws PayrollServicesDownException {
			
			Associate associate=new Associate(yearlyInvestmentUnder80C, firstName, lastName, department, designation, pancard, emailId, new BankDetails(accountNumber, bankName, ifscCode),new Salary(basicSalary, epf, companyPf));
			
			associate=associateDAO.save(associate);
			
			return associate.getAssociateID();
	}

	@Override
	public int calculateNetSalary(int associateId)
			throws AssociateDetailsNotFoundException,
			PayrollServicesDownException {
			Associate associate=getAssociateDetails(associateId);
			int baiscSalary=associate.getSalary().getBasicSalary();
			int companyPf=associate.getSalary().getCompanyPf();
			int epf=associate.getSalary().getEpf();
			
			
			associate.getSalary().setHra((30*associate.getSalary().getBasicSalary())/100);
			associate.getSalary().setOtherAllowance((20*associate.getSalary().getBasicSalary())/100);
			associate.getSalary().setPersonalAllowance((25*associate.getSalary().getBasicSalary())/100);
			associate.getSalary().setConveyenceAllowance((15*associate.getSalary().getBasicSalary())/100);
			associate.getSalary().setGrossSalary((associate.getSalary().getBasicSalary())+(associate.getSalary().getHra())+(associate.getSalary().getConveyenceAllowance())+(associate.getSalary().getPersonalAllowance())+(associate.getSalary().getOtherAllowance()));
			
			//System.out.println("\n"+Associate.getASSOCIATE_COUNTER()+"\n");
			
			//int annualSalary=(associate.getSalary().getGrossSalary()*12);
			
			
			
			System.out.println("Basic Salary : "+associate.getSalary().getBasicSalary());
			System.out.println("Personal Allowance : "+associate.getSalary().getPersonalAllowance());
			System.out.println("HRA : "+associate.getSalary().getHra());
			System.out.println("OtherAllowance : "+associate.getSalary().getOtherAllowance());
			System.out.println("Conveyence Allowance : "+associate.getSalary().getConveyenceAllowance());
			System.out.println("Gross Salary : "+associate.getSalary().getGrossSalary());
		
			
			associate.getSalary().setNetSalary(associate.getSalary().getGrossSalary());
			
			int salaryPerAnnum=(associate.getSalary().getGrossSalary()*12);
			if(salaryPerAnnum<=250000){
				associate.getSalary().setMonthlyTax(0);
			}
			else if(salaryPerAnnum>250000 && salaryPerAnnum<=500000)
				associate.getSalary().setMonthlyTax((10*(associate.getSalary().getGrossSalary()-250000))/(100*12));
				else if(salaryPerAnnum>500000 && salaryPerAnnum<=1000000){
					int till5=25000;
					int till10=(20*(1000000-associate.getSalary().getBasicSalary()))/100;
					associate.getSalary().setMonthlyTax((till5+till10)/12);
				}
					
			
			associate.getSalary().setNetSalary((associate.getSalary().getBasicSalary())-(associate.getSalary().getMonthlyTax()));
		return associate.getSalary().getNetSalary();
	}

	@Override
	public Associate getAssociateDetails(int associateId)
			throws PayrollServicesDownException,
			AssociateDetailsNotFoundException {
		Associate associate=associateDAO.findOne(associateId);
		if(associate==null) throw new AssociateDetailsNotFoundException("Associate Details not found");
		return associate;
	}

	@Override
	public Associate[] getAllAssociateDetails()
			throws PayrollServicesDownException {
		return associateDAO.findAll();
	}

}
