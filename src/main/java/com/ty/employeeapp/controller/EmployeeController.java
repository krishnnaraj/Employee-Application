package com.ty.employeeapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ty.employeeapp.beans.Employee;
import com.ty.employeeapp.dto.EmployeeDto;
import com.ty.employeeapp.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/home")
	public ModelAndView getIndexPage(ModelAndView modelAndView) {
		modelAndView.setViewName("index");
		return modelAndView;
	}
	
	@GetMapping("/add-employee-form")
	public ModelAndView getEmployeeForm(ModelAndView modelAndView) {
		modelAndView.setViewName("add-employee");
		return modelAndView;
	}
	
	@PostMapping("add-employee-details")
	public ModelAndView addEmployeeData(ModelAndView modelAndView, Model model, Employee employee) {
		EmployeeDto employeeAdded = employeeService.addEmployee(employee);
		if (employeeAdded != null) {
			modelAndView.setViewName("redirect:/display-all");
		} else { 
			modelAndView.setViewName("redirect:/add-employee-form");
		}
		return modelAndView;
	}
	
	@GetMapping("/display-all")
	public ModelAndView getAllEmployeeDetails(ModelAndView modelAndView, Model model) {
		List<EmployeeDto> allEmployee = employeeService.getAllEmployee();
		if (allEmployee.isEmpty()) {
			model.addAttribute("msg", "No Records");
		} else {
			model.addAttribute("msg", allEmployee);
		}
		modelAndView.setViewName("display-all-employee");
		return modelAndView;
	}
	
	@GetMapping("/edit")
	public ModelAndView getEditForm(ModelAndView modelAndView,@RequestParam("empId") int employeeId, Model model) {
		EmployeeDto searchEmployee = employeeService.searchEmployee(employeeId);
		System.out.println(searchEmployee);
		if (searchEmployee != null) {
			model.addAttribute("employee", searchEmployee);
			modelAndView.setViewName("edit-form");
		} else {
			model.addAttribute("employee", "No Records Found");
			modelAndView.setViewName("edit-form");
		}
		return modelAndView;
	}
	
	@PostMapping("/update-employee")
	public ModelAndView updateEmployee(Employee employee, @RequestParam("empId") int id, Model model, ModelAndView modelAndView) {
		EmployeeDto updateEmployee = employeeService.updateEmployeeDetails(employee, id);
		System.out.println(updateEmployee);
		if (updateEmployee != null) {
			modelAndView.setViewName("redirect:/display-all");
		} else {
			model.addAttribute("msg", "Records Not Updated");
			modelAndView.setViewName("display-all-employee");
		}
		return modelAndView;
		
	}
	
	@GetMapping("/delete/{employeeId}")
	public ModelAndView deleteEmployee(ModelAndView modelAndView,@PathVariable("employeeId") int employeeId, Model model) {
		EmployeeDto deleteEmployee = employeeService.deleteEmployee(employeeId);
		if (deleteEmployee != null) {
			modelAndView.setViewName("redirect:/display-all");
		} else {
			model.addAttribute("msg", "No Records Found");
			modelAndView.setViewName("display-all-employee");
		}
		return modelAndView;
	}
}
