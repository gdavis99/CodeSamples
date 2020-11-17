package edu.uwsp.cis345.service;

import java.util.List;

import edu.uwsp.cis345.dao.EmployeeDAO;
import edu.uwsp.cis345.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {
	
	//Dependency
	private EmployeeDAO employeeDAO;
	
	//Construct
	public EmployeeServiceImpl(EmployeeDAO employeeDAO){
		this.employeeDAO = employeeDAO;
	}
	
	//Logic
	public Employee getEmployee(int empId) {
		return employeeDAO.getEmployee(empId);
	}
	
	@Override
	public boolean createEmployee(Employee newEmp) {
		return employeeDAO.createEmployee(newEmp);
	}
	
	@Override
	public boolean updateEmployee(Employee newEmp) {
		return employeeDAO.updateEmployee(newEmp);
	}
	
	@Override
	public boolean deleteEmployee(int empId) {
		return employeeDAO.deleteEmployee(empId);
	}
	
	@Override
	public List<Employee> getEmployees() {
		return employeeDAO.getEmployees();
	}
}
