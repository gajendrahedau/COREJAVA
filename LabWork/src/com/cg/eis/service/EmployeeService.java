package com.cg.eis.service;

import com.cg.eis.bean.Employee;

public interface EmployeeService {
	void getEmployeeDetails(int id,int salary,String name,String desig);
	Employee display();
	void insuranceScheme();
}
