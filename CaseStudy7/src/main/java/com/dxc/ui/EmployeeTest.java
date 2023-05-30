package com.dxc.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dxc.model.Company;
import com.dxc.model.Department;
import com.dxc.model.Employee;

public class EmployeeTest {
	public static void main(String[] args) {
		
		
		// Setter Injection using Spring IoC
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Employee.xml");
		Employee e1 = (Employee) applicationContext.getBean("emp1");

		/*
		 * e1.setEmpId(101); e1.setEmpName("Pratik Kashyap"); e1.setGender("male");
		 * e1.setCompId(13242);
		 */
		
		Department d1=(Department)applicationContext.getBean("dept1");
		/*
		 * d1.setDeptId(13213); d1.setDeptName("GLIC"); d1.setEmpId(101);
		 */
		
		
		
		
		
		//Constructor Injectionn
		Company c1=(Company)applicationContext.getBean("comp1");
		/*
		 * c1.setCompId(13232); c1.setCompName("DXC");
		 */
		
		System.out.println(e1);
		System.out.println(d1);
		System.out.println(c1);
	}
	
	
	
	
	
	
	
	
}
