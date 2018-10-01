package com.cg.payroll.services;

import com.cg.payroll.beans.Associate;
import com.cg.payroll.beans.BankDetails;
import com.cg.payroll.beans.Salary;
import com.cg.payroll.daoservices.AssociateDAO;
import com.cg.payroll.daoservices.AssociateDAOImpl;
import com.cg.payroll.exception.AssociateDetailsNotFoundException;
import com.cg.payroll.exception.PayrollServicesDownException;

public class PayrollServicesImpl implements PayrollServices{
	
	private AssociateDAO associateDAO=new AssociateDAOImpl();

	@Override
	public int acceptAssociateDetails(String firstName, String lastName,
			String department, String designation, String panCard,
			String emailId, int yearlyInvestmentUnder80C, int basicSalary,
			int epf, int companyPf, int accountNumber, String bankName,
			String ifscCode) throws PayrollServicesDownException {
		Associate associate = new Associate(yearlyInvestmentUnder80C, firstName, lastName, department, designation, panCard, emailId,new BankDetails(accountNumber, bankName, ifscCode), new Salary(basicSalary, epf, companyPf));
		associate=associateDAO.save(associate);
		return associate.getAssociateId();
	}

	@Override
	public int calculateNetSalary(int associateId)
			throws AssociateDetailsNotFoundException,
			PayrollServicesDownException {
		
		Associate associate = associateDAO.findOne(associateId);
		if(associate==null) throw new AssociateDetailsNotFoundException("Associate Details Not Found");
		
		associate.getSalary().setHra((30*associate.getSalary().getBasicSalary())/100);
		associate.getSalary().setConveyenceAllowance((5*associate.getSalary().getBasicSalary())/100);
		associate.getSalary().setOtherAllowance((20*associate.getSalary().getBasicSalary())/100);
		associate.getSalary().setPersonalAllowance((25*associate.getSalary().getBasicSalary())/100);
		associate.getSalary().setGrossSalary(associate.getSalary().getBasicSalary()+associate.getSalary().getHra()+associate.getSalary().getConveyenceAllowance()+associate.getSalary().getOtherAllowance()+associate.getSalary().getPersonalAllowance());
		
		
		
		associate.getSalary().setMonthlyTax(((20*((associate.getSalary().getGrossSalary())*12))/100)/12);
		associate.getSalary().setNetSalary(associate.getSalary().getGrossSalary()-associate.getSalary().getMonthlyTax());
		
		
		
		
		
		
		
		if(associate.getSalary().getBasicSalary()<3)
		
		return 0;
	}

	@Override
	public Associate getAssociateDetails(int associateId)
			throws PayrollServicesDownException,
			AssociateDetailsNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Associate[] getAllAssociateDetails()
			throws PayrollServicesDownException {
		// TODO Auto-generated method stub
		return null;
	}

}
