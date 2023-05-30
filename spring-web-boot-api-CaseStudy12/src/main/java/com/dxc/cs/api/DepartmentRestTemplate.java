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

import com.dxc.cs.model.Department;

@RestController
public class DepartmentRestTemplate {
	
	 @Autowired
	   RestTemplate restTemplate;
	 
	 private String url = "http://localhost:2345/department";

	   @RequestMapping(value = "/alldepartments")
	   public String getDepartmentList() {
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<String> entity = new HttpEntity<String>(headers);
	      
	      return restTemplate.exchange(
	       url, HttpMethod.GET, entity, String.class).getBody();
	   }
	   @RequestMapping(value = "/adddepartments", method = RequestMethod.POST)
	   public String createDepartment(@RequestBody Department department) {
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<Department> entity = new HttpEntity<Department>(department,headers);
	      
	      return restTemplate.exchange(
	        url, HttpMethod.POST, entity, String.class).getBody();
	   }

		/*
		 * @RequestMapping(value = "/template/products/{id}", method =
		 * RequestMethod.PUT) public String updateProduct(@PathVariable("id") String
		 * id, @RequestBody Department department) { HttpHeaders headers = new
		 * HttpHeaders(); headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		 * HttpEntity<Department> entity = new
		 * HttpEntity<Department>(department,headers);
		 * 
		 * return restTemplate.exchange( url+id, HttpMethod.PUT, entity,
		 * String.class).getBody(); }
		 */
	   @RequestMapping(value = "/deletedepartments/{deptNo}", method = RequestMethod.DELETE)
	   public String deleteDepartment(@PathVariable("deptNo") Integer deptNo) {
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<Department> entity = new HttpEntity<Department>(headers);
	      
	      return restTemplate.exchange(
	        url+deptNo, HttpMethod.DELETE, entity, String.class).getBody();
	   }

}
