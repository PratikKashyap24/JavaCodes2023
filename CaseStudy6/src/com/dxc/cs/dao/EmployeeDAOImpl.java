package com.dxc.cs.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.dxc.cs.exception.EmployeeException;
import com.dxc.cs.model.Company;
import com.dxc.cs.model.Department;
import com.dxc.cs.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

	static {
		em = Persistence.createEntityManagerFactory("mysqlPU").createEntityManager();
	}

	private static EntityManager em;

	@Override
	public void addEmployee(Employee employee) throws EmployeeException {

		if (employee != null) {
			EntityTransaction txn = em.getTransaction();
			txn.begin();
			em.persist(employee);
			txn.commit();
		}

	}

	@Override
	public void deleteEmployee(int empId) throws EmployeeException {

		EntityTransaction txn = em.getTransaction();
		Employee employee = em.find(Employee.class, empId);

		if (employee != null) {
			txn.begin();
			em.remove(employee);
			txn.commit();
		} else {
			throw new EmployeeException("No such employee found!!!");
		}
	}

	@Override
	public List<Employee> getAllEmployees() throws EmployeeException {

		TypedQuery<Employee> qry = em.createNamedQuery("allEmployeesQry", Employee.class);
		return qry.getResultList();
	}

	@Override
	public void addCompany(Company company) throws EmployeeException {

		if (company != null) {
			EntityTransaction txn = em.getTransaction();
			txn.begin();
			em.persist(company);
			txn.commit();
		}

	}

	@Override
	public List<Company> getAllCompanies() throws EmployeeException {

		TypedQuery<Company> qry = em.createNamedQuery("allCompanyQry", Company.class);
		return qry.getResultList();
	}

	@Override
	public void addDepartment(Department department) throws EmployeeException {

		if (department != null) {
			EntityTransaction txn = em.getTransaction();
			txn.begin();
			em.persist(department);
			txn.commit();
		}
	}

	@Override
	public List<Department> getAllDepartments() throws EmployeeException {

		TypedQuery<Department> qry = em.createNamedQuery("allDeparmentQry", Department.class);
		return qry.getResultList();
	}

}// end of EmployeeDAOImpl