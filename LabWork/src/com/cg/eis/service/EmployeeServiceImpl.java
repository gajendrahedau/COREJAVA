package com.cg.eis.service;

import com.cg.eis.bean.Employee;

public class EmployeeServiceImpl implements EmployeeService{
	Employee employee;
	@Override
	public void getEmployeeDetails(int id,int salary,String name,String designation) {
		employee=new Employee(id, salary, name, designation);
	}

	@Override
	public Employee display() {
		return employee;
	}
	@Override
	public void insuranceScheme() {
		if(employee.getSalary()>5000 && employee.getSalary()<20000  && employee.getDesignation().equalsIgnoreCase("system associate"))
			employee.setInsuranceScheme("Scheme C");
		else if(employee.getSalary()>=20000 && employee.getSalary()<40000 && employee.getDesignation().equalsIgnoreCase("programmera"))
			employee.setInsuranceScheme("Scheme B");
		else if(employee.getSalary()>=40000  && employee.getDesignation().equalsIgnoreCase("manager"))
			employee.setInsuranceScheme("Scheme A");
			else if(employee.getSalary()<5000 && employee.getDesignation().equalsIgnoreCase("clerk"))
			employee.setInsuranceScheme("No Scheme");
		
	}
}
