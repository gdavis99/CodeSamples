package edu.uwsp.cis345;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.uwsp.cis345.model.Employee;
import edu.uwsp.cis345.service.EmployeeService;

public class Driver {

	public static void main(String[] args) {
		
		//This project uses Spring Framework in conjuction with an SQL database to  create, fetch, update, and delete employees by their ID numbers from the database.
		//**Code will not work if not connected to the correct network**
		
		String spacer = "\n/---------------/";
		
		Employee newEmp = new Employee();		
		newEmp.setEmpID(303);
		newEmp.setFirstName("Bob");
		newEmp.setLastName("Smith");
		newEmp.setYearOfJoining(2007);
		
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("beanConfig.xml");
		EmployeeService employeeService = (EmployeeService) factory.getBean("employeeService");
		
		//Create
		System.out.println("Create Bob status: " + employeeService.createEmployee(newEmp)+spacer);
		System.out.println("Current Employee List: "+ employeeService.getEmployees()+spacer);
		
		System.out.println("Getting Bob: "+employeeService.getEmployee(303)+spacer);
		
		//Update
		newEmp.setLastName("Saget");
		System.out.println("Updating Bob's Last Name: "+ employeeService.updateEmployee(newEmp) + spacer);
		System.out.println("Current Employee List: "+ employeeService.getEmployees()+spacer);
		
		//Delete
		System.out.println("Delete Bob status: " + employeeService.deleteEmployee(303)+spacer);			
		System.out.println("Current Employee List: "+ employeeService.getEmployees()+spacer);
		
		factory.close();
	}

}
