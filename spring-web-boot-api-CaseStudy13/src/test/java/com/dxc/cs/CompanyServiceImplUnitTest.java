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

import com.dxc.cs.entity.Company;
import com.dxc.cs.exception.EmployeeException;
import com.dxc.cs.repository.CompanyRepository;
import com.dxc.cs.service.CompanyService;
import com.dxc.cs.service.CompanyServiceImpl;

@SpringJUnitConfig
public class CompanyServiceImplUnitTest {

	@TestConfiguration
	static class CompanyServiceImplTestContextConfiguration {

		@Bean
		public CompanyService departmentService() {
			return new CompanyServiceImpl();
		}
	}

	@MockBean
	private CompanyRepository companyRepository;

    @Autowired
	private CompanyService companyService;

	private Company[] testCompany;


	@BeforeEach
	public void fillTestData() {

		testCompany = new Company[] {

				new Company(2132, "DXC"),
				new Company(9110, "HP"),

		};

	}

	@AfterEach
	public void clearDatabase() {
		testCompany = null;
	}

	@Test
	public void addTest() throws EmployeeException  {

		Mockito.when(companyRepository.save(Mockito.any(Company.class))).thenReturn(null);

		Mockito.when(companyRepository.existsById(testCompany[0].getCompId())).thenReturn(false);

		try {
			Company actual = companyService.addCompany(testCompany[0]);
			Assertions.assertEquals(testCompany[0], actual);
		} catch (EmployeeException e) {
			Assertions.fail(e.getMessage());
		}
	}
	
	  @Test public void addExistingEmployeeTest() throws EmployeeException{
	  Mockito.when(companyRepository.save(Mockito.any(Company.class))).thenReturn
	  (null);
	  
	  Mockito.when(companyRepository.existsById(testCompany[0].getCompId())).
	  thenReturn(true);
	  
	  Assertions.assertThrows(EmployeeException.class, () -> {
	  companyService.addCompany(testCompany[0]); });
	 
	 }
	 
	

	
	@Test
	public void getByIdExisitngRecordTest() throws EmployeeException {
		Mockito.when(companyRepository.findById(testCompany[0].getCompId()))
				.thenReturn(Optional.of(testCompany[0]));
		Assertions.assertEquals(testCompany[0], companyService.getByCompId(testCompany[0].getCompId()));
	}

	@Test
	public void getByIdNonExisitngRecordTest() throws EmployeeException{
		Mockito.when(companyRepository.findById(testCompany[0].getCompId())).thenReturn(Optional.empty());
		Assertions.assertNull(companyService.getByCompId(testCompany[0].getCompId()));
	}

	@Test
	public void getAllItemsWhenDataExists() throws EmployeeException {
		List<Company> expected = Arrays.asList(testCompany);

		Mockito.when(companyRepository.findAll()).thenReturn(expected);

		Assertions.assertEquals(expected, companyService.getAllCompanies());
	}

	@Test
	public void getAllItemsWhenNoDataExists() throws EmployeeException {
		List<Company> expected = new ArrayList<>();

		Mockito.when(companyRepository.findAll()).thenReturn(expected);

		Assertions.assertEquals(expected, companyService.getAllCompanies());
	}
	@Test
	public void deleteByIdExistingRecordTest() throws EmployeeException{
		Mockito.when(companyRepository.existsById(Mockito.isA(Integer.class))).thenReturn(true);

		Mockito.doNothing().when(companyRepository).deleteById(Mockito.isA(Integer.class));

		try {
			Assertions.assertTrue(companyService.deleteCompany(testCompany[0].getCompId()));
		} catch (EmployeeException e) {
			Assertions.fail(e.getLocalizedMessage());
		}
	}

	@Test
	public void deleteByIdNonExistingRecordTest() throws EmployeeException {
		Mockito.when(companyRepository.existsById(Mockito.isA(Integer.class))).thenReturn(false);

		Mockito.doNothing().when(companyRepository).deleteById(Mockito.isA(Integer.class));

		Assertions.assertThrows(EmployeeException.class, () -> {
			companyService.deleteCompany(testCompany[0].getCompId());
		});

	}

}


