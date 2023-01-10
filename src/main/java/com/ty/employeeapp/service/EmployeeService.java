package com.ty.employeeapp.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.employeeapp.beans.Employee;
import com.ty.employeeapp.dao.EmployeeDao;
import com.ty.employeeapp.dto.EmployeeDto;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	public EmployeeDto addEmployee(Employee employee) {
		EmployeeDto employeeDto = new EmployeeDto();
		employeeDto.setEmpName(employee.getEmpName());
		employeeDto.setEmailId(employee.getEmailId());
		System.out.println(employee.getDateOfBirth());
		LocalDate dateOfBirth=LocalDate.parse(employee.getDateOfBirth());
		System.out.println(dateOfBirth);
		employeeDto.setDateOfBirth(dateOfBirth);
		int age= LocalDate.now().getYear()-(dateOfBirth.getYear());
		employeeDto.setAge(age);
		System.out.println(age);
		
//		LocalDate dob=null;
//		try {
//			 dob = LocalDate.parse(employee.getDateOfBirth());
//			employeeDto.setDateOfBirth(dob);
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			int age = LocalDate.now().getYear()-dob.getYear();
//			employeeDto.setAge(age);
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
		employeeDto.setSalary(employee.getSalary());
		employeeDto.setEmpStatus(employee.getEmpStatus());
		return employeeDao.insertEmployee(employeeDto);
	}

	public List<EmployeeDto> getAllEmployee() {
		return employeeDao.getAllEmployee();
	}

	public EmployeeDto searchEmployee(int employeeId) {
		return employeeDao.findEmployee(employeeId);
	}

	public EmployeeDto updateEmployeeDetails(Employee employee, int id) {
		EmployeeDto employeeDto = new EmployeeDto();
		employeeDto.setEmpId(id);
		System.out.println(id);
		employeeDto.setEmpName(employee.getEmpName());
		employeeDto.setEmailId(employee.getEmailId());
		LocalDate dob = LocalDate.parse(employee.getDateOfBirth());
		employeeDto.setDateOfBirth(dob);
		int age = LocalDate.now().getYear()-dob.getYear();
		employeeDto.setAge(age);
		employeeDto.setSalary(employee.getSalary());
		employeeDto.setEmpStatus(employee.getEmpStatus());
		return employeeDao.updateEmployee(employeeDto);
	}

	public EmployeeDto deleteEmployee(int employeeId) {
		EmployeeDto employeeDto	= employeeDao.findEmployee(employeeId);
		return employeeDao.removeEmployee(employeeDto);
	}
}
