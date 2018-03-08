package com.bjit.RestAPI.Controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.codehaus.jettison.json.JSONObject;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.bjit.RestAPI.RestApiApplication;
import com.bjit.RestAPI.Service.EmployeeService;
import com.bjit.RestAPI.model.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestApiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTesting {
	

	@Autowired
	private TestRestTemplate testRestTemplate;
	private HttpHeaders headers = new HttpHeaders();
	@LocalServerPort
	private int port;
	@Mock
	EmployeeService employeeService;
	@Autowired
	static private Employee employee;
	
	private MockMvc mockMvc;
	@Autowired JsonContoller jsonController;
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(jsonController).build();
	}
	
	@BeforeClass
	public static void initilizeApplicationList(){
		Employee employee = new Employee();
		employee.setWorkMobile("46545600");
		employee.setEmployeeName("Shamim Khan");
		employee.setWorkAddress("342343423bj00");
		employee.setWorkEmail("m.ala@bjit.com");
		employee.setWorkLocation("4564500");
		employee.setWorkPhone("23424334500");
		employee.setIdentificationNo("345345345300");
		employee.setPassportNo("345345345300");
		employee.setBankAcNo("345345345300");
		SimpleDateFormat sdf = new SimpleDateFormat(
			    "MM-dd-yyyy");
			int year = 2014;
			int month = 10;
			int day = 31;
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR, year);
			cal.set(Calendar.MONTH, month - 1);
			cal.set(Calendar.DAY_OF_MONTH, day);

			java.sql.Date date = new java.sql.Date(cal.getTimeInMillis());
			employee.setDateOfBirth(date);
		employee.setWorkaAddress("45464500");
	
	}
	
//	@Test
//	public void testUpdate() throws Exception{
//		when(employeeService.employeeList()).thenReturn(empList);
//		when(employeeService.findEmployee(1)).thenReturn(emp);
//		mockMvc.perform(get("/form?id=1").accept(MediaType.APPLICATION_JSON))
//		.andExpect(view().name("create"))
//        .andExpect(model().attributeExists("userClickCreate"))
//        .andExpect(model().attribute("userClickCreate", is(true)))
//        .andExpect(model().attributeExists("employees"))
//        .andExpect(model().attribute("employees", is(empList)))
//        .andExpect(model().attributeExists("employeeForm"))
//        .andExpect(model().attribute("employeeForm", is(emp)))
//		.andDo(MockMvcResultHandlers.print());
//	}

	@Test
	public void myTestList () throws Exception {
		mockMvc.perform(get("/list"))
	        .andExpect(status().isOk())
	        .andDo(print());
	}
	
	@Test
	public void myAdd () throws Exception {
		String message = null;
		String leave = null;
		JSONObject jsonObject = new JSONObject();
		message = "  Added!";jsonObject.put("status", "success");
		jsonObject.put("title", message+ " Confirmation");
		jsonObject.put("message", employee.getEmployeeName() + message);
		leave = jsonObject.toString();
		when(employeeService.addEmployee(employee)).thenReturn(leave);
		mockMvc.perform(post("/add"))
	        .andExpect(status().isOk())
	        .andDo(print());
	}
	
	@Test
	public void testCreateLeave() throws Exception {

		String URIToCreateLeave = "/add";
		System.out.println(formFullURLWithPort(URIToCreateLeave));
		//when(leaveServices.save(leave)).thenReturn(leave);
		String inputInJson = this.mapToJson(employee);

		HttpEntity<Employee> entity = new HttpEntity<Employee>(employee, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(formFullURLWithPort(URIToCreateLeave),
				HttpMethod.POST, entity, String.class);
		
		String responseInJson = response.getBody();
		//System.out.println(responseInJson);
		//assertTrue(responseInJson.contains("true"));
		

	}
	
	@Test
	public void testShowEmployee() throws Exception {
		when(employeeService.findEmployee(1)).thenReturn(employee);
		
		mockMvc.perform(get("/show?id=1").accept(MediaType.APPLICATION_JSON))
		.andExpect(view().name("home"))
		.andDo(MockMvcResultHandlers.print());
	}
	
	


	
	
	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}
	
	private String formFullURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

	
	
}
