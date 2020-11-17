package edu.uwsp.cis345.dao;

import java.util.List;

import edu.uwsp.cis345.model.Employee;

public interface EmployeeDAO {
	
	public Employee getEmployee(int id);
	
	public boolean createEmployee(Employee newEmp);
	
	public boolean updateEmployee(Employee newEmp);
	
	public boolean deleteEmployee(int empId);
	
	public List<Employee> getEmployees();

}
