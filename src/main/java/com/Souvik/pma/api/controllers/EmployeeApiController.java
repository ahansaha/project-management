//package com.Souvik.pma.api.controllers;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.Souvik.pma.entities.Employee;
//import com.Souvik.pma.services.EmployeeService;
//
//@RestController
//@RequestMapping("/app-api/employees")
//public class EmployeeApiController {
//	
//	@Autowired
//	EmployeeService employeeService;
//	
//	@GetMapping
//	public Iterable<Employee> getEmployee() {
//		return employeeService.getAll();
//	}
//}
