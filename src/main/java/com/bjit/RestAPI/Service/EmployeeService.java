package com.bjit.RestAPI.Service;

import java.util.List;

import com.bjit.RestAPI.model.Employee;

public interface EmployeeService {
	
	public List<Employee> employeeList();
	public String addEmployee(Employee employee);
	public Employee findEmployee(Integer employeeId);
	
}
