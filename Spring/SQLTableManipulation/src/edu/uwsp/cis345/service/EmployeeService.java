package edu.uwsp.cis345.service;

import java.util.List;

import edu.uwsp.cis345.model.Employee;

public interface EmployeeService {
	public Employee getEmployee(int id);
	
	public boolean createEmployee(Employee newEmp);
	
	public boolean updateEmployee(Employee newEmp);
	
	public boolean deleteEmployee(int empId);
	
	public List<Employee> getEmployees();
}
