package com.bjit.RestAPI.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bjit.RestAPI.Service.EmployeeService;
import com.bjit.RestAPI.model.Employee;

@Controller
public class JsonContoller {
	
	@Autowired
	EmployeeService employeeService;
	
	

	@RequestMapping("/list")
	public String getAllEmployee(Model model){
		model.addAttribute("employees",employeeService.employeeList());
		model.addAttribute("userClickHome",true);
		return "home";
	}
	
	
	
	@RequestMapping("/list/{id}")
	public Employee findOne(@PathVariable int id){
		return employeeService.findEmployee(id);
	}
	
	@GetMapping("/{id}")
	public String editEmployee(@PathVariable int id, Model model) {
		model.addAttribute("employeeForm", employeeService.findEmployee(id));
		model.addAttribute("userClickCreate",true);
		return "home";
	}
	
	@GetMapping("/form")
	public String createForm(Model model) {
		model.addAttribute("employeeForm", new Employee());
		model.addAttribute("userClickCreate",true);
		model.addAttribute("employees",employeeService.employeeList());
		return "home";
	}
	
	@PostMapping("/add")
	public String addEmployee(@ModelAttribute Employee employee,Model model) {
		model.addAttribute("message",employeeService.addEmployee(employee).getEmployeeName());
		 return "redirect:" + "/list";
	}
	
}
