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
import com.dxc.cs.exception.EmployeeException;
import com.dxc.cs.repository.DepartmentRepository;
import com.dxc.cs.service.DepartmentService;
import com.dxc.cs.service.DepartmentServiceImpl;


@SpringJUnitConfig
public class DepartmentServiceImplUnitTest {

	@TestConfiguration
	static class DepartmentServiceImplTestContextConfiguration {

		@Bean
		public DepartmentService departmentService() {
			return new DepartmentServiceImpl();
		}
	}

	@MockBean
	private DepartmentRepository departmentRepository;

    @Autowired
	private DepartmentService departmentService;

	private Department[] testDepartment;


	@BeforeEach
	public void fillTestData() {

		testDepartment = new Department[] {

				new Department(232, "GLIC"),
				new Department(910, "ZURIC"),

		};

	}

	@AfterEach
	public void clearDatabase() {
		testDepartment = null;
	}

	@Test
	public void addTest() throws EmployeeException  {

		Mockito.when(departmentRepository.save(Mockito.any(Department.class))).thenReturn(null);

		Mockito.when(departmentRepository.existsById(testDepartment[0].getDeptNo())).thenReturn(false);

		try {
			Department actual = departmentService.addDepartment(testDepartment[0]);
			Assertions.assertEquals(testDepartment[0], actual);
		} catch (EmployeeException e) {
			Assertions.fail(e.getMessage());
		}
	}
	
	  @Test public void addExistingEmployeeTest() throws EmployeeException{
	  Mockito.when(departmentRepository.save(Mockito.any(Department.class))).thenReturn
	  (null);
	  
	  Mockito.when(departmentRepository.existsById(testDepartment[0].getDeptNo())).
	  thenReturn(true);
	  
	  Assertions.assertThrows(EmployeeException.class, () -> {
	  departmentService.addDepartment(testDepartment[0]); });
	 
	 }
	 
	

	
	@Test
	public void getByIdExisitngRecordTest() throws EmployeeException {
		Mockito.when(departmentRepository.findById(testDepartment[0].getDeptNo()))
				.thenReturn(Optional.of(testDepartment[0]));
		Assertions.assertEquals(testDepartment[0], departmentService.getByDeptId(testDepartment[0].getDeptNo()));
	}

	@Test
	public void getByIdNonExisitngRecordTest() throws EmployeeException{
		Mockito.when(departmentRepository.findById(testDepartment[0].getDeptNo())).thenReturn(Optional.empty());
		Assertions.assertNull(departmentService.getByDeptId(testDepartment[0].getDeptNo()));
	}

	@Test
	public void getAllItemsWhenDataExists() throws EmployeeException {
		List<Department> expected = Arrays.asList(testDepartment);

		Mockito.when(departmentRepository.findAll()).thenReturn(expected);

		Assertions.assertEquals(expected, departmentService.getAllDepartments());
	}

	@Test
	public void getAllItemsWhenNoDataExists() throws EmployeeException {
		List<Department> expected = new ArrayList<>();

		Mockito.when(departmentRepository.findAll()).thenReturn(expected);

		Assertions.assertEquals(expected, departmentService.getAllDepartments());
	}
	@Test
	public void deleteByIdExistingRecordTest() throws EmployeeException{
		Mockito.when(departmentRepository.existsById(Mockito.isA(Integer.class))).thenReturn(true);

		Mockito.doNothing().when(departmentRepository).deleteById(Mockito.isA(Integer.class));

		try {
			Assertions.assertTrue(departmentService.deleteDepartment(testDepartment[0].getDeptNo()));
		} catch (EmployeeException e) {
			Assertions.fail(e.getLocalizedMessage());
		}
	}

	@Test
	public void deleteByIdNonExistingRecordTest() throws EmployeeException {
		Mockito.when(departmentRepository.existsById(Mockito.isA(Integer.class))).thenReturn(false);

		Mockito.doNothing().when(departmentRepository).deleteById(Mockito.isA(Integer.class));

		Assertions.assertThrows(EmployeeException.class, () -> {
			departmentService.deleteDepartment(testDepartment[0].getDeptNo());
		});

	}

}

