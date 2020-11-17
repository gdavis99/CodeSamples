package edu.uwsp.cis345.model;

public class Employee {
	
	private int empID;
	
	private String firstName;
	
	private String lastName;
	
	private int yearOfJoining;

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getYearOfJoining() {
		return yearOfJoining;
	}

	public void setYearOfJoining(int yearOfJoining) {
		this.yearOfJoining = yearOfJoining;
	}
	
	@Override
	public String toString() {
		StringBuilder msg = new StringBuilder();
		msg.append("Employee ID is ").append(empID);
		msg.append("\nEmployees Name is ").append(firstName + " ").append(lastName);
		msg.append("\nYear of Joining ").append(yearOfJoining);
		return msg.toString();
	}
}
