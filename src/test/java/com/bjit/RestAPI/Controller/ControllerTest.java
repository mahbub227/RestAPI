package com.bjit.RestAPI.Controller;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jettison.json.JSONObject;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.bjit.RestAPI.Service.EmployeeService;
import com.bjit.RestAPI.model.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(MockitoJUnitRunner.class)
public class ControllerTest {
	@Mock
	EmployeeService employeeService;
	
	MockMvc mockMvc;
	
	static private Employee employee;
	static private Employee emp = new Employee();
	private static List<Employee> empList= new ArrayList<Employee>();
	
	@InjectMocks
	JsonContoller jsonController;
	
	

	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(jsonController).build();
	}
	
	
	 @Test
     public void testHomePage() throws Exception{
            this.mockMvc.perform(get("/"))
                 .andExpect(status().isOk())
                 .andExpect(view().name("home"))
                 .andDo(print());
     }
	 
	 @Test
     public void testInputPage() throws Exception{
            this.mockMvc.perform(get("/show?id=+{employeeId}",0))
                 .andExpect(status().isOk())
                 .andExpect(view().name("create"))
                 .andDo(print());
     }
	
	
	@BeforeClass
	public static void initilizeApplicationList(){
		
		emp.setEmployeeId(1);
		emp.setWorkMobile("46545649");
		emp.setEmployeeName("Shamim Khan");
		emp.setWorkAddress("342343423bjit");
		emp.setWorkEmail("m.alam.ok@bjit.com");
		emp.setWorkLocation("4564569");
		emp.setWorkPhone("23424334539");
		emp.setIdentificationNo("345345345349");
		emp.setPassportNo("345345345349");
		emp.setBankAcNo("345345345349");
		
		emp.setWorkaAddress("45464569");
		empList.add(emp);
	}
	
	@Test
	public void shouldGetList() throws Exception {
		
	when(employeeService.employeeList()).thenReturn(empList);
		mockMvc.perform(get("/list").accept(MediaType.APPLICATION_JSON)).andDo(MockMvcResultHandlers.print());
	}
	
	
	
	@Test
	public void testShowEmployee() throws Exception {
		when(employeeService.findEmployee(1)).thenReturn(emp);
		
		mockMvc.perform(get("/show?id=1").accept(MediaType.APPLICATION_JSON))
		.andExpect(view().name("home"))
		.andExpect(model().attributeExists("title"))
        .andExpect(model().attribute("title", is(emp.getEmployeeName())))
        .andExpect(model().attributeExists("userClickShowEmployee"))
        .andExpect(model().attribute("userClickShowEmployee", is(true)))
        .andExpect(model().attributeExists("employee"))
        .andExpect(model().attribute("employee", is(emp)))
		.andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void testShowList() throws Exception{
		when(employeeService.employeeList()).thenReturn(empList);
		mockMvc.perform(get("/").accept(MediaType.APPLICATION_JSON))
		.andExpect(view().name("home"))
		.andExpect(model().attributeExists("userClickHome"))
        .andExpect(model().attribute("userClickHome", is(true)));
	}
	
	@Test
	public void testCreateNew() throws Exception{
		when(employeeService.employeeList()).thenReturn(empList);
		mockMvc.perform(get("/form?id=0").accept(MediaType.APPLICATION_JSON))
		.andExpect(view().name("create"))
		.andExpect(model().attributeExists("employees"))
        .andExpect(model().attribute("employees", is(empList)))
        .andExpect(model().attributeExists("userClickCreate"))
        .andExpect(model().attribute("userClickCreate", is(true)))
		.andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void testUpdate() throws Exception{
		when(employeeService.employeeList()).thenReturn(empList);
		when(employeeService.findEmployee(1)).thenReturn(emp);
		mockMvc.perform(get("/form?id=1").accept(MediaType.APPLICATION_JSON))
		.andExpect(view().name("create"))
        .andExpect(model().attributeExists("userClickCreate"))
        .andExpect(model().attribute("userClickCreate", is(true)))
        .andExpect(model().attributeExists("employees"))
        .andExpect(model().attribute("employees", is(empList)))
        .andExpect(model().attributeExists("employeeForm"))
        .andExpect(model().attribute("employeeForm", is(emp)))
		.andDo(MockMvcResultHandlers.print());
	}
	
	
	
	
	@Test
	public void testAdd() throws Exception {

		String message = null;
		String leave = null;
		JSONObject jsonObject = new JSONObject();
		message = "  Added!";jsonObject.put("status", "success");
		jsonObject.put("title", message+ " Confirmation");
		jsonObject.put("message", emp.getEmployeeName() + message);
		leave = jsonObject.toString();
		String json = mapToJson(emp);
		System.out.println("json="+json);
		

		System.out.println();
		System.out.println(leave);
		Mockito.when(employeeService.addEmployee(Mockito.any(Employee.class))).thenReturn(leave);
		//when(employeeServices.findById(4)).thenReturn(employee);
		mockMvc.perform(
				post("/add")
						.accept(MediaType.APPLICATION_JSON_VALUE).content(json)
						.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andDo(MockMvcResultHandlers.print())
				.andReturn();
		// verify(leaveServices,times(1)).save(leave);
	}
	
	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}
	
	
	
	
}