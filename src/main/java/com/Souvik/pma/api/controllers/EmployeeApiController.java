package com.Souvik.pma.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Souvik.pma.dao.IEmployeeRepository;
import com.Souvik.pma.entities.Employee;

@RestController
@RequestMapping("/app-api/employees")
public class EmployeeApiController {
	
	@Autowired
	IEmployeeRepository employeeRepository;
	
	@GetMapping
	public List<Employee> getEmployee() {
		return employeeRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable("id") Long id) {
		return employeeRepository.findById(id).get();
	}
	
	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}
	
	@PutMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public Employee update(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}

	@PatchMapping(path = "/{id}", consumes = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public Employee partialUpdate(@PathVariable("id") long id, @RequestBody Employee patchEmployee) {
		Employee emp = employeeRepository.findById(id).get();
		
		if(patchEmployee.getEmail() != null) {
			emp.setEmail(patchEmployee.getEmail());
		}
		
		if(patchEmployee.getFirstName() != null) {
			emp.setFirstName(patchEmployee.getFirstName());
		}
		
		if(patchEmployee.getLastName() != null) {
			emp.setLastName(patchEmployee.getLastName());
		}
		
		return employeeRepository.save(emp);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") long id) {
		
		try {
			employeeRepository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
