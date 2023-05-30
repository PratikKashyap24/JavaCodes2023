package com.dxc.cs.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dxc.cs.exception.EmployeeException;
import com.dxc.cs.model.Department;
import com.dxc.cs.service.EmployeeService;
import com.dxc.cs.service.EmployeeServiceImpl;

@WebServlet({ "/viewDepartments", "/addDepartment", "/confirmAddDepartment" })
public class DepartmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DepartmentController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = request.getServletPath();
		String view = null;

		try {

			EmployeeService employeeService = new EmployeeServiceImpl();

			Department department = new Department();

			switch (path) {
			case "/viewDepartments":
				view = "departmentsPage.jsp";
				request.setAttribute("department", employeeService.getAllDepartments());
				break;
			case "/addDepartment":
				view = "/departmentFormPage.jsp";
				break;
			case "/confirmAddDepartment":
				department.setDeptNo(Integer.parseInt(request.getParameter("deptNo")));
				department.setDeptName(request.getParameter("deptName"));
				department.setEmpId(Integer.parseInt(request.getParameter("empId")));

				employeeService.addDepartment(department);

				view = "index.jsp";
				request.setAttribute("msg", "Department data saved with Department No: " + department.getDeptNo());
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