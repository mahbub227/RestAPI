package com.bjit.RestAPI.ServiceImpl;

import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
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
	public String addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		String message = null;
		JSONObject jsonObject = new JSONObject();
		try {
			if (employee.getEmployeeId() == null) {
				message = "  Added!";
			} else {
				message = "  Updated";
			}
			Employee emp = employeeRepository.save(employee);
			jsonObject.put("status", "success");
			jsonObject.put("title", message+ " Confirmation");
			jsonObject.put("message", emp.getEmployeeName() + message);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return jsonObject.toString();
	}

	@Override
	public Employee findEmployee(Integer employeeId) {
		// TODO Auto-generated method stub
		return employeeRepository.findOne(employeeId);
	}

}