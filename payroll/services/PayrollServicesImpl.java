package com.cg.payroll.services;

import java.io.DataOutput;

import com.cg.payroll.beans.Associate;
import com.cg.payroll.beans.BankDetails;
import com.cg.payroll.beans.Salary;
import com.cg.payroll.daoservices.AssociateDAO;
import com.cg.payroll.daoservices.AssociateDAOImpl;
import com.cg.payroll.exceptions.AssociateDetailsNotFoundException;
import com.cg.payroll.exceptions.PayrollServicesDownException;

public class PayrollServicesImpl implements PayrollServices {
	
	private AssociateDAO associateDAO = new AssociateDAOImpl() ;

	@Override
	public int acceptAssociateDetails(String firstName, String lastName, String emailId, String department,
			String designation, String pancard, int yearlyInvestmentUnder80C, int basicSalary, int epf, int companyPf,
			int accountNumber, String bankName, String ifscCode) throws PayrollServicesDownException {
		Associate associate = new Associate(yearlyInvestmentUnder80C, firstName, lastName, department, designation, pancard, emailId, new BankDetails(accountNumber, bankName, ifscCode), new Salary(basicSalary, epf, companyPf)); 
		
		associate=associateDAO.save(associate);
		
		return associate.getAssociateID();
	}

	@Override
	public int calculateNetSalary(int associateId)
			throws AssociateDetailsNotFoundException, PayrollServicesDownException {
		Associate associate = associateDAO.findOne(associateId);
		if(associate==null) throw new AssociateDetailsNotFoundException("Associate Details Not Found");
		
		
		//tax calculation code
		return 0;
	}

	@Override
	public Associate getAssociateDetails(int associateId)
			throws AssociateDetailsNotFoundException, PayrollServicesDownException {
		Associate associate = associateDAO.findOne(associateId);
		if(associate==null) throw new AssociateDetailsNotFoundException("Associate Details Not Found");
		return associate;
	}

	@Override
	public Associate[] getAllAssociatesDetails() throws PayrollServicesDownException {
		return associateDAO.findAll();
	}
	
	
}
