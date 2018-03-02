package com.bjit.RestAPI.Service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.bjit.RestAPI.model.Employee;

public interface EmployeeService {
	
	public List<Employee> employeeList();
	public String addEmployee(Employee employee);
	public Employee findEmployee(Integer employeeId);
	

}
