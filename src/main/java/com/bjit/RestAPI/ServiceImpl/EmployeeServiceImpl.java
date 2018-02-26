package com.bjit.RestAPI.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjit.RestAPI.Repository.EmployeeRepository;
import com.bjit.RestAPI.Service.EmployeeService;
import com.bjit.RestAPI.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public List<Employee> employeeList() {
		return employeeRepository.findAll();
	}


	@Override
	public Employee addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}


	@Override
	public Employee findEmployee(Integer employeeId) {
		// TODO Auto-generated method stub
		return employeeRepository.findOne(employeeId);
	}

	
	

}