package com.dxc.cs.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dxc.cs.exception.EmployeeException;
import com.dxc.cs.model.Employee;
import com.dxc.cs.service.EmployeeService;
import com.dxc.cs.service.EmployeeServiceImpl;

@WebServlet({ "/viewEmployees", "/addEmployee", "/confirmAddEmployee" })
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmployeeController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = request.getServletPath();
		String view = null;

		try {

			EmployeeService employeeService = new EmployeeServiceImpl();

			Employee employee = new Employee();

			switch (path) {
			case "/viewEmployees":
				view = "employeesPage.jsp";
				request.setAttribute("employees", employeeService.getAllEmployees());
				break;
			case "/addEmployee":
				view = "employeeFormPage.jsp";
				break;
			case "/confirmAddEmployee":
				employee.setEmpId(Integer.parseInt(request.getParameter("empId")));
				employee.setEmpName(request.getParameter("empName"));
				employee.setGender(request.getParameter("gender"));
				employee.setCompId(Integer.parseInt(request.getParameter("compId")));

				employeeService.addEmployee(employee);

				view = "index.jsp";
				request.setAttribute("msg", "Employee data saved with Employee Code: " + employee.getEmpId());
				break;

			}

		} catch (EmployeeException e) {
			view = "errorPage.jsp";
			request.setAttribute("errMsg", e.getMessage());
		}

		request.getRequestDispatcher(view).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


}