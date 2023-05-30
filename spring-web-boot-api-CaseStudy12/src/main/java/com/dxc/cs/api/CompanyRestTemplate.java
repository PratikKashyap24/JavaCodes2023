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

import com.dxc.cs.model.Company;

@RestController
public class CompanyRestTemplate {

	@Autowired
	RestTemplate restTemplate;

	private String url = "http://localhost:2345/company";

	@RequestMapping(value = "/allcompanies")
	public String getCompanyList() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		return restTemplate.exchange(url, HttpMethod.GET, entity, String.class).getBody();
	}

	@RequestMapping(value = "/addcompanies", method = RequestMethod.POST)
	public String addCompany(@RequestBody Company company) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Company> entity = new HttpEntity<Company>(company, headers);

		return restTemplate.exchange(url, HttpMethod.POST, entity, String.class).getBody();
	}

	
	  @RequestMapping(value = "/{id}", method =
	  RequestMethod.PUT) public String updatecompanies(@PathVariable("id") String
	  id, @RequestBody Company company) { HttpHeaders headers = new HttpHeaders();
	  headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	  HttpEntity<Company> entity = new HttpEntity<Company>(company, headers);
	  
	  return restTemplate.exchange(url + id, HttpMethod.PUT, entity,
	  String.class).getBody(); }
	 
	@RequestMapping(value = "/deletecompanies/{compId}", method = RequestMethod.DELETE)
	public String deleteCompany(@PathVariable("compId") Integer compId) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Company> entity = new HttpEntity<Company>(headers);

		return restTemplate.exchange(url + compId, HttpMethod.DELETE, entity, String.class).getBody();
	}

}
