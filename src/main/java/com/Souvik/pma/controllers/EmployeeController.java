package com.Souvik.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Souvik.pma.entities.Employee;
import com.Souvik.pma.services.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping
	public String displayEmployees(Model model) {
		List<Employee> employees = employeeService.getAll();
		model.addAttribute("employees", employees);
		return "employees/employee-list";
	}
	
	@GetMapping("/new")
	public String displayEmployeeForm(Model model) {
		Employee anEmployee = new Employee();
		model.addAttribute("employee", anEmployee);
		return "employees/new-employee";
	}
	
	@PostMapping("/save")
	public String createEmployee(Employee employee) {
		employeeService.save(employee);
		return "redirect:/employees/new";
	}
	
}
