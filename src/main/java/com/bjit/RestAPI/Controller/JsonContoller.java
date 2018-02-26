package com.bjit.RestAPI.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bjit.RestAPI.Service.EmployeeService;
import com.bjit.RestAPI.model.Employee;

@RestController
public class JsonContoller {
	
	@Autowired
	EmployeeService employeeService;
	@ResponseBody
	@RequestMapping("/employee/list")
	public List<Employee>getAllEmployee(){
		return employeeService.employeeList();
	}
	
}
