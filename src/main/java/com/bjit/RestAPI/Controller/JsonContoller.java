package com.bjit.RestAPI.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bjit.RestAPI.Service.EmployeeService;
import com.bjit.RestAPI.model.Employee;
import com.bjit.RestAPI.util.ErrorUtils;

@Controller
public class JsonContoller {
	
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/list")
	@ResponseBody
	public List<Employee> getAllEmployee(){
		return employeeService.employeeList();
	}
	
	
	@RequestMapping("/")
	public String index(Model model){
		model.addAttribute("userClickHome", true);
		return "home";
	}
	
	
	@GetMapping("/form")
	public String createForm(@RequestParam int id, Model model) {
		
		
		model.addAttribute("employees",employeeService.employeeList());
		if(id==0) {
			
		model.addAttribute("employeeForm", new Employee());
		}
		else {
			
			model.addAttribute("employeeForm", employeeService.findEmployee(id));
		}
		model.addAttribute("userClickCreate",true);
		return "create";
	}
	
	@ResponseBody
	@PostMapping(value="/add", consumes =MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public String addEmployee(@Valid @RequestBody Employee employee,BindingResult result) {
		 
		if(result.hasErrors()) {
			 return ErrorUtils.customErrors(result.getAllErrors());
		 }else {
		 return employeeService.addEmployee(employee);
		 }
	}
	
	@RequestMapping(value= "/show")
	public ModelAndView showSingleProduct(@RequestParam int id){
		
		ModelAndView mv= new ModelAndView("home");
		Employee employee = employeeService.findEmployee(id);
		mv.addObject("title",employee.getEmployeeName());
		mv.addObject("userClickShowEmployee",true);
		mv.addObject("employee",employee);
		return mv;
	}
	
}
