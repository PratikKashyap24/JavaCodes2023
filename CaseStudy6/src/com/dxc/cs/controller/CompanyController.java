package com.dxc.cs.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dxc.cs.exception.EmployeeException;
import com.dxc.cs.model.Company;
import com.dxc.cs.service.EmployeeService;
import com.dxc.cs.service.EmployeeServiceImpl;

@WebServlet({ "/viewCompanies", "/addCompany", "/confirmAddCompany" })
public class CompanyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CompanyController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = request.getServletPath();
		String view = null;

		try {

			EmployeeService employeeService = new EmployeeServiceImpl();

			Company company = new Company();

			switch (path) {
			case "/viewCompanies":
				view = "companyPage.jsp";
				request.setAttribute("company", employeeService.getAllCompanies());
				break;
			case "/addCompany":
				view = "companyFormPage.jsp";
				break;
			case "/confirmAddCompany":
				company.setCompId(Integer.parseInt(request.getParameter("compId")));
				company.setCompName(request.getParameter("compName"));

				employeeService.addCompany(company);

				view = "index.jsp";
				request.setAttribute("msg", "Company data saved with Company Id: " + company.getCompId());
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