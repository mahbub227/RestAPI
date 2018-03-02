package com.bjit.RestAPI.Service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bjit.RestAPI.Repository.EmployeeRepository;
import com.bjit.RestAPI.model.Employee;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {
	
	@Autowired
	private EmployeeService employeeService;
	private Employee employee;
	
	@Test
	public void shouldGetAllEmployee() {
		assertEquals("Something went wrong while fetching the list of products!",
				20,employeeService.employeeList().size());			
	}
	
	@Test
	public void shouldGetEmployeeById() throws Exception{
		Employee employee = employeeService.findEmployee(1);
		assertThat(employee.getEmployeeName(), equalTo("Shamsul Alam"));
	}
	
	 @Test
	 public void shouldSaveEmployee() {
		    Employee employee = employeeService.findEmployee(28);
		    employee.setEmployeeId(70);
			employee.setWorkMobile("465451119");
			employee.setEmployeeName("Shamim Khan");
			employee.setWorkAddress("bjitwoerk");
			employee.setWorkEmail("shamsulalam@bjit.com");
			employee.setWorkLocation("BJITLTD");
			employee.setWorkPhone("23424334111");
			employee.setIdentificationNo("345345345000");
			employee.setPassportNo("345345345000");
			employee.setBankAcNo("345345345000");
			employee.setWorkaAddress("454645611");
			employeeService.addEmployee(employee);
	 }

}
