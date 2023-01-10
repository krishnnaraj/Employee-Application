package com.ty.employeeapp.beans;

public class Employee {
	
	private String empName;
	private String emailId;
	private String dateOfBirth;
	private String empStatus;
	private double salary;
	
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getEmpStatus() {
		return empStatus;
	}
	public void setEmpStatus(String empStatus) {
		this.empStatus = empStatus;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [empName=" + empName + ", emailId=" + emailId + ", dateOfBirth=" + dateOfBirth + ", empStatus="
				+ empStatus + ", salary=" + salary + "]";
	}
	
	
		
}
