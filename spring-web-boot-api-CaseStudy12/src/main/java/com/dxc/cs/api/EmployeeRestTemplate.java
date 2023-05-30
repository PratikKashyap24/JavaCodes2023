package com.dxc.cs.api;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.dxc.cs.model.Employee;

@RestController
public class EmployeeRestTemplate {

	@Autowired
	RestTemplate restTemplate;

	private String url = "http://localhost:2345/employee";

	@RequestMapping(value = "/allemployees")
	public String getEmployeeList() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		return restTemplate.exchange(url, HttpMethod.GET, entity, String.class).getBody();
	}

	@RequestMapping(value = "/addemployees", method = RequestMethod.POST)
	public String addEmployee(@RequestBody Employee employee) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Employee> entity = new HttpEntity<Employee>(employee, headers);

		return restTemplate.exchange(url, HttpMethod.POST, entity, String.class).getBody();
	}

	/*
	 * @RequestMapping(value = "/template/products/{id}", method =
	 * RequestMethod.PUT) public String updateEmployee(@PathVariable("id") String
	 * id, @RequestBody Employee employee) { HttpHeaders headers = new
	 * HttpHeaders(); headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	 * HttpEntity<Employee> entity = new HttpEntity<Employee>(employee, headers);
	 * 
	 * return restTemplate.exchange(url + id, HttpMethod.PUT, entity, String.class)
	 * .getBody(); }
	 */
	@RequestMapping(value = "deleteemployees/{empId}", method = RequestMethod.DELETE)
	public String deleteEmployee(@PathVariable("empId") Integer empId) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Employee> entity = new HttpEntity<Employee>(headers);

		return restTemplate.exchange(url+ empId, HttpMethod.DELETE, entity, String.class)
				.getBody();
	}
}
