package com.bjit.RestAPI.Repository;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.sql.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bjit.RestAPI.model.Employee;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RepositoryTest {
	@Autowired
	private EmployeeRepository employeeRepository;
	private Employee employee;
	
	@Test
	public void shouldGetEmployeeById() throws Exception{
		Employee employee = employeeRepository.findOne(1);
		assertThat(employee.getEmployeeName(), equalTo("Shamsul Alam"));
	}

	@Test
	public void shouldGetAllEmployee() {
//		List<Employee> employeeList = employeeRepository.findAll();
//		assertThat(employeeList.get(3).getEmployeeId(), equalTo(7));
		assertEquals("Something went wrong while fetching the list of products!",
				20,employeeRepository.findAll().size());			
	}
	
	 @Test
	 public void shouldUpdateEmployee() {
		    Employee employee = employeeRepository.findOne(28);
		    employee.setEmployeeName("Touhid Hasan");
			employeeRepository.save(employee);	
	 }
//	
//	@Test
//	public void testCRUDProduct() {
//		employee.setEmployeeId(100);
//		employee.setWorkMobile("46545649");
//		employee.setEmployeeName("Shamim Khan");
//		employee.setWorkAddress("342343423bjit");
//		employee.setWorkEmail("m.alam.ok@bjit.com");
//		employee.setWorkLocation("4564569");
//		employee.setWorkPhone("23424334539");
//		employee.setIdentificationNo("345345345349");
//		employee.setPassportNo("345345345349");
//		employee.setBankAcNo("345345345349");
//		long time = System.currentTimeMillis();
//		java.sql.Date date = new java.sql.Date(time);
//		employee.setDateOfBirth(date);	
//		employee.setWorkaAddress("45464569");
//		
//		assertEquals("Something went wrong while inserting a new product!",
//				true,employeeService.addEmployee(employee));		
//		
//		
//		
//	}
}


