package com.dxc.cs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.dxc.cs.entity.Department;
import com.dxc.cs.entity.Employee;
import com.dxc.cs.exception.EmployeeException;
import com.dxc.cs.repository.EmployeeRepository;
import com.dxc.cs.service.EmployeeService;
import com.dxc.cs.service.EmployeeServiceImpl;

@SpringJUnitConfig
public class EmployeeServiceImplUnitTest {

	@TestConfiguration
	static class EmployeeServiceImplTestContextConfiguration {

		@Bean
		public EmployeeService employeeService() {
			return new EmployeeServiceImpl();
		}
	}

	@MockBean
	private EmployeeRepository employeeRepository;

    @Autowired
	private EmployeeService employeeService;

	private Employee[] testEmployees;

	private List<Department> deptList;

	@BeforeEach
	public void fillTestData() {
		deptList = new ArrayList<>();
		deptList.add(new Department(121, "GLIC"));

		testEmployees = new Employee[] {

				new Employee(890, "Pratik Kashyap", "male", 9800, deptList),
				new Employee(990, "Pratik Kashyap", "male", 900, deptList),

		};

	}

	@AfterEach
	public void clearDatabase() {
		testEmployees = null;
	}

	@Test
	public void addTest() throws EmployeeException  {

		Mockito.when(employeeRepository.save(Mockito.any(Employee.class))).thenReturn(null);

		Mockito.when(employeeRepository.existsById(testEmployees[0].getEmpId())).thenReturn(false);

		try {
			Employee actual = employeeService.addEmployee(testEmployees[0]);
			Assertions.assertEquals(testEmployees[0], actual);
		} catch (EmployeeException e) {
			Assertions.fail(e.getMessage());
		}
	}
	
	  @Test public void addExistingEmployeeTest() throws EmployeeException{
	  Mockito.when(employeeRepository.save(Mockito.any(Employee.class))).thenReturn
	  (null);
	  
	  Mockito.when(employeeRepository.existsById(testEmployees[0].getEmpId())).
	  thenReturn(true);
	  
	  Assertions.assertThrows(EmployeeException.class, () -> {
	  employeeService.addEmployee(testEmployees[0]); });
	 
	 }
	 
	

	
	@Test
	public void getByIdExisitngRecordTest() {
		Mockito.when(employeeRepository.findById(testEmployees[0].getEmpId()))
				.thenReturn(Optional.of(testEmployees[0]));
		Assertions.assertEquals(testEmployees[0], employeeService.getById(testEmployees[0].getEmpId()));
	}

	@Test
	public void getByIdNonExisitngRecordTest() {
		Mockito.when(employeeRepository.findById(testEmployees[0].getEmpId())).thenReturn(Optional.empty());
		Assertions.assertNull(employeeService.getById(testEmployees[0].getEmpId()));
	}

	@Test
	public void getAllItemsWhenDataExists() throws EmployeeException {
		List<Employee> expected = Arrays.asList(testEmployees);

		Mockito.when(employeeRepository.findAll()).thenReturn(expected);

		Assertions.assertEquals(expected, employeeService.getAllEmployees());
	}

	@Test
	public void getAllItemsWhenNoDataExists() throws EmployeeException {
		List<Employee> expected = new ArrayList<>();

		Mockito.when(employeeRepository.findAll()).thenReturn(expected);

		Assertions.assertEquals(expected, employeeService.getAllEmployees());
	}
	@Test
	public void deleteByIdExistingRecordTest() throws EmployeeException{
		Mockito.when(employeeRepository.existsById(Mockito.isA(Integer.class))).thenReturn(true);

		Mockito.doNothing().when(employeeRepository).deleteById(Mockito.isA(Integer.class));

		try {
			Assertions.assertTrue(employeeService.deleteEmployee(testEmployees[0].getEmpId()));
		} catch (EmployeeException e) {
			Assertions.fail(e.getLocalizedMessage());
		}
	}

	@Test
	public void deleteByIdNonExistingRecordTest() throws EmployeeException {
		Mockito.when(employeeRepository.existsById(Mockito.isA(Integer.class))).thenReturn(false);

		Mockito.doNothing().when(employeeRepository).deleteById(Mockito.isA(Integer.class));

		Assertions.assertThrows(EmployeeException.class, () -> {
			employeeService.deleteEmployee(testEmployees[0].getEmpId());
		});

	}

}
