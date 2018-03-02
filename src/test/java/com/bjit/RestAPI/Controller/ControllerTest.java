package com.bjit.RestAPI.Controller;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import com.bjit.RestAPI.Service.EmployeeService;
import com.bjit.RestAPI.model.Employee;

@RunWith(MockitoJUnitRunner.class) 
public class ControllerTest {
	@Mock
	EmployeeService employeeService;
	
	@Mock
	ModelAndView modelMock;
	
	@Mock
	Model model;
	
	@Mock
	Employee employee;
	
	@Mock
	BindingResult result;
	
	
	MockMvc mockMvc;
	
	List<Employee> employeeList = new ArrayList<Employee>();
	
	@InjectMocks
   JsonContoller jsonController;
    
	@Before
    public void setUp() {
	mockMvc = MockMvcBuilders
		.standaloneSetup(jsonController)
		.build();
	employee.setEmployeeId(100);
	employee.setWorkMobile("46545649");
	employee.setEmployeeName("Shamim Khan");
	employee.setWorkAddress("342343423bjit");
	employee.setWorkEmail("m.alam.ok@bjit.com");
	employee.setWorkLocation("4564569");
	employee.setWorkPhone("23424334539");
	employee.setIdentificationNo("345345345349");
	employee.setPassportNo("345345345349");
	employee.setBankAcNo("345345345349");
	long time = System.currentTimeMillis();
	java.sql.Date date = new java.sql.Date(time);
	employee.setDateOfBirth(date);	
	employee.setWorkaAddress("45464569");
    }
	
	

	@Test
	public void testIndex() throws Exception {
			
			assertNotNull(jsonController.index(model));		
			mockMvc.perform(get("/")).andExpect(status().isOk());      
		
	}
	
	@Test
	public void testAllEmployeeList() throws Exception {
			assertNotNull(jsonController.getAllEmployee());
			when(jsonController.getAllEmployee()).thenReturn(employeeList);
			mockMvc.perform(get("/list")).andExpect(status().isOk());
	}
	
	
	@Test
	public void testAddEmployee() throws Exception {
			assertNotNull(jsonController.addEmployee(employee, result));
			//when(jsonController.getAllEmployee()).thenReturn(employee);
			//mockMvc.perform(post("/add")).andExpect(status().isOk());
		
	}
	
	
	
	
	/*@Test
	public void testshowSingleEmployee() throws IOException {
		
			assertNotNull(jsonController.showSingleEmployee((int) 1));		
		
	}*/

}